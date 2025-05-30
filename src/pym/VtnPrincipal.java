/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pym;

import clases.conex.Conexion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonUI;
import raven.scroll.win11.ScrollBarWin11UI;

/**
 *
 * @author jonas
 */
public class VtnPrincipal extends javax.swing.JFrame
{

    /**
     * Creates new form VtnPrincipal
     */
    private int posX, posY;
    static Font font;
    String rutaImg;
    private boolean maximizar = false;

    public VtnPrincipal()
    {
        initComponents();
        Conexion conex= new Conexion();
        exit.setUI(new BasicButtonUI());
        minimized.setUI(new BasicButtonUI());
        titulo.setFont(cambiarFont("Agency FB", 22, 2));
        minimized.setFont(cambiarFont("Arial", 16, 2));
        exit.setFont(cambiarFont("Arial", 16, 2));
        rutaImg = "/imagenes/Logo AbastoFacil.jpeg";
        ImageIcon icono = new ImageIcon(getClass().getResource(rutaImg));
        setIconImage(icono.getImage());
        pintar(new VentaProducto());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        minimized = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            public void mouseDragged(java.awt.event.MouseEvent evt)
            {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                formMousePressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(33, 12, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(800, 30));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 30));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setVerifyInputWhenFocusTarget(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("AbastoFácil");
        jPanel2.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 50));

        exit.setBackground(new java.awt.Color(33, 12, 255));
        exit.setFont(new java.awt.Font("Agency FB", 0, 13)); // NOI18N
        exit.setText("X");
        exit.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                exitMouseExited(evt);
            }
        });
        exit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                exitActionPerformed(evt);
            }
        });
        jPanel2.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(974, 0, 50, 50));

        minimized.setBackground(new java.awt.Color(33, 12, 255));
        minimized.setText("─");
        minimized.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                minimizedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                minimizedMouseExited(evt);
            }
        });
        minimized.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                minimizedActionPerformed(evt);
            }
        });
        jPanel2.add(minimized, new org.netbeans.lib.awtextra.AbsoluteConstraints(924, 0, 50, 50));

        jPanel1.setMinimumSize(new java.awt.Dimension(800, 570));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 570));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setMinimumSize(new java.awt.Dimension(800, 570));
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 570));
        jPanel3.setLayout(null);
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 718));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_formMousePressed
    {//GEN-HEADEREND:event_formMousePressed
        posX = evt.getX();
        posY = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt)//GEN-FIRST:event_formMouseDragged
    {//GEN-HEADEREND:event_formMouseDragged
        int newX = getLocation().x + evt.getX() - posX;
        int newY = getLocation().y + evt.getY() - posY;
        setLocation(newX, newY);
    }//GEN-LAST:event_formMouseDragged

    private void exitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_exitActionPerformed
    {//GEN-HEADEREND:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void exitMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_exitMouseExited
    {//GEN-HEADEREND:event_exitMouseExited
        exit.setBackground(new Color(0, 0, 255));
    }//GEN-LAST:event_exitMouseExited

    private void exitMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_exitMouseEntered
    {//GEN-HEADEREND:event_exitMouseEntered
        exit.setBackground(Color.RED);
    }//GEN-LAST:event_exitMouseEntered

    private void minimizedActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_minimizedActionPerformed
    {//GEN-HEADEREND:event_minimizedActionPerformed
        setState(Frame.ICONIFIED);
    }//GEN-LAST:event_minimizedActionPerformed

    private void minimizedMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_minimizedMouseEntered
    {//GEN-HEADEREND:event_minimizedMouseEntered
        minimized.setBackground(new Color(30, 161, 255));
    }//GEN-LAST:event_minimizedMouseEntered

    private void minimizedMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_minimizedMouseExited
    {//GEN-HEADEREND:event_minimizedMouseExited
        minimized.setBackground(new Color(33, 12, 255));
    }//GEN-LAST:event_minimizedMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(VtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(VtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(VtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(VtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        UIDefaults ui = UIManager.getDefaults();

        ui.put("ScrollBarUI", ScrollBarWin11UI.class.getCanonicalName());
        ui.put("ScrollBar.background", Color.white);
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new VtnPrincipal().setVisible(true);
            }
        });
    }

    /**
     * Este metodo es para cambiar de tamaño como de estilo un texto
     *
     * @param fuente es para darle una fuente a las letras en este caso Arial u
     * otro
     * @param tamaño para darle el tamaño que se necesite el texto
     * @param opc para la opciones en cuanto al estilo aca las opciones 1 para
     * normal, 2 para negritas, 3 para cursiva y 4 para negrita con cursiva
     * @return retorna el estilo que se haya escogigo
     *
     */
    public static Font cambiarFont(String fuente, int tamaño, int opc)
    {
        switch (opc)
        {
            case 1:
                font = new Font(fuente, Font.PLAIN, tamaño);
                break;
            case 2:
                font = new Font(fuente, Font.BOLD, tamaño);
                break;
            case 3:
                font = new Font(fuente, Font.ITALIC, tamaño);
                break;
            case 4:
                font = new Font(fuente, Font.BOLD + Font.ITALIC, tamaño);
                break;

            default:
                font = new Font("Arial", Font.PLAIN, 12);
        }
        return font;
    }

    public static void pintar(JPanel p)
    {
        p.setSize(1024, 718);
        p.setLocation(0, 0);
        jPanel3.removeAll();
        jPanel3.add(p, BorderLayout.CENTER);
        jPanel3.revalidate();
        jPanel3.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private static javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JButton minimized;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
