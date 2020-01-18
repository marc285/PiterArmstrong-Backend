package edu.upc.dsa;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.User;
//import edu.upc.eetac.dsa.model.User;

import java.util.List;

public interface UserDAO {
    public int addUser(String nick, String password);  // ok //vendría siendo el registrarse
    public User login(User user);
    public User getUser(String nick);   //ok
    public List<User> getUsers();  //ok
    public int updateUser(String usrname, User usr); //ok //actualiza al usuario, por ejemplo le quita vida, le da mas dinero... TAMBIÉN CAMBIAR CONTRASEÑA
    public int deleteUser(String nick, String password);  //ok
    public List<Objeto> getObjectos(String nick);
    public void AddObjectToUser(String nick, String nomobjeto);
    String getScreen(String username);
    //public List <User> getEmployeeByDept(int deptId);
}
