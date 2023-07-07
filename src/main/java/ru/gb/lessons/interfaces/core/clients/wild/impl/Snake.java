package ru.gb.lessons.interfaces.core.clients.wild.impl;

import ru.gb.lessons.interfaces.core.clients.owners.Owner;
import ru.gb.lessons.interfaces.core.clients.wild.WildAnimal;

import java.time.LocalDate;

public class Snake extends WildAnimal {
    public Snake() {

    }
    public Snake (int id, int numberOfLimbs, LocalDate registrationDate, Owner owner) {
        super(id, numberOfLimbs, registrationDate, owner);
    }
}
