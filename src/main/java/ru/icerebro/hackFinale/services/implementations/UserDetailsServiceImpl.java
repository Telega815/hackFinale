package ru.icerebro.hackFinale.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
//import ru.icerebro.swapy.dao.interfaces.GroupDAO;
//import ru.icerebro.swapy.dao.interfaces.UserDAO;
//import ru.icerebro.swapy.entities.Group;
//import ru.icerebro.swapy.entities.User;
//import ru.icerebro.swapy.services.interfaces.UserService;


//public class UserDetailsServiceImpl implements UserDetailsService, UserService {
public class UserDetailsServiceImpl implements UserDetailsService{
//    private final PasswordEncoder passwordEncoder;

//    private final UserDAO userDAO;
//
//    private final GroupDAO groupDAO;

    @Autowired
//    public UserDetailsServiceImpl(PasswordEncoder passwordEncoder, UserDAO userDAO, GroupDAO groupDAO) {
        public UserDetailsServiceImpl() {
//        this.passwordEncoder = passwordEncoder;
//        this.userDAO = userDAO;
//        this.groupDAO = groupDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user;
//        try {
//            user = userDAO.getUser(username);
//        } catch (Exception e) {
//
//
//            System.out.println(e.getMessage());
//            throw new UsernameNotFoundException(username+" not found\n"+ e.getMessage());
//        }
//
//        return new org.springframework.security.core.userdetails
//                .User(username, user.getPwd(), true, true, true, true, user.getGroup().getAuthorities());

        return null;
    }

//    public void createUser(User user) {
//        User existingUser = userDAO.getUser(user.getUsername().toLowerCase());
//        if (existingUser != null)
//            return;
//
//        user.setUsername(user.getUsername().toLowerCase());
//        user.setPwd(passwordEncoder.encode(user.getPwd()));
//        Group group = groupDAO.getGroup("USERS");
//        if (group == null){
//            throw new NullPointerException("Couldn't find group USERS");
//        }else {
//            user.setGroup(group);
//            userDAO.saveUser(user);
//        }
//    }
//
//    @Override
//    public void createAdmin(User user) {
//        User existingUser = userDAO.getUser(user.getUsername().toLowerCase());
//        if (existingUser != null)
//            return;
//
//        user.setUsername(user.getUsername().toLowerCase());
//        user.setPwd(passwordEncoder.encode(user.getPwd()));
//        Group group = groupDAO.getGroup("ADMINS");
//        if (group == null){
//            throw new NullPointerException("Couldn't find group USERS");
//        }else {
//            user.setGroup(group);
//            userDAO.saveUser(user);
//        }
//    }

//    @Override
//    public User getUser(String username) {
//        try {
//            return userDAO.getUser(username);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public User getUser(Integer pageOwnerId) {
//
//        return userDAO.getUser(pageOwnerId);
//    }
}
