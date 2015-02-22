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
  public int[] mutate(int[] parent)
  {
    Random random = new Random();
    for (int i = 0; i < parent.length; i++)
    {
      double gaussian = random.nextGaussian();
      System.out.println(gaussian);
      int mutationValue = this.round(getStepSize() * gaussian);
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
