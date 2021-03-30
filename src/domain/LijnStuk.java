package domain;

public class LijnStuk {
    private Punt startPunt;
    private Punt eindPunt;

    public LijnStuk(Punt startPunt, Punt eindPunt) {
        if (startPunt == null) {
            throw new DomainException("izan");
        }
        this.startPunt = startPunt;
        if (eindPunt == null) {
            throw new DomainException("izan");
        }
        this.eindPunt = eindPunt;
    }

    public Punt getStartPunt() {
        return startPunt;
    }

    public Punt getEindPunt() {
        return eindPunt;
    }

    public void setStartPunt(Punt startPunt) {// geen setters in UML
      
        this.startPunt = startPunt;
    }

    public void setEindPunt(Punt eindPunt) {// geen setters in UML 
        this.eindPunt = eindPunt;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof LijnStuk) {
            LijnStuk l = (LijnStuk)o;
            if(this.getStartPunt().equals(l.getStartPunt()) && this.getEindPunt().equals(l.getEindPunt())){
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Lijn: startpunt: (" + getStartPunt() + " - eindpunt: " + getEindPunt();
    }
}
