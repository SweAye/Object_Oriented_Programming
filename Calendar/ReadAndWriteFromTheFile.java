import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

public class ReadAndWriteFromTheFile {

	private Formatter output;
	private Scanner input;

	public void openFile() {

		try {
			output = new Formatter("Events.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * NewList.add(new
	 * Events(Elist.get(i).getDate2(),Elist.get(i).getYear(),Elist.get(i).
	 * getMonth()
	 * ,Elist.get(i).getDate(),Elist.get(i).getDay(),Elist.get(i).getStartTime()
	 * ,Elist.get(i).getEndTime()
	 * ,Elist.get(i).getEvent(),Elist.get(i).getStartHr(),
	 * Elist.get(i).getStarMin(),Elist.get(i).getEndHr()
	 * ,Elist.get(i).getEndMin())); }
	 */

	public boolean  OpenToReadFile() {
		try {
			input = new Scanner(new File("events.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("There is nothing to be load yet: ");
			return false;
			//e.printStackTrace();
		}
		return true;
	}

	/**
	 * String date = s1.nextLine();
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

	 * 
	 */
	
	
	public  void  ReadEvents() {
	
		ArrayList<Events> EventMainArray = StoreArrayListOfEventObject.GetRefereceOfMainList();
		while (input.hasNext()) {
			String date2 = input.next();
			int year= input.nextInt();
			int m=input.nextInt();
			int date= input.nextInt();
			int day= input.nextInt();
			String st=input.next();
			String eT=input.next();
			String event= input.next();
			int stHr= input.nextInt();
			int strM= input.nextInt();
			int endHr= input.nextInt();
			int enM= input.nextInt();
			
			// converting String type date2 to Date type
			Date DateFormat=null;
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			try {
				 DateFormat = format.parse(date2);// this date is ready to set with
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//

			}
			
			//	public Events(Date date2,int year, int month, int date, int day, 
			//String startTime, String endTime, String event, int startHr,
			//int starMin, int endHr, int endMin) {
				
			EventMainArray.add(new Events(DateFormat,year,m,date,day,st,eT,event,stHr,strM,endHr,enM));

		}

	}

	public void CloseInputFile() {

		if (input != null) {
			input.close();
		}
	}
	
	/*
	 * String date2 = input.next();
			int year= input.nextInt();
			int m=input.nextInt();
			int date= input.nextInt();
			int day= input.nextInt();
			String st=input.next();
			String eT=input.next();
			String event= input.next();
			int stHr= input.nextInt();
			int strM= input.nextInt();
			int endHr= input.nextInt();
			int enM= input.nextInt();
	 */

	public void WriteEvents( ) {
		// Events anEvent = new Events(date,year, month, Date, day, startTime,
		// endTime, title, StrHr, StrMin,EndHr,EndMin);
		ArrayList<Events> MainE = StoreArrayListOfEventObject.GetRefereceOfMainList();
		for (int i = 0; i < MainE.size(); i++) {
			//Here is the problem
			
			/*public static String DateFormatter(String date){
				
				String Date = new SimpleDateFormat("MM/dd/yyyy").format(date);
				
				return Date; 
			*/
			
			String date2 =new SimpleDateFormat("MM/dd/yyyy").format(MainE.get(i).getDate2());
			
			output.format("%-10s %-5d  %-5d  %-5d  %-5d  %-10s  %-10s  %-10s  %-5d  %-5d  %-5d  %-5d\n",date2,
					MainE.get(i).getYear(),MainE.get(i).getMonth()
					,MainE.get(i).getDate(),MainE.get(i).getDay(),MainE.get(i).getStartTime()
					,MainE.get(i).getEndTime(),MainE.get(i).getEvent()
					,MainE.get(i).getStartHr(),MainE.get(i).getStarMin(),MainE.get(i).getEndHr(),MainE.get(i).getEndMin()); 
		}
	}

	public void closeFile() {
		if (output != null)
			output.close();

	}

}
