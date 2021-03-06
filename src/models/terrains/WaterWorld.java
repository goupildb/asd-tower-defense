/*
  Copyright (C) 2010 Aurelien Da Campo, Lazhar Farjallah, 
  Pierre-Dominique Putallaz

  This program is free software; you can redistribute it and/or modify
  it under the terms of the GNU General Public License as published by
  the Free Software Foundation; either version 3 of the License, or
  (at your option) any later version.

  This program is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
  GNU General Public License for more details.

  You should have received a copy of the GNU General Public License
  along with this program; if not, write to the Free Software
  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
*/

package models.terrains;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import models.jeu.Jeu;
import models.jeu.ModeDeJeu;
import models.joueurs.EmplacementJoueur;
import models.joueurs.Equipe;

/**
 * Classe de gestion du terrain WaterWorld.
 * 
 * Cette classe herite de la classe Terrain de base.
 * 
 * @author Pierre-Dominique Putallaz
 * @author Aurelien Da Campo
 * @author Lazhar Farjallah
 * @version 1.0 | 14 décembre 2009
 * @since jdk1.6.0_16
 * @see Terrain
 */
public class WaterWorld extends Terrain
{
    
    private static final long serialVersionUID = 1L;
    public static final Image IMAGE_DE_FOND;
	public static final Image IMAGE_MENU;
	public final static File FICHIER_MUSIQUE_DE_FOND;
	public final static String NOM = "WaterWorld";
	
    static
    {
        FICHIER_MUSIQUE_DE_FOND = new File("snd/ambient/Defnael - Combat.mp3");
        
        IMAGE_MENU    = Toolkit.getDefaultToolkit().getImage(
                                              "img/cartes/menu_principal/water.png");
    	IMAGE_DE_FOND = Toolkit.getDefaultToolkit().getImage("img/cartes/water.png");
    }

    /**
     * Constructeur d'un terrain TerrainEau.
     */
    public WaterWorld (Jeu jeu) {
        super(jeu,
              500,  // largeur
              500,  // hauteur
              150,  // nbPiecesOrInitiales
              20,   // nbViesInitiales
              -40,    // positionMaillageX
              0,    // positionMaillageY
              540,  // largeurMaillage
              500,  // hauteurMaillage
              ModeDeJeu.MODE_SOLO, // mode de jeu
              new Color(150,150,150), // couleur de fond
              new Color(63,131,140), // couleur des murs
              IMAGE_DE_FOND, // imageDeFond
              NOM   // nom
        );

        opaciteMurs = 0.f;
        
        // Création des équipes
        Equipe e = new Equipe(1,"Equipe par defaut",Color.BLACK);
        e.ajouterZoneDepartCreatures(new Rectangle(-30, 30, 20, 80));
        e.setZoneArriveeCreatures(new Rectangle(460, 410, 40, 40));
        e.ajouterEmplacementJoueur(new EmplacementJoueur(1,new Rectangle(0,0,500,500)));
        equipes.add(e);
        
        fichierMusiqueDAmbiance = FICHIER_MUSIQUE_DE_FOND;
        
        /*
         * Définition des murs du terrain.
         */
        ajouterMur(new Rectangle(0, 0, 220, 20));
        ajouterMur(new Rectangle(220, 0, 60, 90));
        ajouterMur(new Rectangle(280, 0, 220, 20));
        ajouterMur(new Rectangle(480, 20, 20, 200));
        ajouterMur(new Rectangle(410, 220, 90, 60));
        ajouterMur(new Rectangle(480, 280, 20, 100));
        ajouterMur(new Rectangle(280, 480, 220, 20));
        ajouterMur(new Rectangle(220, 410, 60, 90));
        ajouterMur(new Rectangle(0, 480, 220, 20));
        ajouterMur(new Rectangle(20, 220, 70, 60));
        ajouterMur(new Rectangle(-40, 120, 60, 380));
        ajouterMur(new Rectangle(130, 220, 240, 60));
        ajouterMur(new Rectangle(220, 130, 60, 90));
        ajouterMur(new Rectangle(220, 280, 60, 90));
    }
}
