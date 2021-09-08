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




    //METHODS FOR CREATING OBJECTS AND TABLE INPUT
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

            statement.execute(sqlStatement);

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
                    "'" + food.getPurchaseDate()  + "'," +
                    + food.getPetId() + ")";

            statement.execute(sqlStatement);

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
                    + medicine.getRegularity() + "," +
                    "'" + medicine.getDateGiven() + "'," +
                    "'" + medicine.getDateToGiveNext() + "'," +
                    + medicine.getPetId() + ")";

            statement.execute(sqlStatement);

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
                    + vaccine.getPetId() + ")";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error entering Vaccination info : " + exception);
        }
    }




    //METHODS TO SHOW PET INFORMATION WITHOUT OTHER TABLES
    public ArrayList<Pets> seeAllPets() {

        ArrayList<Pets> allPets = new ArrayList<>();

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

                System.out.println(pet);
            }


        } catch (SQLException exception) {
            System.out.println("Error getting Pet list: " + exception);
        }

        return allPets;
    }

    public ArrayList<Pets> getPetNames() {

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

    public ArrayList<Pets> getOnePet() {

        ArrayList<Pets> petJustOne = new ArrayList<>();

        try {
            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM pets WHERE name = " + "'" + scanner.next() + "'";
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


                System.out.println(pet);
            }

        } catch (SQLException exception) {
            System.out.println("Error getting One pet's information: " + exception);
        }

        return petJustOne;
    }




    //METHODS TO SELECT AND SEE INFORMATION FROM TABLES
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

    public void seeFoodInfo() {

        try {
            Statement statement = conn.createStatement();
            String sqlStatement;

            sqlStatement = "SELECT * FROM pets";
            ResultSet resultSet;

            sqlStatement =
                    "SELECT name, food_brand, food_bag_weight, daily_amount, purchase_date " +
                            " FROM pets  " +
                            " LEFT JOIN food  " +
                            " ON pets.id = food.pet_id " +
                            " ORDER BY name";

            resultSet = statement.executeQuery(sqlStatement);

            while (resultSet.next()) {
                String petsName = resultSet.getString("name");
                String foodBrand = resultSet.getString("food_brand");
                int foodWeight = resultSet.getInt("food_bag_weight");
                int dailyAmount = resultSet.getInt("daily_amount");
                String purchaseDate = resultSet.getString("purchase_date");

                System.out.println(petsName.toUpperCase(Locale.ROOT) + " ---> " + " Food Brand: " + "|" + foodBrand + "|" + " Food bag weight: " + "|" + foodWeight +
                        "(kg)|" + " Daily amount: " + "|" + dailyAmount + "(g)|" + " Purchase Date: " + "|" + purchaseDate + "|");

            }
        } catch (SQLException exception) {

            System.out.println("Error getting medication schedule list " + exception);

        }

    }


}

