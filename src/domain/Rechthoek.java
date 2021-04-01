package domain;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Rechthoek extends Vorm implements Drawable {
    private int breedte;
    private int hoogte;
    private Punt linkerBovenHoek;

    public Rechthoek(Punt linkerBovenHoek,int breedte,int hoogte){
        if( breedte <= 0) throw new DomainException("de breedte moet een positief getal zijn");
        if (hoogte <= 0) throw new DomainException("de hoogte moet een positief getal zijn");
        if (linkerBovenHoek == null) throw new DomainException("het punt mag niet leeg zijn");
        this.breedte = breedte;
        this.hoogte = hoogte;
        this.linkerBovenHoek = linkerBovenHoek;
    }

    public int getBreedte() {
        return breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public Punt getLinkerBovenhoek() {
        return linkerBovenHoek;
    }

    @Override
    public Omhullende getOmhullende() {
        return new Omhullende(linkerBovenHoek,breedte,hoogte);
    }

    @Override
    public void teken(Pane root) {
        Rectangle rechthoekGebouw = new Rectangle(this.getLinkerBovenhoek().getX(), this.getLinkerBovenhoek().getY(), this.getBreedte(), this.getHoogte());
        rechthoekGebouw.setFill(this.getKleur());
        rechthoekGebouw.setStroke(Color.BLACK);
        root.getChildren().addAll(rechthoekGebouw);
    }

    @Override
    public boolean equals(Object andereRechthoek){
        if (andereRechthoek == null) return false;
        if (andereRechthoek instanceof Rechthoek){
            Rechthoek rechthoek = (Rechthoek) andereRechthoek;
            if(linkerBovenHoek.equals(rechthoek.linkerBovenHoek) && this.hoogte == rechthoek.hoogte && this.breedte == rechthoek.breedte){
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString(){
        String resultaat ="";
        resultaat = getClass().getSimpleName() +": linkerbovenhoek: (" + linkerBovenHoek+")" + " -  breedte: "+ breedte + " - hoogte: " + hoogte;
        return resultaat;
    }
}