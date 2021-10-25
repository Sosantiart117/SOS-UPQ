package rockola;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Rockola{

	private Musiteca Musica;
	private String BibFile;
	
	public Queue<Cancion> ColaRep;
	public Reproductor Rep;

	public Rockola() throws FileNotFoundException {
		this("musicFile.txt");
	}

	public Rockola(String musicFile) throws FileNotFoundException {
		this.BibFile = musicFile;
		this.Musica = new Musiteca();
		this.ColaRep = new LinkedList<Cancion>();
		loadMusic(musicFile);
		this.Rep = new Reproductor();
	}

	public void addCola(Cancion song){
		this.ColaRep.add(song);
	}

	public Artista getArtista(int artist){
		return this.Musica.getArtist(artist);
	}

	public void addArtista(String nombre){
		this.Musica.addArtist(nombre,
				this.Musica.getArtistas().size());
	}

	public int addSong(String nombre,int artista,int sID){
		return this.Musica.addSong(nombre, artista, sID);
	}

	public void removeArtista(int aID){
		this.Musica.removeArtista(aID);
	}

	public Cancion getCancion(int song){
		return this.Musica.getSong(song);
	}

	public void removeCancion(int sID){
		this.Musica.removeSong(sID);
	}

	public ArrayList<Artista> getArtistas(){
		return this.Musica.getArtistas();
	}

	public ArrayList<Cancion> getCanciones(){
		return this.Musica.getCanciones();
	}

	public void shuffleCola(){
		LinkedList<Cancion> aux = (LinkedList<Cancion>)ColaRep;
		Collections.shuffle(aux);
		ColaRep = aux;
	}

	public void saveMusiteca() throws IOException{
		String musiteca = this.Musica.print();
		saveFile(new File(this.BibFile),musiteca);
	}

	public void loadMusic(String musicFile) throws FileNotFoundException{
		Scanner mFile = new Scanner(new File(musicFile));
		int lastArtist = 0, lastSong = 0;
		while(mFile.hasNextLine()){
			String line = mFile.nextLine().trim();
			if( line.isBlank() || line.isEmpty()
					|| line.substring(0, 1).equals("#"))
				continue;
			// get action and do acordingly
			char act =  line.charAt(0);
			String obj = line.substring(2);
			switch(act){
				case 'a':
					lastArtist = this.Musica.addArtist(obj,lastArtist+1);
					break;
				case 's':
					lastSong = this.Musica.addSong(obj,lastArtist, lastSong+1);
					this.Musica.getArtist(lastArtist).addSong(lastSong);
					break;
				case 'f':
					this.Musica.getSong(lastSong).setFile(obj);
					break;
			}
		}
	}

	public void savePlayList(String name) throws IOException{
		String playlist = "# Playlist "+name+"\n";
		for(Cancion x: ColaRep){
			playlist+= "a "+x.getArtits()+"\n";
			playlist+= "s "+x.getNombre()+"\n";
			playlist+= "i "+x.getID()+"\n";
			if(x.hasFile())
				playlist+="f "+x.getFile().getPath()+"\n";
			playlist+="e \n";
		}
		File pFile = new File(name+".txt");
		System.out.println("Save Playlist:\n"+playlist);
		saveFile(pFile,playlist);
	}

	public void loadPlayList(String pFile) throws FileNotFoundException{
		Scanner mFile = new Scanner(new File(pFile));
		do{
			Cancion pSong = new Cancion();
			String obj = "";
			while(mFile.hasNextLine()){
				String line = mFile.nextLine().trim();
				if( line.isBlank() || line.isEmpty()
						|| line.substring(0, 1).equals("#"))
					continue;
				// get action and do acordingly
				char act =  line.charAt(0);
				if(act == 'e') break;
				obj = line.substring(2);
				switch(act){
					case 'a':
						pSong.setArtista(Integer.parseInt(obj));
						break;
					case 's':
						pSong.setNombre(obj);
						break;
					case 'i':
						pSong.setID(Integer.parseInt(obj));
						break;
					case 'f':
						pSong.setFile(obj);
						break;
				}
			}
			this.ColaRep.add(pSong);
		}while(mFile.hasNextLine());
	}

	public void saveFile(File saveFile, String content) throws IOException{
		FileWriter fw = new FileWriter(saveFile);
		fw.write(content);
		fw.flush();
		fw.close();
	}

}
