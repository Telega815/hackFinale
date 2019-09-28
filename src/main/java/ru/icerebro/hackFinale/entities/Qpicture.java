package ru.icerebro.hackFinale.entities;

public class Qpicture {
    private int id;
    private String link;
    private Question question;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Qpicture qpicture = (Qpicture) o;

        if (id != qpicture.id) return false;
        if (link != null ? !link.equals(qpicture.link) : qpicture.link != null) return false;
        if (question != null ? !question.equals(qpicture.question) : qpicture.question != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (question != null ? question.hashCode() : 0);
        return result;
    }
}
