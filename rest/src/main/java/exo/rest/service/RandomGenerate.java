package exo.rest.service;

import java.util.Random;

/**
 * Created by exo on 26/09/16.
 */
public class RandomGenerate {


    public static StringBuilder generate() {


        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb1 = new StringBuilder();
        Random random = new Random();
        for (int j = 0; j < 20; j++) {
            char c = chars[random.nextInt(chars.length)];
            sb1.append(c);


        }
        return sb1;
    }

}




