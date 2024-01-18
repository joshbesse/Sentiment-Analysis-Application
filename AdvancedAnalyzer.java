import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AdvancedAnalyzer implements SentimentAnalyzer
{
    private String current_text;
    private SentimentResult current_result;
    private List<String> positive_words;
    private List<String> negative_words;
    private List<String> negation_words;
    private List<String> intensifier_words;
    private List<String> diminisher_words;
    private AnalyzerContext state; 

    public AdvancedAnalyzer()
    {
        // setting positive, negative, negation, intensifier, and diminisher words lists
        Read reader = new Read();
        this.positive_words = reader.fileToList("positive.txt");
        this.negative_words = reader.fileToList("negative.txt");
        this.negation_words = reader.fileToList("negation.txt");
        this.intensifier_words = reader.fileToList("intensifier.txt");
        this.diminisher_words = reader.fileToList("diminisher.txt");
        this.state = new AnalyzerContext(new InitializationState());
    }
    
    public SentimentResult analyzeSentiment(String text)
    {
        // setting text and sentiment score;
        this.current_text = text;
        double score = 0;

        // initialization state 
        state.performAction();
        System.out.println("analyzer: advanced");
        String[] tokens = text.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
        System.out.println("tokenization: " + Arrays.toString(tokens));
        state.changeState();

        // processing state
        List<String> positive_contained = new ArrayList<>();
        List<String> negative_contained = new ArrayList<>();
        List<String> negation_contained = new ArrayList<>();
        List<String> intensifier_contained = new ArrayList<>();
        List<String> diminisher_contained = new ArrayList<>();
        state.performAction();
        for (int i = 0; i < tokens.length; i++)
        {
            // setting score of current word 
            double word_score = 0;
            if (positive_words.contains(tokens[i]))
            {
                word_score = 1;
                positive_contained.add(tokens[i]);
            }
            else if (negative_words.contains(tokens[i]))
            {
                word_score = -1;
                negative_contained.add(tokens[i]);
            }
            
            if (i > 0)
            {
                if (negation_words.contains(tokens[i-1]))
                {
                    word_score *= -1;
                    negation_contained.add(tokens[i-1]);
                }
                else if (intensifier_words.contains(tokens[i-1]))
                {
                    word_score *= 1.5;
                    intensifier_contained.add(tokens[i-1]);
                }
                else if (diminisher_words.contains(tokens[i-1]))
                {
                    word_score *= 0.5;
                    diminisher_contained.add(tokens[i-1]);
                }
                score += word_score;             
            }
        }
        System.out.println("positive: " + positive_contained);
        System.out.println("negative: " + negative_contained);
        System.out.println("negation: " + negation_contained);
        System.out.println("intensifier: " + intensifier_contained);
        System.out.println("diminisher: " + diminisher_contained);
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
            sentiment = "negative";
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