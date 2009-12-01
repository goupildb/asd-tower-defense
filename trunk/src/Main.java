import java.awt.Rectangle;
import javax.swing.UIManager;
import models.jeu.Jeu;
import models.terrain.*;
import vues.Fenetre_Jeu;

/**
 * Classe principale du Tower Defense
 * 
 * @author Pierre-Dominique Putallaz
 * @author Aurélien Da Campo
 * @author Lazhar Farjallah
 * @version 1.0 | 27 novemenbre 2009
 * @since jdk1.6.0_16
 */
public class Main
{
   /**
    * Programme principal.
    * 
    * @param args Les arguments fournis au programme principal.
    */
   public static void main(String[] args) 
   {
      // modification du style de l'interface
	  try 
	  { 
		  UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
	  } 
	  catch (Exception e) 
	  { 
		  /* 
		   * On fait rien, c'est pas grave. 
		   * C'est juste le look and feel qui n'est pas installe.
		   */ 
	  }
	   
	  TerrainDesert terrain = new TerrainDesert();
	  
	  // création du jeu
	  Jeu jeu = new Jeu(terrain);
	  
	  // initialisation du jeu
	  // TODO meilleur implementation
	  jeu.ajouterMur(new Rectangle(0,0,50,500));
	  jeu.ajouterMur(new Rectangle(200,100,400,300));
	  
	  // création de la fenetre du jeu
	  new Fenetre_Jeu(jeu);
   }
}