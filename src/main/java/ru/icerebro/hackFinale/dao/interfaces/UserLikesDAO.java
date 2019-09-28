package ru.icerebro.hackFinale.dao.interfaces;

import ru.icerebro.hackFinale.entities.User;
import ru.icerebro.hackFinale.entities.UserLikes;

import java.util.List;

public interface UserLikesDAO {
    List<UserLikes> getUserLikes(User user);
    int saveUserLikes(UserLikes UserLikes);
    void deleteUserLikes(UserLikes userLikes);
    void updateUserLikes(UserLikes userLikes);
}
