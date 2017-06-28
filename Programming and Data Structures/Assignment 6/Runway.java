public class Runway{
	
	private int minutesForLand, minutesForDeparture;
	private int landTimeLeft, departureTimeLeft;

	public Runway(int l,int d){
		minutesForLand = l;
		minutesForDeparture = d;
		landTimeLeft = 0;
		departureTimeLeft = 0;
	}
	
	public boolean isBusy(){
		return(landTimeLeft > 0 || departureTimeLeft > 0);
	}

	public void reduceRemainingTime(){
		if(landTimeLeft > 0)
			landTimeLeft--;
		if(departureTimeLeft > 0)
			departureTimeLeft--;
	}

	public void land(){
		if(isBusy())
			throw new IllegalStateException("Runway is already full.");
		landTimeLeft = minutesForLand;
	}

	public void depart(){
		if(isBusy())
			throw new IllegalStateException("Runway is already full.");
		departureTimeLeft = minutesForDeparture;
	}
}