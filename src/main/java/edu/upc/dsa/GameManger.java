package edu.upc.dsa;
/**
import edu.upc.dsa.models.Personaje;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.User;

import java.util.HashMap;
import java.util.List;

public interface GameManger {
    public void registerJugador(String name, String password);
    public void addObjeto(String name, String nick);
    public List<Objeto> listadoObjetos(String nick);
    public List<User> listarUsers();
    public int sizeJugadores();
    public Personaje consultarPersonaje(String nick);
    public int numerosObjetos(String nombre); // me da el numero de objetos de un Personaje
    public Personaje updateJugador(Personaje p);



    public Personaje getPersonaje(String id); //necesaria pero no me la piden
    public void clear();  // para el teardown
}
*/