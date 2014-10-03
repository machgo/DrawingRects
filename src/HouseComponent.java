
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by marco on 26/09/14.
 */
public class HouseComponent extends JComponent
{
    int x = 0;

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Line2D line1 = new Line2D.Float(20,20,120,120);
        Line2D line2 = new Line2D.Float(340,20,240,120);
        Rectangle rec1 = new Rectangle(120,120,120,120);

        g2.draw(line1);
        g2.draw(line2);
        g2.draw(rec1);
    }


}
