package cfo;

import java.util.Random;

public class GaussianMutation extends MutationFunction
{
  private double stepSize;

  public GaussianMutation(int iterations, double stepSize)
  {
    this.iterations = iterations;
    this.stepSize = stepSize;
  }

  @Override
  public double[] mutate(double[] parent)
  {
    Random random = new Random();
    for (int i = 0; i < parent.length; i++)
    {
      double gaussian = random.nextGaussian();
      double mutationValue = getStepSize() * gaussian;
      parent[i] = parent[i] + mutationValue;
    }
    return parent;
  }

  public double getStepSize()
  {
    return stepSize;
  }

  public void setStepSize(int stepSize)
  {
    this.stepSize = stepSize;
  }
}
