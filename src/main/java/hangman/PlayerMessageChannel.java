package hangman;

import java.io.OutputStream;
import java.io.PrintStream;

public class PlayerMessageChannel {

    private PrintStream printStream;

    public PlayerMessageChannel(OutputStream outputStream) {
        this(new PrintStream(outputStream));
    }

    public PlayerMessageChannel(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void send(String message) {
        printStream.println(message);
    }
}
