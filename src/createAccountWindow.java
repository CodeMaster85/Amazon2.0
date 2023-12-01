import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class createAccountWindow extends JFrame {
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



    public createAccountWindow(){
        setContentPane(pnlMain);

        setTitle("Create an account");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,600);
        setLocationRelativeTo(null);

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                ArrayList<JTextField> textField = new ArrayList<>();
                textField.add(firstNameTextField);
                textField.add(lastNameTextField);
                textField.add(usernameTextField);
                textField.add(emailTextField);
                textField.add(passwordTextField);
                textField.add(confirmPasswordTextField);

                for( JTextField i : textField){
                    if(i.getText().isEmpty()){
                        errorJLabel.setText("Error : Please complete all the tabs");
                    }
                    if (!Arrays.equals(passwordTextField.getPassword(), confirmPasswordTextField.getPassword())){ //Merci André
                        errorJLabel2.setText("Error : Passwords does not match");
                    }
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

    }

}
