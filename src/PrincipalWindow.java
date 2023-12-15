import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
/**
 * The PrincipalWindow class represents the main window of the XYTExpress.com application.
 * It displays a list of articles and provides navigation options for users.
 *
 * @author Yohan Chuet and Thomas Fortier
 * @version 1.0
 */
public class PrincipalWindow extends JFrame{
    private JPanel pnlMain;
    private JButton signOutButton;
    private JLabel acceuilButtonLabel;
    private JLabel cartJLabel;
    private JPanel menuJPanel;
    private JPanel shopJPanel;
    private JList allArticleList;
    private JComboBox categoryComboBox;
    private JLabel whiteSpace2JLable;
    private JLabel whiteSpace1JLable;

    private ArrayList<Article> itemInCart = new ArrayList<>();

    /**
     * Constructs a new instance of the PrincipalWindow class.
     * Initializes the GUI components, sets up event listeners, and displays the main window.
     */
    public PrincipalWindow()
    {
        pnlMain = new JPanel(new BorderLayout());
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
        setContentPane(pnlMain);
        setTitle("XYTExpress.com");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,380);
        setLocationRelativeTo(null);


        ImageIcon icon = new ImageIcon("Amazon2.0\\images\\logoXYT.png");
        Image scaledImage = icon.getImage().getScaledInstance(61, 37, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        acceuilButtonLabel.setIcon(icon);

        // Display list of all Article
        ArrayList<Article> allArticle = DBO.SearchAllArticle();
        DefaultListModel<Article> listModel = new DefaultListModel<>();
        for (Article i : allArticle) {
            listModel.addElement(i);
        }
        JList<Article> articleList = new JList<>(listModel);

        articleList.setCellRenderer(createArticleListCellRenderer());
        JScrollPane scrollPane = new JScrollPane(articleList);
        changeItem("All", listModel);

        ArrayList<Article> articlesInCart = new ArrayList<>();

        JButton addToCartButton = new JButton("Add to Cart");

        // Add a ListSelectionListener to detect selection
        articleList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    Article selectedArticle = articleList.getSelectedValue();

                    if (selectedArticle != null) {
                        DBO.articleInCart.add(selectedArticle);
                        System.out.println("Added to Cart: "+ selectedArticle);
                    }
                }
            }
        });


        // create a combo box search
        ArrayList<String> category = new ArrayList<>();
        category.add("All");
        category.add("Fashion");
        category.add("Food");
        category.add("Sport");
        category.add("Tools");
        category.add("Tech");
        category.add("Kitchen");
        category.add("Animals");
        category.add("School");
        category.add("Pharmacy");
        category.add("Toys");
        category.add("Video-games");
        category.add("Music");
        category.add("Gift-cards");
        category.add("Car");
        category.add("Furnitures");
        for (String s : category) {
            categoryComboBox.addItem("- "+ s);
        }

        // Action listener
        categoryComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.clear();
                changeItem(categoryComboBox.getSelectedItem().toString(), listModel);
            }
        });
        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Logout Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    // L'utilisateur a choisi "Yes"
                    setVisible(false);
                    LoginWindow loginWindow = new LoginWindow();
                    loginWindow.setVisible(true);
                }
            }
        });
        cartJLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CartWindow cartWindow = new CartWindow();
                cartWindow.setVisible(true);
                setVisible(false);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {
                cartJLabel.setForeground(Color.BLUE);
                cartJLabel.setText("<html><u>" + "Cart" + "</u></html>");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                cartJLabel.setForeground(Color.BLACK);
                cartJLabel.setText("Cart");
            }
        });

        pnlMain.add(menuJPanel, BorderLayout.NORTH);
        pnlMain.add(scrollPane, BorderLayout.WEST);

        setVisible(true);
    }

    /**
     * Creates a JPanel for displaying detailed information about an article.
     *
     * @param article The article for which the panel is created.
     * @return A JPanel containing information about the specified article.
     */
    private JPanel createArticlePanel(Article article) {
        JPanel articlePanel = new JPanel(new BorderLayout());
        //int borderSize = 5;
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

        //JButton addToCartButton = new JButton("Add to Cart");


        infoPanel.add(nameLabel);
        infoPanel.add(priceLabel);
        infoPanel.add(quantityLabel);

        // Ajouter le panneau d'informations à droite du panneau principal
        articlePanel.add(pathImageLabel, BorderLayout.WEST);
        articlePanel.add(infoPanel, BorderLayout.SOUTH);

        return articlePanel;
    }
    /**
     * Creates a custom ListCellRenderer for rendering articles in the JList.
     *
     * @return A ListCellRenderer for rendering articles with additional features.
     */
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
                JButton addToCartButton = new JButton("Add to Cart");
                addToCartButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DBO.articleInCart.add(article); // Ajoutez l'article au panier
                    }
                });

                articlePanel.add(addToCartButton, BorderLayout.EAST);
                return articlePanel;
            }
        };

    }
    /**
     * Changes the items displayed in the article list based on the selected category.
     * @param category   The selected category for filtering articles.
     * @param listModel  The DefaultListModel used to update the article list.
     */
    private void changeItem(String category, DefaultListModel<Article> listModel) {

        ArrayList<Article> allArticle = DBO.SearchAllArticle();
        if (category.equals("- All")) {
            for (Article i : allArticle) {
                listModel.addElement(i);

            }
        } else {
            for (Article i : allArticle) {
                for (String categoriItem : i.category) {
                    if (("- " + categoriItem).equals(category)) {
                        listModel.addElement(i);
                    }
                }
            }
        }
    }
}