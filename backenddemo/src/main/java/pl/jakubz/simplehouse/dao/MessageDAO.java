package pl.jakubz.simplehouse.dao;

import pl.jakubz.simplehouse.entity.Message;

import java.util.List;

public interface MessageDAO {
    void deleteById(int id);

    void save(Message message);

    List<Message> findByRead(boolean read);

    Message getMessage(int id);

    List<Message> findAll();
}
