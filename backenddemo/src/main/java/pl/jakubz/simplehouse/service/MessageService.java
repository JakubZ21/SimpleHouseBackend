package pl.jakubz.simplehouse.service;

import pl.jakubz.simplehouse.entity.Message;

import java.util.List;

public interface MessageService {

    List<Message> findAll();

    Message getMessage(int id);

    List<Message> findByRead(boolean read);

    void saveMessage(Message message);

    void deleteMessage(int id);
}
