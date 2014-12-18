
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;

public class PanMainMenu extends JPanel{
    public JButton btnPlay ,btnExit,btnStats;
    Image Menu;
    
    public PanMainMenu(){
        btnPlay = new JButton("Start Game");
        btnExit = new JButton("End Game");
        //btnStats = new JButton("Stats");
        setLayout(null);
        ImageIcon menu = new ImageIcon("menu.png");
        Menu = menu.getImage();
        
        //position and size of the buttons
        btnPlay.setBounds(900, 400, 100, 50);
        //btnStats.setBounds(900, 475, 100, 50);
        btnExit.setBounds(900, 550, 100, 50);
        // add the buttons
        add(btnPlay);
        //add(btnStats);
        add(btnExit);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Menu, 0, (- 10), null);
        //without the -10 the menu image will have not be completely in focus
    }
}
