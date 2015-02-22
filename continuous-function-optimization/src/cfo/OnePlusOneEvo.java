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
    setRandom(new Random());
  }

  @Override
  public void getSolution()
  {
    SphereFunction f = new SphereFunction(getDimensions());
    int[] x = generateInitialSearchPoint(getDimensions());

    int fOfX = f.computeFitness(x);

    for (int i = 0; i < getTotalIterations(); i++)
    {
      int[] y = getMutator().mutate(x);

      int fOfY = f.computeFitness(y);

      if (fOfY < fOfX)
      {
        x = y;
        fOfX = fOfY;
      }

      getTrialPrinter().writeTrial(Arrays.toString(x), Integer.toString(fOfX));
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

  protected int[] generateInitialSearchPoint(int dimensions)
  {
    int[] x = new int[getDimensions()];
    for (int i = 0; i < x.length; i++)
    {
      x[i] = OptimizationFunction.rng.randInt(-100, 100);
    }

    return x;
  }
}