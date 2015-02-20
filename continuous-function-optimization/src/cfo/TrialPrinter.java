package cfo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TrialPrinter
{
  public TrialPrinter()
  {

  }

  public void writeTrial(OnePlusOneEvo function)
  {
    File file = generateTrialFile(function);
  }

  public String getCurrentTimeStamp()
  {
    SimpleDateFormat sdfDate = new SimpleDateFormat("MM-dd HH:mm:ss");// dd/MM/yyyy
    Date now = new Date();
    String strDate = sdfDate.format(now);
    return strDate;
  }

  private File generateTrialFile(OnePlusOneEvo function)
  {
    String path = "trials/";
    String timeStamp = getCurrentTimeStamp();
    String mutation = function.getMutator().getClass().getSimpleName();
    String filename = path + timeStamp + " " + mutation + ".txt";

    return new File(filename);
  }

}