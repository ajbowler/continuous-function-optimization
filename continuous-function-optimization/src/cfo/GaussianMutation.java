package cfo;

public class GaussianMutation extends MutationFunction
{
  private int stepSize;

  public GaussianMutation(int iterations, int stepSize)
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

  public int getStepSize()
  {
    return stepSize;
  }

  public void setStepSize(int stepSize)
  {
    this.stepSize = stepSize;
  }
}
