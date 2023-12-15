import java.util.ArrayList;
/**
 * The Article class represents a product with details such as name, price, image path, remaining quantity, and categories.
 * It is used to model items available for purchase in the XYTExpress.com application.
 *
 * @author yohan
 */
public class Article {
    String name;
    double price;
    String pathImage; 
    int remainingQuantity;

    ArrayList<String> category = new ArrayList<>();

    /**
     * Constructs a new instance of the Article class with the specified attributes.
     *
     * @param _name             The name of the article.
     * @param _price            The price of the article.
     * @param _pathImage        The file path to the image associated with the article.
     * @param _remainingQuantity The remaining quantity of the article in stock.
     * @param _category         The list of categories to which the article belongs.
     */
    public Article(String _name, double _price, String _pathImage, int _remainingQuantity, ArrayList<String> _category) {
        this.name = _name;
        this.price = _price;
        this.pathImage = _pathImage;
        this.remainingQuantity = _remainingQuantity;
        this.category = _category;
    }
}
