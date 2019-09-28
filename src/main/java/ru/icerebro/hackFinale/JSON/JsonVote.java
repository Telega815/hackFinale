package ru.icerebro.hackFinale.JSON;

import ru.icerebro.hackFinale.entities.User;
import ru.icerebro.hackFinale.entities.Userwatched;
import ru.icerebro.hackFinale.entities.Vote;

public class JsonVote {
    private int id;
    private int votecategory;
    private String voteName;
    private boolean closed;
    private boolean watched;

    public JsonVote(Userwatched userwatched, Vote vote) {
        this.id = vote.getId();
        this.votecategory = vote.getVotecategory();
        this.voteName = vote.getVotename();
        this.closed = vote.getClosed();
        this.watched = userwatched != null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVotecategory() {
        return votecategory;
    }

    public void setVotecategory(int votecategory) {
        this.votecategory = votecategory;
    }

    public String getVoteName() {
        return voteName;
    }

    public void setVoteName(String voteName) {
        this.voteName = voteName;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
