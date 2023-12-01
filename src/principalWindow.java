import javax.swing.*;

public class principalWindow extends JFrame{
    private JButton signOutButton;
    private JLabel acceuilButtonLabel;
    private JLabel cartJLabel;
    private JPanel menuJPanel;
    private JPanel pnlMain;

    public principalWindow()
    {
        setContentPane(pnlMain);

        setTitle("Create an account");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,600);
        setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon("images/logoXYT.png");
        JLabel acceuilButtonLabel = new JLabel("", icon, SwingConstants.LEFT);

        ImageIcon icon2 = new ImageIcon("\uD83D\uDED2");
        JLabel cartJLabel = new JLabel("", icon2, SwingConstants.LEFT);

        JPanel menuJPanel = new JPanel();
        menuJPanel.add(acceuilButtonLabel);
        menuJPanel.add(cartJLabel);

    }
}
