package ru.icerebro.hackFinale.dao.interfaces;

import ru.icerebro.hackFinale.entities.Vote;

import java.util.List;

public interface VoteDAO {
    List<Vote> getVotes(Integer votecategory);
    int saveVote(Vote vote);
    void deleteVote(Vote vote);
    void updateVote(Vote vote);
}
