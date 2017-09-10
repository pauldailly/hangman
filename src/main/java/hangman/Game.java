package hangman;

public class Game {

    private final Guess guess;
    private GameStatus status;
    private final int max;

    public Game(Guess guess, GameStatus status, int max){

        this.guess = guess;
        this.status = status;
        this.max = max;
    }

    public boolean won() {
        return nextGuess(this.status, this.max);
    }

    public boolean nextGuess(GameStatus prevStatus, int remainingAttempts) {

        if(remainingAttempts == 0 || !prevStatus.moreToGuess()){
            return !prevStatus.moreToGuess();
        }

        GameStatus status = guess.next(prevStatus);

        return nextGuess(status, remainingAttempts(prevStatus, status, remainingAttempts));
    }

    private int remainingAttempts(GameStatus prev, GameStatus current, int remainingAttempts) {
        return (prev.correctGuesses() == current.correctGuesses()) ? remainingAttempts - 1 : remainingAttempts;
    }
}
