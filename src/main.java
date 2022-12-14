import FireNext.NextDatabase;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        //print(NextDatabase.add("USER>18301>name:almoaz"));

        ArrayList value = new ArrayList<>();
        value = NextDatabase.query("USER>  183001");
        System.out.println(value);
    }




































    private static void print(String value) {
        System.out.println(value);
    }
    private static void print(int value) {
        System.out.println(value);
    }
}
