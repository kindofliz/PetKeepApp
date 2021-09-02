public class Pets {

    //Attributes
    private String name;
    private String animalType;   //Dog, cat, hamster, etc;
    private String animalBreed;
    private String dateOfBirth;
    private char gender;         //M/F
    private int weight;
    private String owner;        //Name


    //no-argument constructor
    public Pets() {
    }


    //METHODS
    @Override
    public String toString() {
        return "Pets{" +
                "name='" + name + '\'' +
                ", animalType='" + animalType + '\'' +
                ", animalBreed='" + animalBreed + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender=" + gender +
                ", weight=" + weight +
                ", owner='" + owner + '\'' +
                '}';
    }


    //GETTERS AND SETTERS
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

    public String getAnimalBreed() {
        return animalBreed;
    }

    public void setAnimalBreed(String animalBreed) {
        this.animalBreed = animalBreed;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }





}
