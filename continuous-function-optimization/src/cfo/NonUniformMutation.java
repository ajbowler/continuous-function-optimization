package cfo;

/**
 * Non-Uniform Mutation Algorithm
 * 
 * @author Andrew Bowler
 *
 */
public class NonUniformMutation extends MutationFunction
{
  private int currentIteration;

  private double b;

  public NonUniformMutation(int iterations, double b, CFONumberUtils numberUtils)
  {
    this.iterations = iterations;
    this.currentIteration = 1;
    this.b = b;
    this.numberUtils = numberUtils;
  }

  /**
   * Replaces a random index in the parent by generating a new value with the
   * non-uniform mutation formula.
   */
  @Override
  public double[] mutate(double[] parent)
  {
    int index = getNumberUtils().getRandomIndex(parent);
    parent[index] = calculateNewGene(parent[index]);
    return parent;
  }

  public int getCurrentIteration()
  {
    return currentIteration;
  }

  public void setCurrentIteration(int currentIteration)
  {
    this.currentIteration = currentIteration;
  }

  public double getB()
  {
    return b;
  }

  public void setB(double b)
  {
    this.b = b;
  }

  private double calculateNewGene(double old)
  {
    double tau = Math.random();
    double delta = deltaFunction(old, getCurrentIteration(), tau, getB());
    setCurrentIteration(getCurrentIteration() + 1);
    if (tau > 0.5000)
      return old + delta;
    else
      return old - delta;
  }

  private double deltaFunction(double old, int currentIteration, double tau, double b)
  {
    double delta = 0.0;
    double r = getNumberUtils().getRandomDouble(0, 1);
    double iterationDivision = ((double) currentIteration) / getTotalIterations();
    double secondPart = 1 - Math.pow(r, 1 - iterationDivision);
    double y = 0;

    if (tau >= 0.5000)
    {
      y = 100 - old;
      delta = y * Math.pow(secondPart, b);
      return delta;
    }
    else
    {
      y = old + 100;
      delta = y * Math.pow(secondPart, b);
      return delta;
    }
  }
}