package window;

import controller.HashPass;
import dbconection.Dbconnection;
import window.Login;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SingUp extends JFrame {

    private JPanel pnorth,psouth,pwest,peast,pcenter,pbotoika;
    private JLabel title;
    private JButton blogin,bsingin,bgorde;
    private String user, pass, email,mota;
    private JTextField textFieldizena,textFieldemail;
    private JPasswordField textFieldpass;
    private JComboBox<String> aukerak;

    public SingUp(){
        this.setVisible(true);
        this.setSize(400,500);
        this.setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());

        Font f1=new Font("Arial",Font.PLAIN,20);

        //Goiko panela
        pnorth=new JPanel();
        pnorth.setBackground(new Color(0, 48, 73,255));

        title=new JLabel("SING UP");
        title.setForeground(Color.white);
        Font tit=new Font("Arial",Font.PLAIN,30);
        title.setFont(tit);
        pnorth.add(title);

        this.add(pnorth,BorderLayout.NORTH);

        //Erdikoa

        pcenter=new JPanel();
        blogin=new JButton("Log in");
        bsingin=new JButton("Sing up");
        bgorde=new JButton("Gorde");


        JPanel karratuaSingup=new JPanel();
        karratuaSingup.setLayout(new BoxLayout(karratuaSingup,BoxLayout.Y_AXIS));

        //logoa jartzeko
        ImageIcon imageO = new ImageIcon("logoa.png");
        Image imageE=imageO.getImage().getScaledInstance(196,167,Image.SCALE_SMOOTH);
        ImageIcon imageIcon=new ImageIcon(imageE);
        JLabel label=new JLabel(imageIcon);

        karratuaSingup.add(label);
        karratuaSingup.setBackground((new Color(193, 35, 46,255)));





        //betetzeko
        JPanel betekizunak=new JPanel();
        betekizunak.setLayout(new BoxLayout(betekizunak,BoxLayout.Y_AXIS));


        BasicBorders.MarginBorder marginBorder=new BasicBorders.MarginBorder();


        //izena
        JLabel user=new JLabel("Username");
        user.setFont(f1);
        user.setForeground(Color.white);
        this.textFieldizena=new JTextField();

        betekizunak.add(user);
        betekizunak.add(textFieldizena);

        karratuaSingup.add(betekizunak);

        //pass

        JLabel password=new JLabel("Password");
        password.setFont(f1);
        password.setForeground(Color.white);
        this.textFieldpass=new JPasswordField();

        betekizunak.add(password);
        betekizunak.add(textFieldpass);

        karratuaSingup.add(betekizunak, BorderLayout.CENTER);

        //email
        JLabel email = new JLabel("Email");
        email.setFont(f1);
        email.setForeground(Color.white);
        this.textFieldemail = new JTextField();

        betekizunak.add(email);
        betekizunak.add(textFieldemail);

        karratuaSingup.add(betekizunak);

        //mota
        JLabel mota = new JLabel("Kontu mota");
        mota.setFont(f1);
        mota.setForeground(Color.white);
        String[] motak = {"Bazkidea", "Entrenatzailea","Jokalaria"};
        this.aukerak = new JComboBox<>(motak);

        aukerak.setFont(f1);
        aukerak.setForeground(Color.black);

        betekizunak.add(mota);
        betekizunak.add(aukerak);

        karratuaSingup.add(betekizunak);

        //behekoa
        psouth=new JPanel();

        //botoiak
        pbotoika=new JPanel();
        pbotoika.setLayout(new BoxLayout(pbotoika,BoxLayout.X_AXIS));
        psouth.add(bgorde);
        psouth.add(bsingin);
        psouth.add(blogin);


        this.add(psouth,BorderLayout.SOUTH);


        karratuaSingup.add(pbotoika);
        pcenter.setBackground((new Color(193, 35, 46,255)));
        betekizunak.setBackground((new Color(193, 35, 46,255)));

        pcenter.add(karratuaSingup);

        this.add(pcenter,BorderLayout.CENTER);

        JFrame hau=this;

        blogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login l=new Login(hau);
                close();
            }
        });

        //Datuak hartu eta datu basera bidali
        bsingin.addActionListener(new ActionListener() {

            String userdb;

            @Override
            public void actionPerformed(ActionEvent e) {
                datuakesleitu();
                userdb=getUser();
                System.out.println("konexioa: "+userdb);
                String insert="INSERT INTO erabiltzaileak (email, erabiltzailea, pasahitza, mota) VALUES (?,?,?,?)";

                Dbconnection conexioa=new Dbconnection();
                conexioa.ConexionBaseDeDatos();

                PreparedStatement preparedStatement;

                try {
                    preparedStatement=conexioa.conexion.prepareStatement(insert);
                    preparedStatement.setString(1,getEmail());
                    preparedStatement.setString(2,getUser());
                    preparedStatement.setString(3,getPass());
                    preparedStatement.setString(4,getMota());
                    preparedStatement.execute();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }finally {
                    itxi();
                }


            }
        });


    }

    public void datuakesleitu(){
        String notHashed;
        this.user=this.textFieldizena.getText();
        System.out.println("esleitu:"+this.user);
        this.email=this.textFieldemail.getText();
        this.mota= (String) this.aukerak.getSelectedItem();
        notHashed=this.textFieldpass.getText();
        this.pass= HashPass.hasher(notHashed);
        System.out.println("hash: "+this.pass);
    }

    public void close(){
        this.setVisible(false);
    }

    public String getUser() {
        System.out.println("get:"+this.user);
        return this.user;
    }

    public String getPass() {
        return pass;
    }

    public String getMota() {
        return mota;
    }

    public String getEmail() {
        return email;
    }

    public void itxi(){
        this.setVisible(false);
    }
}
