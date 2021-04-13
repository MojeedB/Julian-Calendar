package edu.cuny.csi.csc330.lab1;

/**
 * Generates a non-leap year perpetual Julian Calendar 
 * @author lji
 *
 */
public class JulianCalendar {
	
	// Max number of Days in a month 
	static private  final int MAX_DAY = 31; 
	
	// abbreviated Month names 
	static private  final String [] MONTH_NAMES = {
		"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
	};
	
	// day length of each month 
	static private final  int [] MONTH_SIZES = {
		31, 28, 31,30,31, 30, 31, 31, 30, 31, 30, 31
	};

	/**
	 * display The "DAY" Column Heading 
	 */
	static private void displayDayHeading() {
		System.out.printf("%6s", "Day");
		
	}
	
	/**
	 * display Month names between Day .... Day
	 */
	static private void displayHeading() {
		displayDayHeading(); 
		
		for(int i = 0 ; i < MONTH_NAMES.length ; ++i )  {
			System.out.printf("%5s", MONTH_NAMES[i]);
		}
		
		displayDayHeading(); 
	}
	

	static public void display() {
		displayHeading(); // display heading 
		System.out.printf("%n");
		
		int [][] dayGrid = new int[MAX_DAY][(MONTH_NAMES.length + 2)];
		int dayCounter = 1;
		int monthCounter=0;
		
		// Nested loop to initialize the array dayGrid of 31 rows and 14 columns
		for(int col = 0; col < (MONTH_NAMES.length + 2); col++)  {
			for(int row = 0; row < MAX_DAY; row++){
				if (col == 0 || col == 13) { //Sets the day column from 1-31
					dayGrid[row][col] = row +1;
				}
				else if (row < MONTH_SIZES[monthCounter]) { //Increments the days in each month
					dayGrid[row][col] = dayCounter;
					dayCounter++;
				}
				else {
					dayGrid[row][col] = 0;	 //Sets days that are out of MONTH_SIZES bound to zero
				}
				
			} // end of row for loop
			if(col > 0 && col < 12) {		 //Increments the month column while ignoring the Day column
				monthCounter++; 
			}
		} // end of col for loop

		
		//Nested loop to print the array of dayGrid
		for(int row = 0; row < dayGrid.length; row++) {
			for(int col = 0; col < dayGrid[row].length; col++) {
				
				if (col == 0 || col == 13) { //Prints the day column from 1-31
					System.out.printf("%6d", dayGrid[row][col]);
				}
				else {						 //Prints the days by months
					System.out.printf(" %0 4d", dayGrid[row][col]);
				}
			} // end of col for loop
			System.out.printf("%n");
		} // end of row for loop
		
	} // end method
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// invoke display method 
		JulianCalendar.display(); 
	}
}