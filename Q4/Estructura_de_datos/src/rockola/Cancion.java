package rockola;

import java.io.File;

public class Cancion {

	private File Archivo;
	private String Nombre;
	private int Artista;
 	private int ID;
	private boolean file;

	public Cancion(){
		this("",0,0);
	}

	public Cancion(String song, int artist, int id) {
		this.Nombre = song;
		this.Artista = artist;
    this.ID = id;
		this.file = false;
	}

	public void setFile(String file){
		this.file = true;
		this.Archivo = new File(file);
	}

	public File getFile() {
		return Archivo;
	}

	public boolean hasFile(){
		return this.file
			&& this.Archivo.isFile() 
			&& this.Archivo.exists();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre){
		this.Nombre = nombre;
	} 

	public int getArtits() {
		return Artista;
	}

	public void setArtista(int artista) {
		this.Artista = artista;
	}


	public void updateID(int shift){
		if(this.ID < shift ) return;
		--this.ID;
	}

	public void updateArtistaID(int shift) {
		if(this.Artista < shift ) return;
		--this.Artista;
	}

}

