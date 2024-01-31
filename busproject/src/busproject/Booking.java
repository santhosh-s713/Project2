package busproject;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Booking {
	String passengername;
	int busno;
	Date date;
	int id;
	
	//Booking method
	Booking()
	{
	    Scanner scanner=new Scanner(System.in);
		System.out.println("enter the passenger name:");
		passengername=scanner.next();
		System.out.println("enter the bus no:");
		busno=scanner.nextInt();
		System.out.println("enter the date for booking in dd-MM-yyyy");
		String dateinput=scanner.next();  
		SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy");
		try {
			date=dateformat.parse(dateinput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//Available Method	
public boolean available()throws SQLException
{
	Busdata bus=new Busdata();
	int capacity=bus.getcapacity(busno);
	
	Bookingdata bookingdata=new Bookingdata();
	int booked=bookingdata.bookedcount(busno,date);
	
	return booked<capacity;
	
}



}
