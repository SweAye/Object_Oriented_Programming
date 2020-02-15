import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Views implements ChangeListener{
	
	private static JFrame frame;
	private static CalendarModel cal;
	private static Calendar c;
	private static ArrayList<Calendar> days ;
	private static Calendar CalInstance;
	//private static  String [][] data = new String[10][10];
	private static String EventName =null;
	private static String EventStartTime= null;
	private static String EventEndTime = null;
	private static Object[][] data = new Object[10][10];
	
	
	public Views(CalendarModel m){
		cal = m;
		//cal = new CalendarModel(new Date());// initialized with intended date
		 c= cal.getCalendarInstance();// getting calendar instance
		//TopPanel();// call here for main Frame
		 CreateCalendar();
		 days = new ArrayList<Calendar>();
		
	}
	private static  int GetFirstDayOfMonth(Calendar calendar) {// calendar is current running date
		int firstDay= calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
		System.out.println("firstDay is: " + firstDay );
		//a brand new obj of calendar for just finding the day of week, will not used by anywhere
		Calendar dayFinder = new GregorianCalendar(); 
		dayFinder.set(Calendar.DAY_OF_MONTH,firstDay);
		
		int firstDayName = dayFinder.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("firstDayName is: " + firstDayName );
		
		
		return firstDayName;
	}
	/**
	 * This method will repaint after the stateChanged
	 */
	public static void CreateCalendar(){
		// call MainFrame here
		Component m = MonthView();
		Component southPanel = bundlePanelSouth(m, EventTableGUI());
		Component centerPanel = Create_QuitGUI();
		Component northPanel = DecIncView();
		MainFrame(northPanel,centerPanel,southPanel);
		
		
	}
	public static Component DecIncView(){

		JPanel NorthPanel = new JPanel();
		NorthPanel.setLayout(new FlowLayout());
		
		JButton buttonDec = new JButton("<");// need to add action listener
		buttonDec.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				  SimpleDateFormat  format = new SimpleDateFormat("MM/dd/yyyy");
				c.add(Calendar.DAY_OF_WEEK, -1);
				frame.dispose();
				CreateCalendar();
				System.out.println("Today is : "+ format.format(c.getTime()));

			}
			
			
			
			
		});
		JButton buttonInc = new JButton(">");// need to add action listener
		buttonInc.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				  SimpleDateFormat  format = new SimpleDateFormat("MM/dd/yyyy");
				c.add(Calendar.DAY_OF_WEEK, +1);
				frame.dispose();
				CreateCalendar();
				
				System.out.println("Today is : "+ format.format(c.getTime()));

			}
			
			
			
			
		});

		NorthPanel.add(buttonDec);
		NorthPanel.add(buttonInc);
		return NorthPanel;
	}
		


public static Component Create_QuitGUI(){
		
		JPanel  centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout());
		
		
		JButton create = new JButton("CREATE");
		create.setBackground(Color.ORANGE);
		
		
		 create.addActionListener(new
		           ActionListener()
		           {
		              public void actionPerformed(ActionEvent event)
		              {
		            	  //call this method
		            	  //CreateEventTable(eventPanel);
		            	  System.out.println("Creating a event table");
		            	  EventsCreaterGUI();
		            	     
		              }
		           });
		
		
		
		
		JButton quit = new JButton("QUIT");
		quit.addActionListener(new
		           ActionListener()
		           {
		              public void actionPerformed(ActionEvent event)
		              {
		            	  //call this method
		            	  //CreateEventTable(eventPanel);
		            	  System.out.println("Quitting");
		            	  frame.dispose();
		            	     
		              }
		           });
		
		
		quit.setBackground(Color.GRAY);
		
		centerPanel.add(create);
		centerPanel.add(quit);
		
		return centerPanel;
		
		
		
	}
