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

    ArrayList<String> category = new ArrayList<>();

    public Article(String _name, double _price, String _pathImage, int _remainingQuantity, ArrayList<String> _category) {
        this.name = _name;
        this.price = _price;
        this.pathImage = _pathImage;
        this.remainingQuantity = _remainingQuantity;
        this.category = _category;
    }
}
