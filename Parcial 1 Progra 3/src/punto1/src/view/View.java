package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class View {
    public int readInt(String a) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(a);
        try {
            a = reader.readLine();
        } catch (Exception e) {
            System.out.print("El caracter selecionado no es un numero\n");
        }
        int b = Integer.parseInt(a);

        return b;
    }

    public String readString(String a) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(a);
        try {
            a = reader.readLine();
        } catch (Exception e) {
            System.out.println("El dato ingresado no es un String");
        }
        return a;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

}
