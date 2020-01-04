package edu.upc.dsa;

//import edu.upc.eetac.dsa.model.Employee;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.User;
import edu.upc.dsa.models.UserObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class UserDAOImpl implements UserDAO {
    final static Logger log = Logger.getLogger(UserDAOImpl.class.getName());

    private static UserDAO instance;

    private HashMap<String, User> users;
    private List<Objeto> objectos;

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }

    private UserDAOImpl() {
        users = new HashMap<>();
        objectos = new ArrayList<>();
    }

    public Boolean addUser(String nick, String password) {

        Session session = null;
        Boolean bool = false;
        int userID;
        try {
            session = FactorySession.openSession();
            users.put(nick, new User(nick, password));  //metes en el hashmap nombre y contraseña
            User usernew = new User(nick, password, 100, 100, 100, 100, 0);  //registras al user y le pones todos los stats
            userID = (Integer) session.getIDverify(User.class, usernew.getUsername(), usernew.getPassword()); // aqui comprueba si el id ya esta o no

            if(userID == 0) {    //como hemos visto en el getidverify si no encuentra ninguno el
                session.save(usernew);
                bool = true;
            }
            else{
                bool = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return bool;

    }

    public User loginUser(User user) throws UserNotFoundException{  //se hace el login
        User u = null;
        Session session = null;
        int userID;
        try {
            session = FactorySession.openSession();
            userID = (Integer) session.getIDverify(User.class, user.getUsername(), user.getPassword());
            if(userID == 0){   // aqui pasa al reves que en addUser y es que si no encuentra un id con el nickname  y el password
                throw new UserNotFoundException();       // del usuario, el id será 0 y nos saltará una excepcion
            }

            u = (User) session.login(User.class, userID);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return u;
    }




    public User getUser(String nickname) throws UserNotFoundException {
        Session session = null;
        User user = null;
        int userID;
        try {
            session = FactorySession.openSession();
            userID = (Integer) session.getID(User.class, nickname);
            user = (User) session.get(User.class, userID);
        }
        catch (Exception e) {
            throw new UserNotFoundException(); // LOG
        }
        finally {
            session.close();
        }
        return user;
    }



    public void updateUser(User user) throws UserNotFoundException {
        User u = null;
        Session session = null;
        int userID;
        try {
            session = FactorySession.openSession();
            userID = (Integer) session.getID(User.class, user.getUsername());
            session.update(user, userID);
            //c = (Player)session.login(Player.class, userID);
        } catch (Exception e) {
            throw new UserNotFoundException();
        } finally {
            session.close();
        }
    }


    public void deleteUser(String nick, String password) throws UserNotFoundException{
        Session session = null;
        User user = new User();

        int userID;
        try {
            session = FactorySession.openSession();
            userID = (Integer) session.getIDverify(User.class, nick, password);  //verificamos con contraseña sino no se puede
            session.delete(user, userID);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }


    public List<Objeto> getObjectos(String nickname) throws UserNotFoundException {  //melos objetos de un ususario
        List<Objeto> objetos = new ArrayList<>();
        Session session = null;
        int userID;
        try {
            session = FactorySession.openSession();
            userID = (Integer) session.getID(User.class, nickname);
            objectos = session.findAllObjects(Objeto.class, userID);   //ACABAR
        } catch (Exception e) {
            throw new UserNotFoundException(); // LOG

        } finally {
            session.close();
        }
        return objetos;
    }

    public void AddObjectToUser(String nick, String nomobjeto) {     //ACABAR ESTO HACER EN SEISSION IMPL
        //objects.add(new Objeto(username, name, image));
        Session session = null;
        User user = null;
        Objeto objeto = null;
        int userID;
        int objetoID;
        try {
            session = FactorySession.openSession();
            userID = (Integer) session.getID(User.class, nick);
            objetoID = (Integer) session.getID(Objeto.class, nomobjeto);
            UserObject objectuser = new UserObject(userID, objetoID);
            session.save(objeto);
        } catch (Exception e) {
            // LOG
        } finally {
            session.close();
        }
    }



    public List<User> getUsers() {   // me da una lista de usuarios
        Session session = null;
        List<User> userList=null;
        try {
            session = FactorySession.openSession();
            userList = session.findAll(User.class);
        }
        catch (Exception e) {
            e.printStackTrace();// LOG
        }
        finally {
            session.close();
        }
        return userList;
    }

/**
    public List<Employee> getEmployeeByDept(int deptID) {

        Session session = null;
        List<Employee> employeeList=null;
        try {
            session = FactorySession.openSession();

            HashMap<String, Integer> params = new HashMap<String, Integer>();
            params.put("deptID", deptID);

            employeeList = session.findAll(Employee.class, params);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        return employeeList;
    }
 */


}
