import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBO {
//    public static ArrayList<Article> SearchAllArticle()
//    {
//        ArrayList<Article> item = new ArrayList<>();
//
//        File file = new File("Amazon2.0\\src\\dataWish.txt");
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            String ligne;
//            while ((ligne = br.readLine()) != null)
//            {
//                if (ligne.equals("Article"))
//                {
//                    String name = br.readLine();
//                    double price = Double.parseDouble(br.readLine());
//                    String pathImage = br.readLine();
//                    int remainingQuantity = Integer.parseInt(br.readLine());
//                    ArrayList<String> category = new ArrayList<>();
//
//                    String categoriesLine = br.readLine();
//                    String[] motsLigne = categoriesLine.split("\\s+");
//
//                    // Ajouter chaque mot à l'ArrayList
//                    for (String mot : motsLigne) {
//                        category.add(mot);
//                    }
//                    item.add(new Article(name, price, pathImage, remainingQuantity, category));
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return item;
//
//    }

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

    static public void addUser(String userName, String password) throws IOException {
        File file = new File("Amazon2.0\\src\\dataWish.txt");

        // Lire toutes les lignes existantes dans une liste
        List<String> lines = new ArrayList<>();
        boolean foundEmptyLine = false;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty() && !foundEmptyLine) {
                    // Ajouter la nouvelle ligne à la première ligne vide
                    lines.add(userName + " " + password + "\n");
                    foundEmptyLine = true;
                } else {
                    lines.add(line);
                }
            }
        }

        // Si aucune ligne vide n'a été trouvée, ajouter la nouvelle ligne à la fin
        if (!foundEmptyLine) {
            lines.add(userName + " " + password);
        }

        // Réécrire le fichier avec toutes les lignes
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

