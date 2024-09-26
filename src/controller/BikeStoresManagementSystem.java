package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import model.Product;
import utilities.Validation;

public class BikeStoresManagementSystem extends ArrayList<Product> {

    private final String filePath = "src/fileio/Product.txt";
    ArrayList<String> listBrandId = new ArrayList<>();
    ArrayList<String> listCategoryId = new ArrayList<>();

    public boolean addProduct(Product pro) {
        if (pro == null) {
            return false;
        }
        this.add(pro);
        return true;
    }

    public void addProducts() throws IOException, ClassNotFoundException {
        Product pro = null;
        String id, name, brandId , categoryId;
        int modelYear;
        float listPrice;
        do {
            id = Validation.checkString("Enter id: ");
        } while (isExistProductId(id));
        name = Validation.checkString("Enter name product: ");
        do {
            brandId = Validation.checkString("Enter Brand ID: ");
          } while (isExistBrandId(brandId));

        do {
            categoryId = Validation.checkString("Enter Category ID: ");
        } while (isExistCategoryId(categoryId));

        modelYear = Validation.checkInt("Enter Model Year: ");

        listPrice = Validation.checkFloat("Enter List Price: ");

        pro = new Product(id, name, brandId, categoryId, modelYear, listPrice);

        if (pro != null) {
            addProduct(pro);
        }
        System.out.println("\033[0;32m" + "The new product has been add successfully");
        System.out.print((char) 27 + "[30m");

    }

    public void updateProduct() {
        System.err.println("If you want to hold old value, you can enter a blank to hold");
        Scanner sc = new Scanner(System.in);
        String Id = Validation.checkString("Enter id: ");
        if (getProduct(Id) == null) {
            System.out.println("Product does not exist");
        } else {
            Product pro = (Product) getProduct(Id);
            System.out.println("Enter new Name: ");
            String name = sc.nextLine();
            if (!name.isEmpty()) {
                pro.setName(name);
            }
            System.out.print("Enter new Brand ID: ");
            String BrandId = sc.nextLine();
            if (!BrandId.isEmpty()) {
                pro.setBrandId(BrandId);
            }
            System.out.print("Enter new Category ID: ");
            String categoryId = sc.nextLine();
            if (!categoryId.isEmpty()) {
                pro.setCategoryId(categoryId);
            }
            System.out.print("Enter new Model Year: ");
            String year = sc.nextLine();
            if (!year.isEmpty()) {
                int modelYear = Integer.parseInt(year);
                pro.setModelYear(modelYear);

            }
            System.out.print("Enter new List Price: ");
            String check = sc.nextLine();
            if (!check.isEmpty()) {
                float listPrice = Float.parseFloat(check);
                pro.setListPrice(listPrice);
            }
            System.out.println("\033[0;32m" + "Update Success");
            System.out.print((char) 27 + "[30m");

        }
    }
   
    
    public void SearchProductInformationByName() {
        boolean check = true;
        String name = Validation.checkString("Enter name product: ");
        Collections.sort(this, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Integer.compare(p1.getModelYear(), p2.getModelYear());
            }
        });
        for (Product pro : this) {
            if(pro.getName().toLowerCase().contains(name.toLowerCase())) {
                pro.print();
                check = false;
            }
        }
        if(check) {
            System.out.println("Have no any Product");
        }
    }
 
  
    
 
    public void deleteProduct() {
        String Id = Validation.checkString("Enter ID: ");
        if (getProduct(Id) == null) {
            System.out.println("Product does not exist");
            
        } else {
            String yesNo = Validation.checkYesNo("Are you sure to delete this product?\n Press:\n Y = Yes\n N = No\n");
            if(yesNo.equalsIgnoreCase("Y")) {
                this.remove(getProduct(Id));
                System.out.println("Delete Success");
                
            } else if(yesNo.equalsIgnoreCase("N")){
                System.err.println("Delete Failure");
                
            }
        }
    }
    
  
    
    public void saveToFile() throws IOException {
        File file = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Product product : this) {
                
                    writer.write(product.getId() + "," + product.getName() + "," + product.getBrandId() + ","
                            + product.getCategoryId() + "," + product.getModelYear() + "," + product.getListPrice());
                    writer.newLine();
                
            }
            System.out.println("Product information saved to  " + filePath + " successfully");
        } catch (IOException e) {
            System.err.println("Error while writing to file: " + e.getMessage());
            throw e;
        }
    }

    public void loadFromFile() throws IOException, ClassNotFoundException {
        File file = new File(filePath);
        if(!file.exists()){ 
            System.out.println("File don't exist");
            return;
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = reader.readLine()) != null ) {
                if(!line.trim().isEmpty()) {
                    String[] data = line.split(",");
                    String id = data[0];
                    String name = data[1];
                    String brandId = data[2];
                    String categoryId = data[3];
                    int modelYear = Integer.parseInt(data[4]);
                    float listPrice = Float.parseFloat(data[5]);
                    if(!isExistProductId(id)) {
                        this.add(new Product(id, name, brandId, categoryId, modelYear, listPrice));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error when write file: " + e.getMessage());
            throw e;
        }
    }
   
     public void printAllProduct() throws IOException, ClassNotFoundException {
        loadFromFile();
        Collections.sort(this, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                if (p1.getListPrice() != p2.getListPrice()) {
                    return Float.compare(p2.getListPrice(), p1.getListPrice());
                }
                return p1.getName().compareTo(p2.getName());
            }
        });
        System.out.printf("%-10s %-20s %-20s %-20s %-10s       %-10s\n",
                "ID", "Name", "Brand ID", "Category ID", "Model Year", "List Price");
        for (Product pro : this) {
            System.out.printf("%-10s %-20s %-20s %-20s %-10d       %-10.3f\n", pro.getId(), pro.getName(), pro.getBrandId(), pro.getCategoryId(), pro.getModelYear(), pro.getListPrice());
        }
    }
    
   
            
    public Product getProduct(String Id) {
        for (Product pro : this) {
            if (pro.getId().equalsIgnoreCase(Id)) {
                return pro;
            }
        }
        return null;
    }
     public void readFileBrandId() throws IOException, ClassNotFoundException {
        String brandId = "src/fileio/Brand_id.txt";
        File file = new File(brandId);
        if (!file.exists()) {
            System.out.println("File don't exist");
            return ;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] data = line.split(",");
                    String id = data[0];
                    String name = data[1];
                    String country = data[2];
                    listBrandId.add(id);                                       
                }
            }
        } catch (IOException c) {
            System.err.println("Error when write file: " + c.getMessage());
        }
    }
     

      public void readFileCatagoryId() throws FileNotFoundException, IOException {
        String CategoryId = "src/fileio/Category_id.txt";
        File file = new File(CategoryId);
        if(!file.exists()) {
            System.out.println("File don't exits");
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                listCategoryId.add(id);
            }
        }catch (IOException c) {
            System.err.println("Error when write file: " + c.getMessage());
        }
    }
       public boolean isExistBrandId(String brandId) throws IOException, ClassNotFoundException {
        readFileBrandId();
        for(String brand : listBrandId) {
            if(brand.equalsIgnoreCase(brandId)){
                return true;
            }
        }
        return false;
    }
    
    public boolean isExistCategoryId(String categoryId) throws IOException, ClassNotFoundException {
        readFileCatagoryId();
        for(String category : listCategoryId) {
            if(category.equalsIgnoreCase(categoryId)){
                return true;
            }
        }
        return false;
    }
    
    public boolean isExistProductId(String id) {
        return getProduct(id) != null;
    }

    
    

}
