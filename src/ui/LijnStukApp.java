package ui;

import domain.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class LijnStukApp {

    private Label invoerXLabelS, invoerXLabelE, invoerYLabelS, invoerYLabelE;
    private TextField invoerXS, invoerXE, invoerYS, invoerYE;

    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);
    private Vorm vorm;

    public LijnStukApp(GridPane root) {
        init(root,0);
        invoerYE.setOnAction(eventIngaveInvoerY -> {
            try {
                Punt startpunt = new Punt(Integer.parseInt(invoerXS.getText()),Integer.parseInt(invoerYS.getText()));
                Punt eindpunt = new Punt(Integer.parseInt(invoerXE.getText()),Integer.parseInt(invoerYE.getText()));
                vorm = new LijnStuk(startpunt, eindpunt);
                root.getChildren().clear();
                Text uitvoer = new Text();
                uitvoer.setText(vorm.toString());
                root.add(uitvoer,0,0);

            }catch (NumberFormatException ne){
                invoerYE.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat van het eindpunt moet een numerike waarde bevatten");
                foutenboodschap.showAndWait();
            }
            catch (DomainException e){
                invoerYE.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setHeaderText(null);
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }

        });
    }

    public LijnStukApp(GridPane root, Tekening tekening) {
        init(root, 1);
        invoerYE.setOnAction(eventIngaveInvoerY -> {
            try {
                Punt startpunt = new Punt(Integer.parseInt(invoerXS.getText()), Integer.parseInt(invoerYS.getText()));
                Punt eindpunt = new Punt(Integer.parseInt(invoerXE.getText()), Integer.parseInt(invoerYE.getText()));

                vorm = new LijnStuk(startpunt, eindpunt);
                tekening.voegToe(vorm);
                cleanUp(root);

            } catch (NumberFormatException ne) {
                invoerYE.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat van het eindpunt moet een numerike waarde bevatten");
                foutenboodschap.showAndWait();
            } catch (DomainException e) {
                cleanUp(root);
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setHeaderText(null);
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }

        });
    }

    private void init(GridPane root, int teller) {
        invoerXLabelS = new Label("Geef de x-coördinaat van het startpunt");
        invoerXS = new TextField();

        invoerYLabelS = new Label("Geef de y-coördinaat van het startpunt");
        invoerYS = new TextField();

        invoerXLabelE = new Label("Geef de x-coördinaat van het eindpunt");
        invoerXE = new TextField();

        invoerYLabelE = new Label("Geef de y-coördinaat van het eindpunt");
        invoerYE = new TextField();

        root.add(invoerXLabelS, 0, teller);
        root.add(invoerXS, 1, teller);

        invoerXS.setOnAction(eventIngaveX -> {
            try {
                Integer.parseInt(invoerXS.getText());
                root.add(invoerYLabelS, 0, teller + 1);
                root.add(invoerYS, 1, teller + 1);
            } catch (NumberFormatException e) {
                invoerXS.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x-coördinaat van het startpunt van het lijnstuk moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }

        });

        invoerYS.setOnAction(eventIngaveY -> {
            try {
                Integer.parseInt(invoerYS.getText());
                root.add(invoerXLabelE, 0, teller + 2);
                root.add(invoerXE, 1, teller + 2);
            } catch (NumberFormatException e) {
                invoerYS.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y-coördinaat van het starpunt van het lijnstuk moet een geheel getal zijn");
                foutenboodschap.showAndWait();

            }
        });

        invoerXE.setOnAction(eventIngaveX -> {
            try {
                Integer.parseInt(invoerXE.getText());
                root.add(invoerYLabelE, 0, teller + 1);
                root.add(invoerYE, 1, teller + 1);
            } catch (NumberFormatException e) {
                invoerXE.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x-coördinaat van het eindpunt van het lijnstuk moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }

        });
    }

    private void cleanUp(GridPane root) {
        root.getChildren().remove(invoerXLabelS);
        root.getChildren().remove(invoerXS);
        root.getChildren().remove(invoerYLabelS);
        root.getChildren().remove(invoerYS);
        root.getChildren().remove(invoerXLabelE);
        root.getChildren().remove(invoerXE);
        root.getChildren().remove(invoerYLabelE);
        root.getChildren().remove(invoerYE);

    }
}


//    public static void main(String[] args) {
//        try{
//            Punt p1 = new Punt(10, 50);
//            Punt p2 = new Punt (10, 50);
//            LijnStuk l1 = new LijnStuk(p1, p2);
//        } catch (DomainException e){
//            System.out.println(e.getMessage());
//        }
//    }
//    // De try catch werkt nog ni volledig!!!!!!!!!
//
//}
