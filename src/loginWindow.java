import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginWindow extends JFrame{
    private JTextField userNameTextField;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JButton cancelButton;
    private JPanel pnlMain;


    public loginWindow(){

        setContentPane(pnlMain);

        setTitle("Login Amazon");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(360,250);
        setLocationRelativeTo(null);
        setVisible(true);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


}
