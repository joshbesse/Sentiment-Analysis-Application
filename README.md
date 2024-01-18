# Sentiment-Analysis-Application

This project is a sentiment analysis application in Java.

Sentiment analysis is a field of natural language processing, which is the ability for computers to process human-created text. Sentiment analysis involves analyzing, understanding, and interpreting text to determine if the emotional tone of the message is positive, negative, or neutral.

Two main methods for sentiment analysis are lexicon-based methods and machine learning methods. My application incorporates lexicon-based methods. This approach relies on a predefined list of words with an associated score or category to determine the sentiment of a text.

I created two lexicon-based methods: basic and advanced. The basic analyzer contains instance variables for lists of positive and negative words. The input text is tokenized, meaning it is broken down into an array of individual words. The individual words are checked to see if they are contained in the positive or negative words lists. If the word is part of the positive words list, the sentiment score is incremented by 1. If the word is part of the negative words list, the sentiment score is decremented by 1. Based on the final sentiment score, a sentiment of "positive", "negative", or "neutral" is assigned. The advanced analyzer works similarly but with added features, specifically negation, intensifying, and diminishing handling. It has additional instance variables for lists of negation words (example: didn't), intensifier words (example: very), and diminisher words (example: somewhat). The advanced analyzer checks the previous word in the array to see if it is part of the negation, intensifier, or diminisher lists. If it is a negation word, the score for the current word is multiplied by -1. If it is an intensifier word, the score for the current word is multiplied by 1.5. If it is a diminisher word, the score for the current word is multiplied by 0.5.

To run the application, SentimentAnalysisApplication.java is the driver program.

I utilized four object-oriented design patterns to organize the code.

Factory Method: Gives ability to create instances of different sentiment analysis methods based on user input. Allows me to easily add and modify the kinds of sentiment analysis methods available.

Facade: Provides a simple interface for users to perform sentiment analysis without exposing the complexities of the process.

Memento: Grants additional feature that users can save an analysis result and revisit that analysis at a later time.

State: Manages the various stages of sentiment analysis and allows for smooth transition between them.
