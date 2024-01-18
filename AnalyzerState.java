public interface AnalyzerState
{
    String getState();
    void performAction();
    AnalyzerState changeState();
}