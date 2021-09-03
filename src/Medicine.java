public class Medicine {

    //Attributes
    private String nameOfMedicine;
    private  String regularityOfMedicine;


    //no-argument constructor
    public Medicine () {
    }


    //METHODS
    @Override
    public String toString() {
        return "Medicine{" +
                "nameOfMedicine='" + nameOfMedicine + '\'' +
                ", regularityOfMedicine='" + regularityOfMedicine + '\'' +
                '}';
    }


    //GETTERS AND SETTERS
    public String getNameOfMedicine() {
        return nameOfMedicine;
    }

    public void setNameOfMedicine(String nameOfMedicine) {
        this.nameOfMedicine = nameOfMedicine;
    }

    public String getRegularityOfMedicine() {
        return regularityOfMedicine;
    }

    public void setRegularityOfMedicine(String regularityOfMedicine) {
        this.regularityOfMedicine = regularityOfMedicine;
    }
}