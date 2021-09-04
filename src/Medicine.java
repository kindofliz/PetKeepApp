public class Medicine {

    //Attributes
    private String typeOfMeds;  //Tick and Flea prevention (Nexgard)
    private int regularity; //in months
    private String dateGiven;
    private String dateToGiveNext;


    //no-argument constructor
    public Medicine () {
    }


    //TO-STRING METHOD
    @Override
    public String toString() {
        return "Medicine{" +
                "typeOfMeds='" + typeOfMeds + '\'' +
                ", dateGiven='" + dateGiven + '\'' +
                ", dateToGiveNext='" + dateToGiveNext + '\'' +
                '}';
    }


    //GETTERS AND SETTERS
    public String getNameOfMedicine() {
        return typeOfMeds;
    }

    public void setNameOfMedicine(String nameOfMedicine) {
        this.typeOfMeds = nameOfMedicine;
    }

    public String getDateGiven() {
        return dateGiven;
    }

    public void setDateGiven(String dateGiven) {
        this.dateGiven = dateGiven;
    }

    public String getDateToGiveNext() {
        return dateToGiveNext;
    }

    public void setDateToGiveNext(String dateToGiveNext) {
        this.dateToGiveNext = dateToGiveNext;
    }
}