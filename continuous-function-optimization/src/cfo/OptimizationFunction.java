package cfo;

public interface OptimizationFunction
{
  public static final TimeRNG rng = new TimeRNG();

  public void getSolution();
  
  public int getTotalIterations();
  
  public void setTotalIterations(int iterations);
}