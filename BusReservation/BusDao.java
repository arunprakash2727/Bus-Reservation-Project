package BusReservation;
import java.sql.*;
public class BusDao {
    public static void getBusInfo() throws SQLException {
        String query="SELECT * FROM BUS";
        Connection conect=DBConnection.getConnection();
        Statement st=conect.createStatement();
        ResultSet res=st.executeQuery(query);
        while(res.next()){
            System.out.println("Bus no: "+res.getInt(1));
            if(res.getInt(2)==1)
                System.out.println("Ac is available");
            else
                System.out.println("Ac isnt available");
            System.out.println("Capacity :"+res.getInt(3));
            System.out.println("---------x---------");
        }
        System.out.println("--------------------------");
    }

    public int getCapacity(int Bus_id)throws SQLException{
        String query="SELECT CAPACITY FROM BUS WHERE BUS_NO="+Bus_id;
        Connection conect=DBConnection.getConnection();
        Statement st=conect.createStatement();
        ResultSet re=st.executeQuery(query);
        re.next();
        return re.getInt(1);
    }

}
