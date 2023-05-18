package window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bilera extends JFrame implements ActionListener {

    private JComboBox<String> diaComboBox;
    private JSpinner horaSpinner;
    private JButton confirmarButton;

    public Bilera() {
        // Configuramos el JFrame
        setTitle("Bilerak");
        setSize(300, 150);

        // Creamos los componentes
        String[] dias = {"Astelehena", "Asteartea", "Asteazkena", "Osteguna", "Ostirala"};
        diaComboBox = new JComboBox<String>(dias);
        horaSpinner = new JSpinner(new SpinnerNumberModel(12, 1, 24, 1));
        confirmarButton = new JButton("Gorde");

        // Configuramos los componentes
        JLabel diaLabel = new JLabel("Eguna:");
        JLabel horaLabel = new JLabel("Ordua:");
        JPanel panel1 = new JPanel(new GridLayout(2, 2));
        panel1.add(diaLabel);
        panel1.add(diaComboBox);
        panel1.add(horaLabel);
        panel1.add(horaSpinner);
        JPanel panel2 = new JPanel(new FlowLayout());
        panel2.add(confirmarButton);

        // Agregamos los componentes al JFrame
        setLayout(new BorderLayout());
        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);

        // Configuramos el botón para escuchar eventos de acción
        confirmarButton.addActionListener(this);
    }

    // Método que se llama cuando se hace clic en el botón "Confirmar"
    public void actionPerformed(ActionEvent e) {
        String diaSeleccionado = (String) diaComboBox.getSelectedItem();
        int horaSeleccionada = (int) horaSpinner.getValue();
        System.out.println("Se ha seleccionado el día " + diaSeleccionado + " a las " + horaSeleccionada + " horas.");
    }

    public JButton getConfirmarButton() {
        return confirmarButton;
    }
}

