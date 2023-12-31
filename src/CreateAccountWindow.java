import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * The CreateAccountWindow class represents the window for creating a new user account in the XYTExpress.com application.
 * Users can input their personal information, and the system checks for completion and password match before creating the account.
 *
 * <p>The window includes text fields for first name, last name, username, email, password, and confirmation password.
 * It also provides error messages for incomplete information or mismatched passwords.</p>
 *
 * @author Thomas
 * @see DBO
 * @see LoginWindow
 * @version 1.0
 */
public class CreateAccountWindow extends JFrame {
    private JPanel pnlMain;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField usernameTextField;
    private JTextField emailTextField;
    private JPasswordField passwordTextField;
    private JLabel errorJLabel;
    private JButton createAccountButton;
    private JButton cancelButton;
    private JLabel firstNameLabel;
    private JPasswordField confirmPasswordTextField;
    private JLabel errorJLabel2;
    private JLabel titleJLabel;

    /**
     * Constructs a new instance of the CreateAccountWindow class.
     *
     * <p>The window initializes the graphical user interface components, including text fields for personal information,
     * buttons for account creation and cancellation, and error labels for feedback.</p>
     */
    public CreateAccountWindow() {
        setContentPane(pnlMain);

        setTitle("Create an account");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        titleJLabel.setFont(new Font("Arial", Font.BOLD,25));
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                errorJLabel.setText("");
                errorJLabel2.setText("");

                ArrayList<JTextField> textField = new ArrayList<>();
                textField.add(firstNameTextField);
                textField.add(lastNameTextField);
                textField.add(usernameTextField);
                textField.add(emailTextField);
                textField.add(passwordTextField);
                textField.add(confirmPasswordTextField);

                for (JTextField i : textField) {
                    if (i.getText().isEmpty()) {
                        errorJLabel.setText("Error : Please complete all the tabs");
                    }
                    if (!Arrays.equals(passwordTextField.getPassword(), confirmPasswordTextField.getPassword())) { //Merci André
                        errorJLabel2.setText("Error : Passwords does not match");
                    }
                }

                if (errorJLabel.getText().isEmpty() && errorJLabel2.getText().isEmpty()){
                    try {
                        DBO.addUser(usernameTextField.getText(), passwordTextField.getText(), firstNameTextField.getText(),lastNameTextField.getText(),emailTextField.getText());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(CreateAccountWindow.this, "Account created, We have sent you an Email confirmation");
                    LoginWindow loginWindow = new LoginWindow();
                    loginWindow.setVisible(true);
                    setVisible(false);
                }
            }

        });
        usernameTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == ' ') {
                    e.consume();
                    // ignore space event
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        passwordTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == ' ') {
                    e.consume();
                    // ignore space event
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        emailTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == ' ') {
                    e.consume();
                    // ignore space event
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                LoginWindow loginWindow = new LoginWindow();
                loginWindow.setVisible(true);
            }
        });
    }

}
