package controller;

import Domain.Person;
import dao.PersonaDao;

import java.sql.SQLException;
import java.util.Scanner;

public class PersonController {
    private PersonaDao personaDao = new PersonaDao();
    private Scanner sc = new Scanner(System.in);

    public void printPerson() {
        personaDao.getPersons().forEach(persona -> {
            System.out.println(persona.getId() + " " + persona.getNombre() + " " + persona.getEdad() );
        });
        System.out.println("\n");
    }

    public void addPerson() {
        Person person = new Person();

        System.out.print("Ingrese el nombre del persona: ");
        person.setNombre(sc.nextLine());
        System.out.print("Ingrese el edad del persona: ");
        person.setEdad(sc.nextInt());

        try {
            personaDao.createPersons(person);
        } catch (SQLException e) {
            System.out.println("no se pudo crear una persona");
            throw new RuntimeException(e);
        }
    }

    public void updatePerson() {
        Person person = new Person();

        System.out.print("Ingrese el ID del persona: \n");
        person.setId(sc.nextInt());

        System.out.print("Ingrese el nombre del persona: \n ");
        person.setNombre(sc.next());

        System.out.print("Ingrese el edad del persona: \n");
        person.setEdad(sc.nextInt());

        try {
            personaDao.updatePersons(person);
        } catch (SQLException e) {
            System.out.println("no se pudo actualizar una persona");
            throw new RuntimeException(e);
        }
    }

    public void deletePerson() {
        Person person = new Person();
        System.out.print("Ingrese el ID del persona: \n");
        person.setId(sc.nextInt());
        try {
            personaDao.deletePersons(person);
        } catch (SQLException e) {}
    }
}
