package Model;

public class Note extends NoteAbstract{
    private String id = "";
    public String title;
    public String data;

    public Note(String title, String data) {
        super(title, data);
    }
    public Note(String id, String title, String data) {
        this(title, data);
        this.id = id;
    }
}