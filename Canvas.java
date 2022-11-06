import javax.swing.*;
public class Canvas extends JFrame{
    public Canvas(){
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new Doodle());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
   
}

