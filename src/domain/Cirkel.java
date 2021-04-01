package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Objects;

public class Cirkel extends Vorm implements Drawable{
    private Punt middelPunt;
    private int radius;

    public Cirkel(Punt middelPunt, int radius) {
        setMiddelPunt(middelPunt);
        setRadius(radius);
    }

    public Punt getMiddelPunt() {
        return middelPunt;
    }

    public void setMiddelPunt(Punt middelPunt) {
        if (middelPunt == null) {
            throw new DomainException("middelpunt is leeg");
        }
        this.middelPunt = middelPunt;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius <= 0) {
            throw new DomainException("radius moet positief zijn");
        }
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cirkel cirkel = (Cirkel) o;
        return radius == cirkel.radius &&
                Objects.equals(middelPunt, cirkel.middelPunt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(middelPunt, radius);
    }

    @Override
    public Omhullende getOmhullende() {
        return new Omhullende(new Punt(this.middelPunt.getX()-this.radius,this.middelPunt.getY() - this.radius),this.radius*2,this.radius*2);
    }

    @Override
    public String toString() {
        return "Cirkel{" +
                "middelPunt=" + middelPunt +
                ", radius=" + radius +
                '}';
    }

    @Override
    public void teken(Pane root) {
        Circle c = new Circle(this.getMiddelPunt().getX(), this.getMiddelPunt().getY(), this.getRadius());
        c.setFill(this.getKleur());
        c.setStroke(Color.BLACK);
        root.getChildren().addAll(c);
    }
}
