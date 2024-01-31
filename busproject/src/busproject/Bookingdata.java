package busproject;
import java.sql.*;
import java.util.Date;

public class Bookingdata {
   //booking count
	public int bookedcount(int busno,Date date) throws SQLException
	{
		String query="select count(passenger_name) from alterbook where bus_no=? and travel_date=?";//changed table name asalter book for instead of booking , because of autogenerate.
		
		Connection con=Database.getconnection();
		PreparedStatement pst=con.prepareStatement(query);
		java.sql.Date sqldate=new java.sql.Date(date.getTime());
		pst.setInt(1, busno);
		pst.setDate(2, sqldate);
		ResultSet rs=pst.executeQuery();
		rs.next();
		return rs.getInt(1);
	}
	
	//Add booking
	public void addbooking(Booking booking)throws SQLException
	{
		String query="insert into alterbook(passenger_name,bus_no,travel_date)  values(?,?,?)";
		Connection con=Database.getconnection();
		PreparedStatement pst=con.prepareStatement(query);
		java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());
		pst.setString(1, booking.passengername);
		pst.setInt(2, booking.busno);
		pst.setDate(3,sqldate);
		pst.executeUpdate();
	}
	
	//Delete record
	public void deleterecord(int id,Date canceldate)throws SQLException
	{
		String query="delete from alterbook where passenger_id=? and travel_date=?";
		Connection con=Database.getconnection();
		PreparedStatement pst=con.prepareStatement(query);
		java.sql.Date sqldate=new java.sql.Date(canceldate.getTime());
		pst.setInt(1, id);
		pst.setDate(2, sqldate);
		pst.executeUpdate();
	}
	
	
}
