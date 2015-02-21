package cfo;

import java.util.Random;

public class TimeRNG
{
  private Random random;

  public TimeRNG(Random random)
  {
    this.setRandom(new Random());
  }

  public int getRandomIndex(int[] arr)
  {
    long currentTime = System.currentTimeMillis();
    return (int) (currentTime % arr.length);
  }

  public int randInt(int min, int max)
  {
    int randomNum = getRandom().nextInt((max - min) + 1) + min;

    return randomNum;
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