public static void EventsCreaterGUI(){
	
	JFrame CreatFrame = new JFrame();
	JPanel comboPanel = new JPanel();
	comboPanel.setLayout(new BoxLayout(comboPanel,BoxLayout.Y_AXIS));
	//JPanel eventPanel = new JPanel();
	JPanel TimePanel = new JPanel();
	TimePanel.setLayout(new FlowLayout());
	//panel.setLayout(arg0);
	JTextField  eventName = new JTextField("Untitled event");
	
	
	SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

	
	JTextField  day = new JTextField(format.format(c.getTime()));
	JTextField startTime =new JTextField("00:00");
	JTextField EndTime =new JTextField("00:00");
	
	JButton saveButton = new JButton("SAVE");
	saveButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
		EventName = eventName.getText();
		 EventStartTime = startTime.getText();
			 EventEndTime = EndTime.getText();
			addData();
			
			CreatFrame.dispose();
			CreateCalendar();
		}

		private void addData() {
		data[0][0] = EventStartTime;
		data[0][1]= EventName;
		data[1][0]= EventEndTime;
			
		}

		
	});
	TimePanel.add(day);
	TimePanel.add(startTime);
	TimePanel.add(EndTime);
	TimePanel.add(saveButton);
	
	comboPanel.add(eventName);
	comboPanel.add(TimePanel);
	
	
	CreatFrame.add(comboPanel);
	CreatFrame.setVisible(true);
	CreatFrame.pack();
	CreatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	
	
}


	private static  Component bundlePanelSouth(Component c1, Component c2){
		JPanel SouthPanel = new JPanel();
		SouthPanel.setLayout(new FlowLayout());
		
		SouthPanel.add(c1);
		SouthPanel.add(c2);
		
		return SouthPanel;
		
		
	}
	
	
	
	
	public static  Component EventTableGUI(){
		JPanel comboPanel = new JPanel();
		comboPanel.setLayout(new BoxLayout(comboPanel,BoxLayout.Y_AXIS));
		
		JLabel dateLabel = new JLabel();
		
		  SimpleDateFormat  format = new SimpleDateFormat("MM/dd/yyyy");
			
			dateLabel.setText(format.format(c.getTime()));
		
		String[] columns = {" "," "};
		 
      

        
        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(150,150));
        scrollPane.add(new JSeparator());
        
        
        table.setRowHeight( 20);
        table.getColumnModel().getColumn(1).setWidth( 100 );
        
        
        comboPanel.add(dateLabel);
        comboPanel.add(scrollPane);
       return comboPanel;
        	
	}
	

	
	private static  void MainFrame(Component North,Component Center, Component south) {
		frame = new JFrame();
		frame.setSize(new Dimension(3000,3000));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		mainPanel.add(North);
		mainPanel.add(Center);
		mainPanel.add(south);
		
		
		
		frame.add(mainPanel);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	public static Component MonthView(){
		
		
		int firstDay = c.get(Calendar.DATE);// today is done
		
		int noDaysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		
		int startDate = GetFirstDayOfMonth(cal.getCalendarInstance());// need to fix
		System.out.println("startDate " + startDate);//check if this Tuesday for may
		
		
		
		JPanel keyPanel = new JPanel();
		
		keyPanel.setLayout(new GridLayout(0, 7));
	     Border emptyBorder = BorderFactory.createEmptyBorder();
	  
	     JPanel comboPanel = new JPanel();
		comboPanel.setLayout(new BoxLayout(comboPanel, BoxLayout.Y_AXIS));
			
	     
			for(Day d: Day.values()) {
					//System.out.printf("%-8s", "");
					// This is just for space purpose with empty non listner buttons
					String temp = String.format("%s", d);
					
			        JButton keyButton = new JButton(temp);
			        keyButton.setBorder(emptyBorder);
			        keyButton.setBorderPainted(false);
			        keyButton.setContentAreaFilled(false);

			        keyPanel.add(keyButton);
			       }
				

		for (int i = 1; i < startDate; i++) {
			//System.out.printf("%-8s", "");
			// This is just for space purpose with empty no listner buttons
	        JButton keyButton = new JButton("");
	        keyButton.setBorder(emptyBorder);
	        keyButton.setBorderPainted(false);
	        keyButton.setContentAreaFilled(false);

	        keyPanel.add(keyButton);
	       }
		
		for (int i = 1; i <= noDaysInMonth; i++) {
			//System.out.println("In monthView: noOfDaysInMonth is" + noDaysInMonth);
			if (i == getToday()) {
				CalInstance = new GregorianCalendar();
				 JButton keyButton = new JButton(Integer.toString(i));
			        //keyButton.setBorder(emptyBorder);
			        keyButton.setBorderPainted(true);
			        keyButton.setContentAreaFilled(false);

			        keyPanel.add(keyButton);
			        keyButton.addActionListener(new
			           ActionListener()
			           {
			              public void actionPerformed(ActionEvent event)
			              {
			            	  SimpleDateFormat  format = new SimpleDateFormat("MM/dd/yyyy");
			            	  
			            	  
			            	  //cal.update(c.getTime());
			            	  System.out.println("Today is : "+ format.format(c.getTime()));

			            	  
			            	     
			              }
			           });
			        
			     }

			else 
			{JButton keyButton = new JButton(Integer.toString(i));
	        keyButton.setBorder(emptyBorder);
	        keyButton.setBorderPainted(false);
	        keyButton.setContentAreaFilled(false);

	        keyPanel.add(keyButton);
	        keyButton.addActionListener(new
	           ActionListener()
	           {
	              public void actionPerformed(ActionEvent event)
	              {
	            	  //call this method
	            	  //CreateEventTable(eventPanel);
	            	 
	            	  SimpleDateFormat  format = new SimpleDateFormat("MM/dd/yyyy");
	            	  c.add(Calendar.DAY_OF_WEEK, +1);
	            	//  cal.update(c.getTime());
	            	  System.out.println("Date is : "+ format.format(c.getTime()));
	            	  System.out.println("A Date is Pressed");
	                
	              }
	           });
			}
			
	}
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		JLabel label = new JLabel();// a string of current month and year is returned from this method
		label.setText(getCurrMonth_Year());
		
		panel.add(label);
		comboPanel.add(panel);
		comboPanel.add(keyPanel);
		
		return comboPanel;
		
		
	}
	
private static String getCurrMonth_Year(){
		
		System.out.println("I am in the getCurrMonth_Year");
		SimpleDateFormat  format = new SimpleDateFormat("MM/dd/yyyy");
  	  int actualMonth = c.get(Calendar.MONTH);
		//int actualMonth = c.get(Calendar.DAY_OF_MONTH );
		
		System.out.println("actual Month is "+ actualMonth);
	    String currentM = new DateFormatSymbols().getMonths()[actualMonth];
	    System.out.println("curentM is "+ currentM );
	  //String temp = null; 
	    String temp = String.format("%25s %s\n", currentM, c.get(Calendar.YEAR));
		System.out.println("in the getCurrMonth_Year:" + temp);
		return temp;
		
	}

	
	private static int getToday() {
		// TODO Auto-generated method stub
		
		int today = c.get(Calendar.DATE);
		return today;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		System.out.println("I am in the stateChanged");
		System.out.println(e.getSource().toString()) ;
		c = cal.getCalendarInstance();// here constructor calendar instance is updated
		System.out.println("I am in the stateChanged");
		c.setTime(c.getTime());
		
		frame.dispose(); 
		CreateCalendar();
	
	}

	
	
	
	
}
