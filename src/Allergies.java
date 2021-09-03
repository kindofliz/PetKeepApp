public class Allergies {

    //Attributes
    private String foodAllergies;
    private String medicineAllergies;
    private String other;

    // maybe we can at first make it easier like with only yes and no, but not as boolean but as char like we did in pets
    // private Char foodAllergies   //   Y/N
    // private Char medicineAllergies   //   Y/N
    // private Char other    //    Y/N

    //private String allergyNotes
    //maybe there could be something like this in the end to just write the specific details in a 'note'

    //no-argument constructor
    public Allergies(){
    }

    //METHODS


    @Override
    public String toString() {
        return "Allergies{" +
                "foodAllergies='" + foodAllergies + '\'' +
                ", medicineAllergies='" + medicineAllergies + '\'' +
                ", other='" + other + '\'' +
                '}';
    }

    //GETTERS AND SETTERS


    public String getFoodAllergies() {
        return foodAllergies;
    }

    public void setFoodAllergies(String foodAllergies) {
        this.foodAllergies = foodAllergies;
    }

    public String getMedicineAllergies() {
        return medicineAllergies;
    }

    public void setMedicineAllergies(String medicineAllergies) {
        this.medicineAllergies = medicineAllergies;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}