package ui;

import domain.DomainException;
import domain.LijnStuk;
import domain.Punt;
import domain.Tekening;
import javafx.scene.layout.GridPane;

public class LijnStukApp {
    public LijnStukApp(GridPane root, Tekening tekening) {
    }

    public static void main(String[] args) {
        try{
            Punt p1 = new Punt(10, 50);
            Punt p2 = new Punt (10, 50);
            LijnStuk l1 = new LijnStuk(p1, p2);
        } catch (DomainException e){
            System.out.println(e.getMessage());
        }
    }
    // De try catch werkt nog ni volledig!!!!!!!!!

}
