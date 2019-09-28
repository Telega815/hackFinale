package ru.icerebro.hackFinale.entities;

public class Vote {

    private int id;

    private String votename;
    private Integer votecategory;
    private Boolean closed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVotename() {
        return votename;
    }

    public void setVotename(String votename) {
        this.votename = votename;
    }

    public Integer getVotecategory() {
        return votecategory;
    }

    public void setVotecategory(Integer votecategory) {
        this.votecategory = votecategory;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vote vote = (Vote) o;

        if (id != vote.id) return false;
        if (votename != null ? !votename.equals(vote.votename) : vote.votename != null) return false;
        if (votecategory != null ? !votecategory.equals(vote.votecategory) : vote.votecategory != null) return false;
        if (closed != null ? !closed.equals(vote.closed) : vote.closed != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (votename != null ? votename.hashCode() : 0);
        result = 31 * result + (votecategory != null ? votecategory.hashCode() : 0);
        result = 31 * result + (closed != null ? closed.hashCode() : 0);
        return result;
    }
}
