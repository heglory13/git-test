package viewer;

import java.util.Scanner;

public class Menu {

    public static void showMenu() {
        System.out.println("");
        System.out.println("      **********************************************************");
        System.out.println("      *        WELCOME TO OPTIONS WITH BIKES STORES MANAGEMENT *");
        System.out.println("      **********************************************************");
        System.out.println("      *        1. Add a product                                *");
        System.out.println("      *        2. Search product by product name               *");
        System.out.println("      *        3. Update product                               *");
        System.out.println("      *        4. Delete product                               *");
        System.out.println("      *        5. Save products to file.                       *");
        System.out.println("      *        6. Print list products from the file            *");
        System.out.println("      *        Others - Quit.                                  *");
        System.out.println("      **********************************************************");
        System.out.println("      **(Note: Your options from 1 - 6)");
    }

    public static void addProduct() {
        System.out.println("");
        System.out.println("       ---------------------------------------------------------");
        System.out.println("      |               ADD THE INFORMATION OF PRODUCT            |");
        System.out.println("      |---------------------------------------------------------|");
        System.out.println("      |               1. Add Product                            |");
        System.out.println("      |               2. Exit                                   |");
        System.out.println("       ---------------------------------------------------------");
        System.out.println("\n      **(Note: Your options from 1 - 2)");
    }

    public static void searchProduct() {
        System.out.println("");
        System.out.println("       -------------------------------------------------------");
        System.out.println("      |             SEARCH THE INFORMATION OF PRODUCT         |");
        System.out.println("      |-------------------------------------------------------|");
        System.out.println("      |               1. Search product with name             |");
        System.out.println("      |               2. Exit                                 |");
        System.out.println("       -------------------------------------------------------");
        System.out.println("\n      **(Note: Your options from 1 - 2)");
    }

    public static void updateMenu() {
        System.out.println("");
        System.out.println("       ---------------------------------------------------------");
        System.out.println("      |            UPDATE THE INFORMATION OF PRODUCT            |");
        System.out.println("      |---------------------------------------------------------|");
        System.out.println("      |               1. Update Product                         |");
        System.out.println("      |               2. Exit                                   |");
        System.out.println("       ---------------------------------------------------------");
        System.out.println("\n      **(Note: Your options from 1 - 2)");
    }
    
    public static void deleteMenu() {
        System.out.println("");
        System.out.println("       ---------------------------------------------------------");
        System.out.println("      |            REMOVE THE INFORMATION OF PRODUCT            |");
        System.out.println("      |---------------------------------------------------------|");
        System.out.println("      |               1. Delete Product                         |");         
        System.out.println("      |               2. Exit                                   |");
        System.out.println("       ---------------------------------------------------------");
        System.out.println("\n      **(Note: Your options from 1 - 2)");
    }
    
    public static void saveMenu() {
        System.out.println("");
        System.out.println("       ---------------------------------------------------------");
        System.out.println("      |             SAVE THE INFORMATION OF PRODUCT             |");
        System.out.println("      |---------------------------------------------------------|");
        System.out.println("      |               1. Save                                   |");         
        System.out.println("      |               2. Exit                                   |");
        System.out.println("       ---------------------------------------------------------");
        System.out.println("\n      **(Note: Your options from 1 - 2)");
    }
    
    public static void printProductMenu() {
        System.out.println("");
        System.out.println("       ---------------------------------------------------------");
        System.out.println("      |             PRINT THE INFORMATION OF PRODUCT            |");
        System.out.println("      |---------------------------------------------------------|");
        System.out.println("      |               1. Print all product                      |");         
        System.out.println("      |               2. Exit                                   |");
        System.out.println("       ---------------------------------------------------------");
        System.out.println("\n      **(Note: Your options from 1 - 2)");
    }
}

