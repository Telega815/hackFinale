package ru.icerebro.hackFinale.dao.interfaces;

import ru.icerebro.hackFinale.entities.Qpicture;
import ru.icerebro.hackFinale.entities.Question;

import java.util.List;

public interface QpictureDAO {
    List<Qpicture> getQpictures(Question question);
    int saveQpicture(Qpicture qpicture);
    void deleteQpicture(Qpicture qpicture);
    void updateQpicture(Qpicture qpicture);
}
