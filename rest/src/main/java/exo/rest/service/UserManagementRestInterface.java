/*
 * Copyright (C) 2003-2011 eXo Platform SAS.
 * 
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 * 
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 *
 */
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
    ){
        StringBuilder sb = new StringBuilder();

        try {

            UserManagementService userMgmtService = new UserManagementService();
            for (int i=1 ;i<= nbUsers ;i++){
                char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
                StringBuilder sb1 = new StringBuilder();
                Random random = new Random();
                for (int j = 0; j< 20; j++) {
                    char c = chars[random.nextInt(chars.length)];
                    sb1.append(c);
                }


                if (nbUsers<= maxUsers) {
                    userMgmtService.createUser(userPrefix + sb1, sb1+"@exomail.hr", sb1+"firstName", sb1+"lastName", sb1+"password");
                    sb.append("User ").append("userName").append(" created.");
                    i += 1;
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(UserManagementRestInterface.class.getName()).log(Level.SEVERE, null, ex);
            sb.append(ex.getMessage());
        }
        return sb.toString();


    }



}
