package Model;

public abstract class NoteAbstract {
    private String id;
    public String title;
    public String data;


    public NoteAbstract(String title, String data) {
        this.title = title;
        this.data = data;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}