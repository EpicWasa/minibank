package ua.epicwasa.minibank.Utils;

import java.util.Random;

public class CardNumberGenerator {

    public static String generate(){
        Random rnd = new Random();
        String res="";
        for (int i=0; i<16; i++){
            res += Integer.toString( rnd.nextInt(9));
        }
        return res;
    }

}
