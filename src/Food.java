public class Food extends Pets{

    //Attributes
    private String foodBrand;
    private int foodBagWeight; //in kg
    private int dailyAmount; //in grams
    private String purchaseDate;


    //no-argument constructor
    public Food () {
    }


    //METHODS
    @Override
    public String toString() {
        return "Food{" +
                "foodBrand='" + foodBrand + '\'' +
                ", foodBagWeight=" + foodBagWeight +
                ", dailyAmount=" + dailyAmount +
                ", purchaseDate='" + purchaseDate + '\'' +
                '}';
    }


    //GETTERS AND SETTERS
    public String getFoodBrand() {
        return foodBrand;
    }

    public void setFoodBrand(String foodBrand) {
        this.foodBrand = foodBrand;
    }

    public int getFoodBagWeight() {
        return foodBagWeight;
    }

    public void setFoodBagWeight(int foodBagWeight) {
        this.foodBagWeight = foodBagWeight;
    }

    public int getDailyAmount() {
        return dailyAmount;
    }

    public void setDailyAmount(int dailyAmount) {
        this.dailyAmount = dailyAmount;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }


}