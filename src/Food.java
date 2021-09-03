public class Food {

    //Attributes
    private String foodBrand;
    private int foodBagWeight;
    private int dailyAmount;
    private String purchaseDate;
    private String foodPreferences;
    private String foodDislikes;


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
                ", foodPreferences='" + foodPreferences + '\'' +
                ", foodDislikes='" + foodDislikes + '\'' +
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

    public String getFoodPreferences() {
        return foodPreferences;
    }

    public void setFoodPreferences(String foodPreferences) {
        this.foodPreferences = foodPreferences;
    }

    public String getFoodDislikes() {
        return foodDislikes;
    }

    public void setFoodDislikes(String foodDislikes) {
        this.foodDislikes = foodDislikes;
    }


}