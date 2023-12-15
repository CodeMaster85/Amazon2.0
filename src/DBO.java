import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The DBO (Database Operations) class provides methods for interacting with the application's data,
 * including searching for articles, checking user existence, and adding new users to the system.
 *
 * <p>The class contains static variables and methods for managing articles in the shopping cart and accessing user data.</p>
 *
 * <p>Article data is read from a CSV file, and user data is read from another CSV file.</p>
 *
 * <p>The class implements error handling to address potential issues during file operations and data parsing.</p>
 * @author yohan
 * @see Article
 * @see Client
 * @version 1.0
 */
public class DBO {
    /**
     * A static ArrayList holding articles currently in the shopping cart.
     */
    public static ArrayList<Article> articleInCart = new ArrayList<>();

    /**
     * Searches for all articles stored in the product CSV file.
     *
     * <p>Reads data from the "Products.csv" file, parses each line, and creates Article objects
     * based on the information retrieved. The articles are then added to an ArrayList.</p>
     *
     * @return An ArrayList of Article objects representing all available articles.
     */
    public static ArrayList<Article> SearchAllArticle() {
        ArrayList<Article> articles = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("Amazon2.0\\src\\Products.csv"))) {
            String line;
            br.readLine(); // Pour ignorer l'en-tête si le fichier en a un
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String articleName = data[0];
                Double price = Double.parseDouble(data[1]);
                String pathImage = data[2];
                int remainingQuantity = Integer.parseInt(data[3]);

                // Séparer les catégories entre crochets et les ajouter à la liste
                String categories = data[4].replaceAll("\\[|\\]", ""); // Retirer les crochets
                String[] categoryArray = categories.split("\\s*,\\s*"); // Diviser en fonction des virgules et éliminer les espaces
                ArrayList<String> articleCategories = new ArrayList<>();

                articleCategories.addAll(Arrays.asList(categoryArray));
                Article article = new Article(articleName, price, pathImage, remainingQuantity, articleCategories);
                articles.add(article);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return articles;
    }

    /**
     * Checks if a user with the provided username and password exists in the user CSV file.
     *
     * <p>Reads user data from the "User.csv" file, attempts to match the provided username and password
     * with entries in the file, and returns a boolean indicating the existence of the user.</p>
     *
     * @param _name     The username to check.
     * @param _password The password to check.
     * @return True if the user exists; otherwise, false.
     */
    static public boolean isUserExist(String _name, String _password) {
        File file = new File("Amazon2.0\\src\\User.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            // Lire chaque ligne du fichier
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String username = data[0];
                String password = data[1];
                String firstname = data[2];
                String lastname = data[3];
                String email = data[4];
                new Client(username, password, firstname, lastname, email);
                if (_name.equals(username) && _password.equals(password))
                {
                    return true;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    /**
     * Adds a new user to the user CSV file.
     *
     * <p>Appends a new line containing user information to the "User.csv" file, effectively adding the user to the system.</p>
     *
     * @param userName   The username of the new user.
     * @param password   The password of the new user.
     * @param firstName  The first name of the new user.
     * @param lastName   The last name of the new user.
     * @param email      The email address of the new user.
     * @throws IOException If an I/O error occurs during file writing.
     */
static public void addUser(String userName, String password, String firstName, String lastName, String email) throws IOException {
    File file = new File("Amazon2.0\\src\\User.csv");

    // Construire la nouvelle ligne à ajouter
    String newLine = userName + "," + password + "," + firstName + "," + lastName + "," + email;

    // Ajouter la nouvelle ligne à la fin du fichier
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
        bw.write(newLine);
        bw.newLine();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}

