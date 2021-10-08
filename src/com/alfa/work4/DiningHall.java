package com.alfa.work4;

public class DiningHall {
    static int pizzaNum;
    static int studentID = 1;
    public void makePizza() {
        pizzaNum++;
    }
    public void servePizza() {
        String result;
        if (pizzaNum > 0) {
            result = "Served ";
            pizzaNum--;
        } else result = "Starved ";
        System.out.println(result + studentID);
        studentID++;
    }
}
