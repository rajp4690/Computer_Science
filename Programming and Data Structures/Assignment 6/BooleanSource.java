
public class BooleanSource{
  private double probability;

  public BooleanSource(double p){
    if((p < 0) || (p > 1))
      throw new IllegalArgumentException("Illegal Probability = " + p);
    probability = p;
  }

  public boolean query( ){
    return(Math.random() < probability);
  }
 
}
