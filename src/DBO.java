import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DBO {
    public static ArrayList<Article> SearchAllArticle()
    {
        ArrayList<Article> item = new ArrayList<>();

        File file = new File("Amazon2.0\\src\\dataWish.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String ligne;
            while ((ligne = br.readLine()) != null)
            {
                if (ligne.equals("Article"))
                {
                    String name = br.readLine();
                    double price = Double.parseDouble(br.readLine());
                    String pathImage = br.readLine();
                    int remainingQuantity = Integer.parseInt(br.readLine());
                    ArrayList<String> category = new ArrayList<>();

                    String categoriesLine = br.readLine();
                    String[] motsLigne = categoriesLine.split("\\s+");

                    // Ajouter chaque mot à l'ArrayList
                    for (String mot : motsLigne) {
                        category.add(mot);
                    }
                    item.add(new Article(name, price, pathImage, remainingQuantity, category));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return item;

    }
    static public boolean isUserExist(String _name, String _password)
    {
        File file = new File("Amazon2.0\\src\\dataWish.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String ligne;

            // Lire chaque ligne du fichier
            while ((ligne = br.readLine()) != null) {
                // Diviser la ligne en deux parties : nom et mot de passe
                String[] parties = ligne.trim().split("\\s+");

                // Vérifier si les informations correspondent à la demande
                if (parties.length == 2 && parties[0].equals(_name) && parties[1].equals(_password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

}
