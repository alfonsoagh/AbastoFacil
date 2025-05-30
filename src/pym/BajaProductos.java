/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pym;

import clases.conex.CRUD;
import herramientas.Propiedades;
import herramientas.RoundedBorder;
import herramientas.TextPrompt;
import herramientas.Validaciones;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author jonas
 */
public class BajaProductos extends javax.swing.JPanel
{

    boolean estado;
    DefaultTableModel m2 = new DefaultTableModel();

    /**
     * Creates new form AltasProductos
     */
    public BajaProductos()
    {
        initComponents();
        opcProductos.setUI(Propiedades.createUI(this));
        bajaP.setUI(new BasicButtonUI());
        bajaP.setBorder(new RoundedBorder(10));
        consultaCombo(opcProductos, "Producto", "");
        TextPrompt buscaProd = new TextPrompt("Ingrese clave o nombre del Producto", buscaProducto);
        listenersBuscadores();
        buscaProducto.setEnabled(false);
        jScrollPane1.setVisible(false);

    }

    // Carga de nuevo los productos a el comboBox
    public void consultaCombo(JComboBox jb, String tabla, String sentencia)
    {
        jb.removeAllItems();
        jb.addItem("Seleccione un producto");
        ResultSet rat = CRUD.read(tabla, "*", sentencia + " ORDER BY id");
        cargarComboBox(rat, jb);
    }

