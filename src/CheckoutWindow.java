import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckoutWindow extends JFrame {
    private JPanel pnlMain;
    private JLabel checkoutJLabel;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton orderButton;
    private JButton cancelButton;

    public CheckoutWindow(){
        setContentPane(pnlMain);
        setTitle("XYTExpress.com");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,250);
        setLocationRelativeTo(null);

        checkoutJLabel.setFont(new Font("Arial", Font.BOLD,25));

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                CartWindow cartWindow = new CartWindow();
                cartWindow.setVisible(true);
            }
        });
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
