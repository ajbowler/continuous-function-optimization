package cfo;

import java.util.Arrays;
import java.util.Random;

public class OnePlusOneEvo implements OptimizationFunction
{
  protected MutationFunction mutator;

  protected TrialPrinter trialPrinter;

  protected int iterations;

  protected int dimensions;

  private CFONumberUtils numberUtils;

  public OnePlusOneEvo(MutationFunction mutator, int iterations, int dimensions, boolean oneFifth,
      String bOrStepSize, CFONumberUtils numberUtils)
  {
    this.mutator = mutator;
    this.iterations = iterations;
    this.dimensions = dimensions;
    this.trialPrinter = new TrialPrinter(this, oneFifth, bOrStepSize);
    this.numberUtils = numberUtils;
    this.mutator.setNumberUtils(numberUtils);
  }

  @Override
  public void getSolution()
  {
    SphereFunction f = new SphereFunction(getDimensions());
    double[] x = generateInitialSearchPoint(getDimensions());

    double fOfX = f.computeFitness(x);

    for (int i = 0; i < getTotalIterations(); i++)
    {
      double[] y = getMutator().mutate(x);

      double fOfY = f.computeFitness(y);

      if (fOfY < fOfX)
      {
        x = y;
        fOfX = fOfY;
      }

      // Format everything down to 3 decimal places for the data.
      x = getNumberUtils().formatArray(x);
      fOfX = getNumberUtils().formatDouble(fOfX);

      getTrialPrinter().writeTrial(Arrays.toString(x), Double.toString(fOfX));
    }
  }

  public MutationFunction getMutator()
  {
    return mutator;
  }

  public void setMutator(MutationFunction mutator)
  {
    this.mutator = mutator;
  }

  @Override
  public int getTotalIterations()
  {
    return iterations;
  }

  @Override
  public void setTotalIterations(int iterations)
  {
    this.iterations = iterations;
  }

  public int getDimensions()
  {
    return dimensions;
  }

  public void setDimensions(int dimensions)
  {
    this.dimensions = dimensions;
  }

  public TrialPrinter getTrialPrinter()
  {
    return trialPrinter;
  }

  public void setTrialPrinter(TrialPrinter trialPrinter)
  {
    this.trialPrinter = trialPrinter;
  }

  public CFONumberUtils getNumberUtils()
  {
    return numberUtils;
  }

  public void setNumberUtils(CFONumberUtils numberUtils)
  {
    this.numberUtils = numberUtils;
  }

  protected double[] generateInitialSearchPoint(int dimensions)
  {
    double[] x = new double[getDimensions()];
    for (int i = 0; i < x.length; i++)
    {
      x[i] = getNumberUtils().getRandomDouble(-100.0, 100.0);
    }

    return x;
  }
}