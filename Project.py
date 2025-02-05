from googletrans import Translator
import os

def translate_text_batch(file_path, src_language='auto', dest_language='en'):
    """
    Translates text from a file and outputs the results to a new file.
    
    Parameters:
        file_path (str): Path to the input text file.
        src_language (str): Source language code (default is 'auto' for auto-detection).
        dest_language (str): Target language code (default is 'en' for English).
    """
    # Check if the file exists
    if not os.path.exists(file_path):
        print("Error: File not found! Please provide a valid file path.")
        return
    
    translator = Translator()
    # Define output file name
    output_file = file_path.replace('.txt', '_translated.txt')
    
    try:
        with open(file_path, 'r', encoding='utf-8') as infile, open(output_file, 'w', encoding='utf-8') as outfile:
            print(f"Translating content from {file_path}...")
            for line in infile:
                # Skip empty lines
                if line.strip():
                    translated = translator.translate(line.strip(), src=src_language, dest=dest_language)
                    outfile.write(f"{translated.text}\n")
            print(f"Translation complete! Output saved to: {output_file}")
    except Exception as e:
        print(f"Error during translation: {e}")

def translate_text_interactive():
    """
    Provides an interactive console for translating single lines of text.
    """
    translator = Translator()
    print("Interactive Text Translator. Type 'exit' to quit.")
    
    while True:
        # Accept user input for text
        text = input("\nEnter text to translate (or 'exit' to quit): ")
        if text.lower() == 'exit':
            print("Exiting translator.")
            break
        
        # Accept source and target languages
        src_lang = input("Enter source language code (or 'auto' for detection): ").strip()
        dest_lang = input("Enter target language code: ").strip()
        
        try:
            # Translate the text
            translated = translator.translate(text, src=src_lang, dest=dest_lang)
            print(f"Original ({translated.src}): {text}")
            print(f"Translated ({translated.dest}): {translated.text}")
        except Exception as e:
            print(f"Error during translation: {e}")

if __name__ == "__main__":
    print("Choose a mode for translation:")
    print("1. Interactive Mode: Translate single sentences.")
    print("2. Batch Mode: Translate multiple lines from a file.")
    
    mode = input("Enter '1' for Interactive Mode or '2' for Batch Mode: ").strip()
    
    if mode == '2':  # Batch Mode
        file_path = input("Enter the full path of the text file to translate: ").strip()
        source_lang = input("Enter source language code (or 'auto' for detection): ").strip()
        target_lang = input("Enter target language code: ").strip()
        translate_text_batch(file_path, src_language=source_lang, dest_language=target_lang)
    elif mode == '1':  # Interactive Mode
        translate_text_interactive()
    else:
        print("Invalid choice. Please restart and choose either '1' or '2'.")
