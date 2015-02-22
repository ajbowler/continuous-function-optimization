package cfo;

public class SphereFunction
{
  private int dimension;

  public SphereFunction(int dimension)
  {
    this.dimension = dimension;
  }

  public int getDimension()
  {
    return this.dimension;
  }

  public void setDimension(int dimension)
  {
    this.dimension = dimension;
  }

  public double computeFitness(double[] selection)
  {
    double sum = 0;

    for (int i = 0; i < getDimension(); i++)
    {
      sum += (selection[i] * selection[i]);
    }

    return sum;
  }
}