package domain;

public class HintLetter {
    private char letter;
    private boolean isGeraden;

    public HintLetter(char letter){
        this.letter = letter;
        isGeraden = false;
    }
    public char getLetter() {
        return letter;
    }
    public boolean raad(char letter){
        if(Character.isUpperCase(this.letter)){
            letter = Character.toUpperCase(letter);
        }
        else {
            letter = Character.toLowerCase(letter);
        }
        if(letter == this.letter && !isGeraden){
            isGeraden = true;
            return true;
        }
        return false;
    }
    public char toChar(){
        if (isGeraden){
            return letter;
        }
        return '_';
    }
    public boolean isGeraden(){
        return isGeraden;
    }
}