    public void cargarComboBox(ResultSet rat, JComboBox jcb)
    {
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
        opcProductos = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        bajaP = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        buscaProducto = new javax.swing.JTextField();
        nombreB = new javax.swing.JRadioButton();
        claveB = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        bienvenidos.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        bienvenidos.setText("Baja Producto");
        add(bienvenidos);
        bienvenidos.setBounds(260, 50, 250, 44);

        opcProductos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        opcProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un producto" }));
        opcProductos.setToolTipText("");
        opcProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        opcProductos.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                opcProductosItemStateChanged(evt);
            }
        });
        opcProductos.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                opcProductosActionPerformed(evt);
            }
        });
        add(opcProductos);
        opcProductos.setBounds(220, 320, 350, 28);

        jLabel13.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Producto");
        add(jLabel13);
        jLabel13.setBounds(220, 190, 130, 24);

        bajaP.setBackground(new java.awt.Color(33, 12, 255));
        bajaP.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        bajaP.setForeground(new java.awt.Color(255, 255, 255));
        bajaP.setText("Eliminar");
        bajaP.setBorder(null);
        bajaP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bajaP.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bajaP.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                bajaPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                bajaPMouseExited(evt);
            }
        });
        bajaP.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                bajaPActionPerformed(evt);
            }
        });
        add(bajaP);
        bajaP.setBounds(330, 520, 140, 50);
        add(jSeparator1);
        jSeparator1.setBounds(220, 260, 350, 10);

        buscaProducto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buscaProducto.setToolTipText("");
        buscaProducto.setBorder(null);
        buscaProducto.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                buscaProductoFocusGained(evt);
            }
        });
        buscaProducto.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                buscaProductoMouseClicked(evt);
            }
        });
        buscaProducto.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buscaProductoActionPerformed(evt);
            }
        });
        buscaProducto.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                buscaProductoKeyTyped(evt);
            }
        });
        add(buscaProducto);
        buscaProducto.setBounds(220, 230, 350, 30);

        nombreB.setText("Buscar con Nombre");
        nombreB.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                nombreBActionPerformed(evt);
            }
        });
        add(nombreB);
        nombreB.setBounds(440, 270, 130, 23);

        claveB.setText("Buscar con Clave");
        claveB.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                claveBActionPerformed(evt);
            }
        });
        add(claveB);
        claveB.setBounds(220, 270, 130, 23);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(130, 390, 540, 60);
    }// </editor-fold>//GEN-END:initComponents

    private void opcProductosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_opcProductosActionPerformed
    {//GEN-HEADEREND:event_opcProductosActionPerformed
        jScrollPane1.setVisible(false);
        if (opcProductos.getSelectedIndex() != 0 && opcProductos.getItemCount() > 1)
        {
            jScrollPane1.setVisible(true);
            jTable1.setRowHeight(32);
            m2 = new DefaultTableModel();
            String c2[] =
            {
                "Nombre", "Precio", "Cantidad", "Magintud", "Unidad", "Proveedor", "Categoria"
            };
            m2.setColumnIdentifiers(c2);
            jTable1.setModel(m2);
            try
            {
                String sentencia = "id=" + (opcProductos.getSelectedItem().toString().split(":")[0]);
                ResultSet rat = CRUD.read("producto", "*", "WHERE " + sentencia);
                rat.next();
                ResultSet ratProv = CRUD.read("proveedor", "*", "WHERE id = " + rat.getString("id_Proveedor"));
                ratProv.next();
                ResultSet ratCat = CRUD.read("categoria", "*", "WHERE id = " + rat.getString("id_Categoria"));
                ratCat.next();
                String f[] =
                {
                    rat.getString("nombre"), rat.getString("precio"),
                    rat.getString("cantidad"), rat.getString("magnitudMed"),
                    rat.getString("unidadMed"), ratProv.getString("nombre"),
                    ratCat.getString("nombre")
                };
                m2.addRow(f);
            } catch (Exception e)
            {
                System.out.println("asdasaaaaaaaaaaaaa");
            }
            jTable1.setEnabled(false);
        }
    }//GEN-LAST:event_opcProductosActionPerformed

    private void bajaPMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_bajaPMouseEntered
    {//GEN-HEADEREND:event_bajaPMouseEntered
        bajaP.setBackground(new Color(30, 161, 255));
    }//GEN-LAST:event_bajaPMouseEntered

    private void bajaPMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_bajaPMouseExited
    {//GEN-HEADEREND:event_bajaPMouseExited
        bajaP.setBackground(new Color(33, 12, 255));
    }//GEN-LAST:event_bajaPMouseExited

    private void bajaPActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bajaPActionPerformed
    {//GEN-HEADEREND:event_bajaPActionPerformed
        if (!(opcProductos.getItemCount() == 1))
        {
            if (!(opcProductos.getSelectedIndex() == 0))
            {
                Object[] options =
                {
                    "Sí", "Cancelar"
                };
                if (JOptionPane.showOptionDialog(null,
                        "¿Deseas continuar? Se eliminara toda la información \n dependiente de este producto",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]) == 0)
                {
                    String sentencia = "id=" + (opcProductos.getSelectedItem().toString().split(":")[0]);
                    CRUD.delete("producto", sentencia);
                    consultaCombo(opcProductos, "Producto", "ORDER BY id");
                    ResultSet rat = CRUD.read("Producto", "*", "");
                    buscaProducto.setText("");
                    claveB.setSelected(false);
                    nombreB.setSelected(false);
                    buscaProducto.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Producto ELIMINADO");
                    try
                    {
                        if (!rat.next())
                        {
                            VtnPrincipal.pintar(new MenuOpciones());
                            JOptionPane.showMessageDialog(null, "Ya no hay productos para Eliminar");
                        }
                    } catch (Exception e)
                    {
                    }
                }
            } else
            {
                JOptionPane.showMessageDialog(null, "Seleccione un Producto para ELIMINAR");
            }
        } else
        {
            JOptionPane.showMessageDialog(null, "NO hay datos para ELIMINAR");
        }
    }//GEN-LAST:event_bajaPActionPerformed

    private void opcProductosItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_opcProductosItemStateChanged
    {//GEN-HEADEREND:event_opcProductosItemStateChanged


    }//GEN-LAST:event_opcProductosItemStateChanged

    private void buscaProductoFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_buscaProductoFocusGained
    {//GEN-HEADEREND:event_buscaProductoFocusGained
        opcProductos.setSelectedIndex(0);
    }//GEN-LAST:event_buscaProductoFocusGained

    private void buscaProductoMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_buscaProductoMouseClicked
    {//GEN-HEADEREND:event_buscaProductoMouseClicked

    }//GEN-LAST:event_buscaProductoMouseClicked

    private void buscaProductoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buscaProductoActionPerformed
    {//GEN-HEADEREND:event_buscaProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscaProductoActionPerformed

    private void buscaProductoKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_buscaProductoKeyTyped
    {//GEN-HEADEREND:event_buscaProductoKeyTyped
        if (estado)
        {
            Validaciones.validaEntero(evt, 13, buscaProducto.getText());
        } else
        {
            Validaciones.validaLetra(evt, 20, buscaProducto.getText());
        }
    }//GEN-LAST:event_buscaProductoKeyTyped

    private void claveBActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_claveBActionPerformed
    {//GEN-HEADEREND:event_claveBActionPerformed
        buscaProducto.setText("");
        if (claveB.isSelected())
        {
            buscaProducto.setText("");
            estado = true;
            if (nombreB.isSelected())
            {
                nombreB.setSelected(false);
            }
            buscaProducto.setEnabled(true);
        } else
        {
            if (nombreB.isSelected())
            {
                buscaProducto.setEnabled(true);
            } else
            {
                buscaProducto.setEnabled(false);
            }
        }
    }//GEN-LAST:event_claveBActionPerformed

    private void nombreBActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_nombreBActionPerformed
    {//GEN-HEADEREND:event_nombreBActionPerformed
        buscaProducto.setText("");
        if (nombreB.isSelected())
        {
            estado = false;
            if (claveB.isSelected())
            {
                claveB.setSelected(false);
            }
            buscaProducto.setEnabled(true);
        } else
        {
            if (claveB.isSelected())
            {
                buscaProducto.setEnabled(true);
            } else
            {
                buscaProducto.setEnabled(false);
            }
        }
    }//GEN-LAST:event_nombreBActionPerformed

    public void listenersBuscadores()
    {
        buscaProducto.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e)
            {
                // Acción cuando se inserta texto
                if (buscaProducto.getText().isEmpty())
                {
                    consultaCombo(opcProductos, "Producto", "");
                } else
                {
                    try
                    {
                        Integer.parseInt(buscaProducto.getText());
                        String sentencia = "WHERE id = " + buscaProducto.getText() + "";
                        System.out.println(sentencia);
                        consultaCombo(opcProductos, "Producto", sentencia);
                    } catch (Exception er)
                    {
                        String sentencia = "WHERE nombre LIKE '%" + buscaProducto.getText() + "%'";
                        System.out.println(sentencia);
                        consultaCombo(opcProductos, "Producto", sentencia);
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                // Acción cuando se elimina texto
                if (buscaProducto.getText().isEmpty())
                {
                    consultaCombo(opcProductos, "Producto", "");
                } else
                {
                    try
                    {
                        Integer.parseInt(buscaProducto.getText());
                        String sentencia = "WHERE id = " + buscaProducto.getText() + "";
                        System.out.println(sentencia);
                        consultaCombo(opcProductos, "Producto", sentencia);
                    } catch (Exception er)
                    {
                        String sentencia = "WHERE nombre LIKE '%" + buscaProducto.getText() + "%'";
                        System.out.println(sentencia);
                        consultaCombo(opcProductos, "Producto", sentencia);
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bajaP;
    private javax.swing.JLabel bienvenidos;
    private javax.swing.JTextField buscaProducto;
    private javax.swing.JRadioButton claveB;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton nombreB;
    private javax.swing.JComboBox<String> opcProductos;
    // End of variables declaration//GEN-END:variables
}
