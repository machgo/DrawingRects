import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by marco on 26/09/14.
 */
public class Main
{
    public static void main(String args[])
    {
        JFrame frame = new JFrame();

        frame.setSize(1200,700);
        frame.setTitle("Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Pacman pac = new Pacman(300,300,300);
        frame.add(pac);

        frame.setVisible(true);
        frame.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {

            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyChar() == 'w')
                    pac.setdirection(PacDir.UP);
                if (e.getKeyChar() == 's')
                    pac.setdirection(PacDir.DOWN);
                if (e.getKeyChar() == 'a')
                    pac.setdirection(PacDir.LEFT);
                if (e.getKeyChar() == 'd')
                    pac.setdirection(PacDir.RIGHT);
            }

            @Override
            public void keyReleased(KeyEvent e)
            {

            }
        });

        do
        {
            pac.move();
            try
            {
                Thread.sleep(10);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }while(true);
    }
}
