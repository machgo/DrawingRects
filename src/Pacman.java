import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;


public class Pacman extends JComponent
{
    private int _posX, _posY;
    private int _size;
    private int _mouthArcStart, _mouthArcExtent;
    private boolean _mouthClosing;
    private PacDir _direction;


    public void setdirection(PacDir _direction)
    {
        this._direction = _direction;
    }

    public Pacman(int posX, int posY, int size)
    {
        this._posX = posX;
        this._posY = posY;
        this._size = size;
        this._mouthArcStart = 45; //from 45 to 0 and back
        this._mouthArcExtent = 270; // from 270 to 360 and back
        this._mouthClosing = true;
        this._direction = PacDir.RIGHT;

    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Arc2D arc = new Arc2D.Float(Arc2D.PIE);
        arc.setFrame(_posX - _size / 2, _posY - _size / 2, _size, _size);

        int arcStart = _mouthArcStart;
        if (_direction == PacDir.UP)
            arcStart+=90;
        if (_direction == PacDir.LEFT)
            arcStart+=180;
        if (_direction == PacDir.DOWN)
            arcStart+=270;


        arc.setAngleStart(arcStart);
        arc.setAngleExtent(_mouthArcExtent);

        if (_mouthClosing)
        {
            if (_mouthArcStart == 0)
            {
                _mouthClosing = false;
                _mouthArcStart++;
                _mouthArcExtent = _mouthArcExtent -2;
            }
            else
            {
                _mouthArcStart--;
                _mouthArcExtent = _mouthArcExtent +2;
            }
        }
        else
        {
            if (_mouthArcStart == 45)
            {
                _mouthClosing = true;
                _mouthArcStart--;
                _mouthArcExtent = _mouthArcExtent +2;
            }
            else
            {
                _mouthArcStart++;
                _mouthArcExtent = _mouthArcExtent -2;
            }
        }

        g2.draw(arc);
        g2.setColor(Color.YELLOW);
        g2.fill(arc);
    }

    @Override
    public void repaint()
    {
        super.repaint();
    }


    public void move()
    {
        if (_direction == PacDir.UP)
            _posY--;
        if (_direction == PacDir.DOWN)
            _posY++;
        if (_direction == PacDir.LEFT)
            _posX--;
        if (_direction == PacDir.RIGHT)
            _posX++;

        this.repaint();
    }

    public int getposX()
    {
        return _posX;
    }

    public void setposX(int _posX)
    {
        this._posX = _posX;
        this.repaint();
    }

    public int getposY()
    {
        return _posY;
    }

    public void setposY(int _posY)
    {
        this._posY = _posY;
    }

    public int getsize()
    {
        return _size;
    }

    public void setsize(int _size)
    {
        this._size = _size;
    }
}
