/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.conex;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author alpon
 */
public class CRUD
{

    
    public static int create(String tabla, String valoresRq, String valores, String mensaje)
    {
        try
        {
            Statement stmt = new Conexion().getStmt();
            System.out.println("INSERT INTO " + tabla + " " + valoresRq + " " + " VALUES (" + valores + ");");
            stmt.executeUpdate("INSERT INTO " + tabla + " " + valoresRq + " " + " VALUES (" + valores + ");");
            stmt.close();
            return 0;
        } catch (Exception e)
        {
            System.out.println(e.toString());
            if (e.toString().split(":")[0].equals("java.sql.SQLIntegrityConstraintViolationException"))
            {
                try
                {
                    Integer.parseInt(e.toString().split(" ")[3].substring(1, e.toString().split(" ")[3].length() - 1));
                    return 1;
                } catch (Exception err)
                {
                    return 2;
                }
            } else
            {
                System.out.println(e.toString());
                JOptionPane.showMessageDialog(null, mensaje + " NO REGISTRADO");
            }
            return 3;
        }
    }

    public static ResultSet read(String table, String valuesRq, String sentencia)
    {
        try
        {
            Statement stmt = new Conexion().getStmt();
            System.out.println("SELECT " + valuesRq + " FROM " + table + " " + sentencia + ";");
            ResultSet rat = stmt.executeQuery("SELECT " + valuesRq + " FROM " + table + " " + sentencia + ";");
            return rat;

        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return null;
    }

    public static int update(String table, String sentencia, String values)
    {
        try
        {
            Statement stmt = new Conexion().getStmt();
            System.out.println("UPDATE " + table + " " + " SET " + values + " WHERE " + sentencia + ";");
            stmt.executeUpdate("UPDATE " + table + " " + " SET " + values + " WHERE " + sentencia + ";");
            stmt.close();
            return 0;
        } catch (Exception e)
        {
            System.out.println(e.toString());
            if (e.toString().split(":")[0].equals("java.sql.SQLIntegrityConstraintViolationException"))
            {
                try
                {
                    Integer.parseInt(e.toString().split(" ")[3].substring(1, e.toString().split(" ")[3].length() - 1));
                    return 1;
                } catch (Exception err)
                {
                    return 2;
                }
            }
        }
        return 4;
    }

    public static boolean delete(String table, String sentencia)
    {
        try
        {
            Statement stmt = new Conexion().getStmt();
            System.out.println("DELETE FROM " + table + " WHERE " + sentencia);
            stmt.executeUpdate("DELETE FROM " + table + " WHERE " + sentencia);
            stmt.getWarnings();
            return true;
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return false;
    }

    public static void updateStonks(String sentencia, int cantidad)
    {
        try
        {
            Statement stmt = new Conexion().getStmt();
            stmt.executeUpdate("UPDATE producto SET cantidad = cantidad + " + cantidad + " WHERE " + sentencia);

        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public static void updateStonksVenta(String sentencia, int cantidad)
    {
        try
        {
            Statement stmt = new Conexion().getStmt();
            stmt.executeUpdate("UPDATE producto SET cantidad = cantidad - " + cantidad + " WHERE " + sentencia);
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public static int verificarProveedor()
    {
        int x = -1;
        try
        {

            Statement stmt = new Conexion().getStmt();
            ResultSet resultado = stmt.executeQuery("SELECT COUNT(*) FROM proveedor");
            if (resultado.next())
            {
                x = resultado.getInt(1);
            }
            resultado.close();
            stmt.close();
            return x;
        } catch (Exception e)
        {
            return -1;
        }
    }

    public static int verificarCategoria()
    {
        int x = -1;
        try
        {

            Statement stmt = new Conexion().getStmt();
            ResultSet resultado = stmt.executeQuery("SELECT COUNT(*) FROM categoria");
            if (resultado.next())
            {
                x = resultado.getInt(1);
            }
            resultado.close();
            stmt.close();
            return x;
        } catch (Exception e)
        {
            return -1;
        }
    }

    public static ResultSet consultarFecha(String sentencia)
    {
        try
        {
            Statement stmt = new Conexion().getStmt();
            ResultSet rat = stmt.executeQuery("SELECT P.nombre AS nombre_producto, VP.cantidad, VP.total\n"
                    + "FROM ventas V\n"
                    + "JOIN Venta_Producto VP ON V.id = VP.id_Venta\n"
                    + "JOIN Producto P ON VP.id_Producto = P.id\n"
                    + "WHERE DATE(V.fechaHora) = '" + sentencia + "';");
            return rat;

        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return null;
    }

    public static ResultSet consultarProducto(String sentencia)
    {
        try
        {
            Statement stmt = new Conexion().getStmt();
            ResultSet rat = stmt.executeQuery("SELECT V.fechaHora AS Fecha_vendida, P.nombre AS nombre_producto, VP.cantidad, VP.total "
                    + "FROM ventas V "
                    + "JOIN Venta_Producto VP ON V.id = VP.id_Venta "
                    + "JOIN Producto P ON VP.id_Producto = P.id "
                    + "WHERE P.nombre = '" + sentencia + "';");

            return rat;

        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return null;
    }

    public static ResultSet consultarProveedor(String sentencia)
    {
        try
        {
            Statement stmt = new Conexion().getStmt();
            ResultSet rat = stmt.executeQuery("SELECT Pd.nombre AS nombre_proveedor, Pr.nombre AS nombre_producto, Pr.precio, Pr.cantidad "
                    + "FROM Producto Pr "
                    + "JOIN proveedor Pd ON Pr.id_Proveedor = Pd.id "
                    + "WHERE Pd.nombre = '" + sentencia + "';");

            return rat;

        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return null;
    }

    public static ResultSet consultarCategoria(String sentencia)
    {
        try
        {
            Statement stmt = new Conexion().getStmt();
            ResultSet rat = stmt.executeQuery("SELECT Ct.nombre AS nombre_categoria, Pr.nombre AS nombre_producto, Pr.precio, Pr.cantidad "
                    + "FROM Producto Pr "
                    + "JOIN categoria Ct ON Pr.id_Categoria = Ct.id "
                    + "WHERE Ct.nombre = '" + sentencia + "';");

            return rat;

        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return null;
    }

}
