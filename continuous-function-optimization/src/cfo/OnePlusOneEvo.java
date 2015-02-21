package cfo;

public class OnePlusOneEvo implements OptimizationFunction
{
  protected MutationFunction mutator;

  protected TrialPrinter trialPrinter;

  protected int iterations;

  protected int dimensions;

  public OnePlusOneEvo(MutationFunction mutator, int iterations, int dimensions,
      TrialPrinter trialPrinter)
  {
    this.mutator = mutator;
    this.iterations = iterations;
    this.dimensions = dimensions;
    this.trialPrinter = trialPrinter;
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

      int newFOfY = f.computeFitness(y);
      int newFOfX = f.computeFitness(x);

      if (newFOfY < newFOfX)
      {
        x = y;
        fOfX = newFOfX;
      }

      getTrialPrinter().writeTrial(x.toString(), Integer.toString(fOfX));
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

  protected int[] generateInitialSearchPoint(int dimensions)
  {
    int[] x = new int[getDimensions()];
    for (int i = 0; i < x.length; i++)
    {
      x[i] = OptimizationFunction.rng.getRandomNumberLargeInterval();
    }

    return x;
  }
}