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

#lst = ['NumPy', 'Pandas', 'Matplotlib', 'Scikit-learn', 'TensorFlow', 'Keras', 'PyTorch', 'Django', 'Flask', 'Beautiful Soup', 'Requests', 'NLTK', 'Scrapy', 'Seaborn', 'Plotly', 'Bokeh', 'SciPy', 'SymPy', 'OpenCV', 'Gensim', 'Pygame', 'PyQt', 'Tkinter', 'Pillow', 'SQLAlchemy', 'Pymongo', 'Flask-RESTful', 'FastAPI', 'Tornado', 'PyGTK', 'PySide', 'wxPython', 'SQLAlchemy', 'Alembic', 'Celery', 'Asyncio']
#lst = ['Apple', 'Banana', 'Orange', 'Grape', 'Strawberry', 'Watermelon', 'Pineapple', 'Mango', 'Kiwi', 'Blueberry', 'Peach', 'Cherry', 'Pear', 'Plum', 'Raspberry', 'Blackberry', 'Cranberry', 'Coconut', 'Lemon', 'Lime', 'Pomegranate', 'Apricot', 'Grapefruit', 'Avocado', 'Fig', 'Nectarine', 'Papaya', 'Guava', 'Lychee', 'Cantaloupe', 'Honeydew', 'Tangerine', 'Passion Fruit', 'Dragon Fruit', 'Persimmon', 'Kumquat', 'Starfruit', 'Jackfruit', 'Rambutan', 'Durian']
#lst = ['Labrador Retriever', 'German Shepherd', 'Golden Retriever', 'Bulldog', 'Beagle', 'Poodle', 'French Bulldog', 'Rottweiler', 'Yorkshire Terrier', 'Boxer', 'Dachshund', 'Siberian Husky', 'Doberman Pinscher', 'Great Dane', 'Shih Tzu', 'Pomeranian', 'Cavalier King Charles Spaniel', 'Miniature Schnauzer', 'Chihuahua', 'Shetland Sheepdog', 'Boston Terrier', 'Pembroke Welsh Corgi', 'Havanese', 'Australian Shepherd', 'Brittany', 'Basset Hound', 'Weimaraner', 'Bernese Mountain Dog', 'Border Collie', 'Shiba Inu', 'Vizsla', 'Cane Corso', 'Newfoundland', 'Collie', 'Mastiff', 'Maltese', 'Pug', 'Dalmatian', 'Pointer', 'Rhodesian Ridgeback']
#lst = ['United States', 'Canada', 'Mexico', 'Brazil', 'Argentina', 'United Kingdom', 'France', 'Germany', 'Italy', 'Spain', 'Russia', 'China', 'India', 'Japan', 'South Korea', 'Australia', 'New Zealand', 'South Africa', 'Nigeria', 'Egypt', 'Kenya', 'Ghana', 'Saudi Arabia', 'United Arab Emirates', 'Turkey', 'Iran', 'Israel', 'Pakistan', 'Bangladesh', 'Indonesia', 'Philippines', 'Thailand', 'Vietnam', 'Malaysia', 'Singapore', 'Sweden', 'Norway', 'Denmark', 'Finland', 'Netherlands']
lst = ['Piano', 'Guitar', 'Violin', 'Cello', 'Flute', 'Trumpet', 'Saxophone', 'Drums', 'Clarinet', 'Harp', 'Banjo', 'Accordion', 'Trombone', 'Oboe', 'Double Bass', 'Xylophone', 'French Horn', 'Viola', 'Bass Guitar', 'Harmonica', 'Ukulele', 'Mandolin', 'Bagpipes', 'Organ', 'Synthesizer', 'Marimba', 'Steel Drum', 'Kazoo', 'Theremin', 'Didgeridoo', 'Balalaika', 'Djembe', 'Tabla', 'Cajón', 'Glockenspiel', 'Sitar', 'Kalimba', 'Erhu', 'Cymbals']
#lst = ['The Witcher 3: Wild Hunt', 'Grand Theft Auto V', 'Red Dead Redemption 2', 'The Legend of Zelda: Breath of the Wild', 'Dark Souls III', 'Bloodborne', 'Final Fantasy VII', 'Persona 5', 'Hollow Knight', 'Overwatch', 'Fortnite', 'Minecraft', 'League of Legends', 'Dota 2', 'Counter-Strike: Global Offensive', 'Apex Legends', 'Call of Duty: Warzone', 'Rainbow Six Siege', 'Super Mario Odyssey', 'Super Smash Bros. Ultimate', 'The Elder Scrolls V: Skyrim', 'God of War', 'Horizon Zero Dawn', 'Death Stranding', 'DOOM Eternal', 'Resident Evil 2', 'NieR: Automata', 'Bayonetta', 'The Last of Us Part II', 'Gears 5', 'Borderlands 3', 'Assassin\'s Creed Odyssey', 'Cyberpunk 2077', 'Ghost of Tsushima', 'Demon\'s Souls', 'Fallout 4', 'Monster Hunter: World', 'Sekiro: Shadows Die Twice', 'The Outer Worlds', 'Control', 'The Division 2', 'Far Cry 5']
#lst = ['To Kill a Mockingbird', '1984', 'The Great Gatsby', 'Pride and Prejudice', 'The Catcher in the Rye', 'Brave New World', 'The Lord of the Rings', 'The Hobbit', 'Harry Potter and the Sorcerer\'s Stone', 'The Hunger Games', 'The Da Vinci Code', 'The Chronicles of Narnia', 'The Alchemist', 'The Kite Runner', 'Gone with the Wind', 'The Girl with the Dragon Tattoo', 'The Road', 'Twilight', 'The Book Thief', 'The Fault in Our Stars', 'The Help', 'The Shining', 'A Song of Ice and Fire', 'The Handmaid\'s Tale', 'The Stand', 'The Hitchhiker\'s Guide to the Galaxy', 'Wuthering Heights', 'The Picture of Dorian Gray', 'Dracula', 'Frankenstein', 'Moby-Dick', 'War and Peace', 'Anna Karenina', 'Crime and Punishment', 'The Brothers Karamazov', 'Ulysses', 'The Sound and the Fury', 'Beloved', 'Invisible Man']
#lst = ['Logitech', 'Razer', 'Corsair', 'SteelSeries', 'Microsoft', 'Apple', 'HyperX', 'Ducky', 'Das Keyboard', 'Cooler Master', 'ASUS', 'ROCCAT', 'Redragon', 'Glorious PC Gaming Race', 'Filco', 'EVGA', 'Alienware', 'Thermaltake', 'Anker', 'Acer', 'HP', 'Lenovo', 'Dell', 'Aorus', 'G.Skill', 'Patriot Memory', 'IOGear', 'Keychron', 'Vortexgear', 'Rosewill', 'Kinesis', 'Ergodox', 'Matias', 'Adesso', 'WASD Keyboards', 'Varmilo', 'Topre', 'Realforce', 'HHKB', 'Cherry']
#lst = ['The Shawshank Redemption', 'The Godfather', 'The Dark Knight', 'Schindler\'s List', 'Pulp Fiction', 'The Lord of the Rings: The Return of the King', 'The Good, the Bad and the Ugly', 'Fight Club', 'Forrest Gump', 'Inception', 'The Matrix', 'Goodfellas', 'Star Wars: Episode V - The Empire Strikes Back', 'The Silence of the Lambs', 'The Green Mile', 'The Godfather: Part II', 'Se7en', 'Life is Beautiful', 'The Usual Suspects', 'Léon: The Professional', 'Saving Private Ryan', 'Interstellar', 'The Lion King', 'Gladiator', 'The Prestige', 'American History X', 'The Departed', 'The Pianist', 'The Intouchables', 'Terminator 2: Judgment Day', 'The Lives of Others', 'Cinema Paradiso', 'City of God', 'Back to the Future', 'Psycho', 'The Shining', 'The Departed', 'Braveheart', 'The Sixth Sense', 'Jurassic Park']
#lst = ['Python', 'Java', 'JavaScript', 'C#', 'C++', 'Swift', 'Go', 'Ruby', 'Rust', 'Kotlin', 'TypeScript', 'PHP', 'HTML', 'CSS', 'SQL', 'R', 'Shell', 'Objective-C', 'Scala', 'Perl', 'Lua', 'Assembly', 'MATLAB', 'Haskell', 'Dart', 'Julia', 'Groovy', 'Visual Basic', 'Delphi', 'Cobol', 'Fortran', 'Ada', 'Lisp', 'Prolog', 'Erlang', 'Scheme', 'Smalltalk', 'Tcl', 'Bash', 'PowerShell']

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
