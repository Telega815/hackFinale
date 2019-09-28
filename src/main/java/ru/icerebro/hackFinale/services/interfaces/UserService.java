package ru.icerebro.hackFinale.services.interfaces;

import ru.icerebro.hackFinale.entities.User;

public interface UserService {
    void createUser(User user);
    void createAdmin(User user);
    User getUser(String username);

    User getUser(Integer pageOwnerId);
}
