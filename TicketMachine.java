/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.baptisterio;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author acabezam
 */
public class TicketMachine {
    private HashMap<String, Integer> tickets = new HashMap<String, Integer>();  // Integer son los tickets vendidos en esa fecha
    private int totalCoins;
    private int userCoins ;
    private static final int TICKETPRICE = 4;
    private static final int MAXTICKETSPERDAY = 10;
    
    public TicketMachine(){
        totalCoins = 0;
        userCoins = 0;
    };
    
    public void insertCoin(int numCoins){
        userCoins += numCoins;
    }
    
    public boolean correctImport(int ticketsDesired){

        return ticketsDesired*TICKETPRICE == userCoins;
        
    }
    
    public int returnChange(){
        int change = userCoins;
        userCoins = 0;
        
        return change;
        
    }
    
    public boolean enoughTicketsInDate(String date, int ticketsDesired){
        return MAXTICKETSPERDAY - tickets.get(date) >= ticketsDesired;
    }
    
    public boolean isUsedDate(String date){
        
        return tickets.containsKey(date);
        
    }
    
    public void addDate(String date){
        Integer ticketsSold = 0;
        tickets.put(date, ticketsSold);
    }
    
    public void buyTickets(String date, int ticketsDesired){
        Integer ticketsSold = tickets.get(date).intValue() + ticketsDesired;
        tickets.replace(date, ticketsSold);
        
        totalCoins += userCoins;
        userCoins = 0;
    }
    
    public int getTicketPrice(){
        return TICKETPRICE;
    }
    
    public int getMaxTicketsPerDay(){
        return MAXTICKETSPERDAY;
    }
    
}
