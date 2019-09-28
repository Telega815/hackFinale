package ru.icerebro.hackFinale.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.icerebro.hackFinale.dao.interfaces.GroupDAO;
import ru.icerebro.hackFinale.dao.interfaces.UserDAO;
import ru.icerebro.hackFinale.dao.interfaces.UserLikesDAO;
import ru.icerebro.hackFinale.dao.interfaces.UserWatchedDAO;
import ru.icerebro.hackFinale.entities.*;
import ru.icerebro.hackFinale.services.interfaces.UserService;

import java.util.List;


public class UserDetailsServiceImpl implements UserDetailsService, UserService {
    private final PasswordEncoder passwordEncoder;

    private final UserDAO userDAO;

    private final GroupDAO groupDAO;

    private final UserWatchedDAO userWatchedDAO;

    private final UserLikesDAO userLikesDAO;

    @Autowired
    public UserDetailsServiceImpl(PasswordEncoder passwordEncoder, UserDAO userDAO, GroupDAO groupDAO, UserWatchedDAO userWatchedDAO, UserLikesDAO userLikesDAO) {
        this.passwordEncoder = passwordEncoder;
        this.userDAO = userDAO;
        this.groupDAO = groupDAO;
        this.userWatchedDAO = userWatchedDAO;
        this.userLikesDAO = userLikesDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        try {
            user = userDAO.getUser(username);
        } catch (Exception e) {


            System.out.println(e.getMessage());
            throw new UsernameNotFoundException(username+" not found\n"+ e.getMessage());
        }

        return new org.springframework.security.core.userdetails
                .User(username, user.getPwd(), true, true, true, true, user.getGroup().getAuthorities());
    }

    public void createUser(User user) {
        User existingUser = userDAO.getUser(user.getUsername().toLowerCase());
        if (existingUser != null)
            return;

        user.setUsername(user.getUsername().toLowerCase());
        user.setPwd(passwordEncoder.encode(user.getPwd()));
        Group group = groupDAO.getGroup("USERS");
        if (group == null){
            throw new NullPointerException("Couldn't find group USERS");
        }else {
            user.setGroup(group);
            userDAO.saveUser(user);
        }


//        for (int i = 1; i < 5; i++) {
//            UserLikes userLikes = new UserLikes();
//            userLikes.setUser(user);
//            userLikes.setVotecategory(i);
//            userLikes.setLike(false);
//            userLikesDAO.saveUserLikes(userLikes);
//        }

    }

    @Override
    public void createAdmin(User user) {
        User existingUser = userDAO.getUser(user.getUsername().toLowerCase());
        if (existingUser != null)
            return;

        user.setUsername(user.getUsername().toLowerCase());
        user.setPwd(passwordEncoder.encode(user.getPwd()));
        Group group = groupDAO.getGroup("ADMINS");
        if (group == null){
            throw new NullPointerException("Couldn't find group USERS");
        }else {
            user.setGroup(group);
            userDAO.saveUser(user);
        }
    }

    @Override
    public User getUser(String username) {
        try {
            return userDAO.getUser(username);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User getUser(Integer pageOwnerId) {

        return userDAO.getUser(pageOwnerId);
    }

    @Override
    public Userwatched isWatched(User user, Vote vote) {
        Userwatched userwatched = userWatchedDAO.getUserWatched(user, vote);
        return userwatched;
    }

    @Override
    public UserLikes toggleHeart(User loggedInUser, Integer heart) {
//        UserLikes userLikes = userLikesDAO.getUserLikes(loggedInUser, heart);
//        if (userLikes == null){
//
//            userLikes = new UserLikes();
//            userLikes.setUser(loggedInUser);
//            userLikes.setVotecategory(heart);
//            userLikes.setLike(true);
//            userLikesDAO.saveUserLikes(userLikes);
//
//            return userLikes;
//        }else {
//
//            boolean like = !userLikes.getLike();
//
//            userLikesDAO.deleteUserLikes(userLikes);
//
//            userLikes = new UserLikes();
//            userLikes.setUser(loggedInUser);
//            userLikes.setVotecategory(heart);
//            userLikes.setLike(like);
//
//            userLikesDAO.saveUserLikes(userLikes);
//
//            return userLikes;
//        }
        return null;
    }

    @Override
    public List<UserLikes> getUserLikes(String name) {
        User user = userDAO.getUser(name);
        if (user == null)
            return null;

        return userLikesDAO.getUserLikes(user);
    }
}
