package cfo;

/**
 * Gaussian Mutation Algorithm
 * 
 * @author Andrew Bowler
 *
 */
public class GaussianMutation extends MutationFunction
{
  private double stepSize;

  public GaussianMutation(int iterations, double stepSize, CFONumberUtils numberUtils)
  {
    this.iterations = iterations;
    this.stepSize = stepSize;
    this.numberUtils = numberUtils;
  }

  /**
   * Mutates the provided individual by adding a randomly generated Gaussian
   * value to each gene. Clips the gene within [-100, 100].
   */
  @Override
  public double[] mutate(double[] parent)
  {
    for (int i = 0; i < parent.length; i++)
    {
      double gaussian = getNumberUtils().getRandom().nextGaussian();
      double mutationValue = getStepSize() * gaussian;
      parent[i] = parent[i] + mutationValue;

      // Clip the values if they go out of bounds.
      if (parent[i] > 100.0)
        parent[i] = 100.0;

      if (parent[i] < -100.0)
        parent[i] = -100.0;
    }
    return parent;
  }

  public double getStepSize()
  {
    return stepSize;
  }

  public void setStepSize(double stepSize)
  {
    this.stepSize = stepSize;
  }
}