package edu.upc.dsa;

import edu.upc.dsa.models.User;
import edu.upc.dsa.util.QueryHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InsertTest {
    @Test
    public void testQueryINSERT() {
        Assert.assertEquals("INSERT INTO User (ID, nickname, password, vida, defensa, ataque, dinero) VALUES (?, ?, ?, ?, ?, ?, ?)",
                QueryHelper.createQueryINSERT(new User("Julen", "1234", 100, 100, 100, 100 )));
    }

    /**
    private UserDAO usr;
    @Before
    public void SetUp(){
        this.usr = UserDAOImpl.getInstance();
        }

    @Test
    public void insertUserTest(){
        //User user = new User("Roger","1234");
        this.usr.addUser("Julen", "1234");
        //this.btr.addEmployee("Laia","Munoz",9000);
        //this.btr.clear();
    }
    */
}
