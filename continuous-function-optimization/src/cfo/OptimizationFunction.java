package cfo;

import java.util.Random;

public interface OptimizationFunction
{
  public static final CFONumberUtils numberUtils = new CFONumberUtils(new Random());

  public void getSolution();
  
  public int getTotalIterations();
  
  public void setTotalIterations(int iterations);
}