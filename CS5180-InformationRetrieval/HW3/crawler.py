#-------------------------------------------------------------------------
# AUTHOR: Amir Mohideen Basheer Khan
# FILENAME: CS5180HW3
# SPECIFICATION: Q5 Crawler
# FOR: CS 5180- Assignment #3
# TIME SPENT: 3 hours
#-----------------------------------------------------------*/

import urllib.request
import urllib.parse
import urllib.error
from bs4 import BeautifulSoup
from pymongo import MongoClient
from urllib.parse import urljoin
import re

class Frontier:
    def __init__(self, start_url):
        self.urls = [start_url]
        self.visited = set()
        self.target_found = False
    
    def nextURL(self):
        if self.urls:
            url = self.urls.pop(0)
            self.visited.add(url)
            return url
        return None
    
    def addURL(self, url):
        if url not in self.visited and url not in self.urls:
            self.urls.append(url)
    
    def done(self):
        return len(self.urls) == 0 or self.target_found
    
    def clear_frontier(self):
        self.urls.clear()
        self.target_found = True

def retrieveHTML(url):
    try:
        with urllib.request.urlopen(url) as response:
            return response.read().decode('utf-8')
    except (urllib.error.URLError, urllib.error.HTTPError, UnicodeDecodeError):
        return None

def storePage(url, html, db):
    if html:
        collection = db.pages
        collection.insert_one({
            'url': url,
            'html': html,
            'is_target': False
        })

def flagTargetPage(url, db):
    collection = db.pages
    collection.update_one(
        {'url': url},
        {'$set': {'is_target': True}}
    )

def parse(html, base_url):
    if not html:
        return [], False
    
    soup = BeautifulSoup(html, 'html.parser')
    
    # Check if this is the target page
    headings = soup.find_all(['h1', 'h2', 'h3', 'h4', 'h5', 'h6'])
    is_target = any('Permanent Faculty' in heading.get_text() for heading in headings)
    
    # Extract links
    links = []
    for link in soup.find_all('a', href=True):
        href = link['href']
        full_url = urljoin(base_url, href)
        
        # Only include HTML or SHTML files from cpp.edu domain
        if ('cpp.edu' in full_url and 
            any(full_url.endswith(ext) for ext in ['.html', '.shtml', '/']) and
            not any(exclude in full_url for exclude in ['#', 'mailto:', 'javascript:'])):
            links.append(full_url)
    
    return links, is_target

def crawlerThread(frontier, db):
    while not frontier.done():
        url = frontier.nextURL()
        if url:
            print(f"Crawling: {url}")
            html = retrieveHTML(url)
            storePage(url, html, db)
            
            links, is_target = parse(html, url)
            
            if is_target:
                print(f"Target page found: {url}")
                flagTargetPage(url, db)
                frontier.clear_frontier()
            else:
                for link in links:
                    frontier.addURL(link)

def main():
    # MongoDB connection
    client = MongoClient('mongodb://localhost:27017/')
    db = client['crawler_db']
    
    # Clear existing data
    db.pages.delete_many({})
    
    # Initialize frontier with CS homepage
    start_url = 'https://www.cpp.edu/sci/computer-science/'
    frontier = Frontier(start_url)
    
    # Start crawling
    crawlerThread(frontier, db)
    
    # Print results
    target_page = db.pages.find_one({'is_target': True})
    if target_page:
        print(f"\nSuccess! Target page found at: {target_page['url']}")
    else:
        print("\nTarget page not found")
    
    # Print statistics
    total_pages = db.pages.count_documents({})
    print(f"Total pages crawled: {total_pages}")
    
    client.close()

if __name__ == "__main__":
    main()