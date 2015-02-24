package cfo;

public interface OptimizationFunction
{
  public void getSolution();

  public int getTotalIterations();

  public void setTotalIterations(int iterations);
  
  public int getCurrentIteration();
  
  public void setCurrentIteration(int currentIteration);
}