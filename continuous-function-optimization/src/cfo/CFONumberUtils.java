package cfo;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * A collection of methods used for number manipulation with a built in random
 * number generator.
 * 
 * @author Andrew Bowler
 *
 */
public class CFONumberUtils
{
  private Random random;

  public CFONumberUtils(Random random)
  {
    this.random = random;
  }

  /**
   * @return A pseudorandom index number for a given array. Utilizes time to
   *         increase randomness.
   */
  public int getRandomIndex(double[] arr)
  {
    long currentTime = System.currentTimeMillis();
    return (int) (currentTime % arr.length);
  }

  /**
   * @return A random double in the given min-max range.
   */
  public double getRandomDouble(double min, double max)
  {
    return min + (max - min) * getRandom().nextDouble();
  }

  /**
   * @return Formats double arrays to truncate floating point values past the
   *         third decimal place. Useful for printing to a file.
   */
  public double[] formatArray(double[] arr)
  {
    DecimalFormat decimalFormat = new DecimalFormat("#.###");

    for (int i = 0; i < arr.length; i++)
      arr[i] = Double.valueOf(decimalFormat.format(arr[i]));

    return arr;
  }

  /**
   * @return The provided double with the floating point truncated down to three
   *         decimal places. Useful for printing to a file.
   */
  public double formatDouble(double x)
  {
    DecimalFormat decimalFormat = new DecimalFormat("#.###");
    return Double.valueOf(decimalFormat.format(x));
  }

  public Random getRandom()
  {
    return random;
  }

  public void setRandom(Random random)
  {
    this.random = random;
  }
}