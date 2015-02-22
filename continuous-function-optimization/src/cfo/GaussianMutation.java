package cfo;

import java.util.Random;

public class GaussianMutation extends MutationFunction
{
  private double stepSize;

  public GaussianMutation(int iterations, double stepSize, CFONumberUtils numberUtils)
  {
    this.iterations = iterations;
    this.stepSize = stepSize;
    this.numberUtils = numberUtils;
  }

  @Override
  public double[] mutate(double[] parent)
  {
    for (int i = 0; i < parent.length; i++)
    {
      double gaussian = getNumberUtils().getRandom().nextGaussian();
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
