
package pl.jakubz.simplehouse.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jakubz.simplehouse.dao.MessageDAO;
import pl.jakubz.simplehouse.entity.Message;
import pl.jakubz.simplehouse.exception.MessageNotFoundException;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageDAO messageDAO;

    public MessageServiceImpl() {
    }

    @Transactional
    public List<Message> findAll() {
        return this.messageDAO.findAll();
    }

    @Transactional
    public Message getMessage(int id) {
        Message result = this.messageDAO.getMessage(id);
        if (result != null) {
            return result;
        } else {
            throw new MessageNotFoundException("Message with this id was not found: " + id);
        }
    }

    public List<Message> findByRead(boolean read) {
        return this.messageDAO.findByRead(read);
    }

    @Transactional
    public void saveMessage(Message message) {
        this.messageDAO.save(message);
    }

    @Transactional
    public void deleteMessage(int id) {
        Message result = this.messageDAO.getMessage(id);
        if (result == null) {
            throw new MessageNotFoundException("Message with this id was not found: " + id);
        } else {
            this.messageDAO.deleteById(id);
        }
    }
}
