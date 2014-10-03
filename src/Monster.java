import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

/**
 * Created by marco on 03/10/14.
 */
public class Monster extends JComponent
{
    private int _posX, _posY;
    private int _size;

    public Monster(int posX, int posY, int size)
    {
        this._posX = posX;
        this._posY = posY;
        this._size = size;

    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Arc2D arc = new Arc2D.Float(Arc2D.PIE);
        arc.setFrame(_posX - _size / 2, _posY - _size / 2, _size, _size);
        arc.setAngleStart(0);
        arc.setAngleExtent(180);

        g2.draw(arc);
    }
}
