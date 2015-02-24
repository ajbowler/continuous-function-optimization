package cfo;

public abstract class MutationFunction implements OptimizationFunction
{
  protected int iterations;

  protected CFONumberUtils numberUtils;

  protected int currentIteration;

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

  @Override
  public int getCurrentIteration()
  {
    return currentIteration;
  }

  @Override
  public void setCurrentIteration(int currentIteration)
  {
    this.currentIteration = currentIteration;
  }

  public CFONumberUtils getNumberUtils()
  {
    return numberUtils;
  }

  public void setNumberUtils(CFONumberUtils numberUtils)
  {
    this.numberUtils = numberUtils;
  }
}