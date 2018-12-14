
package opinionmining;
import firstInterface.Login;
import firstInterface.Welcome;
public class OpinionMining {
    public static int login_id=0;
    public static String name=null;
    public static void main(String[] args) {
        Welcome wlcm=new Welcome();
        wlcm.setVisible(true);
        Login log=new Login();
        log.setVisible(false);
    }
}
