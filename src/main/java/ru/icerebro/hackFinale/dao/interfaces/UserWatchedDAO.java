package ru.icerebro.hackFinale.dao.interfaces;

import ru.icerebro.hackFinale.entities.User;
import ru.icerebro.hackFinale.entities.Userwatched;
import ru.icerebro.hackFinale.entities.Vote;

import java.util.List;

public interface UserWatchedDAO {
    List<Userwatched> getUserWatched(User user);
    int saveUserWatched(Userwatched userwatched);
    void deleteUserWatched(Userwatched userwatched);
    void updateUserWatched(Userwatched userwatched);

    Userwatched getUserWatched(User user, Vote vote);
}
