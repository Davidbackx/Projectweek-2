package domain;


import javafx.scene.paint.Color;
import ui.UiException;

public abstract class Vorm implements Drawable{
    private Color kleur = Color.WHITE;

    public Color getKleur() {
        return kleur;
    }

    public void setKleur(Color kleur) {
        if (kleur == null) {
            throw new UiException();
        } else {
            this.kleur = kleur;
        }
    }

    public abstract Omhullende getOmhullende();

    public String toString(){
        return "Kleur";
    }
}
