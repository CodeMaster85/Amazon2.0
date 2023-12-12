import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PrincipalWindow extends JFrame{
    private JPanel pnlMain;
    private JButton signOutButton;
    private JLabel acceuilButtonLabel;
    private JLabel cartJLabel;
    private JPanel menuJPanel;
    private JPanel shopJPanel;
    private JList allArticleList;
    private JComboBox<String> categoryComboBox = new JComboBox<String>();
    private JLabel whiteSpace2JLable;
    private JLabel whiteSpace1JLable;

    public PrincipalWindow()
    {
        ArrayList<String> category = new ArrayList<>();
        category.add("All");
        category.add("Fashion");
        category.add("Sport");
        category.add("Tech");
        category.add("Kitchen");
        category.add("Animals");
        category.add("Toys");
        category.add("Vidéo games");
        category.add("Gift cards");
        category.add("Car");
        category.add("Furnitures");
        //categoryComboBox = new JComboBox<String>();
        for (int i = 0; i < category.size() ; i++){
            categoryComboBox.addItem(category.get(i));
        }
        categoryComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                LoginWindow loginWindow = new LoginWindow();
                loginWindow.setVisible(true);
            }
        });
//        shopJPanel = new JPanel(new GridLayout(0, 3)); // Utilisation de GridLayout avec 3 colonnes (ajuster selon vos besoins)
        pnlMain = new JPanel(new BorderLayout());
        menuJPanel = new JPanel();
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
        setContentPane(pnlMain);

        setTitle("Login XYT Express");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,380);
        setLocationRelativeTo(null);

        //C:\GIT\XYTExpress\Amazon2.0\images
        ImageIcon icon = new ImageIcon("Amazon2.0\\images\\logoXYT.png");
        Image scaledImage = icon.getImage().getScaledInstance(61, 37, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        acceuilButtonLabel.setIcon(icon);


        ArrayList<Article> allArticle = Article.SearchAllArticle();
        DefaultListModel<Article> listModel = new DefaultListModel<>();

        for (Article i : allArticle) {
            listModel.addElement(i);
        }

        JList<Article> articleList = new JList<>(listModel);
        articleList.setCellRenderer(createArticleListCellRenderer());
        JScrollPane scrollPane = new JScrollPane(articleList);


        menuJPanel.add(categoryComboBox);
        pnlMain.add(menuJPanel, BorderLayout.NORTH);
        pnlMain.add(scrollPane, BorderLayout.WEST);

        setVisible(true);


    }
    // modify and create Article
    // use this function to refactor the element on the list
    private JPanel createArticlePanel(Article article) {
        JPanel articlePanel = new JPanel(new BorderLayout());
        int borderSize = 5;
        articlePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE)); // Ajoute une bordure noire

        ImageIcon icon = new ImageIcon(article.pathImage);
        Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        JLabel pathImageLabel = new JLabel(icon);

        // Créer un panneau pour le nom, le prix et la quantité
        JPanel infoPanel = new JPanel(new GridLayout(3, 3)); // Utilisation de GridLayout avec une seule ligne

        // Ajouter le nom, le prix et la quantité au panneau d'informations
        JLabel nameLabel = new JLabel(article.name);
        JLabel priceLabel = new JLabel("Price: $" + article.price);
        JLabel quantityLabel = new JLabel("Remaining quantity: " + article.remainingQuantity );





        infoPanel.add(nameLabel);
        infoPanel.add(priceLabel);
        infoPanel.add(quantityLabel);

        // Ajouter le panneau d'informations à droite du panneau principal
        articlePanel.add(pathImageLabel, BorderLayout.WEST);
        articlePanel.add(infoPanel, BorderLayout.SOUTH);

        return articlePanel;
    }
    // modify and create list
    // use this function to refactor the  list
    private ListCellRenderer<? super Article> createArticleListCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (!(value instanceof Article)) {
                    return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                }

                Article article = (Article) value;
                JPanel articlePanel = createArticlePanel(article);

                if (isSelected) {
                    articlePanel.setBackground(list.getSelectionBackground());
                    articlePanel.setForeground(list.getSelectionForeground());
                } else {
                    articlePanel.setBackground(list.getBackground());
                    articlePanel.setForeground(list.getForeground());
                }

                return articlePanel;
            }
        };

    }




}

