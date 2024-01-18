public interface SentimentAnalyzer
{
    SentimentResult analyzeSentiment(String text);
    SentimentMemento saveState();
    void restoreState(SentimentMemento m);
}