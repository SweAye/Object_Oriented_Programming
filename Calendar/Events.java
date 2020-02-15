import java.util.Date;
import java.util.GregorianCalendar;

public class Events {
	
	private int year=0;
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
	private Date date2;
	
	
	public Events(){
		
	}

	public Events(Date date2,int year, int month, int date, int day, String startTime, String endTime, String event, int startHr,
			int starMin, int endHr, int endMin) {
		super();
		this.year = year;
		this.month = month;
		this.date = date;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.event = event;
		this.startHr = startHr;
		this.starMin = starMin;
		this.endHr = endHr;
		this.endMin = endMin;
		this.setDate2(date2);
	}

	
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public int getStartHr() {
		return startHr;
	}

	public void setStartHr(int startHr) {
		this.startHr = startHr;
	}

	public int getStarMin() {
		return starMin;
	}

	public void setStarMin(int starMin) {
		this.starMin = starMin;
	}

	public int getEndHr() {
		return endHr;
	}

	public void setEndHr(int endHr) {
		this.endHr = endHr;
	}

	public int getEndMin() {
		return endMin;
	}

	public void setEndMin(int endMin) {
		this.endMin = endMin;
	}
	
	
	@Override
	   public String toString() {
	        return ("Date:" +getDate()+
	                    "   Month: "+ getMonth() +
	                    "   Year : "+ getYear()+
	        "   Day : "+ getDay()+
	        "   Event : " + getEvent()+
	        "   StartTime : "+ getStartTime()+
	        "  EndTime: " + getEndTime());
	   }
	
	
	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}
	
		}
