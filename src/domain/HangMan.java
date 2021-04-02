package domain;

public class HangMan {
    private Speler speler;
    private TekeningHangMan tekeningHangMan;
    private WoordenLijst woordenlijst;
    private HintWoord hintwoord;
    private boolean gewonnen;

    public HangMan(Speler speler, WoordenLijst woordenlijst) {
        this.speler = speler;
        this.woordenlijst = woordenlijst;
    }

    public Speler getSpeler() {
        return speler;
    }

    public TekeningHangMan getTekening() {
        return tekeningHangMan;
    }

    public String getHint() {
        return hintwoord.getWoord();
    }

    public boolean isGameOver(){

    }

    public boolean isGewonnen(){
        return hintwoord.isGeraden();
    }

    public boolean raad(char letter){
        return hintwoord.raad(letter);
    }
}
