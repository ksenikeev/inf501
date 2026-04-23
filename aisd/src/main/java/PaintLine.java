import javax.swing.*;
import java.awt.*;

public class PaintLine  extends JFrame {

    public static void main(String[] args) {
        PaintLine paintLine = new PaintLine();
    }

    public PaintLine(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(400, 400);
        setVisible(true);
    }

    public void paint(Graphics g) {
        // x1, y1 - x2,y2
        g.drawLine(10, 10 + 50, 200,200);
    }
}
