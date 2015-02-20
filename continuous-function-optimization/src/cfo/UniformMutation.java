package cfo;

public class UniformMutation extends MutationFunction
{

  public UniformMutation(int iterations)
  {
    this.iterations = iterations;
  }

  @Override
  public int[] mutate(int[] parent)
  {
    int index = OptimizationFunction.rng.getRandomIndex(parent);
    parent[index] = OptimizationFunction.rng.getRandomNumberLargeInterval();
    return parent;
  }
}
