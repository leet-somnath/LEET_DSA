import pyautogui
import time
import random

# Open Microsoft Edge and navigate to the search page
pyautogui.press("winleft")
time.sleep(0.1)
pyautogui.write("Microsoft Edge")
time.sleep(0.1)

pyautogui.press("enter")

# pyautogui.write("https://www.bing.com")

# pyautogui.press("enter")
time.sleep(2.5)


lst = ['Apple', 'Banana', 'Orange', 'Grapes', 'Strawberry', 'Blueberry', 'Watermelon', 'Pineapple', 'Mango', 'Kiwi','Peach', 'Plum', 'Cherry', 'Pear', 'Raspberry', 'Blackberry', 'Cantaloupe', 'Avocado', 'Pomegranate', 'Coconut', 'Lemon', 'Lime', 'Grapefruit', 'Papaya', 'Nectarine', 'Apricot', 'Cranberry', 'Fig', 'Guava', 'Passion Fruit','Dragon Fruit', 'Persimmon', 'Kumquat', 'Lychee', 'Pitaya', 'Jackfruit', 'Tangerine', 'Honeydew', 'Rambutan','Gooseberry', 'Mulberry', 'Elderberry', 'Clementine', 'Melon', 'Blackcurrant', 'Currant', 'Tamarillo']

# Capital names
#lst= ["Tokyo", "London", "Paris", "New York", "Beijing", "Berlin", "Moscow", "Dubai", "Rome", "Washington","Ottawa", "Brasilia", "Buenos Aires", "Cairo", "Sydney", "Stockholm", "Oslo", "Bangkok", "Mumbai", "Seoul","Amsterdam", "Madrid", "Vienna", "Lisbon", "Helsinki", "Nairobi", "Athens", "Copenhagen", "Dublin", "Prague"]

# Chocolate names
#lst = ["Milk Chocolate", "Dark Chocolate", "White Chocolate", "Hazelnut Praline", "Caramel", "Raspberry Truffle","Almond Joy", "Toffee Crunch", "Coconut Cluster", "Peppermint Bark", "Cherry Cordial", "Cookies and Cream","Salted Caramel", "Peanut Butter Cup", "Mocha Espresso", "Champagne Truffle", "Orange Cream", "Maple Walnut","Irish Cream", "Gingerbread Spice", "Pistachio", "Cappuccino", "Strawberry Cheesecake", "Cinnamon Pecan","Rum Raisin", "Toasted Coconut", "Rocky Road", "S'mores", "Matcha Green Tea", "Sea Salted Caramel"]

# Car brand names



for i in lst:
    # pyautogui.click(500, 150) # Replace these coordinates with the actual coordinates of the search box on your screen
    pyautogui.hotkey("ctrl", "e")
    random_float = random.random()
    time.sleep(random_float)
    pyautogui.write(i)
   
    pyautogui.press("enter")
    random_float = random.random()
    time.sleep(random_float + 5)
    pyautogui.hotkey("ctrl", "t")
    random_float = random.random()
    time.sleep(random_float)
