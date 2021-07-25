package skyalert;

public class Aerolinea {
    private double tarifa;
    private String name;

    public Aerolinea(double tarifa, String name){
        this.tarifa = tarifa;
        this.name = name;
    }

    public double getTarifa(){
        return tarifa;
    }

    public void setTarifa(double tarifa){
        this.tarifa = tarifa;
    }

    public String getName(){
        return name;
    }
}
