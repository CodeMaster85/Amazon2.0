import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * The LoginWindow class represents the login window in the XYTExpress.com application.
 * Users can input their credentials to log in, create a new account, or cancel the login process.
 *
 * <p>The window includes text fields for username and password, buttons for login and cancellation,
 * and a label for creating a new account. The "Create an account" label changes appearance when hovered over.</p>
 *
 * @author Thomas
 * @see DBO
 * @see CreateAccountWindow
 * @see PrincipalWindow
 * @version 1.0
 */
public class LoginWindow extends JFrame{
    private JTextField userNameTextField;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JButton cancelButton;
    private JPanel pnlMain;
    private JLabel createJLabel;
    private JLabel errorJLabel;
    /**
     * Constructs a new instance of the LoginWindow class.
     *
     * <p>The window initializes the graphical user interface components, including text fields for username and password,
     * buttons for login and cancellation, a label for creating an account, and an error label.</p>
     */
    public LoginWindow(){

        setContentPane(pnlMain);

        setTitle("Login XYT Express");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,250);
        setLocationRelativeTo(null);
        setVisible(true);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userNameTextField.setText("");
                passwordField1.setText("");
                errorJLabel.setText("");
            }
        });

        createJLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                createJLabel.setText("Go to Walmart");
                setVisible(false);
                CreateAccountWindow accountWindow = new CreateAccountWindow();
                accountWindow.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                createJLabel.setForeground(Color.BLUE);
                createJLabel.setText("<html><u>" + "Create an account" + "</u></html>");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                createJLabel.setForeground(Color.BLACK);
                createJLabel.setText("Create an account");
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (DBO.isUserExist(userNameTextField.getText(), passwordField1.getText())) {
                    setVisible(false);
                    PrincipalWindow principal = new PrincipalWindow();
                    principal.setVisible(true);
                }
                else
                    errorJLabel.setText("Error : Username or Password are wrong");
            }
        });
    }
}
