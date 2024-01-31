package busproject;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Busclass {

	public static void main(String[] args) throws SQLException {
		Busdata bus=new Busdata();
		bus.displayinfo();
		int useropt=1;
		Scanner scanner=new Scanner(System.in);
		while(useropt==1||useropt==2||useropt==3)
		{
		System.out.println("enter 1 for booking ,2 for cancellation and 3  for exit ");
		useropt=scanner.nextInt();
		
		if(useropt==1)
			{
				Booking booking=new Booking();
				if(booking.available())
				{
					Bookingdata bookingdata=new Bookingdata();
					bookingdata.addbooking(booking);
				System.out.println("booking is confirmed");
				}
		else
				{
					System.out.println("Try another one, the bus is full");
				}
			}
		
		if(useropt==2)
				{
				Date canceldate =null;
				System.out.println("enter the id:");
				int id=scanner.nextInt();
				System.out.println("enter the date for cancellation in dd-MM-yyyy");
				String dateinput=scanner.next();  
				SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy");
						try {
							canceldate=dateformat.parse(dateinput);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						Bookingdata bookingdata=new Bookingdata();
						 bookingdata.deleterecord(id,canceldate);
			System.out.println("cancellation is successfull");
				}
		
		if(useropt==3)
		{
			System.out.println("-------Thank you for using sj travels---------");
		}
				
				
		}
        scanner.close();
		
	    }

	    }


