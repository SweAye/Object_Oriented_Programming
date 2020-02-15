
public enum Day {
		
		SUN (1),
		MON (2), 
		TUE(3), 
		WED(4), 
		THU(5), 
		FRI(6), 
		SAT(7); 
		

		private final int DateNo;
		Day (int dayNo){
			DateNo = dayNo;
		}
		public int getDateNo(){
			return  DateNo;	
		}
	
}
