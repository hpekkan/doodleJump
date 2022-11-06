import java.awt.Graphics;
import java.util.*;
import java.awt.*;
import javax.swing.*;
public class Doodle extends JPanel{
    int score=0;
    Thread thread;
    GameControl game;
    Player player;
    Random random;
    float dy=0;
    ArrayList<Platform> platforms;//arraylist of platforms
    EndPanel end;
    ScorePanel scorePanel;
    ImageIcon icon,background;
    public Doodle(){
        setLayout(null);
        setPreferredSize(new Dimension(532,850));
        end = new EndPanel();
        add(end);
        scorePanel = new ScorePanel();
        add(scorePanel);
        start();
        game.start();
        setFocusable(true);
        addKeyListener(game);
        icon = new ImageIcon(Doodle.class.getResource("/assets/doodle.png"));//player image
        background = new ImageIcon(Doodle.class.getResource("/assets/background.png"));//background image
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);//paints the background
        background.paintIcon(this,g,0,0);//paints the background
        icon.paintIcon(this, g, player.getPosX(), player.getPosY());//paints the player
        platforms.stream().forEach(p -> p.image.paintIcon(this, g, p.x, p.y));//paints the platforms
    }
    public void start(){
        random = new Random();//random object
        platforms = new ArrayList<Platform>();//arraylist of platforms
        for(int i=1;i<=16;i++){//creates 16 platforms
            platforms.add(new Platform(random));//adds a platform to the arraylist
        }
        player = new Player(250,500);//creates a player
        game = new GameControl(this,player);//creates a gamecontrol object
        
    }
    public void update(){
        if(game.right){//if the right key is pressed
            player.setPosX(player.getPosX()+3);//moves the player to the right
        }
        if(game.left){//if the left key is pressed
            player.setPosX(player.getPosX()-3);//moves the player to the left
        }

        if(player.getPosX()<0) player.setPosX(512);//if the player goes off the left side of the screen, it will appear on the right side
        if(player.getPosX()>512) player.setPosX(0);//if the player goes off the right side of the screen, it will appear on the left side

        dy+=0.2;//adds 0.2 to dy
        player.setPosY((int)(player.getPosY()+dy));//adds dy to the player's y position
        if(player.getPosY()>790&&player.count==0){//if the player goes off the bottom of the screen and the player has not already died
            dy=-10;//sets dy to -10
        }
        for(Platform p:platforms){//for each platform in the arraylist
            if(p.intersects(player)&&dy>0){//if the player is on the platform and dy is greater than 0
                player.count++;//adds 1 to the player's count
                dy=-10;//sets dy to -10
            }
        }
        player.x=player.getPosX();//sets the player's x position to the player's x position
        player.y=player.getPosY()+55;//sets the player's y position to the player's y position plus 55
        if(player.getPosY()<300){//if the player's y position is less than 300
                score += (300-player.getPosY());// adds 300 minus the player's y position to the score
                player.setPosY(300);//sets the player's y position to 300
             platforms.stream().forEach(p -> {//for each platform in the arraylist
                boolean check=false;//sets check to false
                p.y-=dy;//subtracts dy from the platform's y position
                if(p.y>=830){//if the platform's y position is greater than or equal to 830
                    p.x=random.nextInt(472);//sets the platform's x position to a random number between 0 and 472
                    p.y=0;//sets the platform's y position to 0
                    check=true;//sets check to true
                }
                });
        }
        scorePanel.setScore(score);//sets the scorepanel's score to the score
        if(player.getPosY()>810){//if the player's y position is greater than 810
            game.running=false;//sets running to false
            end.setScore(score);//sets the endpanel's score to the score
            end.makeVisible();//makes the endpanel visible
            
        }

    }
}
