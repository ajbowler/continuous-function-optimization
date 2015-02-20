package cfo;

public abstract class MutationFunction implements OptimizationFunction
{
  protected int iterations;

  @Override
  public void getSolution()
  {
    // do nothing
  }

  public abstract int[] mutate(int[] x);

  @Override
  public int getTotalIterations()
  {
    return this.iterations;
  }

  @Override
  public void setTotalIterations(int iterations)
  {
    this.iterations = iterations;
  }
  
  protected int round(double result)
  {
    if (result - Math.floor(result) > Math.ceil(result) - result)
      return (int) Math.ceil(result);
    else
      return (int) Math.floor(result);
  }
}