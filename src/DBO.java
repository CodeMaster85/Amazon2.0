import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBO {

    public static ArrayList<Article> articleInCart = new ArrayList<>();

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

