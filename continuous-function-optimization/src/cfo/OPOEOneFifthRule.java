package cfo;

import java.util.Arrays;

public class OPOEOneFifthRule extends OnePlusOneEvo
{
  private double stepSize;

  public OPOEOneFifthRule(MutationFunction mutator, int iterations, int dimensions,
      double stepSize, String bOrStepSize, CFONumberUtils numberUtils, int writeOption)
  {
    super(mutator, iterations, dimensions, true, bOrStepSize, numberUtils, writeOption);
    this.stepSize = stepSize;
    this.trialPrinter = new TrialPrinter(this, true, bOrStepSize);
  }

  @Override
  public void getSolution()
  {
    SphereFunction f = new SphereFunction(getDimensions());
    double[] x = generateInitialSearchPoint(getDimensions());
    setStepSize(getNumberUtils().getRandomDouble(1, 100));
    ((GaussianMutation) getMutator()).setStepSize(this.getStepSize());

    int good = 0;
    int bad = 0;

    double fOfX = f.computeFitness(x);

    for (int i = 0; i < getTotalIterations(); i++, setCurrentIteration(i))
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
        {
          setStepSize(getStepSize() * 2);
          ((GaussianMutation) getMutator()).setStepSize(this.getStepSize());
        }
        else
        {
          setStepSize(getStepSize() / 2);
          ((GaussianMutation) getMutator()).setStepSize(this.getStepSize());
        }
        good = 0;
        bad = 0;
      }

      // Format everything down to 3 decimal places for the data.
      x = getNumberUtils().formatArray(x);
      fOfX = getNumberUtils().formatDouble(fOfX);

      int option = getWriteOption();
      if (option == 1)
      {
        getTrialPrinter()
            .writeTrial(Integer.toString(getCurrentIteration()), Double.toString(fOfX));
      }
      else if (option == 2)
        getTrialPrinter().writeTrial(Arrays.toString(x), Double.toString(fOfX));
      else
        getTrialPrinter().writeTrialOnlyFitness(Double.toString(fOfX));
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