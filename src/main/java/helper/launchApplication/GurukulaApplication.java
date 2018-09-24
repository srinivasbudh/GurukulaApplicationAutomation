package helper.launchApplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static java.lang.Runtime.getRuntime;

/**
 * Created by Srinivas Budha on 9/24/2018.
 */
public class GurukulaApplication {

    public static void launch() throws IOException,InterruptedException{
        launchGurukula();
    }

    private static void launchGurukula() throws IOException,InterruptedException {
        getRuntime().exec("cmd /c start java -jar gurukula-0.0.1-SNAPSHOT.war");
        System.out.println("Execution will wait for one minute allowing application to launch..");
        TimeUnit.MINUTES.sleep(1);
    }
}
