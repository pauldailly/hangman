package hangman;

import java.util.List;
import java.util.Random;

public class RandomWord implements Word {

    private List<String> choices;

    public RandomWord(List<String> choices) {
        this.choices = choices;
    }

    public String value(){
        return choices.get(new Random().nextInt(choices.size()));
    }
}
