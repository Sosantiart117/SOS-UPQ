package rockola;

import java.util.ArrayList;

public class Musiteca {

	private ArrayList<Artista> Artistas; 
	private ArrayList<Cancion> Canciones;

	public Musiteca() {
		Artistas = new ArrayList<Artista>();
		Canciones = new ArrayList<Cancion>();
		Artistas.add(new Artista("Sin artista",0));
	}

	public int addArtist(String artista, int id) {
		Artista nArtist = new Artista(artista,id);
		Artistas.add(nArtist);
		return Artistas.size()-1;
	}

	public int addSong(String song, int artist, int sID) {
		Cancion nSong = new Cancion(song, artist, sID);
		this.Canciones.add(nSong);
		return Canciones.size()-1;
	}

	public Cancion getSong(int song) {
		return this.Canciones.get(song);
	}

	public Artista getArtist(int artist) {
		if(artist < 0) return null;
		return this.Artistas.get(artist);
	}

	public ArrayList<Artista> getArtistas(){
		return this.Artistas;
	}

	public ArrayList<Cancion> getCanciones(){
		return this.Canciones;
	}

	public void removeArtista(int aID){
		Artista a = this.Artistas.remove(aID);
		for(Artista x: this.Artistas){
			x.updateID(a.getID());
		}
		// update songs
		for(int i = a.getSongs().size()-1; i>=0;i--)
			removeSong(a.getSong(i));
		for(Cancion x: this.Canciones)
			x.updateArtistaID(a.getID());
	}

	public void removeSong(int sID){
		Cancion s = this.Canciones.remove(sID);
		for(Cancion x: this.Canciones)
			x.updateID(s.getID());
		for(Artista x: this.Artistas)
			x.updateSongs(s.getID());
	}

	public String print(){
		String music = "# Este archivo se genera con la RockOla\n\n";
		for(Artista x: this.Artistas){
			music += "a "+x.getNombre()+"\n";
			for(Integer i: x.getSongs()){
				Cancion s = this.getSong(i);
				 music += "s "+s.getNombre()+"\n";
				if(s.hasFile())
					music += "f "+s.getFile().getPath()+"\n";
			}
			music += "\n\n";
		}
		System.out.print(music);
		return music;
	}

}

