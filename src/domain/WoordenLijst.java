package domain;

import java.util.ArrayList;

public class WoordenLijst {
    private ArrayList<String> woorden;
    public WoordenLijst(){
        woorden = new ArrayList<>();
    }

    public void voegToe(String s) {
        if(s == null || s.trim().isEmpty()) throw new DomainException("Woord mag niet leeg zijn");
        if(woorden.size() == 0){
            woorden.add(s);
        }else{
            for(String woord:woorden) {
                if(woord.equals(s)){
                    throw new DomainException("Woord zit al in de lijst");
                }
                woorden.add(woord);
            }
        }
    }
    public int getAantalWoorden() {
        return woorden.size();
    }
}
