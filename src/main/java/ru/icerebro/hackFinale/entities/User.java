package ru.icerebro.hackFinale.entities;

public class User {
    private int id;
    private String username;
    private String pwd;
    private Group group;
    private String email;
    private String phoneNumber;
    private Boolean juristic;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (pwd != null ? !pwd.equals(user.pwd) : user.pwd != null) return false;
        if (group != null ? !group.equals(user.group) : user.group != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        if (juristic != null ? !juristic.equals(user.juristic) : user.juristic != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (juristic != null ? juristic.hashCode() : 0);
        return result;
    }

    public Boolean getJuristic() {
        return juristic;
    }

    public void setJuristic(Boolean juristic) {
        this.juristic = juristic;
    }
}
