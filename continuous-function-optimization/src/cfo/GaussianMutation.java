package cfo;

public class GaussianMutation extends MutationFunction
{
  private double stepSize;

  public GaussianMutation(int iterations, double stepSize)
  {
    this.iterations = iterations;
    this.stepSize = stepSize;
  }

  @Override
  public void getSolution()
  {
    // TODO Auto-generated method stub

  }

  @Override
  public int[] mutate(int[] parent)
  {
    // TODO Auto-generated method stub
    return null;
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
