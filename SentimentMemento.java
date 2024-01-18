public class SentimentMemento
{
    private String text;
    private SentimentResult result;
    
    public SentimentMemento(String text, SentimentResult result)
    {
        this.text = text;
        this.result = result;
    }
    
    public String getSavedText()
    {
        return text;
    }
    
    public SentimentResult getSavedResult()
    {
        return result;
    }
}