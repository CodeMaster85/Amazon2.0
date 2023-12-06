import javax.swing.*;

public class principalWindow {
    private JButton signOutButton;
    private JLabel acceuilButtonLabel;
    private JLabel cartJLabel;
    private JPanel menuJPanel;

    public principalWindow()
    {



        ImageIcon icon = new ImageIcon("images/logoXYT.png");
        JLabel acceuilButtonLabel = new JLabel("", icon, SwingConstants.LEFT);

        ImageIcon icon2 = new ImageIcon("\uD83D\uDED2");
        JLabel cartJLabel = new JLabel("", icon2, SwingConstants.LEFT);

        JPanel menuJPanel = new JPanel();
        menuJPanel.add(acceuilButtonLabel);
        menuJPanel.add(cartJLabel);

    }
}
