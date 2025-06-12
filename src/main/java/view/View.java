package view;

import controller.PersonController;

import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);
    private PersonController personController = new PersonController();
    private String name;
    private int age;

    private void printMenu() {
        System.out.print("""
                1. mostrar Personas 
                2. agregar Persona
                3. editar una person  
                4. eliminar una person                 
                5. salir.    
                \n             
                """);
    }

    public void slection() {
        boolean exit = false;

        while (!exit) {

            printMenu();
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    personController.printPerson();
                    break;
                case 2:
                    personController.addPerson();
                    break;
                case 3:
                    personController.updatePerson();
                    break;
                case 4:
                    personController.deletePerson();
                    break;
                case 5:
                    exit = true;
            }
        }
    }

    public void init() {
        slection();
    }
}
