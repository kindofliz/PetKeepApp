import java.util.Date;

public class Pets {

    //Attributes
    private String name;
    private String animalType;   //Dog, cat, hamster, etc;
    private String animalBreed;
    private String dateOfBirth;  //dd/MM/yyyy
    private char gender;         //M/F
    private double weight;       //in kg
    private String owner;        //Name
    private int id;
    //add allergies as string here


    //no-argument constructor
    public Pets() {
    }


    //METHODS
    @Override
    public String toString() {
        return "PET || " +
                "Name: '" + name + '\'' +
                " | Animal Type: '" + animalType + '\'' +
                " | Breed: '" + animalBreed + '\'' +
                " | Birthday: '" + dateOfBirth + '\'' +
                " | Gender: " + gender +
                " | Weight (Kg): " + weight +
                " | Owner: '" + owner + '\'' +
                " | ID: '" + id + '\'' +
                '|';
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
