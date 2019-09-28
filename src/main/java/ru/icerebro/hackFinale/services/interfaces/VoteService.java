package ru.icerebro.hackFinale.services.interfaces;

import ru.icerebro.hackFinale.entities.User;
import ru.icerebro.hackFinale.entities.Vote;

import java.util.List;

public interface VoteService {
    List<Vote> getVotes(int votecategory);
}
