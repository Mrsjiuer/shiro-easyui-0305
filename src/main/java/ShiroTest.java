import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;


public class ShiroTest {
    public static void main(String[] args) {
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro.ini");
        //2.解析配置文件，并且返回一些SecurityManger实例
        SecurityManager securityManager = factory.getInstance();
        //3.将SecurityManager绑定给SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "00000");
        subject.login(token);
        System.out.println("admin角色：" + subject.hasRole("admin"));
        System.out.println("test角色：" + subject.hasRole("test"));
        System.out.println("role.html:" + subject.isPermitted("role.html"));
        System.out.println("user.html:" + subject.isPermitted("user.html"));
        subject.logout();

    }
}
