package Juego;

import processing.core.PApplet;

public class Main extends PApplet{

	private Logica logica;
	
	public static void main(String[] args) {
	
		PApplet.main("Juego.Main");
	}

	public void settings() {
		size(500, 750);
	
	}
	
	public void setup() {
		logica = new Logica(this);	
		 
	}
	
	
	public void draw() {
		
		logica.pintar();
	}
	
	public void keyPressed() {
		
		logica.tecla();
		
	}
}
	