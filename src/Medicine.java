public class Medicine {

    //Attributes
    private String typeOfMeds;  //Tick and Flea prevention (Nexgard)
    private int regularity; //in months
    private String dateGiven;
    private String dateToGiveNext;
    private int petId;


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
    public String getTypeOfMeds() {
        return typeOfMeds;
    }

    public void setTypeOfMeds(String typeOfMeds) {
        this.typeOfMeds = typeOfMeds;
    }

    public int getRegularity() {
        return regularity;
    }

    public void setRegularity(int regularity) {
        this.regularity = regularity;
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

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }
}