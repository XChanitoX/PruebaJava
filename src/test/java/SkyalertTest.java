import org.junit.Test;
import skyalert.Aerolinea;
import skyalert.Skyalert;
import skyalert.Usuario;
import org.testng.Assert;

public class SkyalertTest {

    Skyalert skyalert = Skyalert.getInstance();

    @Test
    public void addAerolinea() {
        skyalert.clear();
        var aerolinea = new Aerolinea(50,"Test");
        aerolinea.setTarifa(80);
        skyalert.addAerolinea(aerolinea);
        var name = skyalert.getAerolineas().get(0).getName();
        Assert.assertEquals(name, "Test");
    }

    @Test
    public void addObserver() {
        skyalert.clear();
        var usuario = new Usuario(100,2,"Test");
        var aerolinea = usuario.getAerolinea();
        skyalert.addObserver(usuario);
        var name = skyalert.getUsuarios().get(0).getName();
        Assert.assertEquals(name, "Test");
    }

    @Test
    public void removeObserver() {
        skyalert.clear();
        var usuario = new Usuario(100,2,"Test");
        skyalert.addObserver(usuario);
        skyalert.removeObserver(usuario);
        Assert.assertTrue(skyalert.getUsuarios().isEmpty());
    }

    @Test
    public void cantFindMatch() {
        skyalert.clear();
        var aerolinea1 = new Aerolinea(600,"Aerolinea1");
        var aerolinea2 = new Aerolinea(10,"Aerolinea2");
        var aerolinea3 = new Aerolinea(50,"Aerolinea3");

        var usuario1 = new Usuario(1000,2,"Usuario1");
        var usuario2 = new Usuario(300,10,"Usuario2");
        var usuario3 = new Usuario(750,5,"Usuario3");
        var usuario4 = new Usuario(800,2,"Usuario4");
        var usuario5 = new Usuario(500,2,"Usuario5");

        skyalert.addAerolinea(aerolinea1);
        skyalert.addAerolinea(aerolinea2);
        skyalert.addAerolinea(aerolinea3);

        skyalert.addObserver(usuario1);
        skyalert.addObserver(usuario2);
        skyalert.addObserver(usuario3);
        skyalert.addObserver(usuario4);
        skyalert.addObserver(usuario5);

        Assert.assertFalse(skyalert.findMatch());
    }

    @Test
    public void findMatch() {
        skyalert.clear();
        var aerolinea1 = new Aerolinea(500,"Aerolinea1");
        var aerolinea2 = new Aerolinea(10,"Aerolinea2");
        var aerolinea3 = new Aerolinea(250,"Aerolinea3");

        var usuario1 = new Usuario(1000,2,"Usuario1");
        var usuario2 = new Usuario(300,10,"Usuario2");
        var usuario3 = new Usuario(750,5,"Usuario3");
        var usuario4 = new Usuario(800,2,"Usuario4");
        var usuario5 = new Usuario(500,2,"Usuario5");

        skyalert.addAerolinea(aerolinea1);
        skyalert.addAerolinea(aerolinea2);
        skyalert.addAerolinea(aerolinea3);

        skyalert.addObserver(usuario1);
        skyalert.addObserver(usuario2);
        skyalert.addObserver(usuario3);
        skyalert.addObserver(usuario4);
        skyalert.addObserver(usuario5);

        Assert.assertTrue(skyalert.findMatch());
    }

}