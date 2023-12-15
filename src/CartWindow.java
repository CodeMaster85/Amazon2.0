import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * The CartWindow class represents the shopping cart window in the XYTExpress.com application.
 * It displays the articles added to the cart, allows users to remove items, and provides options
 * to proceed to check out or return to the main page.
 *
 * <p>The window includes a JList to show the articles in the cart, buttons for checkout and returning to the main page,
 * and an information label displaying the subtotal of the items in the cart.</p>
 *
 * @author Thomas and Yohan
 * @see Article
 * @see CheckoutWindow
 * @see PrincipalWindow
 * @version 1.0
 */
public class CartWindow extends JFrame{
    private JList cartArticleJList;
    private JButton checkoutButton;
    private JButton homePageButton;
    private JLabel cartTitleJLabel;
    private JPanel pnlMain;
    private JPanel pnlOptions;
    private JPanel pnlMenu;
    private JLabel informationLabel;
    double subtotal = 0.0;

    /**
     * Constructs a new instance of the CartWindow class.
     *
     * <p>The window initializes the graphical user interface components, including the JList for displaying
     * articles in the cart, buttons for navigation and checkout, and an information label for the subtotal.</p>
     */
    public CartWindow(){
        pnlMain = new JPanel(new BorderLayout());
        pnlOptions = new JPanel();
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
        setContentPane(pnlMain);

        setTitle("XYTExpress.com");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        DefaultListModel<Article> listModel = new DefaultListModel<>();
        for (Article i : DBO.articleInCart) {
            listModel.addElement(i);
        }
        JList<Article> articleList = new JList<>(listModel);
        articleList.setCellRenderer(createArticleListCellRenderer());
        JScrollPane scrollPane = new JScrollPane(articleList);

        cartTitleJLabel.setFont(new Font("Pokemon",Font.BOLD,20));


        articleList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    Article selectedArticle = articleList.getSelectedValue();

                    // add article in cart
                    if (selectedArticle != null) {
                        DBO.articleInCart.remove(selectedArticle);
                        System.out.println("remove to Cart: "+ selectedArticle.name);
                        listModel.remove(articleList.getSelectedIndex());
                        JList<Article> articleList = new JList<>(listModel);
                        articleList.setCellRenderer(createArticleListCellRenderer());

                        // adjust the price
                        subtotal -= selectedArticle.price;
                        informationLabel.setText("Subtotal = \t\t" + subtotal + "$");
                    }
                }
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                CheckoutWindow checkoutWindow = new CheckoutWindow(subtotal);
                checkoutWindow.setVisible(true);
            }
        });
        homePageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                PrincipalWindow principalWindow = new PrincipalWindow();
                principalWindow.setVisible(true);
            }
        });

        for (Article i : DBO.articleInCart) {
            subtotal += i.price;
        }
        informationLabel = new JLabel("Subtotal = \t\t" + subtotal + "$");

        pnlOptions.add(checkoutButton);
        pnlOptions.add(informationLabel);

        pnlMain.add(pnlMenu);
        pnlMain.add(scrollPane);
        pnlMain.add(pnlOptions);

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
        articlePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE)); // Ajoute une bordure noire

        ImageIcon icon = new ImageIcon(article.pathImage);
        Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        JLabel pathImageLabel = new JLabel(icon);

        // create new panel for name price and quantity
        JPanel infoPanel = new JPanel(new GridLayout(3, 3)); // Utilisation de GridLayout avec une seule ligne

        // add the name, price and quantity on information
        JLabel nameLabel = new JLabel(article.name);
        JLabel priceLabel = new JLabel("Price: $" + article.price);
        JLabel quantityLabel = new JLabel("Remaining quantity: " + article.remainingQuantity );


        infoPanel.add(nameLabel);
        infoPanel.add(priceLabel);
        infoPanel.add(quantityLabel);

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
                if (!(value instanceof Article article)) {
                    return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                }
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


