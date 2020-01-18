package edu.upc.dsa;

//import edu.upc.eetac.dsa.model.Employee;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.User;
import edu.upc.dsa.models.UserObject;
import jdk.internal.jline.internal.Log;

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


    public int addUser(String nick, String password) {

        Session session = null;
        //Boolean bool = false;
        int userID;
        try {
            session = FactorySession.openSession();
            users.put(nick, new User(nick, password));  //metes en el hashmap nombre y contraseña
            User usernew = new User(nick, password, 100, 100, 100, 100, 0);  //registras al user y le pones todos los stats
            userID = (Integer) session.getIDverify(User.class, usernew.getUsername(), usernew.getPassword()); // aqui comprueba si el id ya esta o no

            if(userID == 0) {    //como hemos visto en el getidverify si no encuentra ninguno el
                session.save(usernew);
                //bool = true;
                return 201;
            }
            else{
                //bool = false;
                return 409;
            }
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            Log.error("Bad Request: Error in input parameters' format");
            return 400;
        }catch (Exception e) {
            e.printStackTrace();
            Log.error("Internal Server Error");
            return 500;
        }
        finally {
            //session.close();
        }
    }


    public User login(User user){  //se hace el login
        User u = null;
        Session session = null;
        int userID;
        try {
            session = FactorySession.openSession();
            userID = (Integer) session.getIDverify(User.class, user.getUsername(), user.getPassword());
            if(userID == 0){   // aqui pasa al reves que en addUser y es que si no encuentra un id con el nickname  y el password
                Log.error("User not found"); // del usuario, el id será 0 y nos saltará una excepcion
                u = new User("404", "null"); //404 User Not found
            }
            u = (User) session.login(User.class, userID);
        }
        catch (Exception e) {
            e.printStackTrace();
            Log.error("Internal Server Error");
            u = new User("500", "null");
        }
        finally {
            //session.close();
            return u;
        }
    }


    public User getUser(String nickname){
        Session session = null;
        User user = null;
        int userID;
        try {
            session = FactorySession.openSession();
            userID = (Integer) session.getID(User.class, nickname);
            user = (User) session.get(User.class, userID);
        }
        catch (Exception e) {
            e.printStackTrace();
            Log.error("User not found");
            user = new User("404", "null");
        }
        finally {
            //session.close();
            return user;
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
            e.printStackTrace();
            Log.error("Error getting the list of users");
            userList.add(new User("500", "null"));
        }
        finally {
            //session.close();
            return userList;
        }
    }


    public int updateUser(String usrname, User usr){
        User u = null;
        Session session = null;
        int userID;
        try {
            session = FactorySession.openSession();
            userID = (Integer) session.getID(User.class, usrname);
            session.update(usr, userID);
            return 201;
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            Log.error("Bad Request: Error in input parameter's format");
            return 400;
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("Internal Server Error");
            return 500;
        } finally {
            //session.close();
        }
    }


    public int deleteUser(String nick, String pwd){
        Session session = null;
        User user = new User();
        int userID;
        try {
            session = FactorySession.openSession();
            userID = (Integer) session.getIDverify(User.class, nick, pwd);  //En teoría ya hemos comprobado la contraseña en el front-end
            session.delete(user, userID);
            return 201;
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("Couldn't delete the User");
            return 500;
        } finally {
            //session.close();
        }

    }



    //----------------------------------------------OBJETOS Y LISTA DE OBJETOS: HAY QUE ACABARLO !!!!!!!!!!!!!!!!!!!!!!---------------------------//

    public List<Objeto> getObjectos(String nickname){  //melos objetos de un ususario
        List<Objeto> objetos = new ArrayList<>();
        Session session = null;
        int userID;
        try {
            session = FactorySession.openSession();
            userID = (Integer) session.getID(User.class, nickname);
            objectos = session.findAllObjects(Objeto.class, userID);   //ACABAR
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("x");

        } finally {
            //session.close();
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
            e.printStackTrace();
            Log.error("x");
        } finally {

        }
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
