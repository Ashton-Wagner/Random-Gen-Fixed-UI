
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanStats extends JPanel {
    ImageIcon iiLoadNums;
    ImageIcon imgiTime = new ImageIcon("Time.png");
    ImageIcon imgiScore = new ImageIcon("Score.png");
    ImageIcon imgiLives = new ImageIcon("Lives.png");
    ImageIcon imgiCoins = new ImageIcon("Coins.png");
    ImageIcon imgUIBG = new ImageIcon("UIBackground.png");
    Image ariNumbers[] = new Image[10];
    Image iUIBG;
    Image imgTime;
    Image imgScore;
    Image imgLives;
    Image imgCoins;
    Image imgTimeCount1;
    Image imgTimeCount2;
    Image imgTimeCount3;
    Image iBG;
    Boolean bStopTimer = false;
    Boolean bTimeChanged;
    Timer timer;
    int Time1 = 0;
    int Time2 = 0;
    int Time3 = 9;
    int nLife = 3;
    int nCoins1 = 0;
    int nCoins2 = 0;
    int nScore1 = 0;
    int nScore2 = 0;
    int nScore3 = 0;

    public PanStats() {
        setPreferredSize(new Dimension(1250, 75));
        ////Loads all needed images
        for (int i = 0; i < 10; i++) {
            iiLoadNums = new ImageIcon("img" + i + ".png");
            ariNumbers[i] = iiLoadNums.getImage();
        }
        imgCoins = imgiCoins.getImage();
        iUIBG = imgUIBG.getImage();
        imgTime = imgiTime.getImage();
        imgScore = imgiScore.getImage();
        imgLives = imgiLives.getImage();
        timer = new Timer(1000, updateImage);
        ////Starts the Animation of the Southern Pane
        timer.start();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        ////Paints the Background of the southern pane
        g.drawImage(iUIBG, 0, 0, null);
        ////Paints the "Time" part of the southern pane
        g.drawImage(imgTime, 950, 10, null);
        g.drawImage(ariNumbers[(Time1)], 950 + imgTime.getWidth(this), 10, null);
        g.drawImage(ariNumbers[(Time2)], 950 + imgTime.getWidth(this) + 30, 10, null);
        g.drawImage(ariNumbers[(Time3)], 950 + imgTime.getWidth(this) + 60, 10, null);
        ////Paints the "Lives" part of the southern pane
        g.drawImage(imgLives, 10, 10, null);
        g.drawImage(ariNumbers[(nLife)], 10 + imgLives.getWidth(this), 10, null);
        ////Paints the "Score" part of the southern pane
        g.drawImage(imgScore, 520, 10, null);
        g.drawImage(ariNumbers[(nScore1)], 520 + imgScore.getWidth(this) + 10, 10, null);
        g.drawImage(ariNumbers[(nScore2)], 520 + imgScore.getWidth(this) + 40, 10, null);
        g.drawImage(ariNumbers[(nScore3)], 520 + imgScore.getWidth(this) + 70, 10, null);
        ////Paints the "Coins" part of the southern pane
        g.drawImage(imgCoins, 230, 10, null);
        g.drawImage(ariNumbers[(nCoins1)], 230 + imgCoins.getWidth(this) + 10, 10, null);
        g.drawImage(ariNumbers[(nCoins2)], 230 + imgCoins.getWidth(this) + 40, 10, null);
    }
    ActionListener updateImage = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            ////This Controls how the timer loads the images for the "Time"
            ////part of the southern pane
            //bStopTimer  stops the timer
            if (nLife != 0) {
                ////When time runs out, reset the timer and lose a life
                if (Time1 == 0 && Time2 == 0 && Time3 == 0) {
                    Time1 = 0;
                    Time2 = 1;
                    Time3 = 0;
                    nLife--;
                }
                ////bTimeChanged makes it so you ccant go from 109 to 98  
                ////(part of controlling the timer)
                Boolean bTimeChanged;
                if (bStopTimer != true) {
                    bTimeChanged = false;
                    /////Makes 100's -1 and 10's +9
                    if (Time2 == 0 && Time3 == 0 && Time1 != 0) {
                        Time1 -= 1;
                        Time2 += 10;
                        bTimeChanged = true;
                    }
                    //makes 10's -1 and 1's +9
                    if (Time3 == 0 && Time2 != 0) {
                        Time2 -= 1;
                        Time3 += 10;
                        bTimeChanged = true;
                    }
                    /////Makes 1's -1
                    Time3--;
                    ////
                }
            }
            repaint();
        }
    };
}