
import com.mycompany.dashboard.ADMIN;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class DashTest {
    
    public DashTest() {
    }
    @Test
    public void dash(){
        ADMIN ADMIN = new ADMIN();
        int count = ADMIN.getAdminNUM();
        assertEquals(2, count);
    }
}
