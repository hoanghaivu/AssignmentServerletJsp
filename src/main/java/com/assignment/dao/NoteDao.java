package com.assignment.dao;

import com.assignment.entity.Note;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class NoteDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    private EntityManager em = emf.createEntityManager();

    public List<Note> getNote() {
        em.getTransaction().begin();
        List<Note> list = em.createQuery("SELECT c FROM Note c", Note.class).getResultList();
        em.getTransaction().commit();
        close();
        return list;
    }

    public void saveNote(Note note) {
        em.getTransaction().begin();
        em.persist(note);
        em.getTransaction().commit();
        close();
    }

    public void updateNote(Note note, int id) {
        em.getTransaction().begin();
        Note n = em.find(Note.class, id);
        n.setTitle(note.getTitle());
        n.setContent(note.getContent());
        n.setCreatedAt(note.getCreatedAt());
        em.getTransaction().commit();
        close();
    }

    public void deleteNote(int id) {
        em.getTransaction().begin();
        Note n = em.find(Note.class, id);
        if (n != null) {
            em.remove(n);
            em.getTransaction().commit();
        }
        close();
    }

    public void close() {
        em.close();
        emf.close();
    }
}
