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

#lst = ["William Shakespeare", "Mark Twain", "Jane Austen", "Charles Dickens", "F. Scott Fitzgerald", "J.K. Rowling", "George Orwell", "Ernest Hemingway", "Leo Tolstoy", "Fyodor Dostoevsky", "Agatha Christie", "J.R.R. Tolkien", "Harper Lee", "Gabriel Garcia Marquez", "James Joyce", "Virginia Woolf", "Herman Melville", "Emily Bronte", "Toni Morrison", "Oscar Wilde", "Franz Kafka", "Victor Hugo", "John Steinbeck", "Margaret Atwood", "George R.R. Martin", "Kurt Vonnegut", "Isabel Allende", "H.G. Wells", "Albert Camus", "Ian Fleming", "J.D. Salinger", "Stephen King", "Ray Bradbury", "Arthur Conan Doyle", "Roald Dahl"]
#lst = ["Python", "JavaScript", "Java", "C++", "Ruby", "Swift", "Kotlin", "Go", "Rust", "PHP", "Perl", "TypeScript", "C#", "R", "MATLAB", "Scala", "Lua", "Haskell", "Erlang", "Elixir", "Dart", "Clojure", "Objective-C", "VB.NET", "Groovy", "F#", "Scheme", "COBOL", "Fortran", "Ada", "Julia", "Shell", "SQL", "Prolog", "Scratch"]
#lst = ["New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose", "Austin", "Jacksonville", "Fort Worth", "Columbus", "Charlotte", "San Francisco", "Indianapolis", "Seattle", "Denver", "Washington D.C.", "Boston", "El Paso", "Nashville", "Detroit", "Oklahoma City", "Las Vegas", "Portland", "Memphis", "Louisville", "Baltimore", "Milwaukee", "Albuquerque", "Tucson", "Fresno", "Sacramento"]
#lst = ["Eiffel Tower", "Statue of Liberty", "Great Wall of China", "Pyramids of Giza", "Machu Picchu", "Taj Mahal", "Colosseum", "Big Ben", "Sydney Opera House", "Christ the Redeemer", "Mount Rushmore", "Louvre Museum", "Golden Gate Bridge", "Stonehenge", "Burj Khalifa", "Petra", "Angkor Wat", "Acropolis of Athens", "Sagrada Familia", "Brandenburg Gate", "Neuschwanstein Castle", "Empire State Building", "Chichen Itza", "Saint Basil's Cathedral", "Mount Fuji", "Hagia Sophia", "Tower of London", "Alhambra", "Notre-Dame Cathedral", "Buckingham Palace", "CN Tower", "Santorini", "Blue Mosque", "Banff National Park", "Yosemite National Park"]
#lst = ["Mona Lisa", "Starry Night", "The Last Supper", "The Scream", "Girl with a Pearl Earring", "Guernica", "The Persistence of Memory", "The Birth of Venus", "The Night Watch", "American Gothic", "The Kiss", "Water Lilies", "The Arnolfini Portrait", "The School of Athens", "Las Meninas", "Whistler's Mother", "The Hay Wain", "Liberty Leading the People", "The Garden of Earthly Delights", "Olympia", "The Raft of the Medusa", "The Card Players", "Bal du moulin de la Galette", "Impression, Sunrise", "A Sunday Afternoon on the Island of La Grande Jatte", "The Swing", "The Great Wave off Kanagawa", "Christina's World", "Napoleon Crossing the Alps", "The Flower Carrier", "Dogs Playing Poker", "The Fighting Temeraire", "Ophelia", "The Third of May 1808", "The Storm on the Sea of Galilee"]
#lst = ["Dragon", "Unicorn", "Phoenix", "Griffin", "Mermaid", "Cyclops", "Centaur", "Kraken", "Basilisk", "Hydra", "Minotaur", "Sphinx", "Pegasus", "Chimera", "Werewolf", "Vampire", "Fairy", "Banshee", "Yeti", "Sasquatch", "Goblin", "Troll", "Elf", "Dwarf", "Leprechaun", "Golem", "Djinn", "Kelpie", "Wendigo", "Selkie", "Hippogriff", "Manticore", "Nymph", "Ogre", "Cerberus"]
#lst = ["Object-Oriented Programming", "Functional Programming", "Procedural Programming", "Event-Driven Programming", "Aspect-Oriented Programming", "Logic Programming", "Concurrent Programming", "Declarative Programming", "Imperative Programming", "Structured Programming", "Scripting Programming", "Symbolic Programming", "Reflective Programming", "Array Programming", "Reactive Programming", "Distributed Programming", "Component-Based Programming", "Microservice Programming", "Batch Programming", "Rule-Based Programming", "Multi-Paradigm Programming", "Generative Programming", "Metaprogramming", "Natural Language Programming", "Automata-Based Programming", "Quantum Programming", "Genetic Programming", "Probabilistic Programming", "Agent-Based Programming", "Flow-Based Programming", "Graph-Based Programming", "Constraint Programming", "Pipeline Programming", "Dynamic Programming", "Service-Oriented Programming"]
#lst = ["Hydrogen", "Helium", "Lithium", "Beryllium", "Boron", "Carbon", "Nitrogen", "Oxygen", "Fluorine", "Neon", "Sodium", "Magnesium", "Aluminum", "Silicon", "Phosphorus", "Sulfur", "Chlorine", "Argon", "Potassium", "Calcium", "Scandium", "Titanium", "Vanadium", "Chromium", "Manganese", "Iron", "Cobalt", "Nickel", "Copper", "Zinc", "Gallium", "Germanium", "Arsenic", "Selenium", "Bromine"]
#lst = ["Pride and Prejudice", "Moby-Dick", "War and Peace", "1984", "The Great Gatsby", "To Kill a Mockingbird", "Ulysses", "Crime and Punishment", "The Catcher in the Rye", "Wuthering Heights", "Great Expectations", "Jane Eyre", "Anna Karenina", "The Brothers Karamazov", "Brave New World", "The Odyssey", "One Hundred Years of Solitude", "Les Misérables", "Madame Bovary", "Don Quixote", "The Iliad", "Catch-22", "The Grapes of Wrath", "The Picture of Dorian Gray", "The Scarlet Letter", "Heart of Darkness", "Frankenstein", "Dracula", "Alice's Adventures in Wonderland", "The Count of Monte Cristo", "The Hobbit", "Gone with the Wind", "The Lord of the Rings", "Lolita", "A Tale of Two Cities"]
#lst = ["Albert Einstein", "Isaac Ne#wton", "Marie Curie", "Charles Darwin", "Nikola Tesla", "Galileo Galilei", "Stephen Hawking", "Leonardo da Vinci", "Louis Pasteur", "Sigmund Freud", "Carl Sagan", "Richard Feynman", "Niels Bohr", "Michael Faraday", "Alexander Fleming", "Gregor Mendel", "James Watson", "Francis Crick", "Rosalind Franklin", "Ada Lovelace", "Alan Turing", "Johannes Kepler", "Max Planck", "Erwin Schrödinger", "J.J. Thomson", "Enrico Fermi", "Dmitri Mendeleev", "Edwin Hubble", "Robert Hooke", "Alfred Wegener", "Henrietta Leavitt", "Carolyn Porco", "Katherine Johnson", "Lise Meitner", "Emmy Noether"]
#lst = ["Violin", "Viola", "Cello", "Double Bass", "Harp", "Flute", "Oboe", "Clarinet", "Bassoon", "Trumpet", "Trombone", "French Horn", "Tuba", "Timpani", "Snare Drum", "Bass Drum", "Cymbals", "Triangle", "Glockenspiel", "Xylophone", "Marimba", "Piano", "Piccolo", "English Horn", "Contrabassoon", "Alto Saxophone", "Tenor Saxophone", "Baritone Saxophone", "Harmonica", "Accordion", "Bagpipes", "Mandolin", "Castanets", "Tambourine", "Sitar"]
lst = ["Agile", "Scrum", "Kanban", "Waterfall", "Lean", "Extreme Programming", "DevOps", "Rapid Application Development", "Spiral Model", "V-Model", "Incremental Model", "RAD Model", "Feature-Driven Development", "Crystal Methods", "DSDM", "Test-Driven Development", "Behavior-Driven Development", "Joint Application Development", "Prototyping Model", "Adaptive Software Development", "Unified Process", "Model-Driven Architecture", "Structured Programming", "Object-Oriented Development", "Component-Based Development", "Aspect-Oriented Development", "Service-Oriented Architecture", "Domain-Driven Design", "Design Thinking", "Secure Software Development", "Big Bang Model", "Phased Development", "Continuous Integration", "Continuous Deployment", "Infrastructure as Code"]
#lst = ["Apollo 11", "Vostok 1", "Mars Pathfinder", "Voyager 1", "Curiosity Rover", "Cassini-Huygens", "New Horizons", "Pioneer 10", "International Space Station", "Hubble Space Telescope", "Chandrayaan-1", "Juno", "Rosetta", "Galileo", "Luna 2", "Mercury-Atlas 6", "Mars Express", "Philae", "Spirit Rover", "Opportunity Rover", "Gemini 4", "Surveyor 1", "Viking 1", "Kepler", "OSIRIS-REx", "Sputnik 1", "Soyuz 1", "Mariner 4", "Hayabusa", "James Webb Space Telescope", "TESS", "Dawn", "InSight", "Perseverance Rover", "Parker Solar Probe"]
#lst = ["Fall of the Roman Empire", "French Revolution", "World War I", "World War II", "American Civil War", "Industrial Revolution", "Renaissance", "Discovery of America", "Moon Landing", "Signing of the Magna Carta", "Russian Revolution", "Vietnam War", "Berlin Wall Fall", "Columbus's First Voyage", "Black Death", "Protestant Reformation", "Treaty of Versailles", "Battle of Waterloo", "Boston Tea Party", "Assassination of Archduke Franz Ferdinand", "Gutenberg's Printing Press", "Storming of the Bastille", "Hiroshima Bombing", "Women's Suffrage Movement", "Cuban Missile Crisis", "Sinking of the Titanic", "9/11 Attacks", "Apollo 13 Mission", "Founding of Rome", "First Crusade", "Stock Market Crash of 1929", "Discovery of Penicillin", "Marathon Battle", "Independence of India", "Battle of Gettysburg"]
#lst = ["Gabriel Garcia Marquez", "Toni Morrison", "Ernest Hemingway", "Albert Camus", "William Faulkner", "George Bernard Shaw", "Pablo Neruda", "Hermann Hesse", "Rudyard Kipling", "Rabindranath Tagore", "Doris Lessing", "Orhan Pamuk", "Wole Soyinka", "Nadine Gordimer", "Mario Vargas Llosa", "Kazuo Ishiguro", "Bob Dylan", "Olga Tokarczuk", "Alice Munro", "Haruki Murakami", "J.M. Coetzee", "Seamus Heaney", "Wisława Szymborska", "Yasunari Kawabata", "Patrick Modiano", "Svetlana Alexievich", "John Steinbeck", "Isaac Bashevis Singer", "Saul Bellow", "Gabriel Garcia Marquez", "Samuel Beckett", "Octavio Paz", "Luigi Pirandello", "Henrik Ibsen", "Derek Walcott"]
#lst = ["Ballet", "Hip Hop", "Salsa", "Tango", "Jazz", "Tap Dance", "Contemporary", "Ballroom", "Breakdance", "Swing", "Flamenco", "Belly Dance", "Kathak", "Odissi", "Bharatanatyam", "Kuchipudi", "Popping", "Locking", "Krumping", "Bollywood", "Bachata", "Waltz", "Foxtrot", "Quickstep", "Rumba", "Cha-Cha", "Mambo", "Merengue", "Samba", "Polka", "Square Dance", "Line Dance", "Irish Dance", "Scottish Highland Dance", "Capoeira"]
#lst = ["Socrates", "Plato", "Aristotle", "Confucius", "René Descartes", "Immanuel Kant", "Friedrich Nietzsche", "Karl Marx", "John Locke", "David Hume", "Thomas Hobbes", "Jean-Jacques Rousseau", "Voltaire", "Søren Kierkegaard", "Simone de Beauvoir", "Bertrand Russell", "Ludwig Wittgenstein", "Michel Foucault", "Gottfried Wilhelm Leibniz", "Baruch Spinoza", "John Stuart Mill", "Georg Wilhelm Friedrich Hegel", "Arthur Schopenhauer", "Albert Camus", "Jean-Paul Sartre", "Heraclitus", "Epicurus", "Diogenes", "Zeno of Citium", "Avicenna", "Thomas Aquinas", "Blaise Pascal", "Francis Bacon", "George Berkeley", "Noam Chomsky"]
#lst = ["Labrador Retriever", "German Shepherd", "Golden Retriever", "Bulldog", "Beagle", "Poodle", "Rottweiler", "Yorkshire Terrier", "Boxer", "Dachshund", "Shih Tzu", "Great Dane", "Siberian Husky", "Doberman Pinscher", "Australian Shepherd", "Cocker Spaniel", "Chihuahua", "Pomeranian", "Pug", "French Bulldog", "Maltese", "Border Collie", "Basset Hound", "Cavalier King Charles Spaniel", "Miniature Schnauzer", "Boston Terrier", "Shiba Inu", "Akita", "Saint Bernard", "Weimaraner", "Papillon", "Old English Sheepdog", "Newfoundland", "Samoyed", "Bichon Frise"]
#lst = ["React", "Angular", "Vue.js", "Django", "Flask", "Spring", "Rails", "Laravel", "ASP.NET", "Express", "Meteor", "Ember.js", "Backbone.js", "Symfony", "CodeIgniter", "CakePHP", "Yii", "Zend Framework", "Ruby on Rails", "Sails.js", "Pyramid", "Bottle", "FastAPI", "NestJS", "Next.js", "Nuxt.js", "Electron", "Flutter", "Ionic", "PhoneGap", "Cordova", "NativeScript", "Quasar", "Aurelia", "Marko"]



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


#i love it
