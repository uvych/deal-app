package com.vtb.gb.shop;

import com.vtb.gb.shop.config.PrepareDataApp;
import com.vtb.gb.shop.controller.UserController;

import java.util.Scanner;

public class ManyToManyApp {
    public static void main(String[] args) {
        PrepareDataApp.forcePrepareData();

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your command: ");
        String command = scan.next();
        String element = scan.nextLine();
        command = command.strip();
        element = element.strip();

        UserController userController = new UserController();
        userController.map(command,element);
    }
}
