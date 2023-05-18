package window;

import controller.HashPass;
import dbconection.Dbconnection;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {
    //holaa uwu
    private JPanel pnorth,psouth,pwest,peast,pcenter,pbotoika;
    private JLabel title;
    private JButton blogin,bsingin;
    private String email,pass;
    private JTextField textFieldizena;
    private JPasswordField textFieldpass;

    String loginmota="";

    Login(JFrame home){

        this.setVisible(true);
        this.setSize(400,500);
        this.setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());

        Font f1=new Font("Arial",Font.PLAIN,20);

        //Goiko panela
        pnorth=new JPanel();
        pnorth.setBackground(new Color(0, 48, 73,255));

        title=new JLabel("LOGIN");
        title.setForeground(Color.white);
        Font tit=new Font("Arial",Font.PLAIN,30);
        title.setFont(tit);
        pnorth.add(title);

        this.add(pnorth,BorderLayout.NORTH);

        //Erdikoa

        pcenter=new JPanel();
        blogin=new JButton("Log in");
        bsingin=new JButton("Sing up");


        JPanel karratuaLogin=new JPanel();
        karratuaLogin.setLayout(new BoxLayout(karratuaLogin,BoxLayout.Y_AXIS));

        //logoa jartzeko
        ImageIcon imageO = new ImageIcon("logoa.png");
        Image imageE=imageO.getImage().getScaledInstance(196,167,Image.SCALE_SMOOTH);
        ImageIcon imageIcon=new ImageIcon(imageE);
        JLabel label=new JLabel(imageIcon);

        karratuaLogin.add(label);
        karratuaLogin.setBackground((new Color(193, 35, 46,255)));



        //betetzeko
        JPanel betekizunak=new JPanel();
        betekizunak.setLayout(new BoxLayout(betekizunak,BoxLayout.Y_AXIS));


        BasicBorders.MarginBorder marginBorder=new BasicBorders.MarginBorder();


        //izena
        JLabel user=new JLabel("Email");
        user.setFont(f1);
        user.setForeground(Color.white);
        textFieldizena=new JTextField();

        betekizunak.add(user);
        betekizunak.add(textFieldizena);

        karratuaLogin.add(betekizunak);

        //pass

        JLabel password=new JLabel("Password");
        password.setFont(f1);
        password.setForeground(Color.white);
        textFieldpass=new JPasswordField();

        betekizunak.add(password);
        betekizunak.add(textFieldpass);

        karratuaLogin.add(betekizunak);


        //behekoa
        psouth=new JPanel();

        //botoiak
        pbotoika=new JPanel();
        pbotoika.setLayout(new BoxLayout(pbotoika,BoxLayout.X_AXIS));
        psouth.add(bsingin);
        psouth.add(blogin);

        this.add(psouth,BorderLayout.SOUTH);


        karratuaLogin.add(pbotoika);
        pcenter.setBackground((new Color(193, 35, 46,255)));
        betekizunak.setBackground((new Color(193, 35, 46,255)));

        pcenter.add(karratuaLogin);

        this.add(pcenter,BorderLayout.CENTER);

        bsingin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //window.SingUp singUp=new window.SingUp();
                close();
            }
        });

        blogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                Dbconnection conexioa=new Dbconnection();
                conexioa.ConexionBaseDeDatos();

                String select="select mota from erabiltzaileak where email=? and pasahitza=? ";

                PreparedStatement  ps;


                try {
                    ps=conexioa.conexion.prepareStatement(select);
                    ps.setString(1,getEmail());
                    ps.setString(2,getPass());

                    ResultSet rs=ps.executeQuery();

                    while (rs.next()) {
                        loginmota = rs.getString("mota");

                        System.out.println(loginmota);
                    }

                    if(loginmota.equals("Jokalaria")){
                        System.out.println("home");
                        home.dispose();
                        Home a=new Home("jokalaria");
                    }

                    if(loginmota.equals("Bazkidea")){
                        System.out.println("home");
                        home.dispose();
                        Home a=new Home("bazkidea");
                    }

                    if(loginmota.equals("Entrenatzailea")){
                        System.out.println("home");
                        home.dispose();
                        Home a=new Home("entrenatzailea");
                    }

                    if(loginmota.equals("admin")){
                        System.out.println("home");
                        home.dispose();
                        Home a=new Home("admin");
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }finally {
                    close();
                }
            }
        });

        this.email=textFieldizena.getText();
    }

    public Login() {
        this.loginmota="admin";
        this.email="admin";
        this.pass="admin";
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        this.pass= HashPass.hasher(textFieldpass.getText());
        return pass;
    }

    public void close(){
        this.setVisible(false);
    }

    public String getLoginmota() {
        return loginmota;
    }

    public JFrame getThis() {
        return this;
    }
}

