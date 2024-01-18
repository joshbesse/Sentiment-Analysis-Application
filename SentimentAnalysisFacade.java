public class SentimentAnalysisFacade
{
    private SentimentAnalyzer sentiment_analyzer;
    private SentimentMemento memento;
    
    public void showDescription()
    {
        System.out.println("\nBasic Analyzer: Lexicon-based sentiment analysis that adds 1 for positive words and -1 for negative words.");
        System.out.println("Advanced Analyzer: Lexicon-based sentiment analysis with added capacity for negation words, intensifier words, and diminisher words.");
    }
    
    public void selectAnalyzer(String type)
    {
        if (type.equals("basic"))
        {
            AnalyzerMaker maker = new BasicAnalyzerMaker();
            this.sentiment_analyzer = maker.makeAnalyzer();
            System.out.println("\n" + type + " analyzer selected");
        }
        else if (type.equals("advanced"))
        {
            AnalyzerMaker maker = new AdvancedAnalyzerMaker();
            this.sentiment_analyzer = maker.makeAnalyzer();
            System.out.println("\n" + type + " analyzer selected");
        }
        else
        {
            System.out.println("\nPlease select 'basic' or 'advanced'.");
        }
    }
    
    public void analyzeText(String text)
    {
        if (sentiment_analyzer == null)
        {
            System.out.println("\nPlease select an analyzer first.");
            return;
        }
        SentimentResult result = sentiment_analyzer.analyzeSentiment(text);
        System.out.println("sentiment: " + result.getSentiment() + "\nscore: " + result.getScore());
    }
    
    public void saveAnalysis()
    {
        if (sentiment_analyzer == null)
        {
            System.out.println("\nNo analysis to save.");
        }
        else
        {
            this.memento = sentiment_analyzer.saveState();
            System.out.println("\nAnalysis saved.");
        }
    }
    
    public void restoreAnalysis()
    {
        if (memento == null)
        {
            System.out.println("\nNo saved analysis to restore.");
        }
        else
        {
            sentiment_analyzer.restoreState(memento);
            System.out.println("\nstored input text: " + memento.getSavedText() + "\nstored sentiment: " + memento.getSavedResult().getSentiment() + "\nstored score: " + memento.getSavedResult().getScore());
        }
    }
    
}