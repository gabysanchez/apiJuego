package com.gabysanchez.apiJuego.ui;

import com.gabysanchez.apiJuego.dao.DAOFactory;
import com.gabysanchez.apiJuego.entities.Data;
import com.gabysanchez.apiJuego.entities.Player;
import com.gabysanchez.apiJuego.entities.UserToken;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public Menu() {
        start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("    * * * API Console * * *\n" +
                "    - 1) Get All Tokens\n" +
                "    - 2) Get Token\n" +
                "    - 3) Get Token Contain Character\n" +
                "    - 4) Add Token\n");
        System.out.print("  Select option: ");
        String comand = scanner.nextLine();
        switch (comand) {
            case "1":
                getAll();
                break;
            case "2":
                get();
                break;
            case  "3":
                getCharacter ();
                break;
            case "4":
                addToken();
                break;
        }
    }
    private void getAll () {
        List<UserToken> userTokens = DAOFactory.getInstance().getDAOUserToken().get();
        for (UserToken userToken : userTokens) {
            System.out.println(userToken);
        }
    }
    private void get(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n        Select id: ");
        String comand = scanner.nextLine();
        UserToken userToken = DAOFactory.getInstance().getDAOUserToken().get(Integer.valueOf(comand));
        System.out.println(userToken);
        String back = scanner.nextLine();
        start();
    }
    private void getCharacter () {

        List<UserToken> userTokens = DAOFactory.getInstance().getDAOUserToken().get();
        for (UserToken userToken : userTokens) {
            if (userToken.getCharacters()!=null){
                System.out.println(userToken);
            }
        }
        start();
    }
    private void addToken(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n        Select id_DB: ");
        String comand = scanner.nextLine();
        Player player = DAOFactory.getInstance().getDAOPlayerORM().get(comand);
        DAOFactory.getInstance().getDAOUserToken().create(player);
        System.out.println("\n          Successfully Created!!");
        String back = scanner.nextLine();
        start();
    }
}
