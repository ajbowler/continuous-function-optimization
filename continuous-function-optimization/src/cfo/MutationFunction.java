package cfo;

public abstract class MutationFunction implements OptimizationFunction
{
  protected int iterations;

  @Override
  public void getSolution()
  {
    // do nothing
  }

  public abstract double[] mutate(double[] x);

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
}