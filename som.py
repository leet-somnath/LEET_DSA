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

#lst = ["GPT-3", "BERT", "XLNet", "RoBERTa", "T5", "ALBERT", "ELECTRA", "GPT-2", "DistilBERT", "UniLM", "GPT-4", "Megatron", "CTRL", "XLM-RoBERTa", "CamemBERT", "Reformer", "BART", "Pegasus", "Bertini", "GPTune", "LED", "Longformer", "DALL-E", "Turing-NLG", "DialoGPT", "MiniLM", "SpanBERT", "DPR", "ERIE", "BlenderBot", "LayoutLM", "RemBERT", "LaBSE", "Marian", "ProphetNet"]

lst = ["United States", "China", "India", "Brazil", "Russia", "United Kingdom", "France", "Germany", "Japan", "Italy", "Canada", "South Korea", "Australia", "Spain", "Mexico", "Indonesia", "Netherlands", "Saudi Arabia", "Turkey", "Switzerland", "Poland", "Sweden", "Belgium", "Norway", "Austria", "Iran", "UAE", "Israel", "Ireland", "Singapore", "Portugal", "Malaysia", "Denmark", "Philippines", "Pakistan"]

#lst = ["Apple", "Banana", "Orange", "Grapes", "Strawberry", "Watermelon", "Pineapple", "Mango", "Kiwi", "Peach", "Pear", "Cherry", "Plum", "Blueberry", "Raspberry", "Apricot", "Lemon", "Lime", "Coconut", "Pomegranate", "Avocado", "Cantaloupe", "Fig", "Grapefruit", "Guava", "Papaya", "Passionfruit", "Lychee", "Kumquat", "Nectarine", "Dragonfruit", "Cranberry", "Tangerine", "Persimmon", "Starfruit"]

#lst = ["Lion", "Tiger", "Elephant", "Giraffe", "Zebra", "Hippo", "Rhinoceros", "Kangaroo", "Panda", "Penguin", "Dolphin", "Whale", "Shark", "Octopus", "Eagle", "Owl", "Crocodile", "Alligator", "Gorilla", "Monkey", "Sloth", "Squirrel", "Rabbit", "Fox", "Bear", "Wolf", "Deer", "Moose", "Buffalo", "Horse", "Cow", "Sheep", "Goat", "Pig", "Chicken", "Duck"]

#lst= ["Red", "Blue", "Green", "Yellow", "Orange", "Purple", "Pink", "Brown", "Black", "White", "Gray", "Cyan", "Magenta", "Turquoise", "Gold", "Silver", "Indigo", "Maroon", "Navy", "Teal", "Lavender", "Beige", "Olive", "Coral", "Violet", "Peach", "Mint", "Lime", "Tan", "Aqua", "Salmon", "Ivory", "Ruby", "Sapphire", "Emerald", "Amber"]

#lst = ["Doctor", "Engineer", "Teacher", "Lawyer", "Nurse", "Scientist", "Artist", "Writer", "Chef", "Architect", "Police officer", "Firefighter", "Pilot", "Actor", "Musician", "Photographer", "Dentist", "Psychologist", "Veterinarian", "Journalist", "Entrepreneur", "Athlete", "Designer", "Programmer", "Accountant", "Economist", "Electrician", "Plumber", "Farmer", "Mechanic", "Librarian", "Biologist", "Chemist", "Geologist", "Sociologist", "Psychiatrist"]
#lst = ["Carrot", "Broccoli", "Tomato", "Potato", "Cucumber", "Lettuce", "Spinach", "Onion", "Garlic", "Bell pepper", "Eggplant", "Zucchini", "Celery", "Cabbage", "Radish", "Mushroom", "Pumpkin", "Sweet potato", "Green beans", "Asparagus", "Kale", "Cauliflower", "Peas", "Brussels sprouts", "Artichoke", "Beetroot", "Turnip", "Leek", "Squash", "Okra", "Fennel", "Rhubarb", "Bok choy", "Chili pepper", "Corn"]
#lst = ["Soccer", "Basketball", "Tennis", "Cricket", "Golf", "Rugby", "Baseball", "Volleyball", "American football", "Hockey", "Swimming", "Athletics", "Boxing", "Cycling", "Wrestling", "Martial arts", "Skiing", "Snowboarding", "Skateboarding", "Surfing", "Table tennis", "Badminton", "Gymnastics", "Diving", "Sailing", "Rowing", "Fencing", "Weightlifting", "Judo", "Taekwondo", "Karate", "Horse racing", "Formula 1", "Motorcycle racing", "Sumo wrestling"]
#lst = ["Cake", "Ice cream", "Pie", "Cookies", "Brownies", "Pudding", "Cupcake", "Cheesecake", "Tiramisu", "Chocolate mousse", "Creme brulee", "Macarons", "Donuts", "Muffins", "Cannoli", "Eclair", "Fruit tart", "Banoffee pie", "Trifle", "Fudge", "Churros", "Gelato", "Baklava", "Cobbler", "Sorbet", "Frozen yogurt", "Tartufo", "Parfait", "Rice pudding", "Pavlova", "Biscotti", "Strudel", "Nanaimo bar", "Praline", "Mochi"]
#lst = ["Piano", "Guitar", "Violin", "Drums", "Flute", "Saxophone", "Trumpet", "Cello", "Clarinet", "Harp", "Accordion", "Trombone", "Banjo", "Harmonica", "Oboe", "Mandolin", "Xylophone", "Bass guitar", "French horn", "Bagpipes", "Ukulele", "Double bass", "Piccolo", "Viola", "Tuba", "Synthesizer", "Marimba", "Sitar", "Balalaika", "Tabla", "Didgeridoo", "Koto", "Theremin", "Glockenspiel", "Djembe"]
#lst = ["Toyota", "Honda", "Ford", "Chevrolet", "Volkswagen", "BMW", "Mercedes-Benz", "Audi", "Nissan", "Hyundai", "Kia", "Tesla", "Lexus", "Mazda", "Subaru", "Volvo", "Porsche", "Ferrari", "Lamborghini", "Jeep", "Chrysler", "Dodge", "Buick", "Cadillac", "Jaguar", "Land Rover", "Mitsubishi", "Infiniti", "Acura", "Peugeot", "Renault", "Skoda", "Suzuki", "Tata", "Fiat"]
#lst = [ "Apple", "Google", "Amazon", "Microsoft", "Facebook", "Tesla", "Alphabet", "Oracle", "IBM", "Intel","Cisco", "Adobe", "Salesforce", "Netflix", "PayPal", "Nvidia", "Samsung", "Toyota", "Nike", "McDonald's","Coca-Cola", "Disney", "BMW", "Sony", "General Electric", "Visa", "Mastercard", "Starbucks", "UPS","FedEx", "Walmart", "Target", "L'Oréal", "Johnson & Johnson", "Procter & Gamble"]



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
