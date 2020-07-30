package com.vtb.gb.shop.controller;

import com.vtb.gb.shop.repo.UserRepo;

public class UserController {
    private static UserRepo userRepo;

    public UserController() {
        userRepo = new UserRepo();
    }

    public void map(String command , String element) {
        if (command.equals("/showProductsByConsumer")) {
            System.out.println(userRepo.showProductsByConsume(element));
        }
        if (command.equals("/showConsumersByProductTitle")) {
            System.out.println(userRepo.showConsumersByProductTitle(element));
        }
        if (command.equals("/deleteConsumer")) {
            System.out.println(userRepo.deleteConsumer(element));
        }
        if (command.equals("/deleteProduct")) {
            System.out.println(userRepo.deleteProduct(element));
        }
        if (command.equals("/buy")) {
            System.out.println(userRepo.buy(element));
        }
    }
}

