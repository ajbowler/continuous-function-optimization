package cfo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TrialPrinter
{
  private String timeStamp;

  private OnePlusOneEvo function;

  private File file;

  public TrialPrinter(OnePlusOneEvo function)
  {
    setTimeStamp();
    this.function = function;
    this.file = generateTrialFile(function);
  }

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

  public void setTimeStamp()
  {
    SimpleDateFormat sdfDate = new SimpleDateFormat("MM-dd_HH_mm_ss");
    Date now = new Date();
    String strDate = sdfDate.format(now);
    this.timeStamp = strDate;
  }

  private File generateTrialFile(OnePlusOneEvo function)
  {
//    String path = "C:/School_Stuff/NatureInspiredOptimization/continuous-functional-optimization/continuous-function-optimization"
//        + "/trials/" + function.getMutator().getClass().getSimpleName() + "/";
    String path = "trials/" + function.getMutator().getClass().getSimpleName() + "/";
    String timeStamp = getTimeStamp();
    String filename = path + timeStamp + ".txt";
    return new File("test.txt");
  }
}