import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * The OrderSummaryWindow class displays the order summary after a successful purchase in the XYTExpress.com application.
 * It provides information about the total price and an estimated delivery time.
 *
 * <p>The window includes labels for the completion message, order summary, and delivery information. Additionally,
 * there is a button to navigate back to the home page (PrincipalWindow).</p>
 * @author Thomas
 * @version 1.0
 * @see PrincipalWindow
 */
public class OrderSummaryWindow extends JFrame {
    private JPanel pnlMain;
    private JLabel competeJLabel;
    private JLabel summaryJLabel;
    private JButton homePageButton;
    private JLabel orderInfoLabel;
    /**
     * Constructs a new instance of the OrderSummaryWindow class.
     *
     * <p>The window initializes the graphical user interface components, including labels for completion message,
     * order summary, and delivery information. It also includes a button to navigate back to the home page.</p>
     *
     * @param price The total price of the order.
     */
    public OrderSummaryWindow(double price){

        setContentPane(pnlMain);
        setTitle("XYTExpress.com");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,350);
        setLocationRelativeTo(null);

        competeJLabel.setFont(new Font("Arial", Font.BOLD,20));
        summaryJLabel.setFont(new Font("Arial",Font.BOLD,15));
        String orderInfo = "<html>price : " + price + "$" + "<br/>your command will be delivered in less than a year!!!! (maybe not!)</html>";
        orderInfoLabel.setText(orderInfo);
        DBO.articleInCart.clear();
        homePageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrincipalWindow principalWindow = new PrincipalWindow();
                principalWindow.setVisible(true);
                setVisible(false);
            }
        });

    }
}
