public class ProcessingState implements AnalyzerState
{
    public String getState()
    {
        return "Processing";
    }

    public void performAction()
    {
        System.out.println("\nProcessing: analyzing sentiment");
    }

    public AnalyzerState changeState()
    {
        return new CompletedState();
    }
}