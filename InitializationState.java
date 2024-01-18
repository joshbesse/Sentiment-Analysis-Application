public class InitializationState implements AnalyzerState
{
    public String getState()
    {
        return "Initialization";
    }
    
    public void performAction()
    {
        System.out.println("\nInitialization: preparing analysis");
    }

    public AnalyzerState changeState()
    {
        return new ProcessingState();
    }
}
