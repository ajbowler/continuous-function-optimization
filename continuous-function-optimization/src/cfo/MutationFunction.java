package cfo;

public abstract class MutationFunction implements OptimizationFunction
{
  protected int iterations;

  @Override
  public abstract void getSolution();

  public abstract int mutate(int parent);

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