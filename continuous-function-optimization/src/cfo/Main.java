package cfo;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;

public class Main
{
  public static void main(String[] args)
  {
    // Purge the directories of old data.
    cleanDirectories();

    OnePlusOneEvo uniformMutation;
    OnePlusOneEvo nonUniformMutation;
    OnePlusOneEvo gaussianMutation;

    MutationFunction uniformMutator;
    MutationFunction nonUniformMutator;
    MutationFunction gaussianMutator;

    System.out.println("Beginning tests...\n");

    System.out.println("Beginning Non 1/5th Rule Tests...\n");

    System.out.println("Beginning Uniform Mutation Tests...\n");
    for (int i = 1; i <= 30; i++)
    {
      CFONumberUtils utils = new CFONumberUtils(new Random());
      uniformMutator = new UniformMutation(5000, utils);
      uniformMutation = new OnePlusOneEvo(uniformMutator, 5000, 10, false, null, utils);
      uniformMutation.getSolution();
      System.out.println(i + " file(s) created.");
    }

    System.out.println("Uniform Mutation Tests finished.\n");

    System.out.println("Beginning Non-Uniform Mutation Tests...");
    System.out.println("Tests for b = 0.05...\n");
    for (int i = 1; i <= 30; i++)
    {
      CFONumberUtils utils = new CFONumberUtils(new Random());
      nonUniformMutator = new NonUniformMutation(5000, 0.05, utils);
      nonUniformMutation = new OnePlusOneEvo(nonUniformMutator, 5000, 10, false, "005", utils);
      nonUniformMutation.getSolution();
      System.out.println(i + " file(s) created.");
    }

    System.out.println("b = 0.05 Tests complete.\n");

    System.out.println("Tests for b = 1.0...\n");
    for (int i = 1; i <= 30; i++)
    {
      CFONumberUtils utils = new CFONumberUtils(new Random());
      nonUniformMutator = new NonUniformMutation(5000, 1.0, utils);
      nonUniformMutation = new OnePlusOneEvo(nonUniformMutator, 5000, 10, false, "1", utils);
      nonUniformMutation.getSolution();
      System.out.println(i + " file(s) created.");
    }

    System.out.println("b = 1.0 Tests complete.\n");

    System.out.println("Tests for b = 10.0...\n");
    for (int i = 1; i <= 30; i++)
    {
      CFONumberUtils utils = new CFONumberUtils(new Random());
      nonUniformMutator = new NonUniformMutation(5000, 10.0, utils);
      nonUniformMutation = new OnePlusOneEvo(nonUniformMutator, 5000, 10, false, "10", utils);
      nonUniformMutation.getSolution();
      System.out.println(i + " file(s) created.");
    }

    System.out.println("b = 10.0 Tests complete.\n");

    System.out.println("Tests for b = 20.0...\n");
    for (int i = 1; i <= 30; i++)
    {
      CFONumberUtils utils = new CFONumberUtils(new Random());
      nonUniformMutator = new NonUniformMutation(5000, 20.0, utils);
      nonUniformMutation = new OnePlusOneEvo(nonUniformMutator, 5000, 10, false, "20", utils);
      nonUniformMutation.getSolution();
      System.out.println(i + " file(s) created.");
    }

    System.out.println("b = 20.0 Tests complete.\n");

    System.out.println("Non-Uniform Mutation Tests finished.\n");

    System.out.println("Beginning Gaussian Mutation Tests...");
    System.out.println("Tests for stepsize = 0.05...\n");
    for (int i = 1; i <= 30; i++)
    {
      CFONumberUtils utils = new CFONumberUtils(new Random());
      gaussianMutator = new GaussianMutation(5000, 0.05, utils);
      gaussianMutation = new OnePlusOneEvo(gaussianMutator, 5000, 10, false, "005", utils);
      gaussianMutation.getSolution();
      System.out.println(i + " file(s) created.");
    }

    System.out.println("Stepsize = 0.05 complete.\n");

    System.out.println("Tests for stepsize = 0.50...\n");
    for (int i = 1; i <= 30; i++)
    {
      CFONumberUtils utils = new CFONumberUtils(new Random());
      gaussianMutator = new GaussianMutation(5000, 0.50, utils);
      gaussianMutation = new OnePlusOneEvo(gaussianMutator, 5000, 10, false, "05", utils);
      gaussianMutation.getSolution();
      System.out.println(i + " file(s) created.");
    }

    System.out.println("Stepsize = 0.50 complete.\n");

    System.out.println("Tests for stepsize = 1.0...\n");
    for (int i = 1; i <= 30; i++)
    {
      CFONumberUtils utils = new CFONumberUtils(new Random());
      gaussianMutator = new GaussianMutation(5000, 1.0, utils);
      gaussianMutation = new OnePlusOneEvo(gaussianMutator, 5000, 10, false, "1", utils);
      gaussianMutation.getSolution();
      System.out.println(i + " file(s) created.");
    }

    System.out.println("Stepsize = 1.0 complete.\n");

    System.out.println("Tests for stepsize = 10.0...\n");
    for (int i = 1; i <= 30; i++)
    {
      CFONumberUtils utils = new CFONumberUtils(new Random());
      gaussianMutator = new GaussianMutation(5000, 10.0, utils);
      gaussianMutation = new OnePlusOneEvo(gaussianMutator, 5000, 10, false, "10", utils);
      gaussianMutation.getSolution();
      System.out.println(i + " file(s) created.");
    }

    System.out.println("Stepsize = 10.0 complete.\n");

    System.out.println("Gaussian Mutation Tests finished.\n");

    System.out.println("Non 1/5th Rule Tests finished.\n");

    System.out.println("Beginning 1/5th Rule Tests...\n");

    System.out.println("Beginning Gaussian Mutation Tests...\n");

    for (int i = 1; i <= 30; i++)
    {
      CFONumberUtils utils = new CFONumberUtils(new Random());
      double initStepSize = utils.getRandomDouble(1, 100);
      gaussianMutator = new GaussianMutation(5000, initStepSize, utils);
      gaussianMutation = new OnePlusOneEvo(gaussianMutator, 5000, 10, true, null, utils);
      gaussianMutation.getSolution();
      System.out.println(i + " file(s) created.");
    }

    System.out.println("Gaussian Mutation Tests finished.\n");

    System.out.println("1/5th Rule Tests finished.");

    System.out.println("Tests complete. The data will be deleted upon re-running the program.");
    System.out.println("If necessary, export the data files outside of the Eclipse project.");
  }

  private static void cleanDirectories()
  {
    try
    {
      System.out.println("Emptying directories...");

      FileUtils.cleanDirectory(new File("Trials/UniformMutation"));

      FileUtils.cleanDirectory(new File("Trials/NonUniformMutation/005"));
      FileUtils.cleanDirectory(new File("Trials/NonUniformMutation/1"));
      FileUtils.cleanDirectory(new File("Trials/NonUniformMutation/10"));
      FileUtils.cleanDirectory(new File("Trials/NonUniformMutation/20"));

      FileUtils.cleanDirectory(new File("Trials/GaussianMutation/005"));
      FileUtils.cleanDirectory(new File("Trials/GaussianMutation/05"));
      FileUtils.cleanDirectory(new File("Trials/GaussianMutation/1"));
      FileUtils.cleanDirectory(new File("Trials/GaussianMutation/10"));

      FileUtils.cleanDirectory(new File("Trials/1Fifth/GaussianMutation"));

      System.out.println("Directories emptied.");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}