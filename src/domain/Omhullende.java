package domain;

public class Omhullende {
    private int breedte;
    private int hoogte;
    private Punt positieLinksBoven;

    public Omhullende(Punt positieLinksBoven,int breedte,int hoogte){
    if(breedte < 0) throw new DomainException(/*"Breedte mag niet negatieg zijn"*/);
    if (hoogte < 0) throw new DomainException();
    if (positieLinksBoven == null) throw new DomainException();
    this.hoogte = hoogte;
    this.breedte = breedte;
    this.positieLinksBoven = positieLinksBoven;
    }
    public int getMaxX(){
        return positieLinksBoven.getX()+breedte;
    }
    public int getMinX(){
        return positieLinksBoven.getX();
    }
    public int getMinY(){
        return positieLinksBoven.getY();
    }
    public int getMaxY(){
        return positieLinksBoven.getY()+hoogte;
    }

    @Override
    public boolean equals(Object andereOmhullende) {
        if(andereOmhullende instanceof Omhullende){
            Omhullende omhullende = (Omhullende) andereOmhullende;
            if (omhullende.positieLinksBoven == this.positieLinksBoven
                && omhullende.breedte == this.breedte && omhullende.hoogte == this.hoogte){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String resultaat = "";
        resultaat = getClass().getSimpleName() + ": (" +positieLinksBoven.getX()+", " + positieLinksBoven.getY()+") - " + breedte +" - " + hoogte;
        return resultaat;
    }

    public Punt getLinkerBovenhoek() {
        return positieLinksBoven;
    }

    public int getHoogte() {
        return hoogte;
    }

    public int getBreedte() {
        return breedte;
    }
}
