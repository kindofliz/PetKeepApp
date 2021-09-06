import java.util.Locale;
import java.util.Scanner;

public class PetKeepMain {
    public static void main(String[] args) {

        DBConnection petKeepDb = new DBConnection();

        Scanner scanner = new Scanner(System.in);

        int menuItem;

        do {
            System.out.println();
            System.out.println("===============WELCOME!===============");
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1. - Add a new pet."); //done, needs cleaning up and reorganizing
            System.out.println("2. - Add my pet's food information."); //done, needs cleaning up and reorganizing
            System.out.println("3. - Add my pet's medication information."); //done, needs cleaning up and reorganizing
            System.out.println("4. - Add my pet's vaccination information."); // done, needs cleaning up and reorganizing
            System.out.println("5. - See a list of my pets."); //done
            System.out.println("6. - See full information on one pet."); //done, but I want to add more information
            System.out.println("7. - See the vaccination schedule."); //done
            System.out.println("8. - See the medication schedule."); //done
            System.out.println("9. - See information about their food.");
            System.out.println("10. - Delete a medication record");
            System.out.println("11. - Delete a vaccination record.");
            System.out.println("12. - Delete a food record.");
            System.out.println("13. - Delete a pet :( ");
            System.out.println("0. - Exit!");

            menuItem = scanner.nextInt();

            switch (menuItem) {
                case 1:
                    //ADD A NEW PET
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
                    //ADD FOOD INFO

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
                case 3:
                    //ADD MEDICAL INFO

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
                case 4:
                    //ADD VACCINATION INFO

                    Vaccines vaccineInfo = new Vaccines();

                    // Moved method to the bottom of PetKeepMain
                    addVaccine(scanner, vaccineInfo);

                    //Testing until we add databases
                    System.out.println("******TEST******");
                    System.out.println(vaccineInfo);
                    System.out.println("****************");

                    //Calling the method that inserts this into database (needs to be created)
                    petKeepDb.createVaccine(vaccineInfo);

                    break;
                case 5:
                    //SEE A LIST OF MY PETS

                    System.out.println("================= LIST OF MY PETS ================");

                    petKeepDb.getPetNames();

                    System.out.println("==================================================");
                    System.out.println();

                    break;
                case 6:
                    //SEE INFORMATION ON ONE PET

                    System.out.println("Enter a name from the pet list: ");
                    //Calling the method to SELECT all the info about chosen pet from DB

                    System.out.println("================= MY PET ================");
                    petKeepDb.getOnePet();
                    System.out.println("=========================================");

                    break;
                case 7:
                    //SEE VACCINATION SCHEDULE

                    System.out.println("VACCINATION SCHEDULE: ");
                    System.out.println();
                    petKeepDb.diffSeeVaccinationSchedule();

                    //ResultSet resultSet = statement.executeQuery("SELECT * from food");
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
                case 8:
                    //SEE MEDICATION SCHEDULE

                    System.out.println("MEDICATION SCHEDULE: ");
                    System.out.println();
                    petKeepDb.seeMedSchedule();

                    break;
                case 9:
                    //SEE FOOD INFO
                    System.out.println("FOOD INFORMATION: ");
                    System.out.println();
                    petKeepDb.seeFoodInfo();



                    break;
                case 10:
                    //DELETE MEDICAL RECORD



                    break;
                case 11:
                    //DELETE VACCINATION RECORD



                    break;
                case 12:
                    //DELETE FOOD RECORD



                    break;
                case 13:
                    //DELETE A PET



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
            System.out.println("Enter your pet's birthday (yyyy-mm-dd):");
            dateOfBirth = scanner.next();
            if (dateOfBirth.matches("^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|[3][01])")){
                myPet.setDateOfBirth(dateOfBirth);
                checkDate = 1;
            } else{
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

        // 0. Asking user to input their pet's name as the id for food
        String name;
        int checkName = 0;

        do {
            System.out.println("Which pet form your pet list are you adding this food item to?");
            name = scanner.next();
            if (name.matches("[A-Z][a-zA-Z']*")) {
                foodInfo.setName(name);
                checkName = 1;
            } else {
                System.out.println("Invalid name.. try again.");
            }
        } while (checkName == 0);


//        // 1. Asking user to input their Food brand with some validation
        String foodBrand;
        int checkBrand = 0;

        do {
            System.out.println("Enter your food brand you bought: ");
            scanner.nextLine(); //making sure the cursor moves to the new line before scanning
            foodBrand = scanner.nextLine();
            if (foodBrand.matches("[A-Z][A-Za-z'\\s+]*")) {
                foodInfo.setFoodBrand(foodBrand);
                checkBrand = 1;
            } else {
                System.out.println("Invalid food brand.. try again.");
            }
        } while (checkBrand == 0);


//        // 2. Asking user to input food bag weight with some validation
        int foodBagWeight;
        int checkWeight = 0;

        do {
            System.out.println("Enter food bag weight (kg): ");
            foodBagWeight = scanner.nextInt();
            if (foodBagWeight > 0) {
                foodInfo.setFoodBagWeight(foodBagWeight);
                checkWeight = 1;
            } else {
                System.out.println("Invalid food bag weight.. try again.");
            }
        } while (checkWeight == 0);


//        // 3. Asking user to input daily amount with some validation
        int dailyAmount;
        int checkAmount = 0;

        do {
            System.out.println("Enter daily amount of food to be fed: ");
            dailyAmount = scanner.nextInt();
            if (dailyAmount > 0) {
                foodInfo.setDailyAmount(dailyAmount);
                checkAmount = 1;
            } else {
                System.out.println("Invalid food bag weight.. try again.");
            }
        } while (checkAmount == 0);


//        // 4. Asking user to input purchase date
        String dateOfPurchase;
        int checkDate = 0;

        do {
            System.out.println("Enter purchase date (yyy-mm-dd):");
            dateOfPurchase = scanner.next();

            if (dateOfPurchase.matches("^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|[3][01])")) {
                foodInfo.setPurchaseDate(dateOfPurchase);
                checkDate = 1;
            } else {
                System.out.println("Invalid date format.. try again.");
                System.out.println();
            }
        } while (checkDate == 0);

    }

    public static void addMedicine(Scanner scanner, Medicine medicineInfo) {
        // 0. Asking user to add their pet's name for this medication
        String name;
        int checkName = 0;

        do {
            System.out.println("Which of your added pet's is this medication for?:");
            name = scanner.next();
            if (name.matches("[A-Z][a-zA-Z']*")) {
                medicineInfo.setName(name);
                checkName = 1;
            } else {
                System.out.println("Invalid name.. try again.");
            }
        } while (checkName == 0);


        // 1. Asking user to input their name of medicine with some validation
        String typeOfMeds;
        int checkType = 0;

        do {
            System.out.println("Enter name of the medicine:");
            scanner.nextLine(); //making sure the cursor moves to the new line before scanning
            typeOfMeds = scanner.nextLine();
            if (typeOfMeds.matches("[A-Z][A-Za-z'\\-()\\s+]*")) {
                medicineInfo.setTypeOfMeds(typeOfMeds);
                checkType = 1;
            } else {
                System.out.println("Invalid medicine name.. try again.");
            }
        } while (checkType == 0);


        // 2. Asking user to input regularity with some validation
        int regularity;
        int checkRegularity = 0;

        do {
            System.out.println("Enter regularity (in months):");
            regularity = scanner.nextInt();
            if (regularity > 0) {
                medicineInfo.setRegularity(regularity);
                checkRegularity = 1;
            } else {
                System.out.println("Invalid input.. try again.");
            }
        } while (checkRegularity == 0);


        // 3. Asking user to input first date given with some validation
        String dateGiven;
        int checkDate = 0;

        do {
            System.out.println("Enter first date medicine was given (yyy-mm-dd):");
            dateGiven = scanner.next();
            if (dateGiven.matches("^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|[3][01])")) {
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
            System.out.println("Enter next date to give medicine (yyyy-mm-dd):");
            dateToGiveNext = scanner.next();
            if (dateToGiveNext.matches("^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|[3][01])")) {
                medicineInfo.setDateToGiveNext(dateToGiveNext);
                checkNextDate = 1;
            } else {
                System.out.println("Invalid date format.. try again.");
                System.out.println();
            }
        } while (checkNextDate == 0);

    }

    public static void addVaccine(Scanner scanner, Vaccines vaccineInfo) {

        // 1. Asking user to input vaccine type with some validation
        String vaccine;
        int checkVaccine = 0;

        do {
            System.out.println("Enter type orn name of the vaccine:");
            scanner.nextLine(); //making sure the cursor moves to the new line before scanning
            vaccine = scanner.nextLine();
            if (vaccine.matches("[A-Z][A-Za-z'\\-()\\s+]*")) {
                vaccineInfo.setVaccinationType(vaccine);
                checkVaccine = 1;
            } else {
                System.out.println("Invalid vaccine name.. try again.");
            }
        } while (checkVaccine == 0);


        // 2. Asking user to input last vaccination date
        String lastVacc;
        int checkLast = 0;

        do {
            System.out.println("Enter date of last vaccination (yyyy-mm-dd):");
            lastVacc = scanner.next();
            if (lastVacc.matches("^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|[3][01])")) {
                vaccineInfo.setDateVaccinated(lastVacc);
                checkLast = 1;
            } else {
                System.out.println("Invalid date format.. try again.");
            }
        } while (checkLast == 0);


        // 3. Asking user to input next date of vaccination
        String nextVacc;
        int checkNext = 0;

        do {
            System.out.println("Enter date of next scheduled vaccination (yyyy-mm-dd):");
            nextVacc = scanner.next();
            if (nextVacc.matches("^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|[3][01])")) {
                vaccineInfo.setDateToVaccinateNext(nextVacc);
                checkNext = 1;
            } else {
                System.out.println("Invalid date format.. try again.");
            }
        } while (checkNext == 0);

    }


}
