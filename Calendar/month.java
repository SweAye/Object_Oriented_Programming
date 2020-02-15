

public enum month {
		
		JANUARY (0),
		FEBRUARY(1),
		MARCH (2),
		APRIL(3),
		MAY (4),
		JUNE(5),
		JULY(6),
		AUGUST(7),
		SEPTEMBER(8),
		OCTOBER(9),
		NOVEMBER(10),
		DECEMBER(11);
		
		private final int noMonth;
		month(int noMonth){
			
			this.noMonth = noMonth;
		}
		
		public int getNoMonth(){
			
			return noMonth;
					
			
		}
		
		public String getMonthInLiteral(int numMonth){
			
			String month = null;
			
			month[] m = new month[12];
			m= this.values();
			month = m[numMonth].toString();
			
			
			return month;
		}

	
}
