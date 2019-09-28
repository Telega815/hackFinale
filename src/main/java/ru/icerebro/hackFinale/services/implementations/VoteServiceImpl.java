package ru.icerebro.hackFinale.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.icerebro.hackFinale.dao.interfaces.VoteDAO;
import ru.icerebro.hackFinale.entities.User;
import ru.icerebro.hackFinale.entities.Vote;
import ru.icerebro.hackFinale.services.interfaces.VoteService;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteDAO voteDAO;

    @Autowired
    public VoteServiceImpl(VoteDAO voteDAO) {
        this.voteDAO = voteDAO;
    }

    @Override
    public List<Vote> getVotes(int votecategory) {
        return voteDAO.getVotes(votecategory);
    }
}
