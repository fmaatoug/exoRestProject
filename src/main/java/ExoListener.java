import org.exoplatform.services.organization.OrganizationConfig;
import org.exoplatform.services.organization.User;
import org.exoplatform.services.organization.UserEventListener;

import java.util.logging.Logger;

/**
 * Created by exo on 22/09/16.
 */
public class ExoListener extends UserEventListener {
    private static final Logger logger = Logger.getLogger(ExoListener.class.getName());


    public void postSave(OrganizationConfig.User user, boolean isNew) throws Exception {
        //do something - customer code is here

        logger.info("Fares After user is added into database");

    }

    public void preSave(User user, boolean isNew) throws Exception {

        System.out.println("Before " + (isNew?"creating":"updating") + " user " + user.getUserName());

    }

    public void postSave(User user, boolean isNew) throws Exception {

        Logger logger = Logger.getLogger(StartService.class.getName());

        //logger.info("After user " + user.getUserName() + (isNew?" created":" updated"));
        logger.info("Fares Before user is added into database");
        logger.info("Fares After user is added into database");
        logger.info("Fares After user " + user.getUserName() + (isNew?" created":" updated"));

    }

    public void preDelete(User user) throws Exception {
        Logger logger = Logger.getLogger(StartService.class.getName());
        logger.info("Before deleting user " + user.getUserName());

    }


    public void postDelete(User user) throws Exception {

        Logger logger = Logger.getLogger(StartService.class.getName());
        logger.info("After deleting user " + user.getUserName());

    }



    public void preSetEnabled(User user) throws Exception {
        Logger logger = Logger.getLogger(StartService.class.getName());
        logger.info("Before enabling/disabling user " + user.getUserName());

    }


    public void postSetEnabled(User user) throws Exception {

        Logger logger = Logger.getLogger(StartService.class.getName());
        logger.info("After enabling/disabling user " + user.getUserName());

    }


}
