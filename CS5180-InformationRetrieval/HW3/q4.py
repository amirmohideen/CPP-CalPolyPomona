#-------------------------------------------------------------------------
# AUTHOR: Amir Mohideen Basheer Khan
# FILENAME: CS5180HW3
# SPECIFICATION: Q4
# FOR: CS 5180- Assignment #3
# TIME SPENT: 1 hour
#-----------------------------------------------------------*/



from bs4 import BeautifulSoup
import re

# Sample HTML content
html = """
<html> 
<head> 
<title>My first web page</title> 
</head> 
<body> 
<h1>My first web page</h1> 
<h2>What this is tutorial</h2> 
<p>A simple page put together using HTML. <em>I said a simple page.</em>.</p> 
<ul> 
<li>To learn HTML</li> 
<li> 
To show off 
<ol> 
<li>To my boss</li> 
<li>To my friends</li> 
<li>To my cat</li> 
<li>To the little talking duck in my brain</li> 
</ol> 
</li> 
<li>Because I have fallen in love with my computer and want to give her some HTML loving.</li> 
</ul> 
<h3>Where to find the tutorial</h3> 
<p><a href="http://www.aaa.com"><img src=http://www.aaa.com/badge1.gif></a></p> 
<h4>Some random table</h4> 
<table> 
<tr class="tutorial1"> 
<td>Row 1, cell 1</td> 
<td>Row 1, cell 2<img src=http://www.bbb.com/badge2.gif></td> 
<td>Row 1, cell 3</td> 
</tr> 
<tr class="tutorial2"> 
<td>Row 2, cell 1</td> 
<td>Row 2, cell 2</td> 
<td>Row 2, cell 3<img src=http://www.ccc.com/badge3.gif></td> 
</tr> 
</table> 
</body> 
</html>
"""

soup = BeautifulSoup(html, "html.parser")


print("a:", soup.title.text)  


print("b:", soup.find('ol').find_all('li')[1].text)  


print("c:", soup.find('tr', class_='tutorial1').find_all('td'))  


print("d:", soup.find('h2', text=re.compile('tutorial')).text)  


print("e:", soup.find_all(text=re.compile('HTML')))  


print("f:", soup.find('tr', class_='tutorial2').get_text())  


print("g:", soup.find('table').find_all('img')) 