
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * In order to create Event obje this calss take roles getting information from
 * user and make Event obje
 * 
 * @author Aye Swe
 *
 */
public class EventObjMaker {

	private static UtilityClass support = new UtilityClass();
	private static Date date;
	private static String title;
	private static int year;
	private static int month;
	private static int Date;
	private static int day;
	private static String startTime;
	private static int StrHr;
	private static int StrMin;
	private static String endTime;
	private static int EndHr;
	private static int EndMin;
/**
 * make an Event obj and return the object to caller
 * @return
 */
	public Events makeEventObj() {

		// call the help er method takeEventsInformation
		takeEventsInformation();
		//System.out.println("Back to the makeEventobj here after visiting takeEventsInformation:");
		// make the event object
		Events anEvent = new Events(date,year, month, Date, day, startTime, endTime, title, StrHr, StrMin,EndHr,EndMin);
		//System.out.println("Returning to the main to return the obj");
		return anEvent;
	}

	private static void setDateinDate(Date d){
		
		date= d;
	}
	
	private static void takeEventsInformation() {

		Date d = null;

		Scanner s = new Scanner(System.in);
		System.out.print("Title: ");
		System.out.println("");
		title = s.nextLine();

		System.out.println("Please type the date in MM/DD/YYYY format.");
		Scanner s1 = new Scanner(System.in);
		String date = s1.nextLine();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		try {
			d = format.parse(date);// this date is ready to set with
			// Gregoralcalendar
			setDateinDate(d);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//

		}

		GregorianCalendar g = new GregorianCalendar();
		g.setTime(d);
		year = g.get(Calendar.YEAR);
		month = g.get(Calendar.MONTH) + 1;
		Date = (g.get(Calendar.DATE));
		day = (g.get(Calendar.DAY_OF_WEEK));

		System.out.printf("%d\t%d\t%d\t%d\n", year, month, Date, day);

		System.out.println("Starting time In military hour:");
		Scanner s2 = new Scanner(System.in);
		 startTime = s2.nextLine();
		String [] start = support.tokenizeStringPatern1(startTime);
		StrHr= Integer.parseInt(start[0]);
		 StrMin= Integer.parseInt(start[1]);
		
		System.out.println("Ending time In military hour:");
		Scanner s3 = new Scanner(System.in);
		endTime = s3.nextLine();
		String [] end = support.tokenizeStringPatern1(endTime);
		
		 EndHr= Integer.parseInt(end[0]);
		 EndMin= Integer.parseInt(end[1]);
		
		//System.out.println("takeEventInformation Done here");
	}
	//**********************************************
	//here comparing Start time and end time of another event implement here
	

}
