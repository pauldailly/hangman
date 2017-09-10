package hangman;

public class FinalResult {
    private final Game game;
    private final PlayerMessageChannel output;
    private Word word;

    public FinalResult(Game game, PlayerMessageChannel output, Word word) {
        this.game = game;
        this.output = output;
        this.word = word;
    }

    public void announce(){
        boolean won = game.won();
        if(won){
            output.send("You correctly guessed the word:");
        } else {
            output.send("You were unable to guess the word:");
        }

        output.send(word.value());
    }
}
