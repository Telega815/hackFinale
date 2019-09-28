package ru.icerebro.hackFinale.JSON;

import ru.icerebro.hackFinale.entities.Answer;

import java.util.ArrayList;
import java.util.List;

public class JsonVoteResList {
    private List<JsonVoteRes> resList;
    private int id;
    private int votecount;

    public JsonVoteResList(Integer qId, List<Answer> answers) {
        this.id = qId;
        resList = new ArrayList<>();

        int count = 0;

        for (Answer a:answers) {
            count+= a.getVotecount();
        }

        for (Answer a:answers) {
            resList.add(new JsonVoteRes(a.getId(), a.getDescription(), (int)((float)a.getVotecount()/(float) count * 100)));
        }

        this.votecount = count;
    }

    public List<JsonVoteRes> getResList() {
        return resList;
    }

    public void setResList(List<JsonVoteRes> resList) {
        this.resList = resList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVotecount() {
        return votecount;
    }

    public void setVotecount(int votecount) {
        this.votecount = votecount;
    }
}