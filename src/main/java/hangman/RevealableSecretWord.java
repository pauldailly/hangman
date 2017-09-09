package hangman;

public class PartiallySecretWord {

    private SecretWord secret;
    private char[] revealableLetters;
    private int revealedLettersCount;

    public PartiallySecretWord(SecretWord secret) {
        this.secret = secret;
        this.revealableLetters = new char[secret.value().length()];
    }

    public void reveal(char c) {
        revealableLetters[revealedLettersCount++] = c;
    }

    public boolean contains(char c){
        return secret.contains(c);
    }

    public String value(){
        char[] v = secret.value().toCharArray();

        for(int i = 0; i< v.length ;i++){
            boolean found = false;
            for(int j=0; j < revealableLetters.length; j++){
                if(v[i] == revealableLetters[j]){
                    found = true;
                }
            }
            if(!found){
                v[i] = '?';
            }
        }

        return new String(v);
    }

}
