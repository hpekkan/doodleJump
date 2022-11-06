import java.awt.*;
import java.util.*;
import javax.swing.*;
public class Platform extends Rectangle{
    public ImageIcon image;
    public Platform(Random random){
        super();
        image = new ImageIcon(Doodle.class.getResource("/assets/platform.png"));
        this.x=random.nextInt(472);
        this.y=random.nextInt(830);
        setRect(x+10,y,40,20);
    }
}
