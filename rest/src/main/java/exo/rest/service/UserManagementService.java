package exo.rest.service;

import org.exoplatform.container.ExoContainer;
import org.exoplatform.container.ExoContainerContext;
import org.exoplatform.services.organization.*;


public class UserManagementService {

    OrganizationService organizationService = null;
    GroupHandler groupHandler;
    MembershipHandler membershipHandler;
    UserHandler userHandler;
    MembershipTypeHandler membershipTypeHandler;
    UserProfileHandler userProfileHandler;

    /**
     * Initialize the class and setup all utilities
     */
    public UserManagementService() {
        ExoContainer container = ExoContainerContext.getCurrentContainer();
        organizationService = (OrganizationService) container.getComponentInstanceOfType(OrganizationService.class);

        groupHandler = organizationService.getGroupHandler();
        userHandler = organizationService.getUserHandler();
        membershipHandler = organizationService.getMembershipHandler();
        membershipTypeHandler = organizationService.getMembershipTypeHandler();
        userProfileHandler = organizationService.getUserProfileHandler();

    }

    /**
     * Create and save user
     * @param userName
     * @param email
     * @param firstName
     * @param lastName
     * @param password
     * @throws Exception 
     */
    public void createUser(String userName, String email, String firstName, String lastName, String password) throws Exception {
        User user = findUserByUserName(userName);
        if (user == null) {
            user = userHandler.createUserInstance(userName);
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(password);
            userHandler.createUser(user, true);
        } else {
            throw new Exception("User " + userName + " already exist");
        }
    }

    public void createGroup(String parentId, String name, String label, String desc) throws Exception {
        Group parent = parentId == null ? null : groupHandler.findGroupById(parentId);
        Group child = groupHandler.createGroupInstance();
        child.setGroupName(name);
        child.setLabel(label);
        child.setDescription(desc);
        groupHandler.addChild(parent, child, true);

    }

    public void createMembership(String userName, String groupName, String membershipType) throws Exception {
        membershipHandler.linkMembership(userHandler.findUserByName(userName), groupHandler.findGroupById("/" + groupName), membershipTypeHandler.findMembershipType(membershipType), true);
    }

    /**
     * 
     * @param type
     * @param desc
     * @throws Exception 
     */
    public void createMembershipType(String type, String desc) throws Exception {
        MembershipType membershipType = membershipTypeHandler.createMembershipTypeInstance();
        membershipType.setName(type);
        membershipType.setDescription(desc);
        membershipTypeHandler.createMembershipType(membershipType, true);
    }

    /**
     * 
     * @param username
     * @return User if exists, null if not 
     */
    public User findUserByUserName(String username) {

        User user = null;
        try {
            user = userHandler.findUserByName(username);
        } catch (Exception ex) {
        }
        return user;

    }
}
