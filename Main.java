

import Controller.NoteController;
import Model.FileManager;
import Model.Repository;
import View.ViewNote;

public class Main {
    public static void main(String[] args) throws Exception {
        FileManager fileManager = new FileManager("notes.txt");
        Repository repository = new Repository(fileManager);
        NoteController controller = new NoteController(repository);
        ViewNote viewNote = new ViewNote(controller);
        viewNote.run();
    }
}