package gui;

import domain.DomainException;
import domain.Punt;

import java.util.Objects;

public class Cirkel {
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
        if (middelPunt == null ) {
            throw new DomainException("middelpunt is leeg");
        }
        this.middelPunt = middelPunt;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius <= 0 ) {
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
    public String toString() {
        return "Cirkel{" +
                "middelPunt=" + middelPunt +
                ", radius=" + radius +
                '}';
    }
}
