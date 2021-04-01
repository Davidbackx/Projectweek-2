package domain.model;

public class Woord {
    private String woord;


    public boolean equals(Woord woord){
        if (woord.equals(this.woord)){
            return true;
        }
        return false;
    }
}
