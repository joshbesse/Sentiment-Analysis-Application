public class SentimentResult 
{
    private String sentiment;
    private double score; 
    
    public SentimentResult(String sentiment, double score)
    {
        this.sentiment = sentiment;
        this.score = score;
    }
    
    public String getSentiment()
    {
        return sentiment;
    }
    
    public double getScore()
    {
        return score; 
    }
}