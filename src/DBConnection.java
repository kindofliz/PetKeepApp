import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class DBConnection {

    Scanner scanner = new Scanner(System.in);

    public Connection conn;

    public DBConnection() {

        try {
            String dbUrl = "jdbc:sqlite:petKeep.db";
            conn = DriverManager.getConnection(dbUrl);

            if (conn != null) {
                DatabaseMetaData databaseMetadata = conn.getMetaData();
                System.out.println("Connected to " + databaseMetadata.getDatabaseProductName() + " " + databaseMetadata.getDatabaseProductVersion());


                // CREATING A TABLE FOR PETS
                Statement statement = conn.createStatement();
                String sqlStatement =
                        "CREATE TABLE IF NOT EXISTS pets" +
                                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "name TEXT NOT NULL UNIQUE, " +
                                "animal_type TEXT NOT NULL, " +
                                "animal_breed TEXT NOT NULL, " +
                                "date_of_birth TEXT NOT NULL, " +
                                "gender TEXT NOT NULL, " +
                                "weight REAL NOT NULL, " +
                                "owner TEXT NOT NULL )";

                statement.execute(sqlStatement);


                //CREATING A TABLE FOR VACCINES
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS vaccines" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "vaccination_type TEXT NOT NULL, " +
                                "date_vaccinated TEXT NOT NULL, " +
                                "date_to_vaccinate_next TEXT NOT NULL, " +
                                "pet_id INTEGER NOT NULL)";

                statement.execute(sqlStatement);


                //CREATING A TABLE FOR FOOD
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS food" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "food_brand TEXT NOT NULL, " +
                                "food_bag_weight INTEGER NOT NULL, " +
                                "daily_amount INTEGER NOT NULL, " +
                                "purchase_date TEXT NOT NULL, " +
                                "pet_id INTEGER NOT NULL)";

                statement.execute(sqlStatement);


                //CREATING A TABLE FOR MEDICINE
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS medicine" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "type_of_meds TEXT NOT NULL, " +
                                "regularity INTEGER NOT NULL, " +
                                "date_given TEXT NOT NULL, " +
                                "date_to_give_next TEXT NOT NULL, " +
                                "pet_id INTEGER NOT NULL)";

                statement.execute(sqlStatement);
            }
        } catch (SQLException exception) {
            System.out.println("Database issues " + exception);
        }
    }


    //METHODS FOR CREATING OBJECTS AND DATA INPUT INTO DB TABLES
    public void createPet(Pets pet) {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "INSERT INTO pets (" +
                    "name, animal_type, animal_breed, date_of_birth, gender, weight, owner) " +
                    "VALUES (" +
                    "'" + pet.getName() + "'," +
                    "'" + pet.getAnimalType() + "'," +
                    "'" + pet.getAnimalBreed() + "'," +
                    "'" + pet.getDateOfBirth() + "'," +
                    "'" + pet.getGender() + "'," +
                    +pet.getWeight() + "," +
                    "'" + pet.getOwner() + "'" +
                    ")";

            int rowsAffected = statement.executeUpdate(sqlStatement);

            if (rowsAffected != 0) {
                System.out.println("Pet added successfully!");
            } else {
                System.out.println("Sorry.. Something went wrong! Try again.");
            }

        } catch (SQLException exception) {
            System.out.println("Error creating a Pet : " + exception);
        }

        System.out.println();
        System.out.println("Your pet was successfully added!");
        System.out.println();
    }

    public void createFood(Food food) {

        try {
            Statement statement = conn.createStatement();
            String sqlStatement = "INSERT INTO food (" +
                    "food_brand, food_bag_weight, daily_amount, purchase_date, pet_id) " +
                    "VALUES (" +
                    "'" + food.getFoodBrand() + "'," +
                    +food.getFoodBagWeight() + "," +
                    +food.getDailyAmount() + "," +
                    "'" + food.getPurchaseDate() + "'," +
                    +food.getPetId() + ")";

            int rowsAffected = statement.executeUpdate(sqlStatement);

            if (rowsAffected != 0) {
                System.out.println("Food item added successfully!");
            } else {
                System.out.println("Sorry.. Something went wrong! Try again.");
            }

        } catch (SQLException exception) {
            System.out.println("Error entering Food info : " + exception);
        }
    }

    public void createMedicine(Medicine medicine) {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "INSERT INTO medicine (" +
                    "type_of_meds, regularity, date_given, date_to_give_next, pet_id) " +
                    "VALUES (" +
                    "'" + medicine.getTypeOfMeds() + "'," +
                    +medicine.getRegularity() + "," +
                    "'" + medicine.getDateGiven() + "'," +
                    "'" + medicine.getDateToGiveNext() + "'," +
                    +medicine.getPetId() + ")";

            int rowsAffected = statement.executeUpdate(sqlStatement);

            if (rowsAffected != 0) {
                System.out.println("Medical record added successfully!");
            } else {
                System.out.println("Sorry.. Something went wrong! Try again.");
            }

        } catch (SQLException exception) {
            System.out.println("Error entering Medicine info : " + exception);
        }
    }

    public void createVaccine(Vaccines vaccine) {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "INSERT INTO vaccines (" +
                    "vaccination_type, date_vaccinated, date_to_vaccinate_next, pet_id) " +
                    "VALUES (" +
                    "'" + vaccine.getVaccinationType() + "'," +
                    "'" + vaccine.getDateVaccinated() + "'," +
                    "'" + vaccine.getDateToVaccinateNext() + "'," +
                    +vaccine.getPetId() + ")";

            int rowsAffected = statement.executeUpdate(sqlStatement);

            if (rowsAffected != 0) {
                System.out.println("Vaccine record added successfully!");
            } else {
                System.out.println("Sorry.. Something went wrong! Try again.");
            }

        } catch (SQLException exception) {
            System.out.println("Error entering Vaccination info : " + exception);
        }
    }


    //METHODS TO SHOW PET INFORMATION
    public ArrayList<Pets> getPetList() {

        ArrayList<Pets> petList = new ArrayList<>();

        try {
            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT name FROM pets";

            ResultSet rs = statement.executeQuery(sqlStatement);

            while (rs.next()) {
                //Create a new Pets object
                Pets pet = new Pets();
                pet.setName(rs.getString("name"));

                System.out.println(pet.getName());
            }
        } catch (SQLException exception) {
            System.out.println("Error getting Pet name list: " + exception);
        }
        return petList;
    }

    public ArrayList<Pets> getPetProfile() {

        ArrayList<Pets> petJustOne = new ArrayList<>();

        try {
            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM pets WHERE name = " + "'" + scanner.next() + "'";
            System.out.println();

            ResultSet rs = statement.executeQuery(sqlStatement);

            while (rs.next()) {
                //Create a new Pet object
                Pets pet = new Pets();
                pet.setId(rs.getInt("id"));
                pet.setName(rs.getString("name"));
                pet.setAnimalType(rs.getString("animal_type"));
                pet.setAnimalBreed(rs.getString("animal_breed"));
                pet.setDateOfBirth(rs.getString("date_of_birth"));
                pet.setGender(rs.getString("gender").charAt(0));
                pet.setWeight(rs.getDouble("weight"));
                pet.setOwner(rs.getString("owner"));

                System.out.println("=========================================================== MY PET ===========================================================");
                System.out.println(pet);
                System.out.println();
                System.out.println("Additional Info: ");
                System.out.println();
                System.out.println(pet.getName() + " is: ");
                pet.petAge();
                System.out.println();
                seePtExtraVaccines(pet);
                seePtExtraMeds(pet);
                seePtExtraFood(pet);
                System.out.println("==============================================================================================================================");
            }

        } catch (SQLException exception) {
            System.out.println("Error getting One pet's information: " + exception);
        }

        return petJustOne;
    }


    //METHODS TO ADD ALL INFO TO ONE PETS PROFILE
    public void seePtExtraVaccines(Pets pet) {

        try {
            Statement statement = conn.createStatement();
            String sqlStatement;

            sqlStatement = "SELECT * FROM pets";
            ResultSet resultSet;

            sqlStatement =
                    "SELECT * FROM pets  " +
                            " LEFT JOIN vaccines  " +
                            " ON pets.id = vaccines.pet_id " +
                            " WHERE pets.id = " + pet.getId();

            resultSet = statement.executeQuery(sqlStatement);

            while (resultSet.next()) {
                String petsVaccine = resultSet.getString("vaccination_type");
                String petsDateVaccinated = resultSet.getString("date_vaccinated");
                String petsDateNext = resultSet.getString("date_to_vaccinate_next");

                System.out.println("VACCINE: " + petsVaccine + " || Date vaccinated: " + petsDateVaccinated + " || Next Vaccination: " + petsDateNext);

            }
        } catch (SQLException exception) {

            System.out.println("Error getting pet profile information (vaccines) " + exception);

        }

    }

    public void seePtExtraMeds(Pets pet) {

        try {
            Statement statement = conn.createStatement();
            String sqlStatement;

            sqlStatement = "SELECT * FROM pets";
            ResultSet resultSet;

            sqlStatement =
                    "SELECT * FROM pets  " +
                            " LEFT JOIN medicine  " +
                            " ON pets.id = medicine.pet_id " +
                            " WHERE pets.id = " + pet.getId();

            resultSet = statement.executeQuery(sqlStatement);

            while (resultSet.next()) {

                String petsMeds = resultSet.getString("type_of_meds");
                String petsMedGiven = resultSet.getString("date_given");
                String petsGiveNext = resultSet.getString("date_to_give_next");

                System.out.println("MEDS: " + petsMeds + " || Date given: " + petsMedGiven + " || Date to give next: " + petsGiveNext);

            }
        } catch (SQLException exception) {

            System.out.println("Error getting pet profile information (meds) " + exception);

        }

    }

    public void seePtExtraFood(Pets pet) {

        try {
            Statement statement = conn.createStatement();
            String sqlStatement;

            sqlStatement = "SELECT * FROM pets";
            ResultSet resultSet;

            sqlStatement =
                    "SELECT * FROM pets  " +
                            " LEFT JOIN food  " +
                            " ON pets.id = food.pet_id " +
                            " WHERE pets.id = " + pet.getId();

            resultSet = statement.executeQuery(sqlStatement);

            while (resultSet.next()) {

                String foodBrand = resultSet.getString("food_brand");
                int foodWeight = resultSet.getInt("food_bag_weight");
                int dailyAmount = resultSet.getInt("daily_amount");
                String purchaseDate = resultSet.getString("purchase_date");

                System.out.println("FOOD: " + foodBrand + " || Food bag weight: " + foodWeight + "(kg)" + " || Daily amount: " + dailyAmount + "(g)" + " || Purchase Date: " + purchaseDate);


            }
        } catch (SQLException exception) {

            System.out.println("Error getting pet profile information (food) " + exception);

        }

    }


    //METHODS TO SELECT AND SEE INFORMATION FROM TABLES - ALL PETS
    public void seeVaccinationSchedule() {

        try {
            Statement statement = conn.createStatement();
            String sqlStatement;

            sqlStatement = "SELECT * FROM pets";
            ResultSet resultSet;

            sqlStatement =
                    " SELECT name, vaccination_type, date_to_vaccinate_next  " +
                            " FROM pets  " +
                            " LEFT JOIN vaccines  " +
                            " ON pets.id = vaccines.pet_id " +
                            " ORDER BY date_to_vaccinate_next";

            resultSet = statement.executeQuery(sqlStatement);

            while (resultSet.next()) {
                String petsName = resultSet.getString("name");
                String vaccineTitle = resultSet.getString("vaccination_type");
                String nextVaccination = resultSet.getString("date_to_vaccinate_next");


                System.out.println("Next vaccination date: " + "|" + nextVaccination + "|" + " Vaccine: " + "|" + vaccineTitle + "|" + " PET ---> " + petsName.toUpperCase(Locale.ROOT));

            }
        } catch (SQLException exception) {

            System.out.println("Error getting vaccination schedule list " + exception);

        }

    }

    public void seeMedSchedule() {

        try {
            Statement statement = conn.createStatement();
            String sqlStatement;

            sqlStatement = "SELECT * FROM pets";
            ResultSet resultSet;

            sqlStatement =
                    "SELECT name, type_of_meds, date_to_give_next " +
                            " FROM pets  " +
                            " LEFT JOIN medicine  " +
                            " ON pets.id = medicine.pet_id " +
                            " ORDER BY date_to_give_next";

            resultSet = statement.executeQuery(sqlStatement);

            while (resultSet.next()) {
                String petsName = resultSet.getString("name");
                String medicineTitle = resultSet.getString("type_of_meds");
                String nextMedAdministration = resultSet.getString("date_to_give_next");

                System.out.println(petsName.toUpperCase(Locale.ROOT) + " ---> " + " Next date to administer meds: " + "|" + nextMedAdministration + "|" + " Medication type: " + "|" + medicineTitle + "|");

            }
        } catch (SQLException exception) {

            System.out.println("Error getting medication schedule list " + exception);

        }

    }

    public ArrayList<Food> seeFoodInfoList() {

        ArrayList<Food> allFood = new ArrayList<>();

        try {

            Statement statement = conn.createStatement();
            String sqlStatement =
                    "SELECT name, food_brand, food_bag_weight, daily_amount, purchase_date " +
                            " FROM pets  " +
                            " LEFT JOIN food  " +
                            " ON pets.id = food.pet_id " +
                            " ORDER BY name";

            ResultSet resultSet = statement.executeQuery(sqlStatement);

            while (resultSet.next()) {

                // Create new Pet object
                Food food = new Food();
                String petsName = resultSet.getString("name");
                food.setFoodBrand(resultSet.getString("food_brand"));
                food.setFoodBagWeight(resultSet.getInt("food_bag_weight"));
                food.setDailyAmount(resultSet.getInt("daily_amount"));
                food.setPurchaseDate(resultSet.getString("purchase_date"));


                System.out.println(petsName.toUpperCase(Locale.ROOT) + " ---> " + food);
                System.out.println();
                System.out.println("This food bag will last you: " + food.foodDays() + " days from purchase date!");
                System.out.println("You will need to buy a new bag by: " + food.buyFood());
                System.out.println();
            }


        } catch (SQLException exception) {
            System.out.println("Error getting Pet list: " + exception);
        }

        return allFood;
    }


    //METHOD FOR CREATING THE CURRENT-PET OBJECT AND GETTING IT'S ID
    public ArrayList<Pets> selectCurrentPet(Scanner scanner, Pets currentPet) {

        ArrayList<Pets> currentPetList = new ArrayList<>();

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM pets WHERE name = " + "'" + scanner.next() + "'";

            ResultSet rs = statement.executeQuery(sqlStatement);

            while (rs.next()) {

                // Create new Pet object
                currentPet.setName(rs.getString("name"));
                currentPet.setAnimalType(rs.getString("animal_type"));
                currentPet.setAnimalBreed(rs.getString("animal_breed"));
                currentPet.setDateOfBirth(rs.getString("date_of_birth"));
                currentPet.setGender(rs.getString("gender").charAt(0));
                currentPet.setWeight(rs.getInt("weight"));
                currentPet.setOwner(rs.getString("owner"));
                currentPet.setId(rs.getInt("id"));

//                System.out.println(currentPet);
            }


        } catch (SQLException exception) {
            System.out.println("Error getting current pet: " + exception);
        }

        System.out.println();
        if (currentPet.getId() > 0) {
            System.out.println("Log In successful!");
        } else if (currentPet.getId() == 0) {
            System.out.println("Hmm.. Seems like this pet hasn't been added yet!");
        }
        return currentPetList;
    }


    //METHODS TO DELETE RECORDS FROM TABLES
    public void deleteMedRec(Scanner scanner, Pets currentPet) {
        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "DELETE FROM medicine " +
                    "WHERE medicine.pet_id = " + currentPet.getId() + " AND medicine.type_of_meds LIKE '%" + scanner.next() + "%' ";

            int rowsAffected = statement.executeUpdate(sqlStatement);

            if (rowsAffected != 0) {
                System.out.println("Medical record has been successfully deleted!");
            } else {
                System.out.println("Error. Selected medical record not found!");
            }

        } catch (SQLException exception) {
            System.out.println("Error deleting medicine : " + exception);
        }
    }

    public void deleteVaccRec(Scanner scanner, Pets currentPet) {
        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "DELETE FROM vaccines " +
                    "WHERE vaccines.pet_id = " + currentPet.getId() + " AND vaccines.vaccination_type LIKE '%" + scanner.next() + "%' ";

            int rowsAffected = statement.executeUpdate(sqlStatement);

            if (rowsAffected != 0) {
                System.out.println("Vaccine record has been successfully deleted!");
            } else {
                System.out.println("Error. Selected vaccine record not found!");
            }

        } catch (SQLException exception) {
            System.out.println("Error deleting vaccine : " + exception);
        }
    }

    public void deleteFoodRec(Scanner scanner, Pets currentPet) {
        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "DELETE FROM food " +
                    "WHERE food.pet_id = " + currentPet.getId() + " AND food.food_brand LIKE '%" + scanner.next() + "%' ";

            int rowsAffected = statement.executeUpdate(sqlStatement);

            if (rowsAffected != 0) {
                System.out.println("Food item has been successfully deleted!");
            } else {
                System.out.println("Error. Selected food item not found!");
            }

        } catch (SQLException exception) {
            System.out.println("Error deleting food item : " + exception);
        }

    }

    public void deletePet(Scanner scanner) {
        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "DELETE FROM pets " +
                    "WHERE pets.name = '" + scanner.next() + "'";

            int rowsAffected = statement.executeUpdate(sqlStatement);

            if (rowsAffected != 0) {
                System.out.println("Pet was deleted successfully!");
            } else {
                System.out.println("Error. Selected pet not found!");
            }

        } catch (SQLException exception) {
            System.out.println("Error deleting pet : " + exception);
        }

    }


}

