package Controller;

import Model.Note;
import Model.Repository;

import java.util.List;

public class NoteController {
    private final Repository repository;

    public NoteController(Repository repository) {
        this.repository = repository;
    }

    public void saveNote(Note note) {
        repository.createNote(note);
    }

    public Note readNote(String id) {
        return repository.readNote(id);
    }

    public List<Note> readList() {
        List<Note> result = repository.getAllNotes();
        return result;
    }

    public void updateNote(String id, Note note) {
        note.setId(id);
        repository.updateNote(id, note);
    }

    public void deleteNote(String id)  {
        List<Note> notes = repository.getAllNotes();
        repository.deleteNote(id);
    }
}