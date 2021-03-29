package domain;

import com.sun.prism.paint.LinearGradient;
import org.w3c.dom.DOMException;

import java.io.ObjectInputStream;

public class Speler {
    private String naam;
    private int score;

    public Speler(String naam) throws DomainException {
        if (naam == null || naam.trim().isEmpty()) throw new DomainException();
        this.naam = naam;
        this.score = 0;
    }
    public void setScore(int score){
        if (score < 0) throw new IllegalArgumentException();
        this.score = score;
    }
    public String getNaam() {
        return naam;
    }
    public int getScore(){
        return score;
    }
    public void addToScore(int score) {
        if ((score < 0)){
            if(Math.abs(score) > this.score){
               throw new DomainException();
            }
        }
        this.score += score;
    }
    @Override
    public boolean equals(Object andereSpeler) {
        if (andereSpeler == null){
            throw new DomainException();
        }
        if(andereSpeler instanceof Speler){
            Speler speler = (Speler) andereSpeler;
            if(this.naam.equals(speler.naam) && (this.score == speler.score)){
                    return true;
            }
        }

        return false;
    }
}
