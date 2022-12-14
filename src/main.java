import FireNext.NextDatabase;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        //print(NextDatabase.add("USER>18302>name:almoaz"));

        ArrayList value = new ArrayList<>();
        value = NextDatabase.query("USER>  18300");
        System.out.println(value);
    }




































    private static void print(String value) {
        System.out.println(value);
    }
    private static void print(int value) {
        System.out.println(value);
    }
}
