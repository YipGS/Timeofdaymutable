package timeofday_oop;
//Create a imutable version for uses a field hours and minutes
//Then create a mutable version for field minutes since midnights
/**
 * Each instance of this class represents a time of day.
 * 
 *@invar | 0<=getHours()&&getHours()<=23
 *@invar | 0<=getMinutes()&&getMinutes()<=59
 *
 *mutable
 */
public class TimeOfDay {
//1.First thing we always do is put informal sentence explaining what instance of the class represent or stores
//2.Define abstract states getHourse,getMinutes .... initially with not yet  So they are three getters
//3.Chose basic getters and derived getters,the first two are the basic getters with@basic , the third is the derived getters with @post condition
//4.We have to say which value of basic getters are valid values,corresponds to an actual abstract state
//5.For the rest of API, provide some way of constructing time of day object, choose which arguments this constructor take. Here hours and minutes
//6.Then documenting the constructor, first what are the valid value of hours and minutes, in each constructor we have to define the initial abstract state of the object we constructed
//The immutable version is done
	
//And now we can go ahead and implement the class TImeOfDay, two possible way for the implementation, hours or minutes
	//Then we need to say the private int ... which value is valid 
//Once we define the valid representations, the valid concrete states of the object, we can define the implementation of the getters, define the relation 
	// between concrete states and abstract states. delete throw new RuntimeException("Not yet")
//////////////////////////////////////////////
	//when we are making this mutable, first add setters
	/**
	 */
	//because now it's mutable we delete final
	private  int minutesSinceMidnight;
	/**
	 * @basic
	 */
	
	//public int getHours() {throw new RuntimeException("Not yet");}

	public int getHours() {return minutesSinceMidnight/60;}
	/**
	 * @basic
	 */
	//public int get() {throw new RuntimeException("Not yet");}
	public int getMinutes(){return minutesSinceMidnight%60;}
	/**
	 * @post| result ==getHours()*60+ getMinutes()
	 */
	//public int get() {throw new RuntimeException("Not yet");}
	public int getMinutesSinceMidnight(){
		return minutesSinceMidnight;
	}
	
	/**
	 * initializes this object so that it represents the time of day given by the given hours and minutes
	 * 
	 * @throws IllegalArgumentException | hours<0 ||23<hours
	 * @throws IllegalArgumentException | minutes<0 || 59<minutes
	 * 
	 * @post | getHours() == hours
	 * @post | getMinutes()==minutes
	 * 
	 */
	////public int getHours() {throw new RuntimeException("Not yet");}
	public TimeOfDay(int hours, int minutes) {
		if(hours<0 ||23<hours)
			throw new IllegalArgumentException("hours is invalid");
		if(minutes<0 || 59<minutes)
			throw new IllegalArgumentException("minutes is invalid");
		this.minutesSinceMidnight=hours*60+ minutes;
	}
	/**
	 * Sets this object's hours to the given hours.
	 * 
	 * @mutate |this
	 * @pre |0<= newHours&&newHours<=23
	 * 
	 * @post |getHours() == newHours
	 * @post |getMinutes() == old(getMinutes())
	 */
	public void setHours(int newHours) {
		minutesSinceMidnight = 60*newHours+getMinutes();
	}
	/**
	 * Sets this object's minutes to the given minutes.
	 * @mutate |this
	 * @pre |0<= newMinutes&&newMinutes<=59
	 * 
	 * @post |getHours() == old(getHours())
	 * @post |getMinutes() == newMinutes
	 */
	public void seMinutes(int newMinutes) {
		minutesSinceMidnight = getHours*60 + newMinutes;
	}
}


