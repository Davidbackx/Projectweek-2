package domain;


public class Rechthoek {
    private int breedte;
    private int hoogte;
    private Punt linkerBovenHoek;

    public Rechthoek(Punt linkerBovenHoek,int breedte,int hoogte){
        if( breedte <= 0) throw new DomainException();
        if (hoogte <= 0) throw new DomainException();
        if (linkerBovenHoek == null) throw new DomainException();
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
    public String getOmhullende(){
        Omhullende omhullende = new Omhullende(linkerBovenHoek,breedte,hoogte);
        return toString() +"\n"+ omhullende.toString();
    }
    @Override
    public boolean equals(Object andereRechthoek){
        if (andereRechthoek == null) throw new DomainException();
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