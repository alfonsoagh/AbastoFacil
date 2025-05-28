/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pym;

import clases.conex.CRUD;
import herramientas.TextPrompt;
import herramientas.Validaciones;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author jonas
 */
public class Devoluciones extends javax.swing.JPanel
{

    /**
     * Creates new form AltasProductos
     */
    boolean estado = false;
    DefaultTableModel m1 = new DefaultTableModel();
    DefaultTableModel m2 = new DefaultTableModel();

    public Devoluciones()
    {
        initComponents();
        buscar.setUI(new BasicButtonUI());
        buscar.setBackground(new Color(240, 240, 240));
        configCampos(false);
        TextPrompt cantidad = new TextPrompt("0", cantidadProd);
        reinicio();
        deshabilitaAlg();
        tickErr.setVisible(false);
    }

    public void reinicio()
    {
        ticket.setText("");
        ventInfo.setVisible(false);
        ventaP.setVisible(false);
        productosP.setVisible(false);
        productosInfo.setVisible(false);
        chechTot.setEnabled(false);
        monTex.setText("0.0");
        chechTot.setSelected(false);
        opcProducto.removeAllItems();
        opcProducto.addItem("Seleccione un producto");
    }

    public void configCampos(boolean v)
    {
        opcProducto.setEnabled(v);
        chechTot.setEnabled(v);
//        cantidadProd.setEnabled(v);
//        devProdTot.setEnabled(v);
        monTex.setText("0.0");
        monTex.repaint();
    }

