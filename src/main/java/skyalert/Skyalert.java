package skyalert;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Skyalert {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Aerolinea> aerolineas = new ArrayList<>();
    Logger logger = Logger.getLogger(Skyalert.class.getName());

    private static Skyalert instance;

    private Skyalert(){}

    public static Skyalert getInstance(){
        if (instance == null)
            instance = new Skyalert();
        return instance;
    }

    public void addAerolinea(Aerolinea aerolinea) {
        this.aerolineas.add(aerolinea);
    }

    public void addObserver(Usuario usuario){
        this.usuarios.add(usuario);
    }

    public void removeObserver(Usuario usuario) {
        this.usuarios.remove(usuario);
    }

    public boolean findMatch() {
        boolean alerta = false;
        for (Usuario usuario : usuarios) {
            for (Aerolinea aerolinea : aerolineas) {
                if (usuario.getPrecio() / usuario.getDuracion() == aerolinea.getTarifa()) {
                    alerta = true;
                    usuario.update(aerolinea.getName());
                    var match = usuario.getName() + " & " + aerolinea.getName();
                    logger.log(Level.INFO, "Match found! {0}", match);
                }
            }
        }
        return alerta;
    }

    public List<Aerolinea> getAerolineas() {
        return aerolineas;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void clear(){
        usuarios.clear();
        aerolineas.clear();
    }

}
