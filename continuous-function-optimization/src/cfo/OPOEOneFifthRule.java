package cfo;

public class OPOEOneFifthRule extends OnePlusOneEvo
{
  private double stepSize;

  public OPOEOneFifthRule(MutationFunction mutator, int iterations, int dimensions, double stepSize,
      String bOrStepSize)
  {
    super(mutator, dimensions, dimensions, true, bOrStepSize);
    this.stepSize = stepSize;
    this.trialPrinter = new TrialPrinter(this, true, bOrStepSize);
  }

  @Override
  public void getSolution()
  {
    SphereFunction f = new SphereFunction(getDimensions());
    double[] x = generateInitialSearchPoint(getDimensions());
    setStepSize(OptimizationFunction.numberUtils.getRandomIndex(new double[101]));

    int good = 0;
    int bad = 0;

    for (int i = 0; i < getTotalIterations(); i++)
    {
      double[] y = getMutator().mutate(x);

      if (f.computeFitness(y) < f.computeFitness(x))
      {
        x = y;
        good++;
      }
      else
        bad++;

      if ((good + bad) == getDimensions())
      {
        if ((good / getDimensions()) > 0.20)
          setStepSize(getStepSize() * 2);

        if ((good / getDimensions()) < 0.20)
          setStepSize(getStepSize() / 2);

        good = 0;
        bad = 0;
      }
    }

    // TODO: output results to file.
    System.out.println(x + ", " + f.computeFitness(x));
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