package Controler;
import view.*;
import model.*;

import java.util.LinkedList;

public class Controler {
    private View view;
    private Logic logic;

    public Controler() {
        view = new View();
        logic = new Logic();
    }

    LinkedList<Integer> b = new LinkedList<>();
    public int opcion() {
        int a = view.readInt("Punto 1 parcial \n1. Ingresar los numeros y sumarlos.\n2. Salir");
        return a;
    }

    public void showMenu() {
        int a = 0;
        while (a != 3) {
            a = opcion();
            switch (a) {
                case 1:
                    inputAndSum();
                    result();
                    break;
                case 2:
                    end();
                    break;
                default:
                    view.showMessage("No ha seleccionado ninguna de las opciones posibles, por favor ingrese de nuevo los datos");
                    break;
            }
        }
    }

    public void inputAndSum() {
        int aux = view.readInt("Por favor, ingrese un numero:");
        b.add(aux);
        String answer = view.readString("Desea Ingresar otro numero? s/n");
        if(answer.equalsIgnoreCase("s")){
            inputAndSum();
        }
    }
    public void result(){
        logic.fillList(b);
        int result = logic.sumNumbers();
        view.showMessage("La suma de los numeros es: "+ result);
        clear();
    }

    public void clear(){
        b.clear();
        logic.clearList();
    }

    public void end() {
        System.exit(0);
    }

    public static void main(String[] args) {
        new Controler().showMenu();
    }
}
