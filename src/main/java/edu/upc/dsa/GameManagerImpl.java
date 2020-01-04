package edu.upc.dsa;
/**
//import edu.upc.dsa.models.Personaje;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.User;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GameManagerImpl implements GameManger{
    private static GameManger instance;

    private HashMap<String, User> users;
    //List<Objeto> listaObjetos;

    static Logger logger = Logger.getLogger(GameManagerImpl.class);

    private GameManagerImpl(){
        this.users = new HashMap<String, User>();
        //listaObjetos = new LinkedList<Objeto>(); //comento porque alomejor no es necesario
    }

    public static GameManger getInstance() {  //singleton
        if(instance == null){
            instance = new GameManagerImpl();
        }
        return instance;
    }


    public void addUser(String name, String password) {  //añadir jugador  ACABAR
        logger.info("User added con nombre: " + name);
        users.put(name, new User(name, password, 100, 0, 200));
    }

    public void addObjeto(String name, String jugadorname){  //añadir un objeto a un jugador  ACABAR VER EL DEL PROFE
        logger.info("Numero de objetos antes: " + users.get(jugadorname).getObjetos().size());
        users.get(jugadorname).addObjeto(name);
        logger.info("Numero de objetos despues de añadir: " + users.get(jugadorname).getObjetos().size());
        /**Jugador u = jugadores.get(jugadorId);
        if(u == null){
            logger.error("User not found. UserId: " + jugadorId);
            //throw new UserNotFoundException();
        }
        u.addObjeto(name);
        logger.info("Objeto added. name: " + name);


    }
    public int sizeJugadores()  //me da el tamaño de la lista de jugadores
    {
        logger.info("tamaño de la lista de jugadores: "+ jugadores.size());
        return this.jugadores.size();
    }

    public  List<Jugador> listarJugadores()  //listar jugadores alfaveticamente
    {
        logger.info("Listando jugadores ...");
        List<Jugador> ordenarAlfa = new ArrayList<>(jugadores.values());
        ordenarAlfa.sort(new ComparadorJugadores());
        logger.info(ordenarAlfa.get(0).getNombre());
        logger.info(ordenarAlfa.get(1).getNombre());
        return ordenarAlfa;
    }


    public Jugador consultarJugador(String id)    //consulto un jugador
    {
        Jugador j = jugadores.get(id);
        logger.info("Consultado usuario: " + j.getNombre());
        logger.info("Id: " + j.getId());
        logger.info("Nombre completo: " + j.getNombre() +" " + j.getApellido());
        return j;
    }



    public List<Objeto> listadoObjetos(String id)  {  //objetos de un usuario

        List<Objeto> obj;
        obj= jugadores.get(id).getObjetos();
        logger.info("Se mostraran bien " + id);
        return obj;
    }

    public int numerosObjetos(String id)  {  //numero de objetos de un usuario
        logger.info("numero de objetos del jugador con id" +id+ jugadores.get(id).getObjetos().size());
        return jugadores.get(id).getObjetos().size();
    }

    public Jugador getJugador(String id) {  //obtengo un jugador segun su id (no lo piden pero lo necesito)
        logger.info("getJugador id("+id+")");
        Set<String> jug = jugadores.keySet();
        for (HashMap.Entry<String, Jugador> entry: this.jugadores.entrySet()) {
            if (entry.getValue().getId().equals(id)) {
                logger.info("verJugadores id(" + id + "): " + jug);
                return entry.getValue();
            }
        }
        logger.warn("not found " + id);
        return null;
    }

    public Jugador updateJugador(Jugador p) {   //actualizar nombre y apellido de un jugador
        Jugador t = this.getJugador(p.getId());

        if (t!=null) {
            logger.info(p.getNombre()+" rebut!!!! ");
            t.setNombre(p.getNombre());
            t.setApellido(p.getApellido());
            logger.info(t.getNombre()+" updated ");
        }
        else {
            logger.warn("not found jugador con id "+p.getId());
        }
        return t;
    }


    @Override
    public void clear() {
        jugadores.clear();

    }

}
*/