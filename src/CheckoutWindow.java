import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CheckoutWindow extends JFrame {
    private JPanel pnlMain;
    private JLabel checkoutJLabel;
    private JTextField creditCardTextField;
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

        creditCardTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    // Si ce n'est pas un chiffre, ignorez l'événement de frappe
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}
