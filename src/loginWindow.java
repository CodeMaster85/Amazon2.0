import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class loginWindow extends JFrame{
    private JTextField userNameTextField;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JButton cancelButton;
    private JPanel pnlMain;
    private JLabel createJLabel;
    private JLabel errorJLabel;


    public loginWindow(){

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
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        createJLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                createJLabel.setText("Go to Walmart");
                //setVisible(false);
                createAccountWindow accountWindow = new createAccountWindow();
                accountWindow.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                createJLabel.setForeground(Color.BLUE);
                createJLabel.setText("<html><u>" + "Create an account" + "</u></html>"); //Chat gpt pour savoir comment souligner
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
                errorJLabel.setText("Error : Username or Password are wrong");
            }
        });
    }


}
