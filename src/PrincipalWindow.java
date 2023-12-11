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
        shopJPanel = new JPanel(new GridLayout(0, 3)); // Utilisation de GridLayout avec 3 colonnes (ajuster selon vos besoins)
        pnlMain = new JPanel(new BorderLayout());
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
        setContentPane(pnlMain);

        setTitle("Login XYT Express");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,380);
        setLocationRelativeTo(null);


        ImageIcon icon = new ImageIcon("Amazone2.0\\images\\logoXYT.png");
        Image scaledImage = icon.getImage().getScaledInstance(61, 37, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        acceuilButtonLabel.setIcon(icon);


        ArrayList<Article> allArticle = Article.SearchAllArticle();

        shopJPanel.setLayout(new BoxLayout(shopJPanel, BoxLayout.Y_AXIS)); // Utilisation de BoxLayout avec axe Y


        for (Article i : allArticle)
        {
            JPanel articlePanel = createArticlePanel(i);
            shopJPanel.add(articlePanel);
        }


        pnlMain.add(menuJPanel, BorderLayout.NORTH);
        pnlMain.add(shopJPanel, BorderLayout.SOUTH);

        setVisible(true);


    }
    private JPanel createArticlePanel(Article article) {
        JPanel articlePanel = new JPanel(new BorderLayout());

        // Ajouter l'image redimensionnée à gauche
        ImageIcon icon = new ImageIcon(article.pathImage);
        Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        JLabel pathImageLabel = new JLabel(icon);

        // Créer un panneau pour le nom, le prix et la quantité
        JPanel infoPanel = new JPanel(new GridLayout(1, 3)); // Utilisation de GridLayout avec une seule ligne

        // Ajouter le nom, le prix et la quantité au panneau d'informations
        JLabel nameLabel = new JLabel(article.name);
        JLabel priceLabel = new JLabel("\nPrix: $" + article.price);
        JLabel quantityLabel = new JLabel("Quantité restante: " + article.remainingQuantity);

        infoPanel.add(nameLabel);
        infoPanel.add(priceLabel);
        infoPanel.add(quantityLabel);

        // Ajouter le panneau d'informations à droite du panneau principal
        articlePanel.add(pathImageLabel, BorderLayout.WEST);
        articlePanel.add(infoPanel, BorderLayout.SOUTH);

        return articlePanel;
    }


//private JPanel createArticlePanel(Article article) {
//    JPanel articlePanel = new JPanel(new BorderLayout());
//
//    // Ajouter l'image redimensionnée au centre
//    ImageIcon icon = new ImageIcon(article.pathImage);
//    Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
//    icon = new ImageIcon(scaledImage);
//    JLabel pathImageLabel = new JLabel(icon);
//
//
//    // Créer un panneau pour le nom, le prix et la quantité
//    JPanel infoPanel = new JPanel();
//    infoPanel.setLayout(new GridLayout(3, 1));
//
//    // Ajouter le nom, le prix et la quantité au panneau d'informations
//    JLabel nameLabel = new JLabel(article.name);
//    JLabel priceLabel = new JLabel("Prix: $" + article.price);
//    JLabel quantityLabel = new JLabel("Quantité restante: " + article.remainingQuantity);
//
//    //articlePanel.add(pathImageLabel, BorderLayout.CENTER);
//    infoPanel.add(pathImageLabel, BorderLayout.NORTH);
//    infoPanel.add(nameLabel);
//    infoPanel.add(priceLabel);
//    infoPanel.add(quantityLabel);
//
//    // Ajouter le panneau d'informations au côté est du panneau principal
//    articlePanel.add(infoPanel, BorderLayout.WEST);
//
//    return articlePanel;
//}

}

