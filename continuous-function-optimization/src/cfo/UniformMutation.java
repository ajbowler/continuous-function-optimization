package cfo;

public class UniformMutation extends MutationFunction
{
  public UniformMutation(int iterations, CFONumberUtils numberUtils)
  {
    this.iterations = iterations;
    this.numberUtils = numberUtils;
  }

  @Override
  public double[] mutate(double[] parent)
  {
    int index = getNumberUtils().getRandomIndex(parent);
    parent[index] = getNumberUtils().getRandomDouble(-100.0, 100.0);
    return parent;
  }
}
