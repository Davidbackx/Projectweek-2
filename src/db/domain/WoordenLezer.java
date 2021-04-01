package db.domain;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class WoordenLezer {

    public void lees(){
        ArrayList<String> woorden = new ArrayList<>();
        try{
            Scanner sc = new Scanner(new File("D:\\School\\Academiejaar 1\\Semester 2\\Projectweek 2 code\\hangman.txt"));
            while (sc.hasNext()){
                String str = sc.nextLine();
                woorden.add(str);
            }
            sc.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
