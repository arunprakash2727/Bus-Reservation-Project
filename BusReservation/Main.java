package BusReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[]args) {
        try {
            BusDao.getBusInfo();
            int userIn = 1;
            Scanner scan = new Scanner(System.in);
            while (userIn == 1) {
                System.out.println("Enter 1 to book and 2 to exit");
                userIn = scan.nextInt();
                if (userIn == 1) {
                    Booking booking = new Booking();
                    if (booking.isAvailable()) {
                        BookingDao bookdao = new BookingDao();
                        bookdao.addBooking(booking);
                        System.out.println("Your booking is confirmed");
                    } else {
                        System.out.println("sorry try another time");
                    }
                }
            }
            scan.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
