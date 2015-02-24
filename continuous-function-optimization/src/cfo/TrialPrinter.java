package cfo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A utility class that outputs data from the various genetic algorithms tests.
 * 
 * @author Andrew Bowler
 *
 */
public class TrialPrinter
{
  private String timeStamp;

  private OnePlusOneEvo function;

  private File file;

  public TrialPrinter(OnePlusOneEvo function, boolean oneFifth, String bOrStepSize)
  {
    setTimeStamp();
    this.function = function;
    this.file = generateTrialFile(function, oneFifth, bOrStepSize);
  }

  /**
   * Writes either the individual array or the iteration number, along with the
   * corresponding fitness value from the Sphere Function.
   */
  public void writeTrial(String x, String fitnessValue)
  {
    FileWriter writer;
    try
    {
      writer = new FileWriter(getFile(), true);
      writer.write(x + "    " + fitnessValue + "\n");
      writer.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Writes the fitness value.
   */
  public void writeTrialOnlyFitness(String fitnessValue)
  {
    FileWriter writer;
    try
    {
      writer = new FileWriter(getFile(), true);
      writer.write(fitnessValue + "\n");
      writer.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public OnePlusOneEvo getFunction()
  {
    return function;
  }

  public void setFunction(OnePlusOneEvo function)
  {
    this.function = function;
  }

  public File getFile()
  {
    return file;
  }

  public String getTimeStamp()
  {
    return timeStamp;
  }

  /**
   * Generates the timestamp string for the file.
   */
  public void setTimeStamp()
  {
    SimpleDateFormat sdfDate = new SimpleDateFormat("MM-dd HH-mm-ss");
    Date now = new Date();
    String strDate = sdfDate.format(now);
    this.timeStamp = strDate;
  }

  /**
   * @return A .txt file with the current timestamp, and placed in the directory
   *         that matches the genetic algorithm's class name.
   */
  private File generateTrialFile(OnePlusOneEvo function, boolean oneFifth, String bOrStepSize)
  {
    String path = "";

    if (oneFifth)
      path = "Trials/1Fifth/" + function.getMutator().getClass().getSimpleName() + "/";
    else
      path = "Trials/" + function.getMutator().getClass().getSimpleName() + "/";

    if (bOrStepSize != null)
      path += bOrStepSize + "/";

    String timeStamp = getTimeStamp();
    String filename = path + timeStamp + ".txt";
    return new File(filename);
  }
}