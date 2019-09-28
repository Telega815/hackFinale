package ru.icerebro.hackFinale.JSON;

public class JsonVoteRes {
    private int id;
    private String description;
    private int percent;

    public JsonVoteRes(int id, String description, int percent) {
        this.id = id;
        this.description = description;
        this.percent = percent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
