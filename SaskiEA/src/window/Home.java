package window;

import controller.MouseListenerBordeBotones;
import dbconection.Dbconnection;
import dbconection.Estatistikak;
import dbconection.Partiduak;
import model.BotonesNav;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Home extends JFrame{
    private JPanel header,Izena,nagusia,login,logoa,Lnav;
    private JButton buttonlogin;

    public JButton getButtonlogin() {
        return buttonlogin;
    }

    public PreparedStatement preparedStatement;

    public Home(String mota){



        this.setVisible(true);

        //layout orokorra
        this.setLayout(new BorderLayout());

        //header layout
        header = new JPanel();
        header.setBackground(new Color(0, 48, 73, 255));
        header.setLayout(new GridLayout(1, 3));


        //argazkia logoa
        logoa = new JPanel();
        logoa.setLayout(new FlowLayout(FlowLayout.LEFT));
        Border border1 = BorderFactory.createEmptyBorder(0, 0, 0, 1);

        ImageIcon imageO = new ImageIcon("logoa.png");
        Image imageE = imageO.getImage().getScaledInstance(196, 167, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(imageE);

        ImageIcon image1 = new ImageIcon("logoicon.png");
        Image imagee = image1.getImage().getScaledInstance(196, 167, Image.SCALE_SMOOTH);
        ImageIcon imageIcon2 = new ImageIcon(imagee);

        JLabel label = new JLabel();
        label.setBorder(border1);

        label.setIcon(imageIcon);
        logoa.add(label);
        logoa.setBackground(new Color(0, 48, 73, 255));

        header.add(logoa);

        this.setIconImage(imageIcon2.getImage());


        //Izena
        Izena = new JPanel();
        Border bordertitle = BorderFactory.createEmptyBorder(60, 0, 0, 0);
        JLabel label1 = new JLabel("EA BASKET");
        label1.setBorder(bordertitle);

        label1.setForeground(new Color(253, 240, 213, 255));
        Font tit = new Font("Arial", Font.PLAIN, 50);

        label1.setFont(tit);
        Izena.setBackground(new Color(0, 48, 73, 255));
        Izena.add(label1);
        header.add(Izena);

        //Login (Leiho berri batean irekiko da botoi honen bidez)
        login = new JPanel();
        JPanel loggin = new JPanel();

        login.setLayout(new FlowLayout(FlowLayout.RIGHT));

        buttonlogin = new JButton("Log in");
        buttonlogin.setBorderPainted(false);

        buttonlogin.setFocusPainted(false);

        MouseListenerBordeBotones bordeBotones = new MouseListenerBordeBotones(loggin);
        buttonlogin.addMouseListener(bordeBotones);


        Border borderlogin = BorderFactory.createEmptyBorder(70, 0, 0, 20);


        loggin.setBackground(new Color(0, 48, 73, 255));
        buttonlogin.setFont(new Font("Arial", Font.BOLD, 19));
        buttonlogin.setForeground(new Color(253, 240, 213, 255));
        buttonlogin.setBackground(new Color(193, 35, 46, 255));
        login.setBackground(new Color(0, 48, 73, 255));

        login.setBorder(borderlogin);

        loggin.add(buttonlogin);
        login.add(loggin);
        header.add(login);


        //Ezkerreko menua (Lnav)

        Lnav = new JPanel();

        Lnav.setBackground((new Color(193, 35, 46, 255)));

        Border borderlabelak = BorderFactory.createEmptyBorder(20, 20, 1, 1);

        JButton bHome = ((JButton) BotonesNav.getbHome().getComponent(0));
        MouseListenerBordeBotones mlb10 = new MouseListenerBordeBotones(BotonesNav.getbHome());
        bHome.addMouseListener(mlb10);

        JButton bPartiduak = ((JButton) BotonesNav.getbPartiduak().getComponent(0));
        MouseListenerBordeBotones mlb14 = new MouseListenerBordeBotones(BotonesNav.getbPartiduak());
        bPartiduak.addMouseListener(mlb14);

        JButton bZozketa = ((JButton) BotonesNav.getbZozketa().getComponent(0));
        MouseListenerBordeBotones mlb15 = new MouseListenerBordeBotones(BotonesNav.getbZozketa());
        bZozketa.addMouseListener(mlb15);

        JButton bSarrerakErosi = ((JButton) BotonesNav.getbSarrerak().getComponent(0));
        MouseListenerBordeBotones mlb11 = new MouseListenerBordeBotones(BotonesNav.getbSarrerak());
        bSarrerakErosi.addMouseListener(mlb11);

        JButton bTraspasoak = ((JButton) BotonesNav.getBtraspasoak().getComponent(0));
        MouseListenerBordeBotones mlb12 = new MouseListenerBordeBotones(BotonesNav.getbSarrerak());
        bTraspasoak.addMouseListener(mlb12);

        JButton bEstatistikak = ((JButton) BotonesNav.getbEstatistikak().getComponent(0));
        MouseListenerBordeBotones mlb13 = new MouseListenerBordeBotones(BotonesNav.getbSarrerak());
        bEstatistikak.addMouseListener(mlb13);

        JButton bBilera = ((JButton) BotonesNav.getbBilera().getComponent(0));
        MouseListenerBordeBotones ml17 = new MouseListenerBordeBotones(BotonesNav.getbSarrerak());
        bBilera.addMouseListener(ml17);

        botoiakSartu(mota);




        Lnav.setPreferredSize(new Dimension(200, 0));


        //Erdiko edukia card layout
        nagusia = new JPanel();
        CardLayout cardLayout = new CardLayout();
        nagusia.setLayout(cardLayout);


        //nagusia.setBackground(new Color(255, 241, 219,255));
        nagusia.setBackground(new Color(0, 48, 73, 21));


        //Home panela
        JPanel cardHome = new JPanel();
        nagusia.add(cardHome, "cardHome");
        cardHome.setBackground((new Color(31,31,31,255)));



        ImageIcon homelogo = new ImageIcon("SaskiEA_Aitor/background.png");
        Image homelogo2 = homelogo.getImage().getScaledInstance(1730, 886, Image.SCALE_SMOOTH);
        ImageIcon homelogo3 = new ImageIcon(homelogo2);

        JLabel homelabel=new JLabel();
        homelabel.setIcon(homelogo3);

        cardHome.add(homelabel);

        //Partiduentzako panela
        JPanel cardPartiduak = new JPanel();

        nagusia.add(cardPartiduak, "cardPartiduak");

        Dbconnection conexioa = new Dbconnection();
        conexioa.ConexionBaseDeDatos();

        ArrayList<Partiduak> partiduakArrayList = new ArrayList<>();
        String select = "select * from partidoa order by id_partidoa";

        PreparedStatement ps;

        try {
            ps = conexioa.conexion.prepareStatement(select);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_partidoa");
                String zelaia = rs.getString("zelaia");
                String emaitza = rs.getString("emaitza");
                String partido_data = rs.getString("partido_data");

                Partiduak partidua = new Partiduak(id, zelaia, emaitza, partido_data);
                partiduakArrayList.add(partidua);
            }

            JPanel lPartiduak = new JPanel();
            lPartiduak.setLayout(new BoxLayout(lPartiduak, BoxLayout.Y_AXIS));

            for (int i = 0; i < partiduakArrayList.size(); i++) {
                JLabel lPartidua = new JLabel();

                lPartidua.setText((partiduakArrayList.get(i).getId_partidoa()) + " " + partiduakArrayList.get(i).getZelaia() + " " + partiduakArrayList.get(i).getEmaitza());

                lPartiduak.add(lPartidua);

            }

            cardPartiduak.add(lPartiduak);


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }


        //Estatistikak
        JPanel cardEstatistikak = new JPanel();

        //Goiko konexioa erabiliko da

        ArrayList<Estatistikak> estatistikakarraylist = new ArrayList<>();
        Estatistikak [][] lerroak;
        String jokalaria = "SELECT puntuazioa,asistentziak,jokalaria_izena(id_langilea) from jokalaria order by jokalaria.puntuazioa desc";

        PreparedStatement preparedStatement;

        try {
            preparedStatement = conexioa.conexion.prepareStatement(jokalaria);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int puntuazio = resultSet.getInt("puntuazioa");
                int asistentziak = resultSet.getInt("asistentziak");
                String jokalaria_izena = resultSet.getString("jokalaria_izena(id_langilea)");

                Estatistikak estatistika = new Estatistikak(puntuazio, asistentziak, jokalaria_izena);
                estatistikakarraylist.add(estatistika);
            }


            JPanel lEstatistikak = new JPanel();
            lEstatistikak.setLayout(new BoxLayout(lEstatistikak, BoxLayout.Y_AXIS));

            //taula
            Estatistikak [][] lerroa;



            cardEstatistikak.add(lEstatistikak);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        nagusia.add(cardEstatistikak, "cardEstatistikak");

        //Sarrerak erosteko panela
        JPanel cardSarrerak = new JPanel();

        JLabel labelEvento = new JLabel("Sarrera Mota:");
        String[] eventos = {"Sarrera normala", "Premium sarrera"};
        JComboBox<String> comboBoxEvento = new JComboBox<>(eventos);
        JCheckBox bazkide = new JCheckBox("Bazkidea", false);
        JLabel labelCantidad = new JLabel("Sarrera kantitatea:");
        JTextField fieldCantidad = new JTextField(5);
        JButton bErosi = new JButton("Erosi");
        JLabel labelTotal = new JLabel("");
        ArrayList<String> partehartzaileak = new ArrayList<>(100);

        cardSarrerak.add(labelEvento);
        cardSarrerak.add(comboBoxEvento);
        cardSarrerak.add(bazkide);
        cardSarrerak.add(labelCantidad);
        cardSarrerak.add(fieldCantidad);
        cardSarrerak.add(bErosi);
        cardSarrerak.add(labelTotal);

        nagusia.add(cardSarrerak, "cardSarrerak");

        //Sarrerak zozketarako panela
        JPanel cardZozketa = new JPanel();
        cardZozketa.setLayout(new BoxLayout(cardZozketa, BoxLayout.Y_AXIS));

        JPanel panelZozketa = new JPanel();
        label = new JLabel("Ingrese su ID:");
        JTextField idsarrerazozketa = new JTextField(10);
        JButton bparte_hartu = new JButton("Parte hartu");


        // Agregar componentes al panel

        panelZozketa.add(label);
        panelZozketa.add(idsarrerazozketa);
        panelZozketa.add(bparte_hartu);

        // Agregar panel al marco
        cardZozketa.add(panelZozketa);


        nagusia.add(cardZozketa, "cardZozketa");

        //Traspasoak
        JPanel cardTraspasoak = new JPanel();

        String[] columnas = {"Jugador", "Posición", "Origen", "Destino"};

        // Definimos los datos de la tabla
        Object[][] datos = {
                {"LeBron James", "Alero", "Los Angeles Lakers", "Cleveland Cavaliers"},
                {"Chris Paul", "Base", "Houston Rockets", "Oklahoma City Thunder"},
                {"Kawhi Leonard", "Alero", "San Antonio Spurs", "Toronto Raptors"},
                {"DeMarcus Cousins", "Pívot", "New Orleans Pelicans", "Golden State Warriors"},
                {"Jimmy Butler", "Escolta", "Minnesota Timberwolves", "Philadelphia 76ers"},
                {"LeBron James", "Alero", "Los Angeles Lakers", "Cleveland Cavaliers"},
                {"Chris Paul", "Base", "Houston Rockets", "Oklahoma City Thunder"},
                {"Kawhi Leonard", "Alero", "San Antonio Spurs", "Toronto Raptors"},
                {"DeMarcus Cousins", "Pívot", "New Orleans Pelicans", "Golden State Warriors"},
                {"Jimmy Butler", "Escolta", "Minnesota Timberwolves", "Philadelphia 76ers"},
                {"LeBron James", "Alero", "Los Angeles Lakers", "Cleveland Cavaliers"},
                {"Chris Paul", "Base", "Houston Rockets", "Oklahoma City Thunder"},
                {"Kawhi Leonard", "Alero", "San Antonio Spurs", "Toronto Raptors"},
                {"DeMarcus Cousins", "Pívot", "New Orleans Pelicans", "Golden State Warriors"},
                {"Jimmy Butler", "Escolta", "Minnesota Timberwolves", "Philadelphia 76ers"}
        };

        // Creamos la tabla
        JTable tabla = new JTable(datos, columnas);

        // Añadimos la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(tabla);

        // Añadimos el JScrollPane a la ventana
        cardTraspasoak.add(scrollPane);


        nagusia.add(cardTraspasoak, "cardTraspasoak");

        //PANEL OROKORRERA DENA SARTZEN
        this.add(nagusia, BorderLayout.CENTER);
        this.add(header, BorderLayout.NORTH);
        this.add(Lnav, BorderLayout.WEST);

        //estiloa
        this.setTitle("EA Basket || erabiltzaile arrunta");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);


        JFrame hau=this;

        //Action Listeners

        buttonlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login loginclass = new Login(hau);
            }
        });

        bSarrerakErosi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(nagusia, "cardSarrerak");
            }
        });

        bErosi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mota = (String) comboBoxEvento.getSelectedItem();
                int kantitatea = Integer.parseInt(fieldCantidad.getText());

                int prezioa = prezioaKalkulatu(bazkide.isSelected(), kantitatea, mota);
                String sarrera = sarreraID();
                partehartzaileak.add(sarrera);

                JOptionPane.showMessageDialog(null, "Prezioa guztira: " + prezioa + " Sarreraren id-a: " + sarrera);

            }
        });

        bPartiduak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout.show(nagusia, "cardPartiduak");
            }
        });

        bZozketa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(nagusia, "cardZozketa");


            }
        });

        bparte_hartu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sarrera = idsarrerazozketa.getText();
                boolean tf = false;

                for (int i = 0; i < partehartzaileak.size(); i++) {
                    if (partehartzaileak.get(i).equals(sarrera)) {
                        tf = true;
                    }
                    ;
                    System.out.println(partehartzaileak.get(i));
                }

                if (tf) {
                    JOptionPane.showMessageDialog(null, "Zozketan parte hartu duzu");
                } else {
                    JOptionPane.showMessageDialog(null, "Sarrera hori ez da existitzen");
                }

            }
        });
        bTraspasoak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(nagusia, "cardTraspasoak");
            }
        });

        bBilera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bilera bilera = new Bilera();
                bilera.setVisible(true);
            }
        });

        bEstatistikak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(nagusia, "cardEstatistikak");


            }
        });

        bHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(nagusia, "cardHome");
            }
        });



    }

    public int  prezioaKalkulatu(boolean bazkide,int kantitatea,String mota){
        int prezioa;

        if (bazkide==true){
            if (mota.equals("Sarrera normala")){
                prezioa=0;
            }else {prezioa=10*kantitatea;}
        }else {
            if (mota.equals("Sarrera normala")){
                prezioa=30*kantitatea;
            }else {prezioa=50*kantitatea;}
        }

        return prezioa;
    }

    public String sarreraID(){
        int longitud = 5;
        String caracteres = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(longitud);

        for (int i = 0; i < longitud; i++) {
            int indice = rnd.nextInt(caracteres.length());
            sb.append(caracteres.charAt(indice));
        }
        return sb.toString();
    }

    public String irabazlea(ArrayList<String> arrayList){
        Random rnd=new Random();
        int indice = rnd.nextInt(arrayList.size());

        return arrayList.get(indice);
    }

    public void botoiakSartu(String mota){
        Lnav.add(BotonesNav.getbHome());

        if (mota.equals("admin")){
            Lnav.add(BotonesNav.getBklasifikazioa());
            Lnav.add(BotonesNav.getbPartiduak());
            Lnav.add(BotonesNav.getbSarrerak());
            Lnav.add(BotonesNav.getbZozketa());
            Lnav.add(BotonesNav.getbEstatistikak());
            Lnav.add(BotonesNav.getBtraspasoak());

        } else if (mota.equals("jokalaria")) {
            Lnav.add(BotonesNav.getbBilera());
            Lnav.add(BotonesNav.getbEstatistikak());
            Lnav.add(BotonesNav.getbPartiduak());

        }else if (mota.equals("bazkidea")) {
            Lnav.add(BotonesNav.getbEstatistikak());
            Lnav.add(BotonesNav.getbPartiduak());

        }else if (mota.equals("nologed")) {
            Lnav.add(BotonesNav.getbEstatistikak());
            Lnav.add(BotonesNav.getbPartiduak());

        }else if (mota.equals("entrenatzailea")) {
            Lnav.add(BotonesNav.getbEstatistikak());
            Lnav.add(BotonesNav.getbPartiduak());
            Lnav.add(BotonesNav.getbBilera());
            Lnav.add(BotonesNav.getBtraspasoak());
        }
        this.add(Lnav,BorderLayout.WEST);

    }







    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public static void main(String[] args){Home a=new Home("nologed");}
}





