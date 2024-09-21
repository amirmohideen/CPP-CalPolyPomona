#-------------------------------------------------------------------------
# AUTHOR: Amir Mohideen Basheer Khan
# FILENAME: CS5180HW1
# SPECIFICATION: calculating tf-idf
# FOR: CS 5180- Assignment #1
# TIME SPENT: 2.5 hours
#-----------------------------------------------------------*/

import csv
import math
from collections import defaultdict

# Conducting stopword removal for pronouns/conjunctions.
stopWords = {"i", "and", "she", "they", "her", "their"}

# stemming dictionary
stemming = {
    "love": ["loves"],
    "cat": ["cats"],
    "dog": ["dogs"]
}

# Conducting stemming.
def apply_stemming(word):
    for stem, variants in stemming.items():
        if word in variants or word == stem:
            return stem
    return word

# Reading the data in the csv file
documents = []
with open('collection.csv', 'r') as csvfile:
    reader = csv.reader(csvfile)
    for i, row in enumerate(reader):
        if i > 0:  # skipping the header
            documents.append(row[0])

# Function to preprocess documents by removing stopwords and applying stemming
def preprocess_document(doc):
    terms = doc.lower().split()  # Convert to lowercase and split into words
    terms = [apply_stemming(term) for term in terms if term not in stopWords]  # Remove stopwords and apply stemming
    return terms

# Preprocessing each document
preprocessed_docs = [preprocess_document(doc) for doc in documents]

# Identifying the index terms.
index_terms = ["love", "cat", "dog"]

# Initialize document-term matrix
docTermMatrix = [[0 for _ in range(len(index_terms))] for _ in range(len(preprocessed_docs))]

# Build term frequency (TF) matrix
for i, doc in enumerate(preprocessed_docs):
    for term in doc:
        if term in index_terms:  # Ensuring we only count defined terms
            docTermMatrix[i][index_terms.index(term)] += 1

# Function to calculate term frequency (TF)
def calculate_tf(term_count, total_terms):
    return term_count / total_terms

# Function to calculate inverse document frequency (IDF) using log base 10
def calculate_idf(df, N):
    return math.log10(N / df) if df != 0 else 0

# Calculate document frequencies (DF)
df = defaultdict(int)
for term in index_terms:
    for doc in preprocessed_docs:
        if term in doc:
            df[term] += 1

# Calculate TF-IDF matrix
tfidf_matrix = []
for i, doc in enumerate(docTermMatrix):
    tfidf_row = []
    total_terms_in_doc = sum(doc)  # total terms in current document
    for j, term_count in enumerate(doc):
        if total_terms_in_doc > 0:
            tf = calculate_tf(term_count, total_terms_in_doc)
            idf = calculate_idf(df[index_terms[j]], len(preprocessed_docs))
            tfidf_row.append(tf * idf)
        else:
            tfidf_row.append(0)
    tfidf_matrix.append(tfidf_row)

# Printing the document-term matrix
print("TF-IDF Document-Term Matrix:")
print(f"{'':<10}", end="")
for term in index_terms:
    print(f"{term:<10}", end="")
print()

for i, row in enumerate(tfidf_matrix):
    print(f"D{i+1:<10}", end="")
    for value in row:
        print(f"{value:<10.6f}", end="")
    print()
