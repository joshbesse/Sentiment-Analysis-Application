public class BasicAnalyzerMaker implements AnalyzerMaker
{
    public SentimentAnalyzer makeAnalyzer()
    {
        return new BasicAnalyzer();
    }
}