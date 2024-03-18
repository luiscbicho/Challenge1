package com.luisbicho.challenge1;

import com.luisbicho.challenge1.entities.Order;
import com.luisbicho.challenge1.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class Challenge1Application implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(Challenge1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Code: ");
        int code = sc.nextInt();
        System.out.print("Basic Value: ");
        double basic = sc.nextDouble();
        System.out.print("Discount: ");
        double discount = sc.nextDouble();

        Order order = new Order(code,basic,discount);

        System.out.println("Order code: "+order.getCode());
        System.out.printf("Total value: $%.2f%n",orderService.total(order));


        sc.close();
    }
}
