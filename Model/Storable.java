package Model;

import java.util.List;

public interface Storable {
    List<Note> getAllNotes();
    String createNote(Note note);
    void updateNote(String id, Note note);
    void deleteNote(String id);
    Note readNote(String id);
}