public class Vaccines{

    //Attributes
    private String vaccinationType;  //e.g. Annual
    private String dateVaccinated;
    private String dateToVaccinateNext;
    private int petId;


    //no-argument constructor
    public Vaccines () {
    }


    //METHODS
    @Override
    public String toString() {
        return "Vaccines{" +
                "vaccinationType='" + vaccinationType + '\'' +
                ", dateVaccinated='" + dateVaccinated + '\'' +
                ", dateToVaccinateNext='" + dateToVaccinateNext + '\'' +
                '}';
    }


    //GETTERS AND SETTERS

    public String getVaccinationType() {
        return vaccinationType;
    }

    public void setVaccinationType(String vaccinationType) {
        this.vaccinationType = vaccinationType;
    }

    public String getDateVaccinated() {
        return dateVaccinated;
    }

    public void setDateVaccinated(String dateVaccinated) {
        this.dateVaccinated = dateVaccinated;
    }

    public String getDateToVaccinateNext() {
        return dateToVaccinateNext;
    }

    public void setDateToVaccinateNext(String dateToVaccinateNext) {
        this.dateToVaccinateNext = dateToVaccinateNext;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }
}
