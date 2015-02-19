package cfo;

public class OPOEOneFifthRule extends OnePlusOneEvo
{
  private double stepSize;

  public OPOEOneFifthRule(MutationFunction mutator, int iterations, int dimensions, double stepSize)
  {
    super(mutator, dimensions, dimensions);
    this.stepSize = stepSize;
  }

  @Override
  public void getSolution()
  {
    // TODO Auto-generated method stub
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
