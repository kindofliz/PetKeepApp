import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Food {

    //Attributes
    private String foodBrand;
    private int foodBagWeight; //in kg
    private int dailyAmount; //in grams
    private String purchaseDate;
    private int petId;


    //no-argument constructor
    public Food () {
    }


    //METHODS
    @Override
    public String toString() {
        return "| Food brand: '" + foodBrand + '\'' +
                "| Purchased bag weight: " + foodBagWeight + " kg " +
                "| Daily feeding: " + dailyAmount + " grams " +
                "| Purchase date: '" + purchaseDate + '\'' +
                '|';
    }

    //In how many days will the food run out?
    public int foodDays() {

       int daysFoodWillLast = (foodBagWeight*1000)/dailyAmount;

        return daysFoodWillLast;
    }

    //Date when to buy new bag
    public String buyFood() {

        String date = purchaseDate;
        LocalDate localDate = LocalDate.parse(date);

        return localDate.plusDays(foodDays()).toString();
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

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }
}