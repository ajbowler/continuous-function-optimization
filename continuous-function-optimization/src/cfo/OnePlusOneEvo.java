package cfo;

import java.util.Arrays;
import java.util.Random;

public class OnePlusOneEvo implements OptimizationFunction
{
  protected MutationFunction mutator;

  protected TrialPrinter trialPrinter;

  protected int iterations;

  protected int dimensions;

  private Random random;

  public OnePlusOneEvo(MutationFunction mutator, int iterations, int dimensions, boolean oneFifth,
      String bOrStepSize)
  {
    this.mutator = mutator;
    this.iterations = iterations;
    this.dimensions = dimensions;
    this.trialPrinter = new TrialPrinter(this, oneFifth, bOrStepSize);
    this.random = new Random();
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
      x = OptimizationFunction.numberUtils.formatArray(x);
      fOfX = OptimizationFunction.numberUtils.formatDouble(fOfX);

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

  public Random getRandom()
  {
    return random;
  }

  public void setRandom(Random random)
  {
    this.random = random;
  }

  protected double[] generateInitialSearchPoint(int dimensions)
  {
    double[] x = new double[getDimensions()];
    for (int i = 0; i < x.length; i++)
    {
      x[i] = OptimizationFunction.numberUtils.getRandomDouble();
    }

    return x;
  }
}