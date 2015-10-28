package com.test.cours;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufRead {
	public static void main(String[] args) 
	{
		try 
		{
			BufferedReader fichier = new BufferedReader(new FileReader("LISTE.csv"));
			// encapsulation dans un tampon d’un flux de caractères en sortie à destination d’un fichier
			String ligne;
			while (( ligne = fichier.readLine()) != null) 
			{
				System.out.println(ligne);
			}
			fichier.close();
		}
		catch (FileNotFoundException err) 
		{
			System.out.println( "Erreur : le fichier n'existe pas !\n" + err);
		}
		catch (IOException err) 
		{
			System.out.println( "Erreur: \n" + err );
		}
		//il y a deux blocs Catch pour gérer les deux types erreurs : E/S et fichier introuvable
		
	}


}
