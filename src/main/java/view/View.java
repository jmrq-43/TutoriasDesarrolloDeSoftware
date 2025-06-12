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
                1. mostrar Personas 
                2. agregar Persona
                3. editar una persona  
                4. eliminar una persona                 
                5. salir.                 
                """);
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
