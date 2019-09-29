package ru.icerebro.hackFinale.JSON;

import ru.icerebro.hackFinale.entities.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonVoteResList {
    private List<JsonVoteRes> resList;
    private int id;
    private int votecount;

    public JsonVoteResList(Integer qId, Map<Integer, Answer> answers) {
        this.id = qId;
        resList = new ArrayList<>();

        int count = 0;

        for (Map.Entry<Integer, Answer> entry : answers.entrySet()) {
            count+= entry.getValue().getVotecount();
        }

        for (Map.Entry<Integer, Answer> entry : answers.entrySet()) {
            resList.add(new JsonVoteRes(entry.getKey(), entry.getValue().getDescription(), (int)((float)entry.getValue().getVotecount()/(float) count * 100)));
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