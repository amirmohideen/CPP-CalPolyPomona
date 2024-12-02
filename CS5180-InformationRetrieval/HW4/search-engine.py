import re
from pymongo import MongoClient
import math

def create_inverted_index(documents):
    """Create an inverted index with unigrams, bigrams, and trigrams."""
    client = MongoClient('mongodb://localhost:27017/')
    db = client['search_engine']
    
    # Drop existing collections if they exist
    db.terms.drop()
    db.documents.drop()
    
    # Preprocess documents
    def preprocess(text):
        # Remove punctuation and lowercase
        text = re.sub(r'[^\w\s]', '', text.lower())
        return text.split()
    
    # Store documents
    documents_collection = db.documents
    documents_collection.insert_many([
        {'_id': i+1, 'content': doc} for i, doc in enumerate(documents)
    ])
    
    # Create vocabulary
    terms_collection = db.terms
    vocabulary = {}
    term_counter = 0
    
    def add_to_index(term, doc_id, pos):
        existing = terms_collection.find_one({'term': term})
        if not existing:
            term_counter = len(vocabulary)
            vocabulary[term] = term_counter
            terms_collection.insert_one({
                '_id': term_counter,
                'term': term,
                'pos': term_counter,
                'docs': [{
                    'doc_id': doc_id, 
                    'tf_idf': calculate_tf_idf(term, doc_id, documents)
                }]
            })
        else:
            terms_collection.update_one(
                {'term': term},
                {'$push': {'docs': {
                    'doc_id': doc_id, 
                    'tf_idf': calculate_tf_idf(term, doc_id, documents)
                }}}
            )
    
    # Generate unigrams, bigrams, trigrams
    for doc_id, doc in enumerate(documents, 1):
        words = preprocess(doc)
        
        # Unigrams
        for pos, word in enumerate(words):
            add_to_index(word, doc_id, pos)
        
        # Bigrams
        for pos in range(len(words) - 1):
            bigram = f"{words[pos]} {words[pos+1]}"
            add_to_index(bigram, doc_id, pos)
        
        # Trigrams
        for pos in range(len(words) - 2):
            trigram = f"{words[pos]} {words[pos+1]} {words[pos+2]}"
            add_to_index(trigram, doc_id, pos)
    
    return db, vocabulary

def calculate_tf_idf(term, doc_id, documents):
    """Calculate TF-IDF for a term in a specific document."""
    # Simple TF-IDF calculation
    # Term Frequency (TF)
    doc_words = re.sub(r'[^\w\s]', '', documents[doc_id-1].lower()).split()
    tf = doc_words.count(term) / len(doc_words)
    
    # Inverse Document Frequency (IDF)
    doc_count = len(documents)
    term_doc_count = sum(1 for doc in documents if term in doc.lower())
    idf = math.log(doc_count / (term_doc_count + 1))
    
    return tf * idf

def search_documents(db, query, vocabulary):
    """Search documents using Vector Space Model."""
    # Preprocess query
    query_words = re.sub(r'[^\w\s]', '', query.lower()).split()
    
    # Find matching documents
    matching_docs = set()
    matching_terms = []
    
    for term in query_words:
        # Check unigrams, bigrams, trigrams
        terms = [term]
        
        # Add bigrams and trigrams
        words = query_words
        for i in range(len(words) - 1):
            terms.append(f"{words[i]} {words[i+1]}")
        for i in range(len(words) - 2):
            terms.append(f"{words[i]} {words[i+1]} {words[i+2]}")
        
        for search_term in terms:
            term_doc = db.terms.find_one({'term': search_term})
            if term_doc:
                matching_terms.append(term_doc)
                matching_docs.update([doc['doc_id'] for doc in term_doc.get('docs', [])])
    
    # Score documents
    scored_docs = []
    for doc_id in matching_docs:
        doc_content = db.documents.find_one({'_id': doc_id})['content']
        score = calculate_document_score(matching_terms, doc_id)
        scored_docs.append((doc_content, score))
    
    # Sort by score in descending order
    return sorted(scored_docs, key=lambda x: x[1], reverse=True)

def calculate_document_score(matching_terms, doc_id):
    """Calculate document score using Vector Space Model."""
    score = 0
    for term_doc in matching_terms:
        # Find the TF-IDF for this term in the document
        doc_term = next((doc for doc in term_doc.get('docs', []) if doc['doc_id'] == doc_id), None)
        if doc_term:
            score += doc_term['tf_idf']
    return score

# Example documents
documents = [
    "After the medication, headache and nausea were reported by the patient.",
    "The patient reported nausea and dizziness caused by the medication.",
    "Headache and dizziness are common effects of this medication.",
    "The medication caused a headache and nausea, but no dizziness was reported."
]

# Queries
queries = [
    "nausea and dizziness",
    "effects",
    "nausea was reported",
    "dizziness",
    "the medication"
]

# Create index
db, vocabulary = create_inverted_index(documents)

# Search and print results
for query in queries:
    print(f"\nQuery: '{query}'")
    results = search_documents(db, query, vocabulary)
    for doc, score in results:
        print(f'"{doc}", {score:.2f}')
