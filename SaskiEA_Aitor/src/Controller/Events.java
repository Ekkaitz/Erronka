package Controller;

import dbconection.Dbconnection;
import window.SingUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Events implements ActionListener {
    private String user,pass,email,mota;

    public Events(String user, String pass, String email, String mota) {
        this.user=user;
        this.pass=pass;
        this.email=email;
        this.mota=mota;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("listrnme");

        if (e.getSource() instanceof JButton){
            JButton buttonlistener= (JButton) e.getSource();
            String izena=buttonlistener.getText();

            if (izena.equals("Sing up")){
                try {

                    Dbconnection dbconnection=new Dbconnection();
                    dbconnection.ConexionBaseDeDatos();

                    String insert="insert into erabiltzaileak (email,erabiltzailea,pasahitza,mota)values(?,?,?,?)";
                    System.out.println(this.user);

                    System.out.println("events: "+this.user);
//
                    PreparedStatement preparedStatement= dbconnection.conexion.prepareStatement(insert);
                    preparedStatement.setString(1, this.email);
                    preparedStatement.setString(2, this.user );
                    preparedStatement.setString(3, this.pass);
                    preparedStatement.setString(4, this.mota);
                    preparedStatement.execute();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        }


    }


}
