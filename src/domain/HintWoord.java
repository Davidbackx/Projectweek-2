package domain;

import java.lang.reflect.Array;

public class HintWoord {
    private HintLetter hintwoord [];

    public HintWoord(String woord ){
        if (woord == null || woord.trim().isEmpty()) throw new DomainException("woord mag niet null of leeg zijn");

        hintwoord = new HintLetter[woord.length()];
        for (int i = 0; i < woord.length(); i++) {
            hintwoord[i] = new HintLetter(woord.charAt(i));
        }
    }
    public boolean raad(char letter){
        boolean ok = false;
        for (int i = 0; i < hintwoord.length ; i++) {
            ok = hintwoord[i].raad(letter) || ok;         // [t, true] [e,false] [s, false] [t,true]
        }
        return ok;
    }
    public boolean isGeraden(){
        for (int i = 0; i < hintwoord.length  ; i++) {
            if(!hintwoord[i].isGeraden()){
                return false;
            }
        }
        return true;
    }
    public String getWoord(){
        StringBuilder woord = new StringBuilder();
        for (int i = 0; i < hintwoord.length ; i++) {
                woord.append(hintwoord[i].getLetter());
        }
        return woord.toString();
    }
    @Override
    public String toString(){
        String resultaat ="";
       for (int i = 0; i < hintwoord.length; i++) {
           if (hintwoord[i].isGeraden()) {
               resultaat += hintwoord[i].getLetter() + " ";
           } else {
               resultaat += "_ ";
           }
       }
        return resultaat.substring(0,resultaat.length()-1);
    }
}
