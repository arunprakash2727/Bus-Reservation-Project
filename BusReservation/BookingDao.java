package BusReservation;
import java.util.Date;
import java.sql.SQLException;
import java.sql.*;
public class BookingDao {
    public int BookedCount(int Bus_id,Date date)throws SQLException{
        String query="SELECT COUNT(NAME) FROM BOOKING WHERE BUS_ID=? AND TRAVEL_DATE=?";
        Connection conect=DBConnection.getConnection();
        PreparedStatement pst=conect.prepareStatement(query);
        pst.setInt(1,Bus_id);
        java.sql.Date sqldate=new java.sql.Date(date.getTime());
        pst.setDate(2,sqldate);
        ResultSet rs=pst.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public void addBooking(Booking booking)throws SQLException{
        String query="INSERT INTO BOOKING VALUES (?,?,?)";
        Connection conect=DBConnection.getConnection();
        PreparedStatement pst=conect.prepareStatement(query);
        pst.setString(1,booking.Name);
        pst.setInt(2,booking.Bus_id);
        java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());
        pst.setDate(3,sqldate);
        pst.executeUpdate();
    }
}
