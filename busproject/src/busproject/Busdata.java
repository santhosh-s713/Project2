package busproject;
import java.sql.*;


public class Busdata {
	//Display bus details
	public void displayinfo() throws SQLException //view bus data 
	{
		String query="select*from busdetails";
		Connection con=Database.getconnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next())
		{
			System.out.println("bus-no:"+rs.getInt(1));
			if(rs.getInt(2)==0)
			{
				System.out.println("Ac Bus");
			}
			else
			{
				System.out.println("NON-AC Bus");
				
			}
			System.out.println("capacity:"+rs.getInt(3));
		}
		System.out.println("-----------------");
	}
	
	//Get capacity
	public int getcapacity(int id) throws SQLException
	{
		String query="select capacity from busdetails where id="+id;
		Connection con=Database.getconnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
	
	
}
