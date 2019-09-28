package ru.icerebro.hackFinale.services.interfaces;

import ru.icerebro.hackFinale.entities.User;
import ru.icerebro.hackFinale.entities.Userwatched;
import ru.icerebro.hackFinale.entities.Vote;

public interface UserService {
    void createUser(User user);
    void createAdmin(User user);
    User getUser(String username);

    User getUser(Integer pageOwnerId);

    Userwatched isWatched(User user, Vote vote);
}
