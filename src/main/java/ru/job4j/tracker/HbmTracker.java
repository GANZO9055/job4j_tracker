package ru.job4j.tracker;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sf.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
             result = session.createQuery("UPDATE Item SET name = :name WHERE id = :id")
                    .setParameter("name", item.getName())
                    .setParameter("id", id)
                    .executeUpdate() == 1;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return result;
    }

    @Override
    public void delete(int id) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createQuery("DELETE Item WHERE id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        Query<Item> query = session.createQuery("from Item", Item.class);
        return query.list();
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        Query<Item> query = session.createQuery("from Item WHERE name = :name", Item.class);
        query.setParameter("name", key);
        return query.list();
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        Query<Item> query = session.createQuery("from Item WHERE id = :id", Item.class);
        query.setParameter("id", id);
        return query.uniqueResult();
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
