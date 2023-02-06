package View;

import Controller.NoteController;
// import Model.ConsoleLogger;
import Model.Note;

import java.util.List;
import java.util.Scanner;

public class ViewNote {
    private NoteController noteController;
    // private ConsoleLogger consoleLogger;

    public ViewNote(NoteController noteController) {

        this.noteController = noteController;
    }
    public void run() throws Exception {
        Command com = Command.NONE;

        while (true) {
            String command = prompt("Введите команду: ");
            com = Command.valueOf(command.toUpperCase());
            if (com == Command.EXIT) return;
            try {
                switch (com) {
                    case CREATE:
                        noteController.saveNote(createNote());
                        break;
                    case READ:
                        String id = prompt("ID заметки: ");
                        Note note = noteController.readNote(id);
                        System.out.println(note);
                        break;
                    case ALL:
                        List<Note> lst = noteController.readList();
                        lst.forEach(i -> System.out.println(i + "\n"));
                        break;
                    case UPDATE:
                        String numId = prompt("ID заметки для замены: ");
                        noteController.updateNote(numId, createNote());
                        break;
                    case DELETE:
                        String numID = prompt("ID заметки для удаления: ");
                        noteController.deleteNote(numID);
                        System.out.println(numID + " удален");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Oops!\n" + e.getMessage());
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private Note createNote() {
        String title = prompt("Заголовок:  ");
        String data = prompt("Заметка: ");
        Note note = new Note(title, data);
        return note;
    }
}