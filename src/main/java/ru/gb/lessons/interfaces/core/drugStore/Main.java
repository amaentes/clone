package ru.gb.lessons.interfaces.core.drugStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Pharmacy pharmacy1 = new Pharmacy();
        Component comp1 = new Component("Penicillin", "10 mg", 12);
        Component comp2 = new Component("Spirit", "100 g", 1000);

        pharmacy1.addComponent(comp1).addComponent(comp2);

        // Интерфейс Serializable - отвечает за сериализацию объектов. Превращает объект
        // в массив байтов, который потом
        // можно собрать обратно при помощи десериализатора.

        // while (((Iterator<Component>) pharmacy1).hasNext()){
        // System.out.println(pharmacy1.next());
        // }
        System.out.println(pharmacy1);

        // DogPharmacy dogPharmacy = new DogPharmacy();
        // System.out.println(dogPharmacy.hashCode());
        for (Component elem : pharmacy1) {
            System.out.println(elem);
        }

        Pharmacy pharmacy2 = new Pharmacy();
        Component comp3 = new Component("Penicillin", "10 mg", 12);
        Component comp4 = new Component("Spirit", "100 g", 13);
        pharmacy2.addComponent(comp3).addComponent(comp4);

        Pharmacy pharmacy3 = new Pharmacy();
        Component comp5 = new Component("Penicillin", "10 mg", 13);
        Component comp6 = new Component("Spirit", "100 g", 100);
        pharmacy3.addComponent(comp5).addComponent(comp6);

        List<Pharmacy> nomenclature = new ArrayList<>();
        nomenclature.add(pharmacy3);
        nomenclature.add(pharmacy1);
        nomenclature.add(pharmacy2);

        System.out.println(nomenclature);
        Collections.sort(nomenclature);
        System.out.println("============================================================================");
        System.out.println(nomenclature);

        Set<Pharmacy> result = new HashSet<>();
        System.out.println(result.size());
    }

}
