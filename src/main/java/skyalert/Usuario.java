package skyalert;

public class Usuario {
    private double precio;
    private double duracion;
    private String aerolinea;
    private String name;

    public Usuario(double precio, double duracion, String name){
        this.precio = precio;
        this.duracion = duracion;
        this.name = name;
    }

    public double getPrecio(){
        return precio;
    }

    public double getDuracion(){
        return duracion;
    }

    public String getName(){
        return name;
    }

    public void update(String aerolinea){
        this.aerolinea = aerolinea;
    }

    public String getAerolinea(){
        return aerolinea;
    }
}
