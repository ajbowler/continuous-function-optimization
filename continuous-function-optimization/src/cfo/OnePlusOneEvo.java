package cfo;

public class OnePlusOneEvo implements OptimizationFunction
{
  private MutationFunction mutator;

  public OnePlusOneEvo(MutationFunction mutator)
  {
    this.mutator = mutator;
  }

  @Override
  public void getSolution()
  {

  }

  public MutationFunction getMutator()
  {
    return mutator;
  }

  public void setMutator(MutationFunction mutator)
  {
    this.mutator = mutator;
  }

}