    public void consultaCombo(JComboBox jb, String tabla, String sentencia)
    {
        try
        {
            ResultSet ratVenta = CRUD.read("Venta_Producto", "*", "WHERE id_VENTA = " + ticket.getText());
            jb.removeAllItems();
            jb.addItem("Seleccione un producto");
            while (ratVenta.next())
            {
                ResultSet rat = CRUD.read(tabla, "*", "WHERE ID = " + ratVenta.getString("id_Producto"));
                rat.next();
                jb.addItem(rat.getString("id") + ": " + rat.getString("Nombre"));
            }
            if (!(jb.getItemCount() > 1))
            {
                jb.setEnabled(false);
                productosP.setVisible(false);
                productosInfo.setVisible(false);
                JOptionPane.showMessageDialog(null, "Los Productos de la venta Ya NO \n Estan Disponibles");
                configCampos(false);
            } else
            {
                configCampos(true);
                llenarTablaProd();
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Devoluciones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarComboBox(ResultSet rat, JComboBox jcb)
    {
        jcb.removeAllItems();
        jcb.addItem("Seleccione un producto");
        if (rat != null)
        {
            try
            {
                while (rat.next())
                {
                    jcb.addItem(rat.getString("id") + ":  " + rat.getString("nombre"));
                }
            } catch (Exception e)
            {
                System.out.println(e.toString());
            }
        } else
        {

        }
    }

    public void llenarTablaVenta()
    {
        ventaP.setVisible(true);
        ventInfo.setVisible(true);
        ventaP.repaint();
        ventaP.removeAll();
        ventaSC.setVisible(true);
        ventaT.setRowHeight(32);
        m1 = new DefaultTableModel();
        String c2[] =
        {
            "Id (ticket)", "Fecha Hora", "Total"
        };
        m1.setColumnIdentifiers(c2);
        ventaT.setModel(m1);
        try
        {

            ResultSet rat = CRUD.read("ventas", "*", "WHERE id=" + ticket.getText());
            rat.next();
            String f[] =
            {
                rat.getString("id"), rat.getString("fechaHora"), rat.getString("total_Venta")
            };
            m1.addRow(f);
        } catch (Exception e)
        {
        }
        ventaT.setEnabled(false);
        ventaT.repaint();
        if (!(ventaT.getRowCount() >= 1))
        {
            ventInfo.setVisible(false);
            ventaP.setVisible(false);
        } else
        {
            ventaP.add(ventaSC);
            ventaP.repaint();
        }
    }

    public void llenarTablaProd()
    {
        productosP.setVisible(true);
        productosInfo.setVisible(true);
        productosP.removeAll();
        productosSC.setVisible(true);
        productosT.setRowHeight(32);
        m2 = new DefaultTableModel();

        String c2[] =
        {
            "Clave", "Nombre", "Magnitud", "Unidad", "Proveedor", "Categoria", "Cantidad Comprada", "Precio de Compra"
        };
        m2.setColumnIdentifiers(c2);
        productosT.setModel(m2);
        TableColumnModel columnModel = productosT.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(2).setPreferredWidth(40);
        columnModel.getColumn(3).setPreferredWidth(30);
        try
        {

            ResultSet rat = CRUD.read("venta_producto", "*", "WHERE id_Venta=" + ticket.getText());
            while (rat.next())
            {
                ResultSet ratProd = CRUD.read("producto", "*", "WHERE id=" + rat.getString("id_Producto"));
                ratProd.next();
                ResultSet ratProv = CRUD.read("Proveedor", "*", "WHERE id=" + ratProd.getString("id_Proveedor"));
                ratProv.next();
                ResultSet ratCat = CRUD.read("Categoria", "*", "WHERE id=" + ratProd.getString("id_Categoria"));
                ratCat.next();
                String f[] =
                {
                    ratProd.getString("id"), ratProd.getString("nombre"), ratProd.getString("magnitudMed"), ratProd.getString("unidadMed"),
                    ratProv.getString("Nombre"),
                    ratCat.getString("Nombre"),
                    rat.getString("cantidad"), rat.getString("total")
                };
                m2.addRow(f);
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        productosT.setEnabled(false);
        productosT.repaint();
        if (!(productosT.getRowCount() >= 1))
        {
            System.out.println("aaa");
            ventInfo.setVisible(false);
            productosP.setVisible(false);
        } else
        {
            System.out.println("as");
            productosP.add(productosSC);
            productosP.repaint();
        }
    }

    public void deshabilitaAlg()
    {
        cantidadProd.setEnabled(false);
        cantidadProd.setText("");
        devProdTot.setEnabled(false);
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

        bienvenidos = new javax.swing.JLabel();
        ticket = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        cantidadProd = new javax.swing.JTextField();
        codigo2 = new javax.swing.JLabel();
        devolucion = new javax.swing.JButton();
        codigo1 = new javax.swing.JLabel();
        monto = new javax.swing.JLabel();
        opcProducto = new javax.swing.JComboBox<>();
        chechTot = new javax.swing.JCheckBox();
        jSeparator4 = new javax.swing.JSeparator();
        monTex = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        devProdTot = new javax.swing.JCheckBox();
        tickErr = new javax.swing.JLabel();
        ventaP = new javax.swing.JPanel();
        ventaSC = new javax.swing.JScrollPane();
        ventaT = new javax.swing.JTable();
        productosP = new javax.swing.JPanel();
        productosSC = new javax.swing.JScrollPane();
        productosT = new javax.swing.JTable();
        ventInfo = new javax.swing.JLabel();
        productosInfo = new javax.swing.JLabel();
        productosInfo1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bienvenidos.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        bienvenidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bienvenidos.setText("Devoluciones");
        add(bienvenidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 250, -1));

        ticket.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ticket.setToolTipText("");
        ticket.setBorder(null);
        ticket.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                ticketFocusGained(evt);
            }
        });
        ticket.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ticketActionPerformed(evt);
            }
        });
        ticket.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                ticketKeyTyped(evt);
            }
        });
        add(ticket, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 230, 30));

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoLupa.png"))); // NOI18N
        buscar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                buscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                buscarMouseExited(evt);
            }
        });
        buscar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buscarActionPerformed(evt);
            }
        });
        add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 50, 50));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 230, 10));

        cantidadProd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cantidadProd.setToolTipText("");
        cantidadProd.setBorder(null);
        cantidadProd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cantidadProdActionPerformed(evt);
            }
        });
        cantidadProd.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                cantidadProdKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                cantidadProdKeyTyped(evt);
            }
        });
        add(cantidadProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 660, 180, 30));

        codigo2.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        codigo2.setText("Cantidad a devolver");
        add(codigo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 630, 190, 30));

        devolucion.setBackground(new java.awt.Color(33, 12, 255));
        devolucion.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        devolucion.setForeground(new java.awt.Color(255, 255, 255));
        devolucion.setText("Devolución");
        devolucion.setBorder(null);
        devolucion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        devolucion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        devolucion.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                devolucionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                devolucionMouseExited(evt);
            }
        });
        devolucion.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                devolucionActionPerformed(evt);
            }
        });
        add(devolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 890, 140, 50));

        codigo1.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        codigo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        codigo1.setText("Numero de venta (ticket)");
        add(codigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 230, 30));

        monto.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        monto.setText("Monto a devolver");
        add(monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 820, 180, 30));

        opcProducto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        opcProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Producto" }));
        opcProducto.setToolTipText("");
        opcProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        opcProducto.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                opcProductoItemStateChanged(evt);
            }
        });
        opcProducto.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                opcProductoActionPerformed(evt);
            }
        });
        add(opcProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, 350, -1));

        chechTot.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chechTot.setText("Devolver Toda la Venta");
        chechTot.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                chechTotActionPerformed(evt);
            }
        });
        add(chechTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 760, 220, 36));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 690, 180, 10));

        monTex.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        monTex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        monTex.setText("$0.00");
        add(monTex, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 820, 160, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Ó");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 720, -1, -1));

        devProdTot.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        devProdTot.setText("Devolver todo el producto");
        devProdTot.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                devProdTotActionPerformed(evt);
            }
        });
        add(devProdTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 650, 250, -1));

        tickErr.setForeground(new java.awt.Color(255, 0, 0));
        tickErr.setText("Rellenar Campo");
        tickErr.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                tickErrFocusGained(evt);
            }
        });
        add(tickErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 140, -1));

        ventaP.setBackground(new java.awt.Color(255, 255, 255));
        ventaP.setLayout(null);

        ventaT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ventaSC.setViewportView(ventaT);

        ventaP.add(ventaSC);
        ventaSC.setBounds(0, 0, 550, 60);

        add(ventaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 550, 60));

        productosP.setBackground(new java.awt.Color(255, 255, 255));
        productosP.setLayout(null);

        productosT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        productosSC.setViewportView(productosT);

        productosP.add(productosSC);
        productosSC.setBounds(0, 0, 700, 140);

        add(productosP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 700, 140));

        ventInfo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ventInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ventInfo.setText("Información de la Venta");
        add(ventInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 550, -1));

        productosInfo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        productosInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productosInfo.setText("Información de los Productos");
        add(productosInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 550, -1));

        productosInfo1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        productosInfo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productosInfo1.setText("Selección del Producto");
        add(productosInfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, 550, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 970, 30, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void ticketActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ticketActionPerformed
    {//GEN-HEADEREND:event_ticketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ticketActionPerformed

    private void ticketKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_ticketKeyTyped
    {//GEN-HEADEREND:event_ticketKeyTyped

    }//GEN-LAST:event_ticketKeyTyped

    private void buscarMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_buscarMouseEntered
    {//GEN-HEADEREND:event_buscarMouseEntered
        buscar.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_buscarMouseEntered

    private void buscarMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_buscarMouseExited
    {//GEN-HEADEREND:event_buscarMouseExited
        buscar.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_buscarMouseExited

    private void buscarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buscarActionPerformed
    {//GEN-HEADEREND:event_buscarActionPerformed
        if (ticket.getText().isEmpty())
        {
            tickErr.setVisible(true);
            estado = false;
            JOptionPane.showMessageDialog(null, "Ingrese una venta");
        } else
        {
            llenarTablaVenta();
            if (ventaP.isVisible())
            {
                opcProducto.removeAllItems();
                deshabilitaAlg();
                opcProducto.addItem("Seleccione un Producto");
                consultaCombo(opcProducto, "Producto", "");
                estado = true;
            } else
            {
                estado = false;
                opcProducto.removeAllItems();
                opcProducto.addItem("Seleccione un Producto");
                deshabilitaAlg();
                opcProducto.setEnabled(false);
                reinicio();
                JOptionPane.showMessageDialog(null, "No existe la Venta");
            }
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void cantidadProdActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cantidadProdActionPerformed
    {//GEN-HEADEREND:event_cantidadProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadProdActionPerformed

    private void cantidadProdKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_cantidadProdKeyTyped
    {//GEN-HEADEREND:event_cantidadProdKeyTyped
//        System.out.println(evt.getKeyCode());
        Validaciones.validaEntero(evt, 10, cantidadProd.getText());

        try
        {
            Integer.parseInt(cantidadProd.getText() + evt.getKeyChar());
            ResultSet ratP = CRUD.read("venta_Producto", "*", "WHERE id_Venta="
                    + ventaT.getModel().getValueAt(0, 0).toString() + " AND id_Producto ="
                    + opcProducto.getSelectedItem().toString().split(":")[0]);
            try
            {
                ratP.next();
                if (Integer.parseInt(cantidadProd.getText() + evt.getKeyChar()) > ratP.getInt("cantidad"))
                {
                    evt.consume();
                } else
                {
                    ResultSet rat = CRUD.read("venta_Producto", "*", "WHERE id_Venta= "
                            + ventaT.getModel().getValueAt(0, 0).toString() + " AND id_Producto="
                            + opcProducto.getSelectedItem().toString().split(":")[0]);
                    rat.next();
                    float resto = (rat.getFloat("total")
                            / rat.getFloat("cantidad")) * Float.parseFloat(cantidadProd.getText() + evt.getKeyChar());
                    monTex.setText(String.valueOf(resto));
                    monTex.repaint();
                }
            } catch (Exception e)
            {
                System.out.println("Devoluciones 576: " + e.toString());
            }
        } catch (Exception e)
        {
            monTex.setText(String.valueOf("0.0"));
            monTex.repaint();
        }

    }//GEN-LAST:event_cantidadProdKeyTyped

    private void devolucionMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_devolucionMouseEntered
    {//GEN-HEADEREND:event_devolucionMouseEntered
        devolucion.setBackground(new Color(30, 161, 255));
    }//GEN-LAST:event_devolucionMouseEntered

    private void devolucionMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_devolucionMouseExited
    {//GEN-HEADEREND:event_devolucionMouseExited
        devolucion.setBackground(new Color(33, 12, 255));
    }//GEN-LAST:event_devolucionMouseExited

    private void devolucionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_devolucionActionPerformed
    {//GEN-HEADEREND:event_devolucionActionPerformed
        if (estado)
        {
            if (chechTot.isSelected())
            {
                if (CRUD.delete("ventas", "id=" + ventaT.getModel().getValueAt(0, 0).toString()))
                {
                    for (int i = 0; i < productosT.getRowCount(); i++)
                    {
                        CRUD.update("producto", "id=" + productosT.getModel().getValueAt(i, 0),
                                "cantidad=cantidad+" + productosT.getModel().getValueAt(i, 6));
                    }
                    ticket.setText("");
                    reinicio();
                    configCampos(false);
                    JOptionPane.showMessageDialog(null, "Se ha realizado la devolución");
                } else
                {
                    JOptionPane.showMessageDialog(null, "No se ha realizado la devolución");
                }
            } else if (opcProducto.getSelectedIndex() >= 1)
            {
                if (devProdTot.isSelected())
                {
                    try
                    {
                        ResultSet rat = CRUD.read("venta_Producto", "*", "WHERE id_Venta="
                                + ventaT.getModel().getValueAt(0, 0).toString() + " AND id_Producto ="
                                + opcProducto.getSelectedItem().toString().split(":")[0]);
                        rat.next();
                        CRUD.update("ventas", "id=" + ventaT.getModel().getValueAt(0, 0).toString(),
                                "total_Venta=total_Venta-" + rat.getString("total"));
                        CRUD.update("producto", "id=" + opcProducto.getSelectedItem().toString().split(":")[0],
                                "cantidad=cantidad+" + rat.getInt("cantidad"));
                        CRUD.delete("venta_Producto", "id_Venta = " + ventaT.getModel().getValueAt(0, 0).toString()
                                + " AND id_Producto=" + opcProducto.getSelectedItem().toString().split(":")[0]);
                        rat = CRUD.read("venta_Producto", "*", "WHERE id_Venta="
                                + ventaT.getModel().getValueAt(0, 0).toString());
                        opcProducto.setSelectedIndex(0);
                        deshabilitaAlg();
                        llenarTablaProd();
                        consultaCombo(opcProducto, "Producto", "");
                        if (!rat.next())
                        {
                            CRUD.delete("ventas", "id=" + ventaT.getModel().getValueAt(0, 0).toString());
                            reinicio();
                            configCampos(false);
                        } else
                        {
                            llenarTablaVenta();
                        }
                        JOptionPane.showMessageDialog(null, "Se ha realizado la devolución");
                    } catch (Exception e)
                    {
                        System.out.println("Devoluciones 682: " + e.toString());
                    }
                } else
                {
                    try
                    {
                        ResultSet rat = CRUD.read("venta_Producto", "*", "WHERE id_Venta="
                                + ventaT.getModel().getValueAt(0, 0).toString() + " AND id_Producto ="
                                + opcProducto.getSelectedItem().toString().split(":")[0]);
                        rat.next();
                        if (rat.getInt("cantidad") < Integer.parseInt(cantidadProd.getText()))
                        {
                            JOptionPane.showMessageDialog(null, "No se ha realizado la devolución \n"
                                    + "La cantidad devuelta es mayor a la vendida");
                        } else
                        {
                            float resto = (rat.getFloat("total")
                                    / rat.getFloat("cantidad")) * Float.parseFloat(cantidadProd.getText());
                            System.out.println(resto);
                            CRUD.update("ventas", "id=" + ventaT.getModel().getValueAt(0, 0).toString(),
                                    "total_Venta=total_Venta-" + resto);
                            CRUD.update("producto", "id=" + opcProducto.getSelectedItem().toString().split(":")[0],
                                    "cantidad=cantidad+" + cantidadProd.getText());
                            ResultSet ratCVP = CRUD.read("venta_Producto", "*", "WHERE id_Venta="
                                    + ventaT.getModel().getValueAt(0, 0).toString() + " AND id_Producto ="
                                    + opcProducto.getSelectedItem().toString().split(":")[0]);
                            ratCVP.next();
                            if (ratCVP.getInt("cantidad") == Integer.parseInt(cantidadProd.getText()))
                            {
                                CRUD.delete("venta_Producto", "id_Venta=" + ventaT.getModel().getValueAt(0, 0).toString()
                                        + " AND id_Producto=" + opcProducto.getSelectedItem().toString().split(":")[0]);
                                ResultSet ratVD = CRUD.read("venta_Producto", "*", "WHERE id_Venta="
                                        + ventaT.getModel().getValueAt(0, 0).toString());
                                if (!ratVD.next())
                                {
                                    CRUD.delete("ventas", "id=" + ventaT.getModel().getValueAt(0, 0).toString());
                                    reinicio();
                                    configCampos(false);
                                } else
                                {
                                    deshabilitaAlg();
                                    llenarTablaVenta();
                                    llenarTablaProd();
                                    opcProducto.setSelectedIndex(0);
                                    consultaCombo(opcProducto, "Producto", "");
                                }
                            } else
                            {
                                CRUD.update("venta_producto", "id_Venta=" + ventaT.getModel().getValueAt(0, 0).toString()
                                        + " AND id_Producto=" + opcProducto.getSelectedItem().toString().split(":")[0],
                                        "cantidad=cantidad-" + cantidadProd.getText() + ", total=total-" + resto);
                                deshabilitaAlg();
                                llenarTablaVenta();
                                llenarTablaProd();
                                opcProducto.setSelectedIndex(0);
                                consultaCombo(opcProducto, "Producto", "");
                            }
                            JOptionPane.showMessageDialog(null, "Se ha realizado la devolución");
                        }
                    } catch (Exception e)
                    {
                        System.out.println("aaaaaaaaaaaa");
                        System.out.println("Devoluciones 733: " + e.toString());
                    }
                }
            } else
            {
                JOptionPane.showMessageDialog(null, "Seleccione el producto para realizar devolución");
            }
        } else
        {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado venta para devolución");
        }
    }//GEN-LAST:event_devolucionActionPerformed

    private void opcProductoItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_opcProductoItemStateChanged
    {//GEN-HEADEREND:event_opcProductoItemStateChanged

    }//GEN-LAST:event_opcProductoItemStateChanged

    private void opcProductoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_opcProductoActionPerformed
    {//GEN-HEADEREND:event_opcProductoActionPerformed
        System.out.println(opcProducto.getSelectedIndex());
        if (opcProducto.getSelectedIndex() > 0)
        {
            devProdTot.setSelected(false);
            cantidadProd.setEnabled(true);
            cantidadProd.setText("");
            devProdTot.setEnabled(true);
            monTex.setText("0.0");
        } else
        {
            devProdTot.setSelected(false);
            monTex.setText("0.0");
            deshabilitaAlg();
        }
    }//GEN-LAST:event_opcProductoActionPerformed

    private void chechTotActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_chechTotActionPerformed
    {//GEN-HEADEREND:event_chechTotActionPerformed
        if (chechTot.isSelected())
        {
            cantidadProd.setEnabled(false);
            cantidadProd.setText("");
            devProdTot.setEnabled(false);
            devProdTot.setSelected(false);
            opcProducto.setEnabled(false);
            opcProducto.setSelectedIndex(0);
            String valorCelda = ventaT.getModel().getValueAt(0, 0).toString();
            try
            {
                ResultSet rat = CRUD.read("VENTAS", "*", "WHERE id = " + valorCelda);
                rat.next();
                monTex.setText(rat.getString("total_Venta"));
                monTex.repaint();
            } catch (SQLException ex)
            {
                System.out.println("Devoluciones 721: " + ex.toString());
            }
        } else
        {
            cantidadProd.setEnabled(false);
            opcProducto.setSelectedIndex(0);
            opcProducto.setEnabled(true);
            monTex.setText("0.0");
            deshabilitaAlg();
        }
    }//GEN-LAST:event_chechTotActionPerformed

    private void tickErrFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_tickErrFocusGained
    {//GEN-HEADEREND:event_tickErrFocusGained

    }//GEN-LAST:event_tickErrFocusGained

    private void devProdTotActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_devProdTotActionPerformed
    {//GEN-HEADEREND:event_devProdTotActionPerformed

        if (devProdTot.isSelected())
        {
            cantidadProd.setEnabled(false);
            cantidadProd.setText("");
            if (opcProducto.getSelectedIndex() > 0)
            {
                try
                {
                    ResultSet rat = CRUD.read("venta_Producto", "*", "WHERE id_Venta= "
                            + ventaT.getModel().getValueAt(0, 0).toString() + " AND id_Producto="
                            + opcProducto.getSelectedItem().toString().split(":")[0]);
                    rat.next();
                    monTex.setText(rat.getString("total"));
                    monTex.repaint();
                } catch (SQLException ex)
                {
                    System.out.println("22wweerrr");
                }
            }
        } else
        {
            cantidadProd.setEnabled(true);
            monTex.setText("0.0");
        }

    }//GEN-LAST:event_devProdTotActionPerformed

    private void ticketFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_ticketFocusGained
    {//GEN-HEADEREND:event_ticketFocusGained
        tickErr.setVisible(false);
    }//GEN-LAST:event_ticketFocusGained

    private void cantidadProdKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_cantidadProdKeyPressed
    {//GEN-HEADEREND:event_cantidadProdKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadProdKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bienvenidos;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField cantidadProd;
    private javax.swing.JCheckBox chechTot;
    private javax.swing.JLabel codigo1;
    private javax.swing.JLabel codigo2;
    private javax.swing.JCheckBox devProdTot;
    private javax.swing.JButton devolucion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel monTex;
    private javax.swing.JLabel monto;
    private javax.swing.JComboBox<String> opcProducto;
    private javax.swing.JLabel productosInfo;
    private javax.swing.JLabel productosInfo1;
    private javax.swing.JPanel productosP;
    private javax.swing.JScrollPane productosSC;
    private javax.swing.JTable productosT;
    private javax.swing.JLabel tickErr;
    private javax.swing.JTextField ticket;
    private javax.swing.JLabel ventInfo;
    private javax.swing.JPanel ventaP;
    private javax.swing.JScrollPane ventaSC;
    private javax.swing.JTable ventaT;
    // End of variables declaration//GEN-END:variables
}
