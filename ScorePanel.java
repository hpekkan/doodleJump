import java.awt.*;

import javax.swing.*;
public class ScorePanel extends JPanel{
    JLabel l;
    public ScorePanel() {
        setBounds(5, 5, 190, 40);
        setOpaque(false);

        l = new JLabel("Score: 0");
        l.setForeground(Color.RED);
        l.setFont(new Font("Arial", Font.BOLD,25));
        add(l);
    }
    public void setScore(int score){
        l.setText("Score: "+score);
    }
}
