package ru.icerebro.hackFinale.dao.interfaces;


import ru.icerebro.hackFinale.entities.Group;

public interface GroupDAO {
    Group getGroup(String name);
    int saveGroup(Group group);
    void deleteGroup(Group group);
    void updateGroup(Group group);
}
