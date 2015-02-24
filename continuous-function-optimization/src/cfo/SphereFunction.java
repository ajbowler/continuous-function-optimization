package cfo;

/**
 * The Sphere Function is an nature-inspired optimization function that computes
 * the individual's "fitness".
 * 
 * @author Andrew Bowler
 *
 */
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

  /**
   * @return A fitness value calculated by summing the squares of each gene in
   *         an individual.
   */
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