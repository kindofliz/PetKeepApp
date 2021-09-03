public class Vaccines {

    //Attributes
    private String nameOfVaccine;  // maybe better to mention what the vaccine is for and make brand as part of this string
    private String regularityOfVaccine;  // next date or period that vaccine is valid ?


    //no-argument constructor
    public Vaccines () {
    }


    //METHODS
    @Override
    public String toString() {
        return "Vaccines{" +
                "nameOfVaccine='" + nameOfVaccine + '\'' +
                ", regularity='" + regularityOfVaccine + '\'' +
                '}';
    }


    //GETTERS AND SETTERS
    public String getNameOfVaccine() {
        return nameOfVaccine;
    }

    public void setNameOfVaccine(String nameOfVaccine) {
        this.nameOfVaccine = nameOfVaccine;
    }

    public String getRegularity() {
        return regularityOfVaccine;
    }

    public void setRegularity(String regularity) {
        this.regularityOfVaccine = regularity;
    }
}
