import pyautogui
import time
import random

# Open Microsoft Edge and navigate to the search page
pyautogui.press("winleft")
time.sleep(0.1)
pyautogui.write("Microsoft Edge")
time.sleep(0.1)

pyautogui.press("enter")

# pyautogui.write("https://www.bing.com")rapes

# pyautogui.press("enter")
time.sleep(2.5)

lst = ['Apple', 'Banana', 'Orange', 'Grapes', 'Strawberry', 'Blueberry', 'Watermelon', 'Pineapple', 'Mango', 'Kiwi','Peach', 'Plum', 'Cherry', 'Pear', 'Raspberry', 'Blackberry', 'Cantaloupe', 'Avocado', 'Pomegranate', 'Coconut', 'Lemon', 'Lime', 'Grapefruit', 'Papaya', 'Nectarine', 'Apricot', 'Cranberry', 'Fig', 'Guava', 'Passion Fruit','Dragon Fruit', 'Persimmon', 'Kumquat', 'Lychee', 'Pitaya', 'Jackfruit', 'Tangerine', 'Honeydew', 'Rambutan','Gooseberry', 'Mulberry', 'Elderberry', 'Clementine', 'Melon', 'Blackcurrant', 'Currant', 'Tamarillo']



for i in lst:
    # pyautogui.click(500, 150) # Replace these coordinates with the actual coordinates of the search box on your screen
    pyautogui.hotkey("ctrl", "e")
    random_float = random.random()
    time.sleep(random_float)
    pyautogui.write(i)
    
    pyautogui.press("enter")
    random_float = random.random()
    time.sleep(random_float + 9)
    pyautogui.hotkey("ctrl", "t")
    random_float = random.random()
    time.sleep(random_float)