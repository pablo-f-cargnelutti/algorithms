package katas.test;

import jdk.nashorn.internal.objects.NativeJava;

/**
 * Created by pcargnel on 4/16/2014.
 */
public class Main {
    public static void main(String arg[]) {
        int number = 43; int number2 = Integer.MAX_VALUE-44;
        if(Integer.MAX_VALUE - number2 - number > 0 ) {
            int result = number + number2;
            System.out.println(result);
        }
        Object toPrint = "";
        System.out.println(toPrint);
    }
}
