package model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BotonesNav {
    private static JPanel bHome = crearBoton("Home");;
    private static JPanel bSarrerak = crearBoton("Sarrerak erosi");
    private static JPanel bZozketa = crearBoton("Zozketa");
    private static JPanel bEstatistikak = crearBoton("Estadistikak");
    private static JPanel bPartiduak = crearBoton("Partiduak");
    private static JPanel bBilera = crearBoton("Bilera");
    private static JPanel btraspasoak = crearBoton("Traspasoak");

    private ArrayList<JPanel> botoiak = new ArrayList<>();

    public BotonesNav(){
    }

    public static JPanel crearBoton(String texto){
        JButton boton = new JButton(texto);
        boton.setForeground(new Color(253,240,213,255));
        boton.setBackground(new Color(193, 35, 46,255));
        boton.setFont(new Font("Arial",Font.BOLD,16));
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);

        JLabel line=new JLabel("__________________");
        line.setFont(new Font("Arial",Font.PLAIN,19));
        line.setForeground(new Color(253,240,213,255));

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(193, 35, 46,255));
        panel.add(boton, BorderLayout.CENTER);
        panel.add(line, BorderLayout.SOUTH);
        panel.setPreferredSize(new Dimension(200,75));

        return panel;
    }

    public static JPanel getbHome() {
        return bHome;
    }

    public static JPanel getbSarrerak() {
        return bSarrerak;
    }

    public static JPanel getbZozketa() {
        return bZozketa;
    }

    public static JPanel getbEstatistikak() {
        return bEstatistikak;
    }

    public static JPanel getbPartiduak() {
        return bPartiduak;
    }

    public static JPanel getBklasifikazioa() {
        return bBilera;
    }

    public static JPanel getBtraspasoak() {
        return btraspasoak;
    }

    public static JPanel getbBilera() {
        return bBilera;
    }
}
