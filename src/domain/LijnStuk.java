package domain;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class LijnStuk extends Vorm implements Drawable{
    private Punt startPunt;
    private Punt eindPunt;

    public LijnStuk(Punt startPunt, Punt eindPunt) {
        if (startPunt == eindPunt) {
            throw new DomainException("Het start punt mag niet gelijk zijn aan het eindpunt");
        }
        if (startPunt == null) {
            throw new DomainException("Het start punt moet verschillend zijn van null");
        }
        this.startPunt = startPunt;
        if (eindPunt == null) {
            throw new DomainException("Het eind punt moet verschillend zijn van null");
        }
        this.eindPunt = eindPunt;
    }

    public Punt getStartPunt() {
        return startPunt;
    }

    public Punt getEindPunt() {
        return eindPunt;
    }

    public void setStartPunt(Punt startPunt) {
        this.startPunt = startPunt;
    }

    public void setEindPunt(Punt eindPunt) {
        this.eindPunt = eindPunt;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof LijnStuk) {
            LijnStuk l = (LijnStuk)o;
            if(this.getStartPunt().equals(l.getStartPunt()) && this.getEindPunt().equals(l.getEindPunt())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Omhullende getOmhullende() {
        return null;
    }

    public String toString() {
        return "Lijn: startpunt: (" + getStartPunt() + " - eindpunt: " + getEindPunt();
    }

    @Override
    public void teken(Pane root) {
        Line lijnBoomstam = new Line(this.getStartPunt().getX(), this.getStartPunt().getY(), this.getEindPunt().getX(), this.getEindPunt().getY());
        lijnBoomstam.setStrokeWidth(5);
        root.getChildren().addAll(lijnBoomstam);
    }
    //verander stroke width nog
}
