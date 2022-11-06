import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.*;
public class EndPanel extends JPanel {
    private long score=0;
    public JLabel l;
    public EndPanel(){
        setBounds(200,200,200,300);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=gbc.gridy=0;
        gbc.weightx=gbc.weighty=0;
        gbc.weightx=gbc.weighty=1;
        gbc.insets = new Insets(60,20,20,20);
        gbc.anchor = GridBagConstraints.CENTER;
        l = new JLabel("Skorunuz: " + score);
        l.setFont(new Font("Sans Serif",Font.BOLD,20));
        add(l,gbc);
        JButton btn = new JButton("Exit");
        btn.setFont(new Font("Sans Serif",Font.BOLD,14));
        btn.setFocusable(false);
        btn.setBackground(new Color(244, 162, 97));
        btn.addActionListener((e)->System.exit(0));
        gbc.insets = new Insets(20,20,20,20);
        gbc.gridy=1;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        add(btn,gbc);
        setBackground(new Color(231, 111, 81));
        setVisible(false);
        setOpaque(true);
    }
    public void setScore(long score){
        this.score=score;
    }
    public void makeVisible(){
        setVisible(true);
         l.setText("Score: " + score);
         
    }
}