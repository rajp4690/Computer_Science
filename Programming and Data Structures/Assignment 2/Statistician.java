/*	Raj Patel
  	N03555681
  	Programming and Data Structure
  	Assignment-2
  	File Name : Statistician.java
 */

public class Statistician{

    private int statLength;
    private double statSum,statMean,statMax,statMin;
    
    public Statistician(){
    	statLength = 0;
    	statMean = statSum = 0;
    }

    public int length(){
        return statLength;
    }

    public double sum(){
        return statSum;
    }

    public double maximum(){
		if(statLength == 0)
	    	return Double.NaN;
		else
	    	return statMax;
	}

	public double minimum(){
	    if(statLength == 0)
	        return Double.NaN;
	    else
	        return statMin;
	}

	public double mean(){
	    if(statLength == 0)
	        return Double.NaN;
	    else
		    return statMean;

	}

	public void clear(){
    	statLength = 0;
    	statMean = 0;
    	statSum = 0;
	}

	public void next(double number){
	    if(statLength == 0)
	    	statMax = statMin = number;
	    else{
	    	if(statMax < number)
				statMax = number;
	    	if(statMin > number)
				statMin = number;
		}

	    statLength++;
	    statSum += number;
	    statMean = statSum/(double)statLength;
	}

	public boolean equals(Statistician obj){
		return (statLength == obj.statLength && statSum == obj.statSum && statMin == obj.statMin && statMax == obj.statMax && statMean == obj.statMean);
	}

	public void addAll(Statistician addend){
		statLength +=addend.statLength;
		statSum +=addend.statSum;
		statMean = statSum/(double)statLength;

		if(statMax < addend.statMax)
			statMax = addend.statMax;
		if(statMin > addend.statMin)
			statMin = addend.statMin;
	}

	public static Statistician union(Statistician s1, Statistician s2){
		Statistician s3 = new Statistician();
		s3.addAll(s1);
		s3.addAll(s2);
		return s3;
	}

}
