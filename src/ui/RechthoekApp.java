package ui;

import domain.DomainException;
import domain.Punt;
import domain.Rechthoek;
import domain.Tekening;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RechthoekApp extends Application {
    private Label linkerBovenHoekX,linkerBovenHoekY,breedte,hoogte;
    private TextField invoerLinkerBovenHoekX, invoerLinkerBovenHoekY, invoerBreedte, invoerHoogte;

    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);
    private Rechthoek rechthoek;
    public RechthoekApp(GridPane root) {
        init(root,0);
        invoerHoogte.setOnAction(eventInvoerHoogte ->{
        try {
            Punt linkerBovenHoek = new Punt(Integer.parseInt(invoerLinkerBovenHoekX.getText()),Integer.parseInt(invoerLinkerBovenHoekY.getText()));
            rechthoek = new Rechthoek(linkerBovenHoek,Integer.parseInt(invoerBreedte.getText()),Integer.parseInt(invoerHoogte.getText()));
            root.getChildren().clear();
            Text uitvoer = new Text();
            uitvoer.setText(rechthoek.toString());
            root.add(uitvoer,0,0);
        }catch (NumberFormatException ne){
            invoerHoogte.clear();
            foutenboodschap.setTitle("Warning");
            foutenboodschap.setContentText("Hoogte moet een geheel getal zijn");
            foutenboodschap.showAndWait();
        }
        catch (DomainException e){
            invoerHoogte.clear();
            foutenboodschap.setTitle("Warning");
            foutenboodschap.setHeaderText(null);
            foutenboodschap.setContentText(e.getMessage());
            foutenboodschap.showAndWait();
        }
        });
    }

    public RechthoekApp(GridPane root, Tekening tekening) {
        init(root,1);
        invoerHoogte.setOnAction(eventInvoerHoogte ->{
            try{
                Punt linkerbovenHoek = new Punt(Integer.parseInt(invoerLinkerBovenHoekX.getText()),Integer.parseInt(linkerBovenHoekY.getText()));
                rechthoek = new Rechthoek(linkerbovenHoek, Integer.parseInt(invoerBreedte.getText()),Integer.parseInt(invoerHoogte.getText()));
                tekening.voegToe(rechthoek);
                cleanUp(root);
            }catch (NumberFormatException ne){
                invoerHoogte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("Hoogte moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }catch (DomainException e){
                cleanUp(root);
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setHeaderText(null);
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });
    }
    private void init(GridPane root, int teller){
        linkerBovenHoekX = new Label("Geef het X-coordinaat van de linkerbovenhoek ");
        linkerBovenHoekY = new Label("Geef het Y-coordinaat van de linkerbovenhoek");
        invoerLinkerBovenHoekX = new TextField();
        invoerLinkerBovenHoekY = new TextField();

        breedte = new Label("Geef de breedte van de rechthoek");
        invoerBreedte = new TextField();

        hoogte = new Label("Geeft de hoogte in van de rechthoek");
        invoerHoogte = new TextField();

        root.add(linkerBovenHoekX,0,teller);
        root.add(invoerLinkerBovenHoekX,1,teller);
        invoerLinkerBovenHoekX.setOnAction(eventIngaveX ->{
            try{
                Integer.parseInt(invoerLinkerBovenHoekX.getText());
                root.add(linkerBovenHoekY,0,teller +1);
                root.add(invoerLinkerBovenHoekY,1,teller +1);
            }
            catch (NumberFormatException e){
                invoerLinkerBovenHoekX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coordinaat van linkerbovenhoek moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
        invoerLinkerBovenHoekY.setOnAction(eventIngaveY -> {
            try{
                Integer.parseInt(invoerLinkerBovenHoekY.getText());
                root.add(breedte,0,teller +2);
                root.add(invoerBreedte,1,teller+2);
            }catch (NumberFormatException e){
                invoerLinkerBovenHoekY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coordinaat van de linkerbovenhoek moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
        invoerBreedte.setOnAction(eventIngaveBreedte ->{
            try {
                Integer.parseInt(invoerBreedte.getText());
                root.add(hoogte,0,teller +3);
                root.add(invoerHoogte,1,teller +3);
            }catch (NumberFormatException e){
                invoerBreedte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("Invoer voor de breedte van de rechthoek moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
    }
    private void cleanUp(GridPane root){
        root.getChildren().remove(linkerBovenHoekX);
        root.getChildren().remove(invoerLinkerBovenHoekX);
        root.getChildren().remove(linkerBovenHoekY);
        root.getChildren().remove(invoerLinkerBovenHoekY);
        root.getChildren().remove(breedte);
        root.getChildren().remove(invoerBreedte);
        root.getChildren().remove(hoogte);
        root.getChildren().remove(invoerHoogte);
    }
    @Override
    public void start(Stage stage) throws Exception {

    }
}
