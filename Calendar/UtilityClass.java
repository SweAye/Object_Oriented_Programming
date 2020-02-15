	import java.text.ParseException;
	import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
	
	/**
	 * Various kinds of utilities methods that support the MyCalendarTester's
	 * functions
	 * 
	 * @author Aye Swe
	 *
	 */
	
	public class UtilityClass {
	
	
	
	/**
	 * Compare two string of date passed in MM/dd/yyyy format
	 * 
	 * @param dummyString
	 * @param userdate
	 * @return
	 */
	
	public static boolean DateComparator(String dummyString, String userdate) {
	
		boolean value = false;
	
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
		try {
			value = format.parse(dummyString).equals(format.parse(userdate));// this
		} catch (ParseException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			return value;
		}
	//----------------------
		
	public static String format(GregorianCalendar calendar){
	    SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yyyy");
	    fmt.setCalendar(calendar);
	    String dateFormatted = fmt.format(calendar.getTime());
	    return dateFormatted;
	}
	/**
	 * take user input date in MM/DD/YYYY format
	 * 
	 * @return
	 */

	public static String getUserDate(){
	
		Scanner scan = new Scanner(System.in);
			System.out.print("Type a date: in MM/DD/YYYY format: ");
			String date = scan.nextLine();
			
		return date;
	
}
/*
 * fomate any date to MM/dd/yyyy format
 * @ pram value
 * @ pram value
 * 
 */
	public static String DateFormatter(String date){
	
	String Date = new SimpleDateFormat("MM/dd/yyyy").format(date);
	
	return Date; 
}
	
	
	
	public static String[] tokenizeStringPatern(String v) {

		String[] token = v.split(" ");
		
		return token;
			
	}

	public static String[] tokenizeStringPatern1(String v) {

		String[] token = v.split(":");
		
		return token;
			
	}

	public void displayMessage(String message){
		
		System.out.print(message);
	}
	
		
		public static String UserInputString(){
			Scanner myScanner;		
			myScanner = new Scanner(System.in);
			return myScanner.nextLine();
		}
		
		
		public static String ChooseDay(int day) {

			switch (day) {
			case 0:
				
				return "Sunday";
				

			case 1:
				return "Monday";
				

			case 2:
				return "Tuesday";
				

			case 3:
				return "Wesdenday";
				

			case 4:
				return "Thursday";
				

			case 5:
				return "Friday";
				

			case 6:
				return "Saturaday";
				

			default:
				return "Not a day";
				
			}

		}
			public static String ChooseMonth(int m) {

				switch (m) {
				case 1:
					
					return "January";
					

				case 2:
					return "February";
					

				case 3:
					return "March";
					

				case 4:
					return "April";
					

				case 5:
					return "May";
					

				case 6:
					return "June";
					

				case 7:
					return "July";
					
					
				case 8:
					
					return "August";
					

				case 9:
					return "September";
					

				case 10:
					return "Octobember";
					

				case 11:
					return "November";
					

				case 12:
					return "December";
					

				default:
					return "Not a day";
					
				}
		
			
			
	
			}
			
			public static ArrayList<Events> FindEventWithDate(Date d, ArrayList<Events> e){
				Collections.sort(StoreArrayListOfEventObject.GetRefereceOfMainList(),new Comparator<Events>(){
					public int compare(Events e1, Events e2){
						return (e1.getDate2().compareTo(e2.getDate2()));
					}
				});

				ArrayList<Events> SameDayEvents = new ArrayList<Events>();
				
				//compare d and d in the ArrayList 
				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
				
				
				for (int i =0; i< e.size(); i++){
					GregorianCalendar g1 = new GregorianCalendar();
					GregorianCalendar g2 = new GregorianCalendar();
					g1.setTime(d);//user enter day
					g2.setTime(e.get(i).getDate2());//day in the main Array list 
					
					if (g1.equals(g2))
					{
						SameDayEvents.add(e.get(i));
						
					}
					
					
				}
				System.out.println("From FindSameDayEvent()");
				for (Events ev: SameDayEvents){
					System.out.println(ev);
				}
				return SameDayEvents;
				
			}

			
			public static void displayMenuOfList(ArrayList<Events> Elists){
				ArrayList <Events > temp = new ArrayList<Events> ();
				temp = Elists;
			for (int i = 0; i< temp.size(); i++){
				System.out.println();
				System.out.println("NO."+ (i+1) +" ->"+ temp.get(i).getDay()+ " "+temp.get(i).getMonth() + " "+ 
				temp.get(i).getDate()+ " "+ temp.get(i).getStartTime()+ "-" + temp.get(i).getEndTime()+ 
				"  "+ temp.get(i).getEvent());
				
			}
					
			}
			public static void PrintArray(String s ){
			 System.out.printf(s);
				System.out.println();
				for (Events e: StoreArrayListOfEventObject.GetRefereceOfMainList() ){
					System.out.println(e);
					System.out.println();
					}
			
			}
			
			public static void PrintArray(String s, ArrayList<Events> list ){
				 System.out.printf(s);
					System.out.println();
					for (Events e:list){
						System.out.println(e);
						System.out.println();
						}
				
				}

	}
	
	
	
	
	
