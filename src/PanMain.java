
import java.awt.BorderLayout;
import javax.swing.JPanel;
public class PanMain extends JPanel{
    PanGame pangame = new PanGame();
    PanStats panstats = new PanStats();
    public PanMain(){
        
        setLayout(new BorderLayout());
        add(pangame, BorderLayout.CENTER);
        add(panstats, BorderLayout.SOUTH);
    }
}
