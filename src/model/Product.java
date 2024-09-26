
package model;



public class Product  {
    protected String id;
    protected String name;
    protected String BrandId;
    protected String categoryId;
    protected int modelYear;
    protected float listPrice;
  
    public Product(String id, String name, String BrandId, String categoryId, int modelYear, float listPrice ) {
        this.id = id;
        this.name = name;
        this.BrandId = BrandId;
        this.categoryId = categoryId;
        this.modelYear = modelYear;
        this.listPrice = listPrice;
        
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandId() {
        return BrandId;
    }

    public void setBrandId(String BrandId) {
        this.BrandId = BrandId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public float getListPrice() {
        return listPrice;
    }

    public void setListPrice(float listPrice) {
        this.listPrice = listPrice;
    }

    @Override
    public String toString() {
        return id +"," + name + "," + BrandId + "," + categoryId + "," + modelYear + "," + listPrice;
    }
    
    
    
    public void print(){
        System.out.printf("Id: %s, Name: %s, Brand ID: %s, Category ID: %s, Model Year: %d, List Price: %.3f\n", id,name,BrandId,categoryId,modelYear,listPrice);
    }

}


