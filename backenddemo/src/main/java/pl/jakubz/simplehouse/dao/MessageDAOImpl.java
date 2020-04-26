package pl.jakubz.simplehouse.dao;

import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.jakubz.simplehouse.entity.Message;

@Repository
public class MessageDAOImpl implements MessageDAO {
    @Autowired
    EntityManager entityManager;
    Logger logger = Logger.getLogger(this.getClass().getName());

    public MessageDAOImpl() {
    }

    public void deleteById(int id) {
        Session session = (Session)this.entityManager.unwrap(Session.class);
        Message message = (Message)session.get(Message.class, id);
        session.delete(message);
    }

    public void save(Message message) {
        Session session = (Session)this.entityManager.unwrap(Session.class);
        session.saveOrUpdate(message);
    }

    public List<Message> findByRead(boolean read) {
        Session session = (Session)this.entityManager.unwrap(Session.class);
        Query<Message> query = session.createQuery("from Message where isRead=:read");
        query.setParameter("read", read);
        List<Message> messages = query.getResultList();
        return messages;
    }

    public Message getMessage(int id) {
        Session session = (Session)this.entityManager.unwrap(Session.class);
        Message message = (Message)session.get(Message.class, id);
        return message;
    }

    public List<Message> findAll() {
        Session session = (Session)this.entityManager.unwrap(Session.class);
        Query<Message> query = session.createQuery("from Message");
        List<Message> messages = query.getResultList();
        return messages;
    }
}
