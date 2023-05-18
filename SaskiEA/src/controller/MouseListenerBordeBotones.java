package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerBordeBotones implements MouseListener {
    private JPanel panel;
    private JButton boton;
    public MouseListenerBordeBotones(JPanel panel){
        this.panel =panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e){
        boton = (JButton) e.getSource();
        boton.setForeground(new Color(193, 35, 46,255));
        boton.setBackground(new Color(253,240,213,255));

    }
    @Override
    public void mouseExited(MouseEvent e){
        boton = (JButton) e.getSource();
        boton.setForeground(new Color(253,240,213,255));
        boton.setBackground(new Color(193, 35, 46,255));


    }


}
