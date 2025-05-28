package clases.conex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase para gestionar la conexión a la base de datos y la creación de las
 * tablas necesarias.
 */
public class Conexion
{

    String usuario = "root";
    String clave = "123456";
    String url = "jdbc:mysql://localhost:3306/Abasto_Facil";
    Connection con;
    Statement stmt;
    ResultSet rs;

    public Conexion()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, clave);
            stmt = con.createStatement();

        } catch (Exception e)
        {

            try
            {
                url = "jdbc:mysql://localhost:3306";
                con = DriverManager.getConnection(url, usuario, clave);
                stmt = con.createStatement();
                crearBaseDeDatosYTablas();
                url = "jdbc:mysql://localhost:3306/Abasto_Facil";
                con = DriverManager.getConnection(url, usuario, clave);
                stmt = con.createStatement();
            } catch (Exception ex)
            {
                System.out.println("Error conexión BDD");
            }
//            e.printStackTrace();
        }
    }

    public Connection getCon()
    {
        return con;
    }

    public Statement getStmt()
    {
        return stmt;
    }

    /**
     * Método para crear la base de datos y las tablas necesarias si no existen.
     */
    private void crearBaseDeDatosYTablas()
    {
        System.out.println("Creada");
        try
        {
            // Cambiar la URL temporalmente para la creación de la base de datos
            String tempUrl = "jdbc:mysql://localhost:3306";
            try (Connection tempCon = DriverManager.getConnection(tempUrl, usuario, clave); Statement tempStmt = tempCon.createStatement())
            {
                // Crear la base de datos si no existe
                String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS Abasto_Facil";
                tempStmt.executeUpdate(createDatabaseSQL);
                System.out.println("Base de datos 'Abasto_Facil' verificada/creada exitosamente.");
            }

            // Usar la base de datos específica
            stmt.executeUpdate("USE Abasto_Facil");

            // Sentencias SQL para crear las tablas
            String createProveedorTableSQL = "CREATE TABLE IF NOT EXISTS proveedor ("
                    + "id INT AUTO_INCREMENT,"
                    + "nombre VARCHAR(30) NOT NULL,"
                    + "telefono CHAR(10) NOT NULL,"
                    + "direccion VARCHAR(60) NOT NULL,"
                    + "PRIMARY KEY (id),"
                    + "UNIQUE (nombre))";

            String createCategoriaTableSQL = "CREATE TABLE IF NOT EXISTS categoria ("
                    + "id INT AUTO_INCREMENT,"
                    + "nombre VARCHAR(30) NOT NULL,"
                    + "PRIMARY KEY (id),"
                    + "UNIQUE (nombre))";

            String createProductoTableSQL = "CREATE TABLE IF NOT EXISTS Producto ("
                    + "id NUMERIC(13,0),"
                    + "nombre VARCHAR(30) NOT NULL,"
                    + "unidadMed VARCHAR(2) NOT NULL,"
                    + "magnitudMed FLOAT NOT NULL,"
                    + "precio FLOAT NOT NULL CHECK (precio > 0),"
                    + "cantidad INT NOT NULL CHECK (cantidad > 0),"
                    + "id_Proveedor INT NOT NULL,"
                    + "id_Categoria INT NOT NULL,"
                    + "PRIMARY KEY (id),"
                    + "FOREIGN KEY (id_Proveedor) REFERENCES proveedor (id) ON DELETE CASCADE ON UPDATE CASCADE,"
                    + "FOREIGN KEY (id_Categoria) REFERENCES categoria (id) ON DELETE CASCADE ON UPDATE CASCADE,"
                    + "UNIQUE (nombre, unidadMed, magnitudMed, id_Proveedor))";

            String createVentasTableSQL = "CREATE TABLE IF NOT EXISTS ventas ("
                    + "id INT AUTO_INCREMENT,"
                    + "fechaHora DATETIME NOT NULL,"
                    + "total_Venta FLOAT NOT NULL CHECK (total_Venta > 0),"
                    + "PRIMARY KEY (id))";

            String createVentaProductoTableSQL = "CREATE TABLE IF NOT EXISTS Venta_Producto ("
                    + "id_Producto NUMERIC(13,0) NOT NULL,"
                    + "id_Venta INT NOT NULL,"
                    + "cantidad INT NOT NULL CHECK (cantidad > 0),"
                    + "total FLOAT NOT NULL CHECK (total > 0),"
                    + "FOREIGN KEY (id_Producto) REFERENCES Producto (id) ON DELETE CASCADE ON UPDATE CASCADE,"
                    + "FOREIGN KEY (id_Venta) REFERENCES ventas (id) ON DELETE CASCADE ON UPDATE CASCADE)";

            // Crear las tablas
            stmt.executeUpdate(createProveedorTableSQL);

            stmt.executeUpdate(createCategoriaTableSQL);
            stmt.executeUpdate(createProductoTableSQL);
            stmt.executeUpdate(createVentasTableSQL);
            stmt.executeUpdate(createVentaProductoTableSQL);

            System.out.println("Tablas creadas/verificadas exitosamente.");

        } catch (SQLException e)
        {
            System.out.println("Error al crear la base de datos o las tablas.");
            e.printStackTrace();
        }
    }
}
