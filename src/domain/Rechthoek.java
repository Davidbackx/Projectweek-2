package domain;


public class Rechthoek {
    private int breedte;
    private int hoogte;
    private Punt linkerBovenHoek;

    public Rechthoek(Punt linkerBovenHoek,int breedte,int hoogte){
        if( breedte <= 0) throw new DomainException("Verkeerde invoer");
        if (hoogte <= 0) throw new DomainException("Verkeerde invoer");
        if (linkerBovenHoek == null) throw new DomainException("Verkeerde invoer");
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
    public boolean equals(Object andereRechthoek){
        if (andereRechthoek == null) throw new DomainException("Verkeerde invoer");
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