package katas.test;

import jdk.nashorn.internal.objects.NativeJava;

/**
 * Created by pcargnel on 4/16/2014.
 */
public class Main {
    public static int value =2;
    public static void main(String... arg) {
//        int number = 43; int number2 = Integer.MAX_VALUE-44;
//        if(Integer.MAX_VALUE - number2 - number > 0 ) {
//            int result = number + number2;
//            System.out.println(result);
//        }
//        Object toPrint = "";
        Main3<Main3> main3 = new Main3<>();
    }

    static class Main3<B>
    {
        private B b;
        public void printMe(B b2){
            System.out.println(b2.getClass().getName());
        }
    }
    public class Main2{
        public void show()
        {
            System.out.println(value);
            System.out.println(Main.value);

        }
    }


}

class One{
    String one;
    public static int getx(){return 1;}
}

class Two extends One{
    public static int getx(){return 2;}
}