package com.test.cours;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufWrit 
{
  public static void main(String[] args)
  {
	try 
	{
		String ligne;
		/* try et catch permettent d’intercepter les erreurs de fonctionnement du programme.
		Cela s’appelle en Java la gestion des exceptions */
		BufferedWriter fichier1 = new BufferedWriter(new FileWriter("utilisateur.html"));
		BufferedReader fichierCSV = new BufferedReader(new FileReader("LISTE.csv"));
					
		// encapsulation dans un tampon d’un flux de caractères en entrée issu d’un fichier
		// ceci permet la déclaration et l’ouverture du fichier
				
		fichier1.write("<!DOCTYPE html>");;
		fichier1.newLine();
		fichier1.write("<html>");
		fichier1.newLine();
		fichier1.write("<head>");
		fichier1.newLine();
		fichier1.write("<title>Liste </title>");
		fichier1.newLine();
		fichier1.write("</head>");
		fichier1.newLine();
		fichier1.write("<body>");
		fichier1.newLine();
		fichier1.write("<h1>Liste </h1>");
		fichier1.newLine();	
		fichier1.write("<table BORDER=1>");
		fichier1.write("<table>");
	
			while ((ligne = fichierCSV.readLine()) != null) 
			{
				String newLigne = replace(ligne, ";;;;;;;;;;;", " ");
		
				System.out.println("<tr>" + "<td>" + replace(newLigne, ";", "</td><td>") + "</td>" + "</tr>");
		
				fichier1.write("<tr>" + "<td>" + replace(newLigne, ";", "</td><td>") + "</td>" + "</tr>");
							
			}
				
		fichier1.write("</table>");
		//	BufWrit.genTab();
		fichier1.write("</body>");
		fichier1.write("</html>");
		fichier1.close();
	}
				
	catch (IOException err) 
	{
		System.out.println( "Erreur: \n" + err );
		//Catch gère les erreurs interceptées par le bloc try
	}	
	  
  }
  
  public static String replace(String originalText, String subStringToFind, String subStringToReplaceWith) 
  {
	int s = 0;
	int e = 0;
	StringBuffer newText = new StringBuffer();
	while ((e = originalText.indexOf(subStringToFind, s)) >= 0) 
	{
		newText.append(originalText.substring(s, e));
		newText.append(subStringToReplaceWith);
		s = e + subStringToFind.length();

	}
	newText.append(originalText.substring(s));
	return newText.toString();

  }


}
