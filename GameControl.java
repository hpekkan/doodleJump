import java.awt.event.*;
public class GameControl extends Thread implements KeyListener{
    Doodle doodle;
    Player player;
    public boolean right,left;
    public boolean running=true;
    public GameControl(Doodle doodle,Player player) {
        super();
        this.doodle=doodle;
        this.player=player;
        
    }
    @Override
    public void run() {
        super.run();
        while(running){
            try{
                doodle.update();
                doodle.repaint();
                Thread.sleep(1000/144);
            }catch(InterruptedException e){
                e.printStackTrace();
                 
                 
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(Character.toUpperCase(e.getKeyChar())=='A' || e.getKeyCode()==37){
            left=true;
        }
        if(Character.toUpperCase(e.getKeyChar())=='D'|| e.getKeyCode()==39){
            right=true;
            
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(Character.toUpperCase(e.getKeyChar())=='A' || e.getKeyCode()==37){
            left=false;
        }
        if(Character.toUpperCase(e.getKeyChar())=='D'|| e.getKeyCode()==39){
            right=false;
            
        }
    }    
}
