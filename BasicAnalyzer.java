import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class BasicAnalyzer implements SentimentAnalyzer
{
    private String current_text;
    private SentimentResult current_result; 
    private List<String> positive_words;
    private List<String> negative_words;
    private AnalyzerContext state;
    
    public BasicAnalyzer()
    {
        // setting positive and negative words lists
        Read reader = new Read();
        this.positive_words = reader.fileToList("positive.txt");
        this.negative_words = reader.fileToList("negative.txt");
        this.state = new AnalyzerContext(new InitializationState());
    }
    
    public SentimentResult analyzeSentiment(String text)
    {
        // setting text and sentiment score 
        this.current_text = text;
        int score = 0;
        
        // initialization state
        state.performAction();
        System.out.println("analyzer: basic");
        String[] tokens = text.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
        System.out.println("tokenization: " + Arrays.toString(tokens));
        state.changeState();

        // processing state
        List<String> positive_contained = new ArrayList<>();
        List<String> negative_contained = new ArrayList<>();
        state.performAction();
        for (String token : tokens)
        {
            if (positive_words.contains(token))
            {
                score++;
                positive_contained.add(token);
            }
            else if (negative_words.contains(token))
            {
                score--;
                negative_contained.add(token);
            }
        }
        System.out.println("positive: " + positive_contained);
        System.out.println("negative: " + negative_contained);
        state.changeState();
        
        // completed state
        String sentiment;
        state.performAction();
        if (score > 0)
        {
            sentiment = "positive";
        }
        else if (score < 0)
        {
            sentiment = "pegative";
        }
        else 
        {
            sentiment = "neutral";
        }
        
        this.current_result = new SentimentResult(sentiment, score);
        return current_result;
    }
    
    public SentimentMemento saveState()
    {
        return new SentimentMemento(current_text, current_result);
    }
    
    public void restoreState(SentimentMemento m)
    {
        this.current_text = m.getSavedText();
        this.current_result = m.getSavedResult();
    }
}