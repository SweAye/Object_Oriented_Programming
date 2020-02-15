import java.util.Date;

public class SimpleCalendar {
	
	public static void main (String[] args){
		
		CalendarModel newModel = new CalendarModel(new Date());
		Views view = new Views(newModel);
		
		newModel.attach(view);
		
		
		
	}

}
