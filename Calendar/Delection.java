import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Delection {

	
	
	
	public static void DeleteManager() {
		ArrayList<Events> event = new ArrayList<Events>();
		Date d = null;

		Scanner s = new Scanner(System.in);
		System.out.println("Please type the date you want to delete in MM/DD/YYYY format.");
		Scanner s1 = new Scanner(System.in);
		String date = s1.nextLine();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		
		try {
			d = format.parse(date);// this date is ready to set with
			// Gregoralcalendar
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//

		}

		GregorianCalendar g = new GregorianCalendar();
		g.setTime(d);
		int year = g.get(Calendar.YEAR);
		int	month = g.get(Calendar.MONTH) + 1;
		int Date = (g.get(Calendar.DATE));
		int day = (g.get(Calendar.DAY_OF_WEEK));

		System.out.printf("%d\t%d\t%d\t%d\n", year, month, Date, day);
		//Just testing the return same day events list
		
		event = FindEventWithDate(g.getTime(), StoreArrayListOfEventObject.GetRefereceOfMainList());
		
		
		displayMenuOfList(event);
		
		char choice ;
		choice  =getuserChoice();
		
		if (choice == 'S'){
			System.out.println("Please choose Event NO. eg. 1, 2 or 3): ");
			Scanner scan = new Scanner(System.in);
			int EventNo = scan.nextInt();
			// select one event
			//get the obj information that needd for deletion
			
			String eventTodelete = event.get(EventNo-1).getEvent();
			System.out.println("The string is: " + eventTodelete);
			event.remove(EventNo-1);//this will delete the user choice
			 System.out.println();
			
			 	
			 // Sort the array here
			 Collections.sort(event,new Comparator<Events>(){
					public int compare(Events e1, Events e2){
						return (e1.getDate2().compareTo(e2.getDate2()));
					}
				});
				
			modifyTheMainArray(eventTodelete, g.getTime());// This will make a buch of Events object from the event list and then call the FindAndDelteSameDayEvent(), then add the created Evetns
		}				
		
		if (choice == 'A'){
			//Delete all 
			System.out.println();
			System.out.println("Deleting all event.");
			FindAndDeleteSameDayEvent(g.getTime());
		
			System.out.println();
		}
		
			
	
	}
	
		
	//This method be the last to call, it is modify the main ArrayList in the run time active , but will be gone again in program quit.
	// This will make a buch of Events object from the event list and 
	//then call the FindAndDelteSameDayEvent(), then add the created Evetns
	public static void modifyTheMainArray(String EtoDelete, Date d){
		// deleteing same day from the main array
		//sort main array
		Collections.sort(StoreArrayListOfEventObject.GetRefereceOfMainList(),new Comparator<Events>(){
			public int compare(Events e1, Events e2){
				return (e1.getDate2().compareTo(e2.getDate2()));
			}
		});

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		
		ArrayList<Events> temp = StoreArrayListOfEventObject.GetRefereceOfMainList();
		for (int i =0; i< temp.size(); i++){
			GregorianCalendar g1 = new GregorianCalendar();
			GregorianCalendar g2 = new GregorianCalendar();
			g1.setTime(d);//user enter day
			g2.setTime(temp.get(i).getDate2());//day in the main Array list 
			
			if(temp.get(i).getEvent()==(EtoDelete)  & g1.equals(g2)) 
			
			
			{
				temp.remove(i);
				
			}
			//System.out.println("They are not the same:");
			
		}
			
			 
	}
		
	
		public static char getuserChoice(){
				char c;
				System.out.println();
				System.out.println("Pleaste enter [S]elete or [A]ll");
		Scanner myScanner = new Scanner(System.in);
		return c = myScanner.nextLine().charAt(0);
		
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
		
			
		
	//deleting all events in one day
	public static void FindAndDeleteSameDayEvent(Date d){
	
		ArrayList<Events> tempE = StoreArrayListOfEventObject.GetRefereceOfMainList();
		
	Collections.sort(tempE,new Comparator<Events>(){
		public int compare(Events e1, Events e2){
			return (e1.getDate2().compareTo(e2.getDate2()));
		}
	});
		for (int i =0; i< tempE.size(); i++){
			GregorianCalendar g1 = new GregorianCalendar();
			GregorianCalendar g2 = new GregorianCalendar();
			g1.setTime(d);//user enter day
			g2.setTime(tempE.get(i).getDate2());//day in the main Array list 
		// No this not remove all of them 	
			if (g1.equals(g2))
			{
				tempE.remove(i);
				continue;
				
			}
			
			
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
		
		return SameDayEvents;
	}

}
