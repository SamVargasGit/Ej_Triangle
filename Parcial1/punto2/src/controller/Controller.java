package controller;

import model.Person;
import view.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Controller {
    private Vector<Person> vector = new Vector<Person>();
    private Map<String,Integer> hash = new HashMap<>();

    private View view;
    private Person person;
    public Controller(){
        this.view = new View();
    }
    public void asign(){
        int tam = view.readInt("Cuantas personas va a ingresar");
        for(int i=0;i<tam;i++) {
            String name = view.readString("Ingrese el nombre de la persona");
            int age = view.readInt("Ingrese la edad de la persona");
            person = new Person(name, age);
            vector.add(person);
        }
        convert();
        viewPerson();
    }

    public void convert(){
        for (Person per:vector){
            if(!hash.containsKey(per.getName())){
               hash.put(per.getName(), per.getAge());
            }
        }
    }

    public  void viewPerson(){
        StringBuilder text = new StringBuilder();
            text.append("Nombres: \n").append(hash.keySet()).append("\n").append("Edades: \n").append(hash.values()).append("\nEdades total: "+sumAge());
        view.show(""+text);
    }

    public int sumAge(){
        Integer[] array = hash.values().toArray(new Integer[hash.size()]);
        int total=0;
            for (int i =0;i<array.length;i++){
                total=total+array[i];
        }
        return total;
    }

    public static void main(String[] args) {
        new Controller().asign();
    }
}
