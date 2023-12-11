import javax.swing.*;
import java.awt.*;

public class PrincipalWindow extends JFrame{
    private JPanel pnlMain;
    private JButton signOutButton;
    private JLabel acceuilButtonLabel;
    private JLabel cartJLabel;
    private JPanel menuJPanel;

    public PrincipalWindow()
    {
        //this.pnlMain = new JPanel();
        setContentPane(pnlMain);

        setTitle("Login XYT Express");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,500);
        setLocationRelativeTo(null);


        ImageIcon icon = new ImageIcon("Amazone2.0\\images\\logoXYT.png");

        acceuilButtonLabel.setIcon(icon);


        // Rendre la fenêtre visible
        setVisible(true);


    }
}
