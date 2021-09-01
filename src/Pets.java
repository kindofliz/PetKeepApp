public class Pets {

    //Attributes
    private String name;
    private String animalType;
    private String dateOfBirth;
    private char gender;
    private String owner;


    //no-argument constructor
    public Pets() {
    }


    //methods

    @Override
    public String toString() {
        return "Pets{" +
                "name='" + name + '\'' +
                ", animalType='" + animalType + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender=" + gender +
                ", owner='" + owner + '\'' +
                '}';
    }


    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
