package ui;

import domain.DomainException;
import domain.HintLetter;
import domain.HintWoord;
import domain.Speler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class WoordRadenApp {
    private Label uitkomst;
    private Label hint;
    private Label woord;
    private Label letter;
    private TextField invoerLetter;
    private Label woordZLetters;
    private Alert foutenBoodschap = new Alert(Alert.AlertType.WARNING);


    public WoordRadenApp(GridPane root,Speler speler) {
        init(root,0);
        HintWoord raadWoord = new HintWoord("hangmanspelletje");
        woordZLetters = new Label(raadWoord.toString());
        try {
            Speler speler1 = speler;
            System.out.println(uitkomst);
            root.add(uitkomst,0,1);
            root.add(hint,0,2);
            root.add(woordZLetters,0,3);
            root.add(letter,0,4);
            root.add(invoerLetter,0,5);
        }catch (DomainException e){
            invoerLetter.clear();
        }
        invoerLetter.setOnAction(eventInvoerLetter ->{
            try{
                char uitvoer;
                uitvoer = invoerLetter.getCharacters().charAt(0);
                HintLetter raadLetter = new HintLetter(uitvoer);
                if(raadWoord.raad(raadLetter.getLetter())){
                    uitkomst = new Label("Super, doe zo voort");
                }
                else{
                    uitkomst = new Label("Helaas volgende keer beter?");
                }
                woord = new Label(raadWoord.toString());
                woordZLetters = woord;
                root.add(uitkomst,0,1);
                root.add(woord,0,3);
                invoerLetter.clear();
            }catch (DomainException e){
                e.getMessage();
            }
        });
    }
    public void init(GridPane root, int teller){
        uitkomst = new Label("");
        hint = new Label("Rarara, welk woord zoeken we?");
        letter = new Label("Geef een letter:");
        woord = new Label("");
        invoerLetter = new TextField();
        }
}
