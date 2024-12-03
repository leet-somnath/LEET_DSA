import streamlit as st
import re
import joblib
from sklearn.feature_extraction.text import CountVectorizer
# Import necessary libraries
import pandas as pd
import numpy as np
import re
from nltk.corpus import stopwords
from nltk.stem import PorterStemmer
from sklearn.model_selection import train_test_split
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.naive_bayes import MultinomialNB
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix

# Sample dataset (replace with your own dataset or download from a source like Kaggle)
# This dataset should have at least two columns: 'review' (text) and 'sentiment' (label)
data = pd.read_csv('movie_reviews.csv')  # Replace with your own dataset
data.dropna(inplace=True)  # Remove rows with missing data

# Display basic information about the dataset
print(data.info())
print(data.head())


# Load the trained model and vectorizer
model = joblib.load('sentiment_model.pkl')
vectorizer = joblib.load('vectorizer.pkl')

# Function to preprocess and predict sentiment
def preprocess_text(text):
    text = re.sub(r'http\S+', '', text)  # Remove URLs
    text = re.sub(r'[^a-zA-Z\s]', '', text)  # Remove non-alphabetic characters
    text = text.lower()  # Convert to lowercase 1 
    text = text.split()  # Tokenize
    text = [word for word in text if word not in stopwords.words('english')]  # Remove stopwords
    text = ' '.join(text)
    return text

def predict_sentiment(text):
    text = preprocess_text(text)
    text_vec = vectorizer.transform([text])
    prediction = model.predict(text_vec)
    return 'Positive' if prediction == 1 else 'Negative'
# Define the target variable
y = data['sentiment']  # Assuming binary sentiment (0 = Negative, 1 = Positive)

# Split the data into training and testing sets (80% train, 20% test)
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Train a Naive Bayes model
model = MultinomialNB()
model.fit(X_train, y_train)

# Make predictions on the test set
y_pred = model.predict(X_test)

# Evaluate the model performance
print(f"Accuracy: {accuracy_score(y_test, y_pred)}")
print(f"Classification Report: \n{classification_report(y_test, y_pred)}")
print(f"Confusion Matrix: \n{confusion_matrix(y_test, y_pred)}")

# Streamlit Web App Interface
st.title('Sentiment Analysis Web App')

# User input box for text
user_input = st.text_area("Enter the text to analyze sentiment:")

# Prediction on button click
if st.button("Predict"):
    if user_input:
        sentiment = predict_sentiment(user_input)
        st.write(f"Predicted Sentiment: {sentiment}")
    else:
        st.write("Please enter some text.")