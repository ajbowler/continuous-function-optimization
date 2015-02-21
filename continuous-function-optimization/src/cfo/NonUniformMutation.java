package cfo;

public class NonUniformMutation extends MutationFunction
{
  private int currentIteration;

  private double b;

  public NonUniformMutation(int iterations, double b)
  {
    this.iterations = iterations;
    this.currentIteration = 1;
    this.b = b;
  }

  @Override
  public int[] mutate(int[] parent)
  {
    int index = OptimizationFunction.rng.getRandomIndex(parent);
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

  private int calculateNewGene(int old)
  {
    double tau = Math.random();
    double delta = deltaFunction(old, getCurrentIteration(), tau, getB());
    setCurrentIteration(getCurrentIteration() + 1);
    if (tau > 0.5000)
      return round(old + delta);
    else
      return round(old - delta);
  }

  private double deltaFunction(int old, int currentIteration, double tau, double b)
  {
    double delta = 0.0;
    double r = Math.random();
    double iterationDivision = ((double) currentIteration) / getTotalIterations();
    double secondPart = 1 - Math.pow(r, 1 - iterationDivision);
    int y = 0;

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
