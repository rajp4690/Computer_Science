/*
Raj Patel
N03555681
Programming and Data Structure
Airport Simulator
*/
import java.util.*;

public class AirportSimulator{

	public static void main(String[] arg){
		final int LANDTIME = 4;
		final int DEPARTURETIME = 2;
		final double LANDINGPROBABILITY = 0.05;
		final double DEPARTUREPROBABILITY = 0.05;
		final int CRASHTIME = 2;
		final int TOTALTIME = 6000;

		airportSimulate(LANDTIME, DEPARTURETIME, LANDINGPROBABILITY, DEPARTUREPROBABILITY, TOTALTIME, CRASHTIME);
	}

	public static void airportSimulate(int landTime, int departureTime, double landingProbability, double departureProbability, int totalTime, int crashTime){
		Queue<Integer> landingTimes = new LinkedList<Integer>();
		Queue<Integer> departingTimes = new LinkedList<Integer>();
		int next, crashed = 0;
		BooleanSource land = new BooleanSource(landingProbability);
		BooleanSource departure = new BooleanSource(departureProbability); 
		Runway runway = new Runway(landTime, departureTime);
		Averager landWaitTimes = new Averager();
		Averager departureWaitTimes = new Averager();
		int currentMinute;

		System.out.println("Amount of minutes to land: " + landTime);
		System.out.println("Amount of minutes to take off: " + departureTime);
		System.out.println("Probability of arrival during a minute: " + landingProbability);
		System.out.println("Average amount of time between planes to land: " + 1 / landingProbability);
		System.out.println("Probability of departure during a minute: " + departureProbability);
		System.out.println("Average amount of time between planes to take off: " + 1 / departureProbability);
		System.out.println("Maximum amount of time in the air befor crashing: " + crashTime);
		System.out.println("Total simulation minutes: " + totalTime);

		if(landTime < 0 || departureTime < 0 || landingProbability < 0 || landingProbability > 1 || departureProbability < 0 || departureProbability > 1 || totalTime < 0){
			throw new IllegalArgumentException("Values out of range");
		}

		for(currentMinute = 0; currentMinute < totalTime; currentMinute++){
			if(land.query())
				landingTimes.add(currentMinute);
			if(departure.query())
				departingTimes.add(currentMinute);
			if((!runway.isBusy()) && ((!landingTimes.isEmpty()) || (!departingTimes.isEmpty()))){
				if(!landingTimes.isEmpty()){
					next = landingTimes.remove();
					if(currentMinute - next > crashTime)
						crashed++;
					else{
						landWaitTimes.addNumber(currentMinute - next);
						runway.land();
					}
				}
				else{
					next = departingTimes.remove();
					departureWaitTimes.addNumber(currentMinute - next);
					runway.depart();
				}
			}

			runway.reduceRemainingTime();
		}

		System.out.println("");
		System.out.println("Number of planes taken off: " + departureWaitTimes.howManyNumbers());
		System.out.println("Number of planes landed: " + landWaitTimes.howManyNumbers());
		System.out.println("Number of planes crashed: " + crashed);
		System.out.printf("Average waiting time for taking off: %.2f minutes\n", departureWaitTimes.average());
		System.out.printf("Average waiting time for landing: %.2f minutes", landWaitTimes.average());
	}
}