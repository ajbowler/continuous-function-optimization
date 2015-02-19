package cfo;

public class NonUniformMutation extends MutationFunction
{
  private int currentIteration;

  private double b;

  public NonUniformMutation(int iterations, double b)
  {
    this.iterations = iterations;
    this.currentIteration = 0;
    this.b = b;
  }

  @Override
  public void getSolution()
  {
    // TODO Auto-generated method stub

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
    return deltaFunction(old, getCurrentIteration(), tau, getB());
  }

  private int deltaFunction(int old, int currentIteration, double tau, double b)
  {
    double delta = 0.0;
    int r = getR();
    double secondPart = 1 - Math.pow(r, 1 - (currentIteration / getTotalIterations()));
    int y = 0;

    if (tau >= 0.5000)
      y = 100 - old;
    else
      y = old + 100;

    delta = y * Math.pow(secondPart, b);
    double result = old + delta;
    return round(result);
  }

  private int round(double result)
  {
    if (result - Math.floor(result) > Math.ceil(result) - result)
      return (int) Math.ceil(result);
    else
      return (int) Math.floor(result);
  }

  private int getR()
  {
    double random = Math.random();

    if (random >= 0.5000)
      return 1;
    else
      return 0;
  }
}
