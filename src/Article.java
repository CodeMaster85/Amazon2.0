import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Article {
    String name;
    double price;
    String pathImage; 
    int remainingQuantity;

    public Article(String _name, double _price, String _pathImage, int _remainingQuantity ) {
        this.name = _name;
        this.price = _price;
        this.pathImage = _pathImage;
        this.remainingQuantity = _remainingQuantity;
    }

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
                    item.add(new Article(name, price, pathImage, remainingQuantity));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return item;

    }
}
