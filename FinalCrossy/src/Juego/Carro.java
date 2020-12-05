package Juego;


import processing.core.PApplet;


class Carros extends Rectangulos implements Runnable {
	  double speed;
	  float grid = 50;
	  
	  
	 
	  
	  Carros(float x, float y, float w, float h, double s, PApplet app) {
	    super(x, y, w, h, app);
	    speed = s;
	  }

	  public void update() {
	    x = (float) (x + speed);
	    if (speed > 0 && x > this.app.width+grid) {
	      x = -w-grid;
	    } else if (speed < 0 && x < -w-grid) {
	      x = this.app.width+grid;
	    }
	  }

	  public void show() {
	    this.app.fill(200);
	    this.app.rect(x, y, w, h);
	    
	    
	  }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		update();
	}
	}

