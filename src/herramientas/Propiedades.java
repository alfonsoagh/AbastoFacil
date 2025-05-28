/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author PC
 */
public class Propiedades extends BasicComboBoxUI
{

//    Color c = new Color(32,178,170);
    Color c = new Color(30, 200, 255);

    public static ComboBoxUI createUI(JComponent com)
    {
        return new Propiedades();
    }

    @Override
    protected JButton createArrowButton()
    {
        JButton btn = new JButton();
        btn.setIcon(new ImageIcon(getClass().getResource("/imagenes/iconAbajo.png")));
        btn.setBorder(BorderFactory.createLineBorder(c, 4));
        btn.setBackground(c);
        btn.setUI(new BasicButtonUI());
        return btn;
    }

    @Override
    public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus)
    {
        g.setColor(c);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    @Override
    protected ListCellRenderer createRenderer()
    {
        return new DefaultListCellRenderer()
        {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
            {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
                
                list.setSelectionBackground(c);
                list.setForeground(Color.black);
//                if(index !=-1)
//                {
//                    setIcon(new ImageIcon(getClass().getResource("/imagenes/iconFar.png")));
//                }
                
                return this;
            }

        };

    }

}
