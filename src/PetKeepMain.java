import java.util.Locale;
import java.util.Scanner;

public class PetKeepMain {
    public static void main(String[] args) {

        DBConnection petKeepDb = new DBConnection();

        Scanner scanner = new Scanner(System.in);

        int menuItem;

        do {
            System.out.println("~~~~~~~");
            System.out.println("HELLO");
            System.out.println("~~~~~~~");
            System.out.println("CHOOSE YOUR OPTION");
            System.out.println("1. - ADD A NEW PET");
            System.out.println("2. - SEE LIST OF PETS");
            System.out.println("3. - SEE A PET'S PROFILE");
            System.out.println("4. - SEE THE VACCINATION SCHEDULE");
            System.out.println("5. - SEE MEDICATION SCHEDULE");
            System.out.println("6. - ADD FOOD INFORMATION");
            System.out.println("7. - ADD A NEW MEDICINE FOR A PET");
            System.out.println("8. - ADD A NEW VACCINE FOR A PET"); //how to make this happen for each pet separately?
            System.out.println("9. - DELETE MEDICINE FOR A PET");
            System.out.println("10. - DELETE VACCINE FOR A PET");
            System.out.println("11. - DELETE FOOD FOR A PET");
            System.out.println("12. - DELETE A PET :(");
            System.out.println("0. - EXIT");
            menuItem = scanner.nextInt();

            switch (menuItem) {
                case 1:
                    // Creating a new Pets object
                    Pets myPet = new Pets();

                    // Moved method to the bottom of PetKeepMain
                    addAPet(scanner, myPet);

                    //Testing until we add databases
                    System.out.println("******TEST******");
                    System.out.println(myPet);
                    System.out.println("****************");

                    //Calling the method that inserts this into database (needs to be created)
                    petKeepDb.createPet(myPet);

                    break;
                case 2:
                    System.out.println("================= LIST OF PETS ================");
                    //Need to create a method in DBConnection to get only names from the table
                    petKeepDb.seeAllPets();

                    //Method to show all pet names. to be located in DBConnections?
//                    public ArrayList<Pets> getPetNames() {
//
//                    ArrayList<Pets> petList = new ArrayList<Pets>();
//
//                    try {
//
//                        Statement statement = conn.createStatement();
//                        String sqlStatement = "SELECT name FROM pets";
//
//                        ResultSet rs = statement.executeQuery(sqlStatement);
//
//                        while (rs.next()) {
//                            //Create a new Pets object
//                            Pets pet = new Pets();
//                            myPet.setName(rs.getString("name"));
//
//                            System.out.println(pet.getName());
//                        }
//
//
//                    } catch (SQLException exception) {
//                        System.out.println("Error getting Heroes list: " + exception);
//                    }
//                    return petList;
//                }

                    System.out.println("================= LIST OF PETS ================");
                    System.out.println();

                    break;
                case 3:

                    System.out.println("Enter a name from the pet list: ");
                    //Calling the method to SELECT all the info about chosen pet from DB
//                    petKeepDb.getOnePet();
                    System.out.println();

                    //Method located in DBConnections?
//                    public ArrayList<Pets> getOnePet() {
//
//                    ArrayList<Pets> petJustOne= new ArrayList<Pets>();
//
//                    try {
//
//                        Statement statement = conn.createStatement();
//                        String sqlStatement = "SELECT * FROM pets WHERE name = " + "\'" + scanner.next() + "\'";
//
//                        ResultSet rs = statement.executeQuery(sqlStatement);
//
//                        while (rs.next()) {
//                            //Create a new Hero object
//                            Pets pet = new Pets();
//                            pet.setName(rs.getString("name"));
//                            pet.setAnimalType(rs.getString("animal_type"));
//                            pet.setAnimalBreed(rs.getString("animal_breed"));
//                            pet.setDateOfBirth(rs.getString("date_of_birth"));
//                            pet.setGender(rs.getString("gender").charAt(0));
//                            pet.setWeight(rs.getDouble("weight"));
//                            pet.setOwner(rs.getString("owner"));
//
//
//                            System.out.println(pet.toString());
//                        }
//
//
//
//                    } catch (SQLException exception) {
//                        System.out.println("Error getting Heroes list: " + exception);
//                    }
//
//                    return petJustOne;
//                }


                    break;
                case 4:

                    //                    ResultSet resultSet = statement.executeQuery("SELECT * from foo");
                    //ResultSetMetaData rsmd = resultSet.getMetaData();
                    //int columnsNumber = rsmd.getColumnCount();
                    //while (resultSet.next()) {
                    //    for (int i = 1; i <= columnsNumber; i++) {
                    //        if (i > 1) System.out.print(",  ");
                    //        String columnValue = resultSet.getString(i);
                    //        System.out.print(columnValue + " " + rsmd.getColumnName(i));
                    //    }
                    //    System.out.println("");
                    //}

                    break;
                case 5:

                    break;
                case 6:
//                    6. - ADD FOOD INFORMATION
                    // Creating a new Food object
                    Food foodInfo = new Food();

                    // Moved method to the bottom of PetKeepMain
                    addFood(scanner, foodInfo);

                    //Testing until we add databases
                    System.out.println("******TEST******");
                    System.out.println(foodInfo);
                    System.out.println("****************");

                    //Calling the method that inserts this into database (needs to be created)
                    petKeepDb.createFood(foodInfo);

                    break;
                case 7:

                    Medicine medicineInfo = new Medicine();

                    // Moved method to the bottom of PetKeepMain
                    addMedicine(scanner, medicineInfo);

                    //Testing until we add databases
                    System.out.println("******TEST******");
                    System.out.println(medicineInfo);
                    System.out.println("****************");

                    //Calling the method that inserts this into database (needs to be created)
                    petKeepDb.createMedicine(medicineInfo);

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:

                    break;
                case 12:

                    break;
                case 13:

                    break;
                default:
                    if (menuItem != 0)
                        System.out.println("Menu item does not exist!");
                    System.out.println();
            }


        } while (menuItem != 0);


    }

