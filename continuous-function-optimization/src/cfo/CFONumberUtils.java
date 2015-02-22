package cfo;

import java.text.DecimalFormat;
import java.util.Random;

public class CFONumberUtils
{
  private Random random;

  public CFONumberUtils(Random random)
  {
    this.random = random;
  }

  public int getRandomIndex(double[] arr)
  {
    long currentTime = System.currentTimeMillis();
    return (int) (currentTime % arr.length);
  }

  public double getRandomDouble(double min, double max)
  {
    return min + (max - min) * getRandom().nextDouble();
  }

  public Random getRandom()
  {
    return random;
  }

  public void setRandom(Random random)
  {
    this.random = random;
  }

  public double[] formatArray(double[] arr)
  {
    DecimalFormat decimalFormat = new DecimalFormat("#.###");

    for (int i = 0; i < arr.length; i++)
      arr[i] = Double.valueOf(decimalFormat.format(arr[i]));

    return arr;
  }

  public double formatDouble(double x)
  {
    DecimalFormat decimalFormat = new DecimalFormat("#.###");
    return Double.valueOf(decimalFormat.format(x));
  }
}