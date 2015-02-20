package cfo;

import java.util.Random;

public class GaussianMutation extends MutationFunction
{
  private int stepSize;

  public GaussianMutation(int iterations, int stepSize)
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
      int mutationValue = this.round(getStepSize() * random.nextGaussian());
      parent[i] = parent[i] + mutationValue;
    }
    return parent;
  }

  public int getStepSize()
  {
    return stepSize;
  }

  public void setStepSize(int stepSize)
  {
    this.stepSize = stepSize;
  }
}
