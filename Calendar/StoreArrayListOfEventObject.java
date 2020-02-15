

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
public class StoreArrayListOfEventObject{

 /** class will store the evnet object 
 * will work together with Events, EventObjMaker classes
 * will intend to work with calendar also, day view, month view will use this class 
 * to compare the events , find the evnets
 * ***when user crete an event, EventObjmaker will be called by the MyCalendar 
 * **Major job for this class to store events in the runtime and saving to the outside file, before programming terminating (Main Menu Stop).
 */
	
	//Every events are individual events eventhough they have same date, so date are not unique, but events are 
	// user will find the events with date, the system will show all the events in the same date.(Here system will find the date and 
	
	private static ArrayList<Events> EventArray = new ArrayList<Events>();
	
		
	public static void addToArrayList(Events e ){
		
		EventArray.add(e);
		
	}
	public static ArrayList<Events> GetRefereceOfMainList(){
		
		return EventArray;
	}
	
}
	
	
/**
 * here constructing reading and writing from the file to populate the array list
 * 	
 */
/*
	
	private Formatter output;
	public void openFileAndWrite(Events oneEvent)
	{
		try {
			output = new Formatter ("Events.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Events anEvent = new Events(year, month, Date, day, startTime, endTime, title, StrHr, StrMin,EndHr,EndMin);
			//oneEvent.getDate()+"  "+ oneEvent.getMonth()+"  "+ oneEvent.getDay()+"  "+oneEvent.getYear()+"  "+oneEvent.getEndTime()+"  "+oneEvent.getStartTime()+
			/**
			 * private int year=0;
	private int month=0;
	private int date=0;
	private int day=0;
	private String startTime="";
	private String endTime="";
	private String event="";
	private int startHr =0;
	private int starMin=0;
	private int endHr=0;
	private int endMin=0;
	
			 */
			
			//"  "+oneEvent.getEvent()+"  "+oneEvent.getStartHr()+"  "+oneEvent.getStarMin()+"  "+oneEvent.getEndHr()+"  "+oneEvent.getEndMin());
			/*
			output.format(%2d%2d%2d%2d %-5s%-5s%-5s %2d%2d%2d%2d,oneEvent.getDate(), oneEvent.getMonth(),oneEvent.getDay(),oneEvent.getYear(),
					oneEvent.getEndTime(),oneEvent.getStartTime(),oneEvent.getEvent(),oneEvent.getStartHr(),
					oneEvent.getStarMin(),oneEvent.getEndHr(),oneEvent.getEndMin());
					* / 
		}
	}

}
	
	


 */
