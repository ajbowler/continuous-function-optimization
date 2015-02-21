package cfo;

public class OPOEOneFifthRule extends OnePlusOneEvo
{
  private int stepSize;

  public OPOEOneFifthRule(MutationFunction mutator, int iterations, int dimensions, int stepSize,
      TrialPrinter trialPrinter)
  {
    super(mutator, dimensions, dimensions, trialPrinter);
    this.stepSize = stepSize;
  }

  @Override
  public void getSolution()
  {
    SphereFunction f = new SphereFunction(getDimensions());
    int[] x = generateInitialSearchPoint(getDimensions());
    setStepSize(OptimizationFunction.rng.getRandomIndex(new int[101]));

    int good = 0;
    int bad = 0;

    for (int i = 0; i < getTotalIterations(); i++)
    {
      int[] y = getMutator().mutate(x);

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

  public int getStepSize()
  {
    return stepSize;
  }

  public void setStepSize(int stepSize)
  {
    this.stepSize = stepSize;
  }
}