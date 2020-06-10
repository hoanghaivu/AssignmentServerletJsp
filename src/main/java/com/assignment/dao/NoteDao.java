package com.assignment.dao;

import com.assignment.entity.Note;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NoteDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    private EntityManager em = emf.createEntityManager();

    public void saveNote(Note note) {
        em.getTransaction().begin();
        em.persist(note);
        em.getTransaction().commit();
        close();
    }

    public void close() {
        em.close();
        emf.close();
    }
}
