package BusReservation;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class Booking {
    public String Name;
    public int Bus_id;
    public Date date;

    public Booking(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter Your name");
        Name=scan.nextLine();
        System.out.println("Enter the bus number");
        Bus_id=scan.nextInt();
        System.out.println("Enter your journey date in dd-MM-yyyy");
        String dateIn=scan.next();
        SimpleDateFormat dateFor=new SimpleDateFormat("dd-MM-yyyy");
        try{
            date=dateFor.parse(dateIn);
        }
        catch(ParseException e){
            e.printStackTrace();
        }
    }

    public boolean isAvailable() throws SQLException {
        BusDao busdao=new BusDao();
        int Capacity=busdao.getCapacity(Bus_id);

        BookingDao bookdao=new BookingDao();
        int Booked=bookdao.BookedCount(Bus_id,date);

        return Booked<Capacity;
    }
}
