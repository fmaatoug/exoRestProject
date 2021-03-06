
package exo.rest.service;

import org.exoplatform.services.organization.User;
import org.exoplatform.services.rest.resource.ResourceContainer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/extensions/users/")
public class UserManagementRestInterface implements ResourceContainer {


    @GET
    @Path("/addusers")
    public String addUsers(
            @QueryParam("prefix") String userPrefix,
            @QueryParam("numberOfUsers") int nbUsers,
            @QueryParam("batch") int maxUsers
    ) {
        StringBuilder sb = new StringBuilder();

        try {

            UserManagementService userMgmtService = new UserManagementService();
            StringBuilder sb1 = new StringBuilder();


            if (nbUsers <= maxUsers) {
                for (int i = 1; i <= nbUsers; i++) {
                    sb1 = RandomGenerate.generate();
                    userMgmtService.createUser(userPrefix + sb1, sb1 + "@exomail.hr", sb1 + "firstName", sb1 + "lastName", sb1 + "password");
                    sb.append("User ").append("userName").append(" created.");
                    i += 1;

                }
            } else {


                while (nbUsers > maxUsers) {
                    for (int i = 1; i <= maxUsers; i++) {
                        sb1 = RandomGenerate.generate();
                        userMgmtService.createUser(userPrefix + sb1, sb1 + "@exomail.hr", sb1 + "firstName", sb1 + "lastName", sb1 + "password");
                        sb.append("User ").append("userName").append(" created.");
                        i += 1;

                    }
                    nbUsers -= maxUsers;
                }


            }


        } catch (Exception ex) {
            Logger.getLogger(UserManagementRestInterface.class.getName()).log(Level.SEVERE, null, ex);
            sb.append(ex.getMessage());
        }


        return sb.toString();


    }


}
