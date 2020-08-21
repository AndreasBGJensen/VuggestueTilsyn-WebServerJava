
import Configuration.Config;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        try {
            Config configuration = Config.getInstance();
            configuration.setTestMode(true);


            Tomcat tomcat = new Tomcat();
            tomcat.setBaseDir("temp");
            String port = System.getenv("PORT"); //Til Heroku
                if (port==null){
                port="8080";
            }

            tomcat.setPort(Integer.parseInt(port));
            tomcat.getConnector();

            tomcat.addWebapp("/", new File("src/main/webapp").getAbsolutePath());


            tomcat.start();
            tomcat.getServer().await();

        } catch (LifecycleException e) {
            e.printStackTrace();
        }


    }
}
