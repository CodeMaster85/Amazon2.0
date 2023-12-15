import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
                    // Obtenez l'élément sélectionné dans la JList
                    Article selectedArticle = articleList.getSelectedValue();

                    // Ajoutez l'article sélectionné au panier
                    if (selectedArticle != null) {
                        DBO.articleInCart.remove(selectedArticle);
                        System.out.println("remove to Cart: "+ selectedArticle.name);
                        listModel.remove(articleList.getSelectedIndex());
                        JList<Article> articleList = new JList<>(listModel);
                        articleList.setCellRenderer(createArticleListCellRenderer());
                        subtotal -= selectedArticle.price;

                        informationLabel.setText("Subtotal = \t\t" + subtotal + "$");
                    }
                }
            }
        });
        for (Article i : DBO.articleInCart) {
            subtotal += i.price;
        }
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

        informationLabel = new JLabel("Subtotal = \t\t" + subtotal + "$");

        pnlOptions.add(checkoutButton);
        pnlOptions.add(informationLabel);

        pnlMain.add(pnlMenu);
        pnlMain.add(scrollPane);
        pnlMain.add(pnlOptions);
        setVisible(true);


    }
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

        //JButton addToCartButton = new JButton("Add to Cart");


        infoPanel.add(nameLabel);
        infoPanel.add(priceLabel);
        infoPanel.add(quantityLabel);

        // Ajouter le panneau d'informations à droite du panneau principal
        articlePanel.add(pathImageLabel, BorderLayout.WEST);
        articlePanel.add(infoPanel, BorderLayout.SOUTH);

        return articlePanel;
    }
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


