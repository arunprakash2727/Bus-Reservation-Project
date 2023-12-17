package BusReservation;

public class Bus {
    private int Busno;
    private boolean Ac;
    private int Capacity;

    public int getBusno(){
        return Busno;
    }
    public boolean getAc(){
        return Ac;
    }
    public int getCapacity(){
        return Capacity;
    }
    public void setBusno(int Busno){
        this.Busno=Busno;
    }
    public void setCapacity(int Capacity){
        this.Capacity=Capacity;
    }
}
