import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pets {

    //Attributes
    private String name;
    private String animalType;   //Dog, cat, hamster, etc;
    private String animalBreed;
    private String dateOfBirth;  //yyyy-mm-dd
    private char gender;         //M/F
    private double weight;       //in kg
    private String owner;        //Name
    private int id;


    //no-argument constructor
    public Pets() {
    }

    //METHOD TO CALCULATE AGE
    public void petAge() {

        LocalDate start = LocalDate.parse(dateOfBirth);
        LocalDate end = LocalDate.now();
        long ageInMonths = ChronoUnit.MONTHS.between(start, end);

        if (ageInMonths > 12) {
            int ageInYears = (int) ageInMonths/12;
            System.out.println(ageInYears + " years old!");
        } else if ((ageInMonths > 0) && (ageInMonths < 12)){
            System.out.println(ageInMonths + " months old!");
        } else {
            System.out.println("Hmm.. looks like the birthday hasn't been added for this pet!");
        }
    }





    //TO-STRING METHOD
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
