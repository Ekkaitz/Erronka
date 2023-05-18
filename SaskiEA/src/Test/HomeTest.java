package Test;

import controller.HashPass;
import controller.MouseListenerBordeBotones;
import dbconection.Dbconnection;
import dbconection.Estatistikak;
import dbconection.Partiduak;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;
import window.Bilera;
import window.Home;
import window.Login;


import javax.swing.*;

import java.awt.event.MouseEvent;

import static org.junit.jupiter.api.Assertions.*;

class HomeTest {
  @Test
  @DisplayName("Froga 1")
  void metodoa1(){
      Home home=new Home("admin");

      String id;
      id =home.sarreraID();

      assertAll(
              ()->assertNotNull(id),
              ()-> assertEquals(5, id.length())
      );

  }

  @Test
  @DisplayName("BeforeAll")
  @RepeatedTest(3)
  public static void konexioa(){
      Dbconnection dbconnection=new Dbconnection();
      dbconnection.ConexionBaseDeDatos();
      assertTrue(dbconnection.getEgoera(),"Konexioa ongi dabil");

      if (dbconnection.getEgoera()){
          System.out.println("konexioa egin da");
      }
  }

  @Test
  @AfterAll
  @DisplayName("After All")
  public static void konexioaBukatu(){
    Dbconnection dbconnection=new Dbconnection();
    assertNotNull(dbconnection.DesconexionDeBasesDeDatos());
  }

  @Test
  @EnabledOnOs(OS.WINDOWS)
  @DisplayName("Froga Windows")
  public void windowserako(){
      Home home=new Home("admin");
      int prezioa=home.prezioaKalkulatu(true,1000,"Sarrera normala");
      assertEquals(0,prezioa);

  }

  @Test
    @DisplayName("Hash stest")
    public void hasstext(){
      HashPass hashh=new HashPass();
      assertNotNull(hashh.hashCode());
  }

@Test
@DisplayName("Crud eragiketak")
@Nested
    public void crud(){
      Home home=new Home("admin");
      //select-a null ez izatea
      assertNull( home.getPreparedStatement());
}

@Test
    @DisplayName("Bilera")
    @Nested
    public void bilera(){
        Bilera bilera=new Bilera();
        JButton b=new JButton();

        b=bilera.getConfirmarButton();

        assertNotNull(b);
        assertNotNull(bilera);


}

@Test
    @DisplayName("Login")
    @Nested
    public void login(){
        Home n=new Home("admin");

        assertNotNull(n.getButtonlogin());

        Login login=new Login();

        assertNotNull(login.getLoginmota());

    }

@Test
    @DisplayName("Singin")
    @Nested
    public void sing(){

        Login login=new Login();
        assertNotNull(login.getThis());


    }

    @Test
    @DisplayName("Hash")
    @Nested
    public void t3(){
        String pass="pasahitza";
        assertNotNull(pass=HashPass.hasher(pass));
    }

    @Test
    @DisplayName("Botoiak")
    @Nested
    public void t4(){
        JPanel panel=new JPanel();
        MouseListenerBordeBotones a=new MouseListenerBordeBotones(panel);

    }

    @Test
    @DisplayName("Estatistikak")
    @Nested
    public void t5(){
        Estatistikak estatistikak=new Estatistikak(233,54,"ekaitz");

        assertNotNull(estatistikak.getAsistentziak());
        assertNotNull(estatistikak.getPuntuazioa());
        assertNotNull(estatistikak.getJokalaria_izena());

    }

    @Test
    @DisplayName("Partiduak")
    @Nested
    public void t6(){
        Partiduak partiduak=new Partiduak(1,"a","20-20","atzo");

        assertNotNull(partiduak.getData());
        assertNotNull(partiduak.getEmaitza());
        assertNotNull(partiduak.getZelaia());
        assertNotNull(partiduak.getId_partidoa());

    }

    @Test
    @DisplayName("dbk2")
    @Nested
    public void t7(){
        Dbconnection dbconnection=new Dbconnection();


        assertTrue(dbconnection.DesconexionDeBasesDeDatos());
        assertNotNull(dbconnection.getEgoera());
        assertNotNull(dbconnection.getConexion());

    }

    @Test
    @DisplayName("s")
    @Nested
    public void t8(){
        JPanel panel=new JPanel();
        MouseEvent mouseEvent = null;

        MouseListenerBordeBotones mouseListenerBordeBotones=new MouseListenerBordeBotones(panel);
        


    }






}
