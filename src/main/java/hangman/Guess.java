package hangman;

import java.io.InputStream;
import java.util.Scanner;

public class Guess {

    private InputStream in;
    private PlayerMessageChannel out;

    public Guess(InputStream in, PlayerMessageChannel out) {
        this.in = in;
        this.out = out;
    }

    public GameStatus next(GameStatus status) {
            out.send("The word is " + status.currentlyKnown());
            out.send("Please guess a letter ");
            Scanner s = new Scanner(in);
            return status.withRevealed(s.nextLine().charAt(0));
    }
}
