package Model;

import java.util.ArrayList;
import java.util.List;

public class Repository implements Storable {
    private NoteMapper mapper = new NoteMapper();

    private FileManager fileManager;

    public Repository(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public String createNote(Note note) {
        List<Note> notes = getAllNotes();
        int max = 0;
        for (Note item : notes) {
            int id = Integer.parseInt(item.getId());
            if (max < id) {
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        note.setId(id);
        notes.add(note);
        writeDown(notes);
        return id;
    }

    @Override
    public List<Note> getAllNotes() {
        List<String> lines = fileManager.readAllLines();
        List<Note> notes = new ArrayList<>();
        for (String line : lines) {
            notes.add(mapper.map(line));
        }
        return notes;
    }


    @Override
    public void updateNote(String id, Note note) {
        List<Note> notes = getAllNotes();
        Note toEdit = notes.stream().filter(i -> i.getId().equals(id)).findFirst().get();
        toEdit.setTitle(note.getTitle());
        toEdit.setData(note.getData());
        writeDown(notes);

    }

    @Override
    public void deleteNote(String id) {
        List<Note> notes = getAllNotes();
        Note toDelete = notes.stream().filter(i -> i.getId().equals(id)).findFirst().get();
        notes.remove(toDelete);
        writeDown(notes);
    }

    @Override
    public Note readNote(String id) {
        List<Note> notes = getAllNotes();
        Note toRead = notes.stream().filter(i -> i.getId().equals(id)).findFirst().get();
        return toRead;
    }


    private void writeDown(List<Note> notes) {
        List<String> lines = new ArrayList<>();
        for (Note note : notes) {
//            String res = String.format("%s,%s,%s", note.getId(), note.getTitle(), note.getData());
            lines.add(mapper.map(note));
        }
        fileManager.saveAllLines(lines);
    }


//    public String map(User user) {
//        return String.format("%s,%s,%s,%s", user.getId(), user.getFirstName(), user.getLastName(), user.getPhone());
//    }
//
//    public User map(String line) {
//        String[] lines = line.split(",");
//        return new User(lines[0], lines[1], lines[2], lines[3]);
//    }


}