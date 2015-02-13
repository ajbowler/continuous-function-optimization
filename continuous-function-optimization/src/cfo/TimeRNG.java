package cfo;

/**
 * This is a pseudorandom number generator that outputs the modulo of the
 * current time by 201. If 0 < n <= 101 then negate it. Otherwise return the
 * positive. This ensures the result is within the interval [-100, 100].
 * 
 * @author Andrew Bowler
 *
 */
public class TimeRNG
{
  public TimeRNG()
  {
    // empty constructor
  }

  /**
   * @return A pseudorandom number calculated by taking the modulo of the
   *         current time by 201 to fit the [-100, 100] interval.
   */
  public int getRandomNumber()
  {
    long currentTime = System.currentTimeMillis();
    int result = (int) (currentTime % 201);
    if (result <= 101)
      return result;
    else
      return (result * -1);
  }
}
