/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crud;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Pedido;

/**
 *
 * @author marco
 */
public class Controller implements Serializable {

    private static Connection con;

    static {
        String url = "jdbc:mysql://localhost:3307/acceso?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String password = "";
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión establecida con la base de datos");
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static final String LIST_PRODUCTS = "SELECT * FROM pedidos";
    static final String CREATE_PEDIDO = "INSERT INTO pedidos(alumno,ciclo,estado,producto_id) VALUES (?,?,?,?)";
    static final String DELETE_PEDIDO = "DELETE FROM pedidos WHERE id=?";
    static final String LIST_COMMAND = "SELECT * FROM pedidos WHERE estado='pendiente'";
    static final String MARCAR_PEDIDO = "UPDATE pedidos SET estado = 'Recogido' WHERE id=?";

    public void crearPedido() {

        String nombre;
        String ciclo;
        String estado;

        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte su nombre: ");
        nombre = sc.next();
        System.out.println("Inserte su ciclo: ");
        ciclo = sc.next();
        System.out.println("Inserte el estado: ");
        estado = sc.next();
        System.out.println("Inserte el id del producto: ");
        int producto = sc.nextInt();

        try ( PreparedStatement ps = con.prepareStatement(CREATE_PEDIDO, RETURN_GENERATED_KEYS)) {
            ps.setString(1, nombre);
            ps.setString(2, ciclo);
            ps.setString(3, estado);
            ps.setInt(4, producto);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int eliminarPedido() {
        int pedido;
        int res = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte el id del pedido a eliminar: ");
        pedido = sc.nextInt();

        try ( PreparedStatement ps = con.prepareStatement(DELETE_PEDIDO)) {
            ps.setInt(1, pedido);
            res = ps.executeUpdate();

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public ArrayList<Pedido> listarComanda() {

        var salida = new ArrayList<Pedido>();

        try ( Statement st = con.createStatement()) {

            ResultSet resultado = st.executeQuery(LIST_PRODUCTS);

            while (resultado.next()) {
                Pedido t = new Pedido();
                t.setId(resultado.getInt("id"));
                t.setAlumno(resultado.getString("alumno"));
                t.setCiclo(resultado.getString("ciclo"));
                t.setFecha(resultado.getString("fecha"));
                t.setProductoId(resultado.getInt("producto_id"));
                t.setEstado("estado");

                salida.add(t);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        return salida;

    }

    public ArrayList<Pedido> listarCarta() {
        var salida = new ArrayList<Pedido>();

        try ( Statement st = con.createStatement()) {

            ResultSet resultado = st.executeQuery(LIST_COMMAND);

            while (resultado.next()) {
                Pedido t = new Pedido();
                t.setId(resultado.getInt("id"));
                t.setAlumno(resultado.getString("alumno"));
                t.setCiclo(resultado.getString("ciclo"));
                t.setFecha(resultado.getString("fecha"));
                t.setProductoId(resultado.getInt("producto_id"));
                t.setEstado(resultado.getString("estado"));

                salida.add(t);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        return salida;

    }

    public void marcarPedido() {
        int marcar;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte el id del alumno que quiera marcar como recogido: ");
        marcar = sc.nextInt();

        try ( PreparedStatement ps = con.prepareStatement(MARCAR_PEDIDO, RETURN_GENERATED_KEYS)) {
            ps.setInt(1, marcar);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
