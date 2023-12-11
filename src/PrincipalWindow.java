import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PrincipalWindow extends JFrame{
    private JPanel pnlMain;
    private JButton signOutButton;
    private JLabel acceuilButtonLabel;
    private JLabel cartJLabel;
    private JPanel menuJPanel;
    private JPanel shopJPanel;
    private JScrollBar scrollBar1;

    public PrincipalWindow()
    {
        shopJPanel = new JPanel();
        pnlMain = new JPanel();
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
        setContentPane(pnlMain);

        setTitle("Login XYT Express");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,500);
        setLocationRelativeTo(null);


        ImageIcon icon = new ImageIcon("Amazone2.0\\images\\logoXYT.png");
        Image scaledImage = icon.getImage().getScaledInstance(61, 37, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        acceuilButtonLabel.setIcon(icon);


        ArrayList<Article> allArticle = Article.SearchAllArticle();

        for (Article i : allArticle)
        {
            shopJPanel.add(createArticlePanel(i));
        }


        pnlMain.add(menuJPanel);
        pnlMain.add(shopJPanel);

        setVisible(true);


    }

//    private JPanel createArticlePanel(Article article) {
//        JPanel articlePanel = new JPanel();
//        articlePanel.setLayout(new GridLayout(1, 4));
//
//        // Ajouter les informations de l'article au panneau
//        ImageIcon icon = new ImageIcon(article.pathImage);
//        Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
//        icon = new ImageIcon(scaledImage);
//        JLabel pathImageLabel = new JLabel(icon);
//
//        JLabel nameLabel = new JLabel(article.name);
//        JLabel priceLabel = new JLabel("Prix: " + article.price);
//
//        JLabel quantityLabel = new JLabel("Quantité restante: " + article.remainingQuantity);
//
//        articlePanel.add(nameLabel);
//        articlePanel.add(priceLabel);
//        articlePanel.add(pathImageLabel);
//        articlePanel.add(quantityLabel);
//
//        return articlePanel;
//    }
private JPanel createArticlePanel(Article article) {
    JPanel articlePanel = new JPanel(new BorderLayout());

    // Ajouter l'image redimensionnée au centre
    ImageIcon icon = new ImageIcon(article.pathImage);
    Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    icon = new ImageIcon(scaledImage);
    JLabel pathImageLabel = new JLabel(icon);
    articlePanel.add(pathImageLabel, BorderLayout.CENTER);

    // Créer un panneau pour le nom, le prix et la quantité
    JPanel infoPanel = new JPanel();
    infoPanel.setLayout(new GridLayout(3, 1));

    // Ajouter le nom, le prix et la quantité au panneau d'informations
    JLabel nameLabel = new JLabel(article.name);
    JLabel priceLabel = new JLabel("Prix: $" + article.price);
    JLabel quantityLabel = new JLabel("Quantité restante: " + article.remainingQuantity);

    infoPanel.add(nameLabel);
    infoPanel.add(priceLabel);
    infoPanel.add(quantityLabel);

    // Ajouter le panneau d'informations au côté est du panneau principal
    articlePanel.add(infoPanel, BorderLayout.EAST);

    return articlePanel;
}

}
