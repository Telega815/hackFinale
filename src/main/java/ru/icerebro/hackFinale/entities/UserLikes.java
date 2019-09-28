package ru.icerebro.hackFinale.entities;

public class UserLikes {
    private int id;
    private User user;
    private Integer votecategory;
    private Boolean like;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userid) {
        this.user = userid;
    }

    public Integer getVotecategory() {
        return votecategory;
    }

    public void setVotecategory(Integer votecategory) {
        this.votecategory = votecategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserLikes userLikes = (UserLikes) o;

        if (id != userLikes.id) return false;
        if (user != null ? !user.equals(userLikes.user) : userLikes.user != null) return false;
        if (votecategory != null ? !votecategory.equals(userLikes.votecategory) : userLikes.votecategory != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (votecategory != null ? votecategory.hashCode() : 0);
        return result;
    }

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }
}
