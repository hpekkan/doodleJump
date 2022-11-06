import java.awt.Rectangle;
public class Player extends Rectangle{
    private int posX,posY;
    public int count=0;

    public int getPosX() {
        return this.posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    public Player(int posX, int posY){
        super();
        this.posX = posX;
        this.posY = posY;
        setRect(posX+10,posY+55,40,5);
    }

}
