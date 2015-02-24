package cfo;

/**
 * Uniform Mutation Algorithm
 * 
 * @author Andrew Bowler
 *
 */
public class UniformMutation extends MutationFunction
{
  public UniformMutation(int iterations, CFONumberUtils numberUtils)
  {
    this.iterations = iterations;
    this.numberUtils = numberUtils;
  }

  /**
   * Mutates an individual by replacing a random gene with a random double and
   * returns the new individual.
   */
  @Override
  public double[] mutate(double[] parent)
  {
    int index = getNumberUtils().getRandomIndex(parent);
    parent[index] = getNumberUtils().getRandomDouble(-100.0, 100.0);
    return parent;
  }
}