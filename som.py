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


lst =  [  'Paris',  'New York City',  'Tokyo',  'London',  'Barcelona',  'Sydney',  'Rio de Janeiro',  'Rome',  'Amsterdam',  'Hong Kong',  'San Francisco',  'Dubai',  'Mumbai',  'Istanbul',  'Cape Town',  'Berlin',  'Singapore',  'Vienna',  'Bangkok',  'Toronto',  'Shanghai',  'Montreal',  'Seoul',  'Moscow',  'Buenos Aires',  'Los Angeles',  'Melbourne',  'Havana',  'Jerusalem',  'Zurich','hyderabad','karnataka','Andra','telangana']


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