package cfo;

public abstract class MutationFunction implements OptimizationFunction
{
  public MutationFunction()
  {
    // empty constructor
  }

  @Override
  public abstract void getSolution();

  public abstract int mutate(int parent);
}