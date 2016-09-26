package jobSchedulerexo;



import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by exo on 22/09/16.
 */
public class MyJobScheduler implements Job {
    private static final Logger logger = Logger.getLogger(MyJobScheduler.class.getName());


    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info(("Fares this is the " + new Date()));

    }
}
