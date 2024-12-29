package time;

/**
 * Class for Timer for holding and modifying days
 */
public class Timer {
	
	private int day;
	
	public Timer() {
		this.day=0;
	}

	public void moveToNextDay() {
		this.day=this.day+1;
	}
	
	public void jumpToGivenDay(int day) {
		if(day<this.day) {return;}
		
		this.day=day;
	}
	
	public void jumpNDaysLater(int day) {
		if(day<0) { return;}
		this.day=this.day + day;
	}
	
	//getters and setters
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
}
