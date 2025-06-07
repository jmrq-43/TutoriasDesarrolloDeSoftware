package view;

import controller.PersonController;
import dao.PersonaDao;

import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);
    private PersonController personController  = new PersonController();

    private void printMenu() {
        System.out.println("""
                Bienvenido \n
                1. crear una nueva persona 
                2. mostrar personas 
                3. editar una persona  
                4. eliminar una persona                 
                5. salir.                 
                """);
    }

    private void printPersons() {
        PersonaDao.getPersonas().forEach(persona -> {
        });
    }

    public void slection() {
        printMenu();
        int option = Integer.parseInt(scanner.nextLine());

        switch (option) {
            case  1:
                personController.printPerson();

        }
    }

    public void init() {
        slection();
    }



}
