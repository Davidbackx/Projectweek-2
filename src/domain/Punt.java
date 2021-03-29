package domain;

public class Punt {
    private int x;
    private int y;

    public Punt (int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o){
        boolean result = false;
        if(o instanceof Punt) {  Punt p = (Punt) o;
            if(this.getX() == (p.getX())
                    && (this.getY() == (p.getY()))){
                result = true; }
        }
        return result;
    }

    public String toString(){
        return "(" + getX() + ", " + getY() + ")";
    }

}
