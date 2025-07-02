package org.example;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Pizza Ordering mini capstone
 */
public class Main {
    static ArrayList<String> pizzas = new ArrayList<>();
    static ArrayList<Integer> quantities = new ArrayList<>();

    public static void main(String[] args) {
        int option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add Order");
        System.out.println("2. Update Order");
        System.out.println("3. Remove Order");
        System.out.println("4. View Order");
        System.out.println("5. Exit");
        //loop until option is Exit
        do {
            System.out.print("\nChoose option: ");
            option = Integer.parseInt(scanner.nextLine());
            processOption(option, scanner);
        }while(option != 5);
    }

    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities,
                                String pizzaType, int quantity){
        //add pizzatype and quantity to arraylist
        if(quantity > 0) {
            pizzas.add(pizzaType);
            quantities.add(quantity);
        }
    }

    public static void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity){
        //update quantity of order based on index
        if(index < quantities.size() && newQuantity > 0) {
            quantities.set(index, newQuantity);
        }
    }

    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index){
        //remove order based on index
        if(index < pizzas.size()) {
            pizzas.remove(index);
            quantities.remove(index);
        }
    }

    public static void printOrders(ArrayList<String> pizzas, ArrayList<Integer> quantities){
        //print current order
        System.out.println("\n--- Current Orders ---");
        for(int i = 0; i < pizzas.size(); i++){
            System.out.print(i + 1);
            System.out.println(". ".concat(pizzas.get(i)).concat(" x ").concat(String.valueOf(quantities.get(i))));
        }
    }

    public static void processOption(int option, Scanner scanner){
        switch (option){
            case 1:
                System.out.print("Pizza type: ");
                String pizzaType = scanner.nextLine();
                System.out.print("Quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                addOrder(pizzas, quantities, pizzaType, quantity);
                break;
            case 2:
                System.out.print("Order number to update: ");
                int orderNumber = Integer.parseInt(scanner.nextLine()) - 1;
                //checks if order number exist
                if(orderNumber >= pizzas.size()){
                    System.out.println("Order number does not exist!");
                    break;
                }
                System.out.print("New quantity: ");
                int newQuantity = Integer.parseInt(scanner.nextLine());
                updateOrder(quantities, orderNumber, newQuantity);
                break;
            case 3:
                System.out.print("Order number to remove: ");
                int removeOrder = Integer.parseInt(scanner.nextLine()) - 1;
                //checks if order number exist
                if(removeOrder >= pizzas.size()){
                    System.out.println("Order number does not exist!");
                    break;
                }
                removeOrder(pizzas, quantities, removeOrder);
                break;
            case 4:
                printOrders(pizzas, quantities);
                break;
            case 5:
                System.out.println("---Thank you!---");
                break;
            default:
                System.out.println("Invalid! Please only choose from options 1-5.");
                break;
        }
    }

}