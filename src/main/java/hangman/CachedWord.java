package hangman;

public class CachedWord implements Word {

    private Word origin;
    private String word;

    public CachedWord(Word origin) {

        this.origin = origin;
    }

    @Override
    public String value() {
        if (word == null) {
            word = origin.value();
        }

        return word;
    }

}