    public static void addAPet(Scanner scanner, Pets myPet) {

        // 1. Asking user to input their pet's name with some validation
        String name;
        int checkName = 0;

        do {
            System.out.println("Enter your pet's name:");
            name = scanner.next();
            if (name.matches("[A-Z][a-zA-Z']*")) {
                myPet.setName(name);
                checkName = 1;
            } else {
                System.out.println("Invalid name.. try again.");
            }
        } while (checkName == 0);


        // 2. Asking user to input their pet's type with some validation
        String type;
        int checkType = 0;

        do {
            System.out.println("What type of animal is it? (Dog, Cat, etc.)");
            type = scanner.next().toUpperCase(Locale.ROOT);
            if (type.matches("[a-zA-Z]*")) {
                myPet.setAnimalType(type);
                checkType = 1;
            } else {
                System.out.println("Invalid animal type.. try again.");
            }
        } while (checkType == 0);


        // 3. Asking user to input their pet's breed with some validation
        String breed;
        int checkBreed = 0;

        do {
            System.out.println("Enter your pet's breed:");
            scanner.nextLine(); //making sure the cursor moves to the new line before scanning
            breed = scanner.next();
            if (breed.matches("[a-zA-Z'\\s+]*")) {
                myPet.setAnimalBreed(breed);
                checkBreed = 1;
            } else {
                System.out.println("Invalid breed.. try again.");
            }
        } while (checkBreed == 0);


        // 4. Asking user to input their pet's birthday
        String dateOfBirth;
        int checkDate = 0;

        do {
            System.out.println("Enter your pet's birthday (dd/mm/yyyy):");
            dateOfBirth = scanner.next();
            if (dateOfBirth.matches("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$")) {
                myPet.setDateOfBirth(dateOfBirth);
                checkDate = 1;
            } else {
                System.out.println("Invalid date format.. try again.");
                System.out.println();
            }
        } while (checkDate == 0);


        // 5. Asking user to input their pet's gender
        System.out.println("Is your pet male (M) or female (F)?");
        char gender = scanner.next().toUpperCase(Locale.ROOT).charAt(0);
        myPet.setGender(gender);


        // 6. Asking user to input their pet's weight
        double weight;
        int checkWeight = 0;

        do {
            System.out.println("Your pet's weight (kg): ");
            weight = scanner.nextDouble();
            if (weight > 0) {
                myPet.setWeight(weight);
                checkWeight = 1;
            } else {
                System.out.println("Invalid weight.. try again.");
                System.out.println();
            }
        } while (checkWeight == 0);


        // 7. Asking user to input their pet's owner
        String owner;
        int checkOwner = 0;

        do {
            System.out.println("Enter owner's name: ");
            scanner.nextLine(); //making sure the cursor moves to the new line before scanning
            owner = scanner.next();
            if (owner.matches("[A-Z][a-zA-Z'.\\s+]*")) {
                myPet.setOwner(owner);
                checkOwner = 1;
            } else {
                System.out.println("Invalid owner's name.. try again.");
            }
        } while (checkOwner == 0);
    }

