package ru.icerebro.hackFinale.services.interfaces;

import ru.icerebro.hackFinale.entities.*;

import java.util.List;

public interface UserService {
    void createUser(User user);
    void createAdmin(User user);
    User getUser(String username);

    User getUser(Integer pageOwnerId);

    Userwatched isWatched(User user, Question question);

    UserLikes toggleHeart(User loggedInUser, Integer heart);

    List<UserLikes> getUserLikes(String name);
}
