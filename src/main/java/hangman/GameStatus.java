package hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameStatus {

    private final Word word;
    private List<Character> known;

    public GameStatus(Word word) {
        this(word, new ArrayList<>());
    }

    public GameStatus(Word word, List<Character> known) {

        this.word = word;
        this.known = known;
    }

    public GameStatus withRevealed(Character c) {
        if (contains(c)) {
            return new GameStatus(word, Stream.concat(known.stream(), Stream.of(c)).collect(Collectors.toList()));
        }

        return this;
    }

    public boolean moreToGuess() {
        return currentlyKnown().contains("?");
    }

    public String currentlyKnown() {
        String s = word.value();
        char[] split = s.toCharArray();
        for (int i = 0; i < split.length; i++) {
            if (!known.contains(split[i])) {
                split[i] = '?';
            }
        }
        return String.valueOf(split);
    }

    public int correctGuesses() {
        return known.size();
    }

    private boolean contains(char s) {
        return word.value().indexOf(s) != -1;
    }
}
