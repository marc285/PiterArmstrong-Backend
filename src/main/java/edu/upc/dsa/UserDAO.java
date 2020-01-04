package edu.upc.dsa;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.User;
//import edu.upc.eetac.dsa.model.User;

import java.util.List;

public interface UserDAO {

    public Boolean addUser(String nick, String password);  // ok //vendría siendo el registrarse
    User loginUser(User user) throws UserNotFoundException;
    public User getUser(String nickname) throws UserNotFoundException;   //ok
    public void updateUser(User user) throws UserNotFoundException; //ok //actualiza al usuario, por ejemplo le quita vida, le da mas dinero...
    public void deleteUser(String nick, String password) throws UserNotFoundException;  //ok
    List<Objeto> getObjectos(String nick) throws UserNotFoundException;
    public void AddObjectToUser(String nick, String nomobjeto);
    public List<User> getUsers();  //ok
    //public List <User> getEmployeeByDept(int deptId);
}
