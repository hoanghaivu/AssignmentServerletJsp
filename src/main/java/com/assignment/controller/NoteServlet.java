package com.assignment.controller;

import com.assignment.dao.NoteDao;
import com.assignment.entity.Note;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NoteServlet", urlPatterns = "/note")
public class NoteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NoteDao noteDao = new NoteDao();
        List<Note> listNote = noteDao.getNote();
        request.setAttribute("notes", listNote);
//        createNote();
//        updateNote();
//        deleteNote();
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    protected void createNote() {
        Note note = new Note();
        note.setTitle("Tick note2");
        note.setContent("hihihihihi");
        note.setCreatedAt("2020-05-10");
        NoteDao noteDao = new NoteDao();
        noteDao.saveNote(note);
    }

    protected void updateNote() {
        Note note = new Note();
        note.setTitle("Tick");
        note.setContent("ggdfdfd");
        note.setCreatedAt("2020-05-16");
        NoteDao noteDao = new NoteDao();
        noteDao.updateNote(note, 1);
    }

    protected void deleteNote() {
        NoteDao noteDao = new NoteDao();
        noteDao.deleteNote(2);
    }
}
