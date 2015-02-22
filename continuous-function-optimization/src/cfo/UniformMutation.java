package cfo;

public class UniformMutation extends MutationFunction
{

  public UniformMutation(int iterations)
  {
    this.iterations = iterations;
  }

  @Override
  public double[] mutate(double[] parent)
  {
    int index = OptimizationFunction.numberUtils.getRandomIndex(parent);
    parent[index] = OptimizationFunction.numberUtils.getRandomDouble();
    return parent;
  }
}
