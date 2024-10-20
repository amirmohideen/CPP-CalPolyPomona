from pymongo import MongoClient
import datetime

def connectDataBase():

    # Creating a database connection object using pymongo

    DB_NAME = "CPP"
    DB_HOST = "localhost"
    DB_PORT = 27017

    try:

        client = MongoClient(host=DB_HOST, port=DB_PORT)
        db = client[DB_NAME]

        return db

    except:
        print("Database not connected successfully")

def createUser(col, id, name, email):

    # Value to be inserted
    user = {"_id": id,
            "name": name,
            "email": email,
            }

    # Insert the document
    col.insert_one(user)

def updateUser(col, id, name, email):

    # User fields to be updated
    user = {"$set": {"name": name, "email": email} }

    # Updating the user
    col.update_one({"_id": id}, user)

def deleteUser(col, id):

    # Delete the document from the database
    col.delete_one({"_id": id})

def getUser(col, id):

    user = col.find_one({"_id":id})

    if user:
        return str(user['_id']) + " | " + user['name'] + " | " + user['email']
    else:
        return []

def createComment(col, id_user, dateTime, comment):

    # Comments to be included
    comments = {"$push": {"comments": {
                                       "datetime": datetime.datetime.strptime(dateTime, "%m/%d/%Y %H:%M:%S"),
                                       "comment": comment
                                       } }}

    # Updating the user document
    col.update_one({"_id": id_user}, comments)

def updateComment(col, id_user, dateTime, new_comment):

    # User fields to be updated
    comment = {"$set": {"comments.$.comment": new_comment} }

    # Updating the user
    col.update_one({"_id": id_user, "comments.datetime": datetime.datetime.strptime(dateTime, "%m/%d/%Y %H:%M:%S")}, comment)

def deleteComment(col, id_user, dateTime):

    # Comments to be delete
    comments = {"$pull": {"comments": {"datetime": datetime.datetime.strptime(dateTime, "%m/%d/%Y %H:%M:%S")} }}

    # Updating the user document
    col.update_one({"_id": id_user}, comments)

def getChat(col):

    # creating a document for each message
    pipeline = [
                 {"$unwind": { "path": "$comments" }},
                 {"$sort": {"comments.datetime": 1}}
               ]

    comments = col.aggregate(pipeline)

    chat = ""

    for com in comments:
        chat += com['name'] + " | " + com['comments']['comment'] + " | " + str(com['comments']['datetime']) + "\n"

    return chat


# Amir Code

def createDocument(col, id, text, title, date, category):
    doc = {
        "_id": id,
        "text": text,
        "title": title,
        "date": datetime.datetime.strptime(date, "%Y-%m-%d"),
        "category": category
    }
    col.insert_one(doc)


def updateDocument(col, id, text, title, date, category):
    set = {
        "$set": {
            "text": text,
            "title": title,
            "date": datetime.datetime.strptime(date, "%Y-%m-%d"),
            "category": category
        }
    }
    col.update_one({ "_id": id }, set)


def deleteDocument(col, id):
    col.delete_one({ "_id": id })

def getIndex(collection):
    pipeline = [
        {
            # Extract alphanumeric words, ignoring special characters
            "$project": {
                "terms": {
                    "$regexFindAll": {
                        "input": { "$toLower": "$text" },
                        "regex": "[a-zA-Z0-9]+"  # Match alphanumeric characters only
                    }
                },
                "title": 1,  # Include document title
                "_id": 0
            }
        },
        {
            # Extract the `match` field from regex results
            "$project": {
                "terms": "$terms.match",  # Extract matched words from regex
                "title": 1
            }
        },
        { "$unwind": "$terms" },  # Flatten the terms into separate rows
        {
            # Group by term and title, count occurrences
            "$group": {
                "_id": { "title": "$title", "term": "$terms" },
                "term_count": { "$sum": 1 }  # Sum occurrences
            }
        },
        {
            # Create "title:count" string for each term
            "$project": {
                "term": "$_id.term",
                "title_term_count_map": {
                    "$concat": ["$_id.title", ":", { "$toString": "$term_count" }]
                },
                "_id": 0,
            }
        },
        {
            # Group by term and collect "title:count" strings into array
            "$group": {
                "_id": "$term",
                "term_count_per_title_array": { "$push": "$title_term_count_map" }
            }
        },
        {
            # Join all "title:count" strings for each term
            "$project": {
                "term_counts_per_title": {
                    "$reduce": {
                        "input": "$term_count_per_title_array",
                        "initialValue": "",
                        "in": {
                            "$cond": {
                                "if": { "$eq": [{ "$indexOfArray": ["$term_count_per_title_array", "$$this"] }, 0] },
                                "then": { "$concat": ["$$value", "$$this"] },
                                "else": { "$concat": ["$$value", ", ", "$$this"] }
                            }
                        }
                    }
                }
            }
        },
        {
            # Create key-value objects for each term
            "$project": {
                "kvObject": { "k": "$_id", "v": "$term_counts_per_title" },
                "_id": 0
            }
        },
        {
            # Collect key-value pairs into a single object
            "$group": {
                "_id": None,
                "kvObjects": { "$push": "$kvObject" }
            }
        },
        {
            # Convert array to a key-value object for final output
            "$project": {
                "results": { "$arrayToObject": "$kvObjects" }
            }
        }
    ]
    
    # Run the pipeline and return the result
    for result in collection.aggregate(pipeline):
        return result["results"]
