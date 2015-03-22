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
public abstract class TrialPrinter
{
  private String timeStamp;

  private Object object;

  private File file;

  public TrialPrinter(Object function, boolean oneFifth, String bOrStepSize)
  {
    setTimeStamp();
    this.object = function;
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
      writer.write(x + "\t" + fitnessValue + "\n");
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

  public Object getFunction()
  {
    return object;
  }

  public void setObject(Object obj)
  {
    this.object = obj;
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
   * Generates the file.
   */
  public abstract File generateFile();
}