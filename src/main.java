import FireNext.NextDatabase;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        print(NextDatabase.add("USER>18302>name:al moaz"));
        ArrayList child = new ArrayList();
        child = NextDatabase.query("USER>18301>nam:");
        print(String.valueOf(child));
    }




































    private static void print(String value) {
        System.out.println(value);
    }
    private static void print(int value) {
        System.out.println(value);
    }
}
