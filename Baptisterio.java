/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.curso.baptisterio;

import java.util.Scanner;

/**
 *
 * @author acabezam
 */
public class Baptisterio {

    public static void main(String[] args) {
        // Menu:
        // 1 -> Meter monedas 2 -> Comprar 3 -> Salir
        
        // Para comprar
            // Pedir la fecha
                // Comprobar si es nueva
                    // Añadirla
                // Pedirle el numero de tickets
                // Comprobar si hay suficientes tickets en esa fecha
                // Comprobar que el dinero introducido sea el importe justo
                // Comprar
        Scanner sc = new Scanner(System.in);
        TicketMachine machine = new TicketMachine();
        int action = -1;
        int coins;
        String date;
        String menu = """
                    Welcome to the baptistery. The price of the tickets is  
                    """ + " " + machine.getTicketPrice() + " " + """
                    and you can only buy """ + " " + machine.getMaxTicketsPerDay() + 
                    " " + """
                    tickets per day. Press:
                        1) Insert Coin
                        2) Buy ticket
                        3) Exit
                    """;
        
        while (action != 3){
            System.out.println(menu);
            
            action = sc.nextInt();
            
            switch(action){
                case 1:
                    System.out.println("How many coins do you want to insert?");
                    coins = sc.nextInt();
                    machine.insertCoin(coins);
                    break;
                case 2:
                    System.out.println("In what date do you want to order the date?");
                    date = sc.next();
                    
                    int num_tickets = 0;
                    
                    System.out.println("How many tickets do you want?");
                    num_tickets = sc.nextInt();
                    
                    while (num_tickets <= 0 && num_tickets >= 10){
                        System.out.println("Invalid number of tickets. Introduce a number between 0 and 10");
                        num_tickets = sc.nextInt();
                    }
                    
                    if (machine.enoughTicketsInDate(date, num_tickets)){
                        if (machine.correctImport(num_tickets)){
                            
                            if(!machine.isUsedDate(date)){
                                machine.addDate(date);
                            }
                            
                            machine.buyTickets(date, num_tickets);
                            System.out.println("Your reservation has been made!");
                        } else {
                            System.out.println("You have to insert the exact price of the tickets");
                            System.out.println("Get your change: " + machine.returnChange());
                        }
                    } else {
                        System.out.println("There isnt't enough tickets for this day");
                    }
                    break;
            }
            
            
        }
    }
}
