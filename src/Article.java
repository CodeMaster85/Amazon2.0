public class Article {
    String name;
    double price;
    String pathImage; 
    int remainingQuantity;

    public  Article(String _name, double _price, String _pathImage, int _remainingQuantity ) {
        this.name = _name;
        this.price = _price;
        this.pathImage = _pathImage;
        this.remainingQuantity = _remainingQuantity;
    }
}
