import java.util.Scanner;

public class SentimentAnalysisApplication
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        SentimentAnalysisFacade facade = new SentimentAnalysisFacade();
        
        boolean exit = false;
        while (!exit)
        {
            System.out.println("\nWelcome to the Sentiment Analyzer");
            System.out.println("1. Show Description of Sentiment Analysis Methods");
            System.out.println("2. Select Sentiment Analysis Method");
            System.out.println("3. Analyze Text");
            System.out.println("4. Save Analysis");
            System.out.println("5. Restore Analysis");
            System.out.println("6. Exit");
            System.out.println("\nPlease enter your choice: ");
            
            String choice = scanner.nextLine();
            
            switch (choice)
            {
                case "1":
                    facade.showDescription();
                    break;
                case "2":
                    System.out.println("\nSelect a sentiment analyzer (basic/advanced)");
                    String analyzer_choice = scanner.nextLine();
                    facade.selectAnalyzer(analyzer_choice);
                    break;
                case "3":
                    System.out.println("\nEnter text to analyze:");
                    String input_text = scanner.nextLine();
                    facade.analyzeText(input_text);
                    break;
                case "4":
                    facade.saveAnalysis();
                    break;
                case "5":
                    facade.restoreAnalysis();
                    break;
                case "6":
                    exit = true; 
                    System.out.println("\nExiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
        scanner.close();
    }
}