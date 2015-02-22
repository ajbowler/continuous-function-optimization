package cfo;

import java.util.Arrays;

public class OPOEOneFifthRule extends OnePlusOneEvo
{
  private double stepSize;

  public OPOEOneFifthRule(MutationFunction mutator, int iterations, int dimensions,
      double stepSize, String bOrStepSize, CFONumberUtils numberUtils)
  {
    super(mutator, dimensions, dimensions, true, bOrStepSize, numberUtils);
    this.stepSize = stepSize;
    this.trialPrinter = new TrialPrinter(this, true, bOrStepSize);
  }

  @Override
  public void getSolution()
  {
    SphereFunction f = new SphereFunction(getDimensions());
    double[] x = generateInitialSearchPoint(getDimensions());
    setStepSize(getNumberUtils().getRandomDouble(1, 100));

    int good = 0;
    int bad = 0;

    double fOfX = f.computeFitness(x);

    for (int i = 0; i < getTotalIterations(); i++)
    {
      double[] y = getMutator().mutate(x);

      double fOfY = f.computeFitness(y);

      if (fOfY < fOfX)
      {
        x = Arrays.copyOf(y, y.length);
        fOfX = fOfY;
        good++;
      }
      else
        bad++;

      if ((good + bad) == getDimensions())
      {
        double gbRatio = ((double) good) / getDimensions();

        if (gbRatio >= 0.20)
          setStepSize(getStepSize() * 2);

        else
          setStepSize(getStepSize() / 2);

        good = 0;
        bad = 0;
      }

      // Format everything down to 3 decimal places for the data.
      x = getNumberUtils().formatArray(x);
      fOfX = getNumberUtils().formatDouble(fOfX);

      getTrialPrinter().writeTrial(Arrays.toString(x), Double.toString(fOfX));
    }
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