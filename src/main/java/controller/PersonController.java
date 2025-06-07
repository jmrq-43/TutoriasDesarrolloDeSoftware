package controller;

import dao.PersonaDao;

public class PersonController {
    public void printPerson() {
        PersonaDao.getPersonas().forEach(persona -> {
            System.out.println(persona.getId() + " " + persona.getNombre() + " " + persona.getEdad());
        });
    }
}
