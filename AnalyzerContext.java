public class AnalyzerContext
{
    private AnalyzerState state;

    public AnalyzerContext(AnalyzerState state)
    {
        this.state = state;
    }

    public void performAction()
    {
        state.performAction();
    }

    public void changeState()
    {
        this.state = state.changeState();
    }
}