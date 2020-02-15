

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * A model part of the MVC, with attach method for listener and update method for stat change
 * @author Aye Swe
 *
 */


public class CalendarModel {
	private String day = null;
	private String WeekOfDay = null;
	private String dayOfMonth = null;
	private String year = null;
	private ArrayList<ChangeListener> listeners;
	private Calendar cal = new GregorianCalendar();
	/**
	 * constructor will set today date
	 * @param date
	 */
	
	public CalendarModel(Date date){
		
		cal.setTime(date);
		listeners = new ArrayList<ChangeListener>();
		
	}
	public void attach(ChangeListener c){
		System.out.println("I am in the attach of model");
		listeners.add(c);
	}
	
	/**
	 * This method will return a CalendarInstance with preSetted date
	 * @return
	 */
	public Calendar getCalendarInstance() {
		return cal;
	}
/**
 * the update method for this model
 * this method will set to different date 
 */
 
	public void update(Date d) {
		SimpleDateFormat  format = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("IN update testing: now date is " +format.format(d));
		
		cal.setTime(d);
		System.out.println("after setTime" + cal.getTime().toString() );
		for (ChangeListener l : listeners)
		    {
			 System.out.println("I am in the update");
		       l.stateChanged(new ChangeEvent(this));
		    }
	}
	
/**
 * This method will return presetted date such as 1, 2, 3, 4
 * @return
 */

	public String getDay() {
		return day;
	}
/**
 * This method will return Mon, Tues, Wed etc of the setted date
 * @return
 */
	public String getWeekOfDay() {
		return WeekOfDay;
	}

/**
 * This method will return the month of the date with setted date
 * @return
 */
	public String getDayOfMonth() {
		return dayOfMonth;
	}
/**
 * This method will return the year of the date setted
 * @return
 */

	public String getYear() {
		return year;
	}

}
