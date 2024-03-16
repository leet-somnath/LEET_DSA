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

lst = ['apple', 'banana', 'orange', 'grape', 'kiwi', 'pineapple', 'mango', 'strawberry', 'blueberry', 'watermelon',
        'peach', 'pear', 'plum', 'apricot', 'cherry', 'lemon', 'lime', 'coconut', 'pomegranate', 'raspberry',
        'blackberry', 'cantaloupe', 'honeydew', 'nectarine', 'fig', 'guava', 'papaya', 'tangerine', 'cranberry',
        'dragonfruit', 'passionfruit', 'lychee', 'persimmon', 'boysenberry', 'elderberry', 'mulberry', 'kiwifruit',
        'starfruit', 'quince', 'avocado', 'papaya', 'melon', 'apricot', 'plum', 'nectarine', 'guava', 'fig', 'pomegranate',
        'mango', 'passionfruit', 'lychee', 'dragonfruit', 'kiwifruit', 'starfruit', 'quince', 'avocado', 'papaya', 'melon']



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
