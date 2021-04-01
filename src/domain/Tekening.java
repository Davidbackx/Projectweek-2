package domain;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Tekening extends Vorm implements Drawable{
    private String naam;
    private ArrayList<Vorm> vormen;
    public static final int MIN_X = 0;
    public static final int MAX_X = 399;
    public static final int MIN_Y = 0;
    public static final int MAX_Y = 399;


    public Tekening(String naam) {
        if (!isValidNaam(naam)) {
            throw new DomainException();
        }
        this.naam = naam;
        this.vormen = new ArrayList<>();
    }

    public static boolean isValidNaam(String s){
        return !(s == null || s.trim().isEmpty());
    }

    public String getNaam() {
        return naam;
    }

    public void voegToe(Vorm v) {
        Omhullende omhullende = new Omhullende(new Punt(MIN_X,MAX_Y),MIN_X+MAX_X,MIN_Y+MAX_Y);
        if (v == null) {
            throw new DomainException();
        }
        if(v.getOmhullende().getMinX() > omhullende.getMinX()){
            throw new DomainException();
        }
        vormen.add(v);
    }

    public void verwijder(Vorm v){
        if ( v == null){
            throw new DomainException();
        } vormen.remove(v);

    }

    public int getAantalVormen() {
        return vormen.size();
    }

    public boolean bevat (Vorm v){
        if ( vormen.contains(v)){
            return true;
        }
        return false;
    }

    public Vorm getVorm(int i){
        return vormen.get(i);
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Tekening) {
            Tekening t = (Tekening)o;
            if(this.getNaam().equals(t.getNaam())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void teken(Pane root) {
        for (Vorm vorm:
             vormen) {
            vorm.teken(root);
        }

    }

    @Override
    public Omhullende getOmhullende() {
        return null;
    }
    // toString er nog bij
}
