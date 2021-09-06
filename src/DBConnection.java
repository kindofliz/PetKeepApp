import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class DBConnection {

    Scanner scanner = new Scanner(System.in);

    private Connection conn;

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
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "name TEXT NOT NULL, " +
                                "animal_type TEXT NOT NULL, " +
                                "animal_breed TEXT NOT NULL, " +
                                "date_of_birth TEXT NOT NULL, " +
                                "gender TEXT NOT NULL, " +
                                "weight REAL NOT NULL, " +
                                "owner TEXT NOT NULL )";

                statement.execute(sqlStatement);


                //INTERMEDIATE MANY TO MANY TABLE pets+vaccines
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS pets_vaccines" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "pet_id INTEGER NOT NULL, " +
                                "vaccine_id INTEGER NOT NULL, " +
                                "date_to_vaccinate_next TEXT NOT NULL)";

                statement.execute(sqlStatement);


                //CREATING A TABLE FOR VACCINES
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS vaccines" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "vaccination_type TEXT NOT NULL, " +
                                "date_vaccinated TEXT NOT NULL, " +
                                "date_to_vaccinate_next TEXT NOT NULL)";

                statement.execute(sqlStatement);


                //CREATING A TABLE FOR FOOD
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS food" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "food_brand TEXT NOT NULL, " +
                                "food_bag_weight INTEGER NOT NULL, " +
                                "daily_amount INTEGER NOT NULL, " +
                                "purchase_date TEXT NOT NULL)";

                statement.execute(sqlStatement);


                //INTERMEDIATE MANY TO MANY TABLE pets+food
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS pets_food" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "pet_id INTEGER NOT NULL, " +
                                "food_id INTEGER NOT NULL, " +
                                "daily_amount INTEGER NOT NULL)";

                statement.execute(sqlStatement);


                //CREATING A TABLE FOR MEDICINE
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS medicine" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "pet_name TEXT NOT NULL, " +
                                "type_of_meds TEXT NOT NULL, " +
                                "regularity INTEGER NOT NULL, " +
                                "date_given TEXT NOT NULL, " +
                                "date_to_give_next TEXT NOT NULL)";

                statement.execute(sqlStatement);


                //INTERMEDIATE MANY TO MANY TABLE pets+medicine
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS pets_medicine" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "pet_id INTEGER NOT NULL, " +
                                "medicine_id INTEGER NOT NULL, " +
                                "date_to_give_next TEXT NOT NULL)";

                statement.execute(sqlStatement);

            }

        } catch (SQLException exception) {
            System.out.println("Database issues " + exception);
        }
    }

    // method for seeing all Pets
    public ArrayList<Pets> seeAllPets() {

        ArrayList<Pets> allPets = new ArrayList<Pets>();

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM pets";

            ResultSet rs = statement.executeQuery(sqlStatement);

            while (rs.next()) {

                // Create new Pet object
                Pets pet = new Pets();
                pet.setName(rs.getString("name"));
                pet.setAnimalType(rs.getString("animal_type"));
                pet.setAnimalBreed(rs.getString("animal_breed"));
                pet.setDateOfBirth(rs.getString("date_of_birth"));
                pet.setGender(rs.getString("gender").charAt(0));
                pet.setWeight(rs.getInt("weight"));
                pet.setOwner(rs.getString("owner"));

                System.out.println(pet.toString());
            }


        } catch (SQLException exception) {
            System.out.println("Error getting Pet list: " + exception);
        }

        return allPets;
    }

    // method for creating a pet
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
                    + pet.getWeight() + "," +
                    "'" + pet.getOwner() + "'" +
                    ")";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error creating a Pet : " + exception);
        }
    }


    //METHOD TO SHOW THE LIST OF PET NAMES
    public ArrayList<Pets> getPetNames() {

        ArrayList<Pets> petList = new ArrayList<Pets>();

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


    //METHOD TO SHOW ONE PET'S INFORMATION (PET PROFILE)
    public ArrayList<Pets> getOnePet() {

        ArrayList<Pets> petJustOne = new ArrayList<Pets>();

        try {
            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM pets WHERE name = " + "\'" + scanner.next() + "\'";
            System.out.println();

            ResultSet rs = statement.executeQuery(sqlStatement);

            while (rs.next()) {
                //Create a new Pet object
                Pets pet = new Pets();
                pet.setName(rs.getString("name"));
                pet.setAnimalType(rs.getString("animal_type"));
                pet.setAnimalBreed(rs.getString("animal_breed"));
                pet.setDateOfBirth(rs.getString("date_of_birth"));
                pet.setGender(rs.getString("gender").charAt(0));
                pet.setWeight(rs.getDouble("weight"));
                pet.setOwner(rs.getString("owner"));


                System.out.println(pet.toString());
            }

        } catch (SQLException exception) {
            System.out.println("Error getting One pet's information: " + exception);
        }

        return petJustOne;
    }


//    //method to see vaccination schedule (original, not working)
//    public ArrayList<Pets> seeVaccinationSchedule() {
//
//        ArrayList<Pets> petsVaccinations = new ArrayList<Pets>();
//
//        try {
//            Statement statement = conn.createStatement();
//            String sqlStatement;
//
//            sqlStatement = "SELECT * FROM pets";
//            ResultSet resultSet = statement.executeQuery(sqlStatement);
//
//            sqlStatement =
//                    "SELECT pets.name AS pet_Name, vaccines.vaccination_type AS vaccine_Title, pets_vaccines.date_to_vaccinate_next AS next_Vaccination " +
//                            " FROM pets  " +
//                            " LEFT JOIN pets_vaccines  " +
//                            " ON pets_vaccines.pet_id = pets.id " +
//                            " LEFT JOIN vaccines " +
//                            " ON pets_vaccines.vaccine_id = vaccines.id  " +
//                            " ORDER BY pets_vaccines.date_to_vaccinate_next";
//
//            resultSet = statement.executeQuery(sqlStatement);
//
//            while (resultSet.next()) {
//                String petsName = resultSet.getString("pet_Name");
//                String vaccineTitle = resultSet.getString("vaccine_Title");
//                String nextVaccination = resultSet.getString("next_Vaccination");
//
//
//            }
//        } catch (SQLException exception) {
//
//            System.out.println("Error getting vaccination list " + exception);
//
//        }
//        return petsVaccinations;
//    }


    //DIFFERENT method to see vaccination schedule
    public void diffSeeVaccinationSchedule() {

        try {
            Statement statement = conn.createStatement();
            String sqlStatement;

            sqlStatement = "SELECT * FROM pets";
            ResultSet resultSet = statement.executeQuery(sqlStatement);

            sqlStatement =
                    "SELECT pets.name AS pet_name, vaccines.vaccination_type AS vaccine_type, vaccines.date_to_vaccinate_next AS next_vaccination " +
                            " FROM pets  " +
                            " JOIN vaccines  " +
                            " ON pets.id = vaccines.id " +
                            " ORDER BY vaccines.date_to_vaccinate_next";

            resultSet = statement.executeQuery(sqlStatement);

            while (resultSet.next()) {
                String petsName = resultSet.getString("pet_name");
                String vaccineTitle = resultSet.getString("vaccine_type");
                String nextVaccination = resultSet.getString("next_vaccination");


                System.out.println("Next vaccination date: " + "|" + nextVaccination + "|" + " Vaccine: " + "|" + vaccineTitle + "|" + " PET ---> " + petsName.toUpperCase(Locale.ROOT));

            }
        } catch (SQLException exception) {

            System.out.println("Error getting vaccination schedule list " + exception);

        }

    }


    //METHOD TO SEE MEDICATION SCHEDULE
    public void seeMedSchedule() {

        try {
            Statement statement = conn.createStatement();
            String sqlStatement;

            sqlStatement = "SELECT * FROM pets";
            ResultSet resultSet = statement.executeQuery(sqlStatement);

            sqlStatement =
                    "SELECT pets.name AS pet_name, medicine.type_of_meds AS medication_type, medicine.date_to_give_next AS administer_meds_next " +
                            " FROM pets  " +
                            " JOIN medicine  " +
                            " ON pets.name = medicine.pet_name " +
                            " ORDER BY medicine.date_to_give_next";

            resultSet = statement.executeQuery(sqlStatement);

            while (resultSet.next()) {
                String petsName = resultSet.getString("pet_name");
                String medicineTitle = resultSet.getString("medication_type");
                String nextMedAdministration = resultSet.getString("administer_meds_next");

                System.out.println(petsName.toUpperCase(Locale.ROOT) + " ---> " + " Next date to administer meds: " + "|" + nextMedAdministration + "|" + " Medication type: " + "|" + medicineTitle + "|");

            }
        } catch (SQLException exception) {

            System.out.println("Error getting medication schedule list " + exception);

        }

    }


    //method for creating food
    public void createFood(Food food) {

        try {
            Statement statement = conn.createStatement();
            String sqlStatement = "INSERT INTO food (" +
                    "food_brand, food_bag_weight, daily_amount, purchase_date) " +
                    "VALUES (" +
                    "'" + food.getFoodBrand() + "'," +
                    + food.getFoodBagWeight() + "," +
                    + food.getDailyAmount() + "," +
                    "'" + food.getPurchaseDate() + "'" +
                    ")";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error entering Food info : " + exception);
        }
    }


    //method for creating medicine
    public void createMedicine(Medicine medicine) {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "INSERT INTO medicine (" +
                    "pet_name, type_of_meds, regularity, date_given, date_to_give_next) " +
                    "VALUES (" +
                    "'" + medicine.getName() + "'," +
                    "'" + medicine.getTypeOfMeds() + "'," +
                    + medicine.getRegularity() + "," +
                    "'" + medicine.getDateGiven() + "'," +
                    "'" + medicine.getDateToGiveNext() + "'" +
                    ")";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error entering Medicine info : " + exception);
        }
    }


    //method for creating vaccine
    public void createVaccine(Vaccines vaccine) {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "INSERT INTO vaccines (" +
                    "vaccination_type, date_vaccinated, date_to_vaccinate_next) " +
                    "VALUES (" +
                    "'" + vaccine.getVaccinationType() + "'," +
                    "'" + vaccine.getDateVaccinated() + "'," +
                    "'" + vaccine.getDateToVaccinateNext() + "'" +
                    ")";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error entering Vaccination info : " + exception);
        }
    }






    }