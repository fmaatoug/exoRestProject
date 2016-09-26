import jobSchedulerexo.MyJobScheduler;
import org.picocontainer.Startable;

import java.util.logging.Logger;

/**
 * Created by exo on 22/09/16.
 */
public class StartService implements Startable {
    private static final Logger logger = Logger.getLogger(StartService.class.getName());
    public void start() {
        logger.info("Fares the service starts");
    }

    public void stop() {
        logger.info("Fares the service stops");

    }

    MyJobScheduler ajob ;

    public void setAjob(MyJobScheduler ajob) {
        this.ajob = ajob;
        logger.info("this is the job");
    }
}
