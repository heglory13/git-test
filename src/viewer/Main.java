package viewer;

import controller.BikeStoresManagementSystem;
import utilities.Validation;

public class Main {

    public static void main(String[] args) {
        try { 
            BikeStoresManagementSystem bsms = new BikeStoresManagementSystem();
            int choice;
            do {
                Menu.showMenu();
                choice = Validation.checkInt("Please enter your choice: ", 7);
                switch (choice){
                    case 1:
                        int addChoice;
                        do {
                            Menu.addProduct();
                            addChoice = Validation.checkInt("Please enter your choice: ", 2);
                            switch (addChoice){
                                case 1:
                                    bsms.addProducts();
                                    break;
                            }
                        } while (addChoice == 1);
                        break;
                    case 2:
                        int findChoice;
                        do {
                            Menu.searchProduct();
                            findChoice = Validation.checkInt("Please enter your choice: ", 2);
                            switch (findChoice){
                                case 1:
                                    bsms.SearchProductInformationByName();
                                    break;
                            }
                        } while (findChoice == 1);
                        break;
                    case 3:
                        int updateProduct;
                        do {
                            Menu.updateMenu();
                            updateProduct = Validation.checkInt("Plese enter your choice: ", 2);
                            switch (updateProduct) {
                                case 1:
                                    bsms.updateProduct();
                                    break;
                            }
                        } while (updateProduct == 1);
                        break;
                    case 4:
                        int deleteProduct;
                        do {
                            Menu.deleteMenu();
                            deleteProduct = Validation.checkInt("Please enter your choice: ", 2);
                            switch (deleteProduct){
                                case 1:
                                    bsms.deleteProduct();
                                    break;
                            }
                        } while (deleteProduct == 1);
                        break;
                    case 5:
                        int saveFile;
                        do {
                            Menu.saveMenu();
                            saveFile = Validation.checkInt("Please enter your choice: ", 2);
                            switch (saveFile) {
                                case 1:
                                    bsms.saveToFile();
                                    break;
                            }
                        } while (saveFile == 1);
                        break;
                    case 6:
                        int printAllProduct;
                        do {
                            Menu.printProductMenu();
                            printAllProduct = Validation.checkInt("Please enter your choice: ", 2);
                            switch (printAllProduct) {
                                case 1:
                                bsms.printAllProduct();
                                break;
                            }
                        } while (printAllProduct == 1);
                        break;
                }   
            } while (choice < 7); 
            
        } catch (Exception c) {
            System.err.println(c.toString());
        }
       
    }
}  
