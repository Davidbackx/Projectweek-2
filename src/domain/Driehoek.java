package domain;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

import java.util.Arrays;
public class Driehoek extends Vorm implements Drawable{
    private Punt hoekpunt1, hoekpunt2, hoekpunt3;
    public Driehoek(Punt hoekpunt1, Punt hoekpunt2, Punt hoekpunt3) {
        if(hoekpunt1 == null){
            throw new DomainException("mag niet null zijn");
        }
        if(hoekpunt2 == null){
            throw new DomainException("mag niet null zijn");
        }
        if(hoekpunt3 == null){
            throw new DomainException("mag niet null zijn");
        }
        if(formALine(hoekpunt1, hoekpunt2, hoekpunt3)) {
            throw new DomainException("hoekpunten mogen niet op een zelfde lijn liggen.");
        }
        if (hoekpunt1.equals(hoekpunt2)||hoekpunt2.equals(hoekpunt3)||hoekpunt3.equals(hoekpunt1)) {
            throw new DomainException("hoekpunten mogen niet samenvallen.");
        }
        this.hoekpunt1 = hoekpunt1;
        this.hoekpunt2 = hoekpunt2;
        this.hoekpunt3 = hoekpunt3;
    }
    public Punt getHoekPunt1() {
        return hoekpunt1;
    }
    public Punt getHoekPunt2() {
        return hoekpunt2;
    }
    public Punt getHoekPunt3() {
        return hoekpunt3;
    }
    public void setHoekPunt1(Punt hoekpunt1) {
        this.hoekpunt1 = hoekpunt1;
    }
    public void setHoekPunt2(Punt hoekpunt2) {
        this.hoekpunt2 = hoekpunt2;
    }
    public void setHoekPunt3(Punt hoekpunt3) {
        this.hoekpunt3 = hoekpunt3;
    }
    private boolean formALine(Punt p1, Punt p2, Punt p3) {
        int x1 = p1.getX();
        int y1 = p1.getY();
        int x2 = p2.getX();
        int y2 = p2.getY();
        int x3 = p3.getX();
        int y3 = p3.getY();
        return (x2 - x1) * (y3 - y1) == (x3 - x1) * (y2 - y1);
    }

    private void sortCorners() {
        Punt[] corners = {this.getHoekPunt1(), this.getHoekPunt2(), this.getHoekPunt3()};
        Arrays.sort(corners);
        this.setHoekPunt1(corners[0]);
        this.setHoekPunt2(corners[1]);
        this.setHoekPunt3(corners[2]);
    }
    public Punt getLinkerBovenhoek() {
        int x = Math.min(hoekpunt1.getX(), Math.min(hoekpunt2.getX(), hoekpunt3.getX()));
        int y = Math.max(hoekpunt1.getY(), Math.max(hoekpunt2.getY(), hoekpunt3.getY()));
        Punt linkerBovenhoek = new Punt(x,y);
        return linkerBovenhoek;
    }

    public int getBreedte() {
        return Math.max(hoekpunt1.getX(), Math.min(hoekpunt2.getX(), hoekpunt3.getX())) - getLinkerBovenhoek().getX();
    }

    public int getHoogte() {
        return getLinkerBovenhoek().getY() - Math.min(hoekpunt1.getY(), Math.max(hoekpunt2.getY(), hoekpunt3.getY()));
    }
    @Override
    public Omhullende getOmhullende() {
        Omhullende omhullende =  new Omhullende(getLinkerBovenhoek(),getBreedte(),getHoogte());
        return omhullende;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driehoek driehoek = (Driehoek) o;
        return hoekpunt1.equals(driehoek.hoekpunt1) && hoekpunt2.equals(driehoek.hoekpunt2) && hoekpunt3.equals(driehoek.hoekpunt3);
    }
    @Override
    public String toString() {
        return String.format("Driehoek: hoekpunt1: %s - hoekpunt2: %s - hoekpunt3: %s", this.getHoekPunt1().toString(), this.getHoekPunt2().toString(), this.getHoekPunt3().toString());
    }

    @Override
    public void teken(Pane root) {
        Driehoek dak = new Driehoek(hoekpunt1, hoekpunt2, hoekpunt3);

        Polyline driehoekDak = new Polyline();
        driehoekDak.setFill(Color.RED);
        driehoekDak.setStroke(Color.BLACK);
        driehoekDak.getPoints().addAll(new Double[]{(double) dak.getHoekPunt1().getX(), (double) dak.getHoekPunt1().getY(), (double) dak.getHoekPunt2().getX(),
                (double) dak.getHoekPunt2().getY(), (double) dak.getHoekPunt3().getX(), (double) dak.getHoekPunt3().getY()});
    }
}