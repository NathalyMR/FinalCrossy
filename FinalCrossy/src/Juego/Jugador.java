package Juego;

import processing.core.PApplet;

class Jugador extends Rectangulos {

	float grid = 50;

		  Jugador(float x, float y, float w, PApplet app) {
		    super(x, y, w, w, app);
		  }

		  
		  public void update() {
		    x = PApplet.constrain(x, 0, this.app.width-w);
		  }

		  public void show() {
		    app.fill(0, 255, 0, 200);
		    app.rect(x, y, w, w);
		  }

		  public void move(float xdir, float ydir) {
		    x += xdir * grid;
		    y += ydir * grid;
		  }
		}

