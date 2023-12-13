import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartWindow extends JFrame{
    private JList cartArticleJList;
    private JButton checkoutButton;
    private JButton homePageButton;
    private JLabel cartTitleJLabel;
    private JPanel pnlMain;


    public CartWindow(){
        setContentPane(pnlMain);

        setTitle("XYTExpress.com");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        cartTitleJLabel.setFont(new Font("Pokemon",Font.PLAIN,20));
        homePageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                PrincipalWindow principalWindow = new PrincipalWindow();
                principalWindow.setVisible(true);
            }
        });




    }
}


