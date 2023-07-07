package ru.gb.lessons.interfaces.core.drugStore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Pharmacy implements Iterable<Component>, Comparable<Pharmacy>, Marker {
    private List<Component> components;
    private int componentsCount;

    public Pharmacy() {
        this.components = new ArrayList<>();
        this.componentsCount = 0;
    }

    public Pharmacy addComponent(Component component) {
        this.components.add(component);
        this.componentsCount++;
        return this;
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "components=" + components +
                ", index=" + componentsCount +
                '}' + "Total power = " + getPower(this) + "\n";
    }

    @Override
    public Iterator<Component> iterator() {
        // return new Iterator<Component>() { //Анонимный класс
        // public Component next() {
        // return components.get(componentsCount++);
        // }
        //
        // public boolean hasNext() {
        // return componentsCount < components.size();
        // }
        // };
        return new ComponentIterator();
    }

    // @Override
    // public int compareTo(Pharmacy o) {
    // int pow1 = getPower(this);
    // int pow2 = getPower(o);
    // return Integer.compare(pow1, pow2);
    // // Альтернативная запись:
    // // if (pow1 > pow2) return 1;
    // // else if (pow1 < pow2) return -1;
    // // else return 0;
    // }

    // private int getPower(Pharmacy pharm) {
    // int result = 0;
    // for (Component elem : pharm.getComponents()) {
    // result += elem.getPower();
    // }
    // return result;
    // }

    @Override
    public int compareTo(Pharmacy o) {
        int pow1 = getPower(this);
        int pow2 = getPower(o);

        if (pow1 == pow2) {
            List<Component> components1 = this.getComponents();
            List<Component> components2 = o.getComponents();

            // Сравниваем названия компонентов
            for (int i = 0; i < Math.min(components1.size(), components2.size()); i++) {
                String name1 = components1.get(i).getName();
                String name2 = components2.get(i).getName();

                int result = name1.compareTo(name2);
                if (result != 0) {
                    return result;
                }
            }

            // Если все названия компонентов совпадают, то объекты считаются равными
            return 0;
        } else {
            return Integer.compare(pow1, pow2);
        }
    }

    private int getPower(Pharmacy pharmacy) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Pharmacy pharmacy = (Pharmacy) o;
        return Objects.equals(components, pharmacy.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }

}
