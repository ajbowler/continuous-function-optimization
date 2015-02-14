package cfo;

public class OnePlusOneEvo implements OptimizationFunction
{
  private MutationFunction mutator;

  private int iterations;

  private int dimensions;

  public OnePlusOneEvo(MutationFunction mutator, int iterations, int dimensions)
  {
    this.mutator = mutator;
    this.iterations = iterations;
    this.dimensions = dimensions;
  }

  @Override
  public void getSolution()
  {
    int[] x = new int[getDimensions()];
    SphereFunction f = new SphereFunction(getDimensions());
    for (int i = 0; i < x.length; i++)
    {
      x[i] = OptimizationFunction.rng.getRandomNumber();
    }

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
    }

    // TODO: output results to file.
    System.out.println(x + ", " + fOfX);
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
}
