/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

/**
 *
 * @author jonas
 */
import java.awt.*;
import java.awt.geom.*;
import javax.swing.border.*;

public class RoundedBorder implements Border
{

    private int radius;

    public RoundedBorder(int radius)
    {
        this.radius = radius;
    }

    public Insets getBorderInsets(Component c)
    {
        return new Insets(this.radius, this.radius, this.radius, this.radius);
    }

    public boolean isBorderOpaque()
    {
        return false;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
    {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(255,255,255));
        RoundRectangle2D borde = new RoundRectangle2D.Double(x, y, width-1, height-1, radius*2, radius*2);
        Stroke grosor = new BasicStroke(radius-1,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER);
        g2d.setStroke(grosor);
        g2d.draw(borde);

    }
}
