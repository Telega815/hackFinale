package ru.icerebro.hackFinale.dao.interfaces;

import ru.icerebro.hackFinale.entities.User;

public interface UserDAO {
    User getUser(String username);
    int saveUser(User user);
    void deleteUser(User user);
    void updateUser(User user);

    User getUser(Integer pageOwnerId);
}
