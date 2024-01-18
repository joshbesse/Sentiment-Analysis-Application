public class CompletedState implements AnalyzerState
{
    public String getState()
    {
        return "Completed";
    }

    public void performAction()
    {
        System.out.println("\nCompleted: analysis finished");
    }

    public AnalyzerState changeState()
    {
        return new InitializationState();
    }
}
