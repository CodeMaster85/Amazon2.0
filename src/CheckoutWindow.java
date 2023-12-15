import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
/**
 * The CheckoutWindow class represents the checkout window in the XYTExpress.com application.
 * Users can enter payment and address information to proceed with the order.
 *
 * <p>The window includes text fields for credit card details, a combo box for selecting the expiration month and year,
 * buttons for placing an order or canceling, and error handling for incomplete information.</p>
 * @author Thomas
 * @see CartWindow
 * @see OrderSummaryWindow
 * @version 1.0
 */
public class CheckoutWindow extends JFrame {
    private JPanel pnlMain;
    private JLabel checkoutJLabel;
    private JTextField creditCardTextField;
    private JComboBox monthComboBox;
    private JComboBox yearComboBox;
    private JButton orderButton;
    private JButton cancelButton;
    private JTextField cvcTextField;
    private JTextField addressTextField;
    private JTextField ownerTextField;
    private JLabel errorJLabel;
    double subtotal;
    /**
     * Constructs a new instance of the CheckoutWindow class.
     *
     * <p>The window initializes the graphical user interface components, including text fields for credit card details,
     * combo boxes for expiration month and year, buttons for order placement and cancellation, and an error label.</p>
     *
     * @param _price The subtotal of the items in the cart.
     */
    public CheckoutWindow(double _price){
        subtotal = _price;

        setContentPane(pnlMain);
        setTitle("XYTExpress.com");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,350);
        setLocationRelativeTo(null);
        checkoutJLabel.setFont(new Font("Arial", Font.BOLD,25));

        // if user click on cancel button, he goes back where he came
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                CartWindow cartWindow = new CartWindow();
                cartWindow.setVisible(true);
            }
        });

        creditCardTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    // if it's not a number, ignore event
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<JTextField> textField = new ArrayList<>();
                textField.add(ownerTextField);
                textField.add(creditCardTextField);
                textField.add(cvcTextField);
                textField.add(addressTextField);

                // if one text field is not field, add e error msg
                boolean isGood = true;
                for(JTextField i : textField){
                    if (i.getText().isEmpty()) {
                        errorJLabel.setText("Error : Please complete all the tabs");
                        isGood = false;
                    }
                }

                if (isGood) {
                    OrderSummaryWindow orderSummaryWindow = new OrderSummaryWindow(subtotal);
                    orderSummaryWindow.setVisible(true);
                    setVisible(false);
                }

            }
        });
    }
}
