#-------------------------------------------------------------------------
# AUTHOR: Amir Mohideen Basheer Khan
# FILENAME: CS5180HW3
# SPECIFICATION: Q6 Parser
# FOR: CS 5180- Assignment #3
# TIME SPENT: 10 hours
#-----------------------------------------------------------*/

from bs4 import BeautifulSoup
from pymongo import MongoClient
import re

def clean_text(text):
    """Clean and normalize text data"""
    if text:
        # Remove extra whitespace, newlines, and special characters
        text = ' '.join(text.split())
        text = text.replace('\xa0', ' ')  # Replace non-breaking space
        return text.strip()
    return None

def parse_faculty_info(html):
    """Parse faculty information from HTML content"""
    soup = BeautifulSoup(html, 'html.parser')
    faculty_list = []
    
    # Find all h2 tags within main content area (after clearfix divs begin)
    first_clearfix = soup.find('div', class_='clearfix')
    if not first_clearfix:
        return faculty_list
        
    # Start searching for h2 tags after the first clearfix div
    for name_tag in first_clearfix.find_all_next('h2'):
        faculty_info = {}
        
        # Extract name from h2
        name = clean_text(name_tag.get_text())
        # Skip if the name looks like a navigation element
        if name.lower() in ['popular searches', 'navigation', 'menu']:
            continue
            
        faculty_info['name'] = name
        
        # Find the next paragraph tag after this h2
        info_paragraph = name_tag.find_next('p')
        
        if info_paragraph:
            # Get all text content first
            content = info_paragraph.get_text()
            
            # Extract title
            title_match = re.search(r'Title:\s*([^\n]*?)(?=\s*Office|$)', content)
            if title_match:
                faculty_info['title'] = clean_text(title_match.group(1))
            
            # Extract office
            office_match = re.search(r'Office:\s*(\d+-\d+[A-Z]?)', content)
            if office_match:
                faculty_info['office'] = clean_text(office_match.group(1))
            
            # Extract phone
            phone_match = re.search(r'Phone:\s*\((\d{3})\)\s*(\d{3})-(\d{4})', content)
            if phone_match:
                faculty_info['phone'] = f"({phone_match.group(1)}) {phone_match.group(2)}-{phone_match.group(3)}"
            
            # Extract email from anchor tag
            email_tag = info_paragraph.find('a', href=lambda x: x and 'mailto:' in x)
            if email_tag:
                faculty_info['email'] = clean_text(email_tag.get_text())
            
            # Website extraction
            website_tag = info_paragraph.find('a', href=lambda x: x and 'mailto:' not in x)
            faculty_info['website'] = clean_text(website_tag['href']) if website_tag else "N/A"
        
        # Only add if we have both name and title (to ensure it's a valid faculty entry)
        if faculty_info.get('name') and faculty_info.get('title'):
            faculty_list.append(faculty_info)
    
    return faculty_list

def main():
    # Connect to MongoDB
    client = MongoClient('mongodb://localhost:27017/')
    db = client['crawler_db']
    
    # Find the target page (Permanent Faculty page)
    target_page = db.pages.find_one({'is_target': True})
    
    if not target_page:
        print("Error: Target page not found in database!")
        return
    
    # Clear existing professors collection
    db.professors.delete_many({})
    
    # Parse faculty information
    faculty_list = parse_faculty_info(target_page['html'])
    
    # Store faculty information in MongoDB
    if faculty_list:
        db.professors.insert_many(faculty_list)
        print(f"Successfully parsed and stored information for {len(faculty_list)} faculty members")
        
        # Print summary of parsed data
        print("\nFaculty Information Summary:")
        for prof in faculty_list:
            print(f"\nName: {prof.get('name')}")
            print(f"Title: {prof.get('title', 'N/A')}")
            print(f"Office: {prof.get('office', 'N/A')}")
            print(f"Phone: {prof.get('phone', 'N/A')}")
            print(f"Email: {prof.get('email', 'N/A')}")
            print(f"Website: {prof.get('website', 'N/A')}")
    else:
        print("No faculty information found!")
    
    # Verify the number of professors
    prof_count = db.professors.count_documents({})
    if prof_count == 18:
        print(f"\nSuccess! Found all {prof_count} permanent faculty members")
    else:
        print(f"\nWarning: Found {prof_count} professors, expected 18")
    
    client.close()

if __name__ == "__main__":
    main()