public class AdvancedAnalyzerMaker implements AnalyzerMaker
{
    public SentimentAnalyzer makeAnalyzer()
    {
        return new AdvancedAnalyzer();
    }
}