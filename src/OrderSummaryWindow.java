import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderSummaryWindow extends JFrame {
    private JPanel pnlMain;
    private JLabel competeJLabel;
    private JLabel summaryJLabel;
    private JButton homePageButton;

    public OrderSummaryWindow(){

        setContentPane(pnlMain);
        setTitle("XYTExpress.com");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,350);
        setLocationRelativeTo(null);

        competeJLabel.setFont(new Font("Arial", Font.BOLD,20));
        summaryJLabel.setFont(new Font("Arial",Font.BOLD,15));


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
