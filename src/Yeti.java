

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Yeti {

    private Image ImgYeti;
    private int i, nFrame, x, y, dx, dy;
    ImageIcon iiLoadYeti;
    Image ImgMovement[][] = new Image[5][2];
    private final int SPEED = 15;
    boolean left, right, up, down, canJump = true, isJumping = false, isWalking = false;
    Timer TimerMovement;
    Timer TimerGrav;
    Timer TimerJump;

    public Yeti() {
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 5; i++) {
                iiLoadYeti = new ImageIcon("Yeti" + j + i + ".png");
                ImgMovement[i][j] = iiLoadYeti.getImage();
            }
        } 
        x = 10;
        y = 238;
        dx = 0;
        dy = 0;
        left = false;
        right = false;
        up = false;
        down = false;
        TimerJump = new Timer(500, jumpingCheck);
        TimerJump.start();
        TimerGrav = new Timer(25, GravDrop);
        TimerGrav.start();
        TimerMovement = new Timer(100, updateImage);
        TimerMovement.start();
    }
    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
        //get x for repainting
    }

    public int getY() {
        return y;
        //get y for repainting
    }

    public Image getImage() {
        ImgYeti = ImgMovement[i][nFrame];
        if (right == true) {
            if (nFrame == 0) {
            }
        } else if (left == true) {
            nFrame = 1;
            if (nFrame == 0) {;
            }
        } else if (up == true) {
        } else if (down == true) {
        }
        return ImgYeti;
    }

    public void keyPressed(KeyEvent k) {
        int code = k.getKeyCode();
        //AnimationMutator();
        // was animating with any key
        //when you hit the barrier at the left or right and the jump you can ignore the barrier
        if (code == KeyEvent.VK_A) {
            isWalking = true;
            left = true;
            if (x - SPEED <= 0) {
                x = 0;
            } else {
                dx = -SPEED;
                AnimationMutator();
            }

        } else if (code == KeyEvent.VK_D) {
            isWalking = true;
            right = true;
            if (x + (ImgYeti.getWidth(null)) + SPEED >= 1250) {
                x = 1250 - (ImgYeti.getWidth(null));
            } else {
                dx = SPEED;
                AnimationMutator();
            }

        } else if (code == KeyEvent.VK_W) {
            //if you walk to the left or right while at the max height you ignor the barrier
                up = true;
                if (y - 45 <= 45) {
                    y = 45;
                } else {
                    dy = -45;
                    canJump = false;
                }

        } else if (code == KeyEvent.VK_S) {
            down = true;
            if (y < 375) {
                y = 375;
            }
        }
    }

    public void keyReleased(KeyEvent k) {
        int code = k.getKeyCode();
        isWalking = false;
        i = 0;
        if (code == KeyEvent.VK_A) {
            left = false;
            if (right) {
            } else {
                dx = 0;
            }
        } else if (code == KeyEvent.VK_D) {
            right = false;
            if (left) {
            } else {
                dx = 0;
            }
        } else if (code == KeyEvent.VK_W) {
            up = false;
            if (up) {
            } else {
                dy = 0;
            }
        } else if (code == KeyEvent.VK_S) {
            down = false;
            if (up) {
            } else {
                dy = 0;
            }
        }
    }

    public void AnimationMutator() {
        if (right == true) {
            nFrame = 1;
        } else if (left == true) {
            nFrame = 0;
        }
    }
    ActionListener updateImage = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (isWalking == true) {
                i++;
                if (i >= 4) {
                    i = 0;
                }
            }

        }
    };
    ActionListener GravDrop = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (up == false) {
                if (y < 400) {
                    y += 5;
                }
            }


        }
    };
    ActionListener jumpingCheck = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (isJumping == false) {
            }
            canJump = true;
        }
    };
}
