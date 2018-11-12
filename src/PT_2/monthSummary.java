package PT_2;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class monthSummary {

	public static void main(String[] args) {
		 

		 // create a GregorianCalendar with current time zone
		 Calendar calendar = new GregorianCalendar(TimeZone.getDefault());
		 Date trialTime = new Date();
		 calendar.setTime(trialTime);

		 for (int w = 1, t = 2 - calendar.getMinimalDaysInFirstWeek(); t <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); w++) {
			 for (int i = 1; i <= 7; i++, t++) {
				 if (calendar.getMinimalDaysInFirstWeek() <= i || w != 1) {
					 if (t <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH) )
						 if (calendar.get(Calendar.DAY_OF_MONTH) == t)
							 System.out.print(t + "*\t");
						 else
							 System.out.print(t + "\t");
			 	} else {
			 		System.out.print("\t");
			 	}
			 }
			 System.out.println(); 
		 }
	}
}
