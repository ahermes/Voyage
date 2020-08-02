package com.santiane;

import com.santiane.entities.*;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class App {
    public static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {

        Voyage v = null;
        System.out.println("Bienvenu dans l'interface de création de voyage");
        int option = 0;

        while (option != 9) {
            option = showMainMenu(v);
            switch (option) {

                case 1:
                    System.out.println("Veuillez donner un nom au voyage:");
                    v = new Voyage();
                    v.setName(keyboard.nextLine());
                    break;
                case 2:
                    Step s = showStepMenu(v);
                    assert v != null;
                    v.addToStepList(s);
                    break;
                case 3:
                    assert v != null;
                    System.out.println(v.toString());
                    break;
                case 9:
                    //exit(0);
                    break;
                default:
                    System.out.println("Désolé, Veuillez renseigner une option valide");
            }// End of switch statement

        }
        System.out.println("Merci. Au revoir.");



    }

    private static Step showStepMenu(Voyage voyage) {
        int option = 4;
        Step step = null;
        while (option > 3) {
            System.out.println("Création d'étape:");
            System.out.println("--------------");
            System.out.println("Veuillez choisir le type de transport:");
            System.out.println("1. Bus");
            System.out.println("2. Avion");
            System.out.println("3. Train");
            System.out.println("--------------");
            System.out.println("Faites un choix:");
            try {
                option = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Désolé, Veuillez renseigner une option valide");
                option = 100;
            }
            if(option > 3) System.out.println("Désolé, Veuillez renseigner une option valide");
        }
        switch (option){
            case 1: step = new Bus();
                step.setVariablesMenu(voyage);
                break;
            case 2: step = new Plane();
                step.setVariablesMenu(voyage);
            break;
            case 3: step = new Train();
                step.setVariablesMenu(voyage);
            break;
            default: break;

        }

        return step;
    }



    public static int showMainMenu(Voyage voyage) {

        int option = 0;
        System.out.println("Menu principal:");
        System.out.println("--------------");
        System.out.println("1.Créer un nouveau voyage");
        if(voyage != null){
            System.out.println("2.Ajouter une étape au voyage");
            System.out.println("3.Afficher le voyage en cours " + voyage.getName());
        }
        System.out.println("9.Quitter");
        System.out.println("--------------");
        System.out.println("Faites un choix:");
        try{
            option = Integer.parseInt(keyboard.nextLine());
        }catch (NumberFormatException  e){
            option = 100;
        }
        if(voyage == null){
            if(option == 2 || option == 3){
                option = 100;
            }
        }
        return option;

    }
}
