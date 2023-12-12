import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

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


    public CreateAccountWindow() {
        setContentPane(pnlMain);

        setTitle("Create an account");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        //titleJLabel.setFont(20);
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

                if (errorJLabel.getText()=="" && errorJLabel2.getText()==""){
                    JOptionPane.showMessageDialog(CreateAccountWindow.this, "Account created, We have sent you an Email confirmation");
                    setVisible(false);
                }
            }

        });
        usernameTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { //Chat GPT
                if (e.getKeyChar() == ' ') {
                    e.consume(); // Empêche l'ajout de l'espace dans le JTextField
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        passwordTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == ' ') {
                    e.consume(); // Empêche l'ajout de l'espace dans le JTextField
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        emailTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == ' ') {
                    e.consume(); // Empêche l'ajout de l'espace dans le JTextField
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
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
