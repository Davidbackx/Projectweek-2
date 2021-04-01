package db.domain;

import domain.WoordenLijst;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WoordenLezer {

    public WoordenLijst lees(File file){
        WoordenLijst woorden = new WoordenLijst();
        try{
            Scanner sc = new Scanner(file);
            while (sc.hasNext()){
                String str = sc.nextLine();
                woorden.voegToe(str);
            }
            sc.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return woorden;
    }


}