    public static void addFood(Scanner scanner, Food foodInfo) {
//
//////             private String foodBrand;
//////    private int foodBagWeight;
//////    private int dailyAmount; //in grams
//////    private String purchaseDate;
//
//        // 1. Asking user to input their Food brand with some validation
        String foodBrand;
        int checkBrand = 0;

        do {
            System.out.println("Enter your food brand you bought:");
            foodBrand = scanner.next();
            if (foodBrand.matches("[A-Z][a-zA-Z']*")) {
                foodInfo.setFoodBrand(foodBrand);
                checkBrand = 1;
            } else {
                System.out.println("Invalid food brand.. try again.");
            }
        } while (checkBrand == 0);

//
//        // 2. Asking user to input food bag weight with some validation
        int foodBagWeight = 0;
        String foodBagWeightAsString = String.valueOf(foodBagWeight);
        int checkWeight = 0;

        do {
            System.out.println("Enter food bag weight (g):");
            foodBagWeightAsString = scanner.next();
            if (foodBagWeightAsString.matches("[0-9]")) {
                foodInfo.setFoodBagWeight(foodBagWeight);
                checkWeight = 1;
            } else {
                System.out.println("Invalid food bag weight.. try again.");
            }
        } while (checkWeight == 0);

//
//        // 3. Asking user to input daily amount with some validation
        int dailyAmount = 0;
        String dailyAmountAsString = String.valueOf(dailyAmount);
        int checkAmount = 0;

        do {
            System.out.println("Enter food bag weight:");
            dailyAmountAsString = scanner.next();
            if (dailyAmountAsString.matches("[0-9]")) {
                foodInfo.setDailyAmount(dailyAmount);
                checkAmount = 1;
            } else {
                System.out.println("Invalid food bag weight.. try again.");
            }
        } while (checkAmount == 0);

//
//        // 4. Asking user to input purchase date
        String dateOfPurchase;
        int checkDate = 0;

        do {
            System.out.println("Enter purchase date (dd/mm/yyyy):");
            dateOfPurchase = scanner.next();

//            regex needs to be checked

            if (dateOfPurchase.matches("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$")) {
                foodInfo.setPurchaseDate(dateOfPurchase);
                checkDate = 1;
            } else {
                System.out.println("Invalid date format.. try again.");
                System.out.println();
            }
        } while (checkDate == 0);

    }

    public static void addMedicine(Scanner scanner, Medicine medicineInfo) {

//  private String typeOfMeds;  //Tick and Flea prevention (Nexgard)
//    private int regularity; //in months
//    private String dateGiven;
//    private String dateToGiveNext;

        // 1. Asking user to input their name of medicine with some validation
        String typeOfMeds;
        int checkType = 0;

        do {
            System.out.println("Enter name of the medicine:");
            typeOfMeds = scanner.next();
            if (typeOfMeds.matches("[A-Z][a-zA-Z']*")) {
                medicineInfo.setNameOfMedicine(typeOfMeds);
                checkType = 1;
            } else {
                System.out.println("Invalid medicine name.. try again.");
            }
        } while (checkType == 0);


        // 2. Asking user to input regularity with some validation
        int regularity = 0;
        String regularityAsString = String.valueOf(regularity);
        int checkRegularity = 0;

        do {
            System.out.println("Enter regularity (in months):");
            regularityAsString = scanner.next();
            if (regularityAsString.matches("[0-9]")) {
                medicineInfo.setRegularity(regularity);
                checkRegularity = 1;
            } else {
                System.out.println("Insert regularity in months.. try again.");
            }
        } while (checkRegularity == 0);


        // 3. Asking user to input first date given with some validation
        String dateGiven;
        int checkDate = 0;

        do {
            System.out.println("Enter first date medicine was given (dd/mm/yyyy):");
            dateGiven = scanner.next();
            if (dateGiven.matches("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$")) {
                medicineInfo.setDateGiven(dateGiven);
                checkDate = 1;
            } else {
                System.out.println("Invalid date format.. try again.");
            }
        } while (checkDate == 0);


        // 4. Asking user to input next date to give medicine
        String dateToGiveNext;
        int checkNextDate = 0;

        do {
            System.out.println("Enter next date to give medicine (dd/mm/yyyy):");
            dateToGiveNext = scanner.next();
//            regex needs to be checked
            if (dateToGiveNext.matches("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$")) {
                medicineInfo.setDateToGiveNext(dateToGiveNext);
                checkNextDate = 1;
            } else {
                System.out.println("Invalid date format.. try again.");
                System.out.println();
            }
        } while (checkNextDate == 0);

    }


}
