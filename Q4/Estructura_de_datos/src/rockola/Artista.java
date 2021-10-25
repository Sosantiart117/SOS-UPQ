package rockola;

import java.util.ArrayList;

public class Artista {

  private String Nombre;
  private ArrayList<Integer> Canciones;
  private int ID;

  public Artista(String artista, int id) {
    Canciones = new  ArrayList<Integer>();
    this.Nombre = artista;
    this.ID = id;
  }

  public String getNombre() {
    return Nombre;
  }

  public void addSong(int song) {
    this.Canciones.add(song);
  }

  public int getSong(int song) {
    return this.Canciones.get(song);
  }

  public ArrayList<Integer> getSongs(){
    return Canciones;
  }

  public int getID() {
    return ID;
  }

	public void updateID(int shift){
		if(this.ID < shift ) return;
		--this.ID;
	}

  public void updateSongs(int shift) {
    ArrayList<Integer> aux = this.Canciones;
    this.Canciones = new ArrayList<Integer>();
    for(Integer ID : aux){
      if(ID > shift )
        ID--;
      this.Canciones.add(ID);
    }
  }

  public void cleanSongs(){
    ArrayList<Integer> aux = this.Canciones;
    this.Canciones = new ArrayList<Integer>();
    int i = 1;
    for(Integer ID : aux)
      if(i++ < aux.size())
        this.Canciones.add(ID);
  }
}

