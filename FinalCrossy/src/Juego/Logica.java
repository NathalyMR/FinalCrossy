package Juego;
import processing.core.PApplet;

public class Logica {
	
	private PApplet app;
	
private Jugador jugador;
private Carros[] carros;
int contadorTiempo=0;
int finalizar=0;
boolean gameOver=false;
int pantalla=0;

public float grid = 50;

public Logica(PApplet app) {
	
	this.app = app;

	
	    resetGame();

	  int index = 0;
	  carros = new Carros[30];

	  // ROW 1
	  for (int i = 0; i < 2; i++) {
	    float x = i * 300;
	    carros[index] = new Carros(x, this.app.height-grid*2, grid, grid, -2, app);
	    index++;
	    
	  }

	  // ROW 2
	  for (int i = 0; i < 2; i++) {
	    float x = i * 200 + 150;
	    carros[index] = new Carros(x, this.app.height-grid*3, grid, grid, 1, app);
	    index++;
	  }

	  // ROW 3
	  for (int i = 0; i < 3; i++) {
	    float x = i * 150 + 25;
	    carros[index] = new Carros(x, this.app.height-grid*4, grid, grid, -1.5, app);
	    index++;
	  }
	  // ROW 4
	  for (int i = 0; i <3 ; i++) {
		    float x =  i * 250 + 100;
		    carros[index] = new Carros(x, this.app.height-grid*6, grid, grid, 2.5, app);
		    index++;
		  }
	// ROW 5
		  for (int i = 0; i < 4; i++) {
			    float x = i * 200 + 30;
			    carros[index] = new Carros(x, this.app.height-grid*7, grid, grid, -1, app);
			    index++;
			  }
		// ROW 6
		  for (int i = 0; i < 2; i++) {
			    float x =  i * 400 + 10;
			    carros[index] = new Carros(x, this.app.height-grid*8, grid, grid, 3, app);
			    index++;
			  }
		  for (int i = 0; i < 4; i++) {
			    float x =  i * 400 + 10;
			    carros[index] = new Carros(x, this.app.height-grid*10, grid, grid, -1.5, app);
			    index++;
			  }
		  for (int i = 0; i < 5; i++) {
			    float x =  i * 400 + 10;
			    carros[index] = new Carros(x, this.app.height-grid*11, grid, grid, 2, app);
			    index++;
			  }
		  for (int i = 0; i < 2; i++) {
			    float x =  i * 400 + 10;
			    carros[index] = new Carros(x, this.app.height-grid*12, grid, grid, -1, app);
			    index++;
			  }
		  for (int i = 0; i < 3; i++) {
			    float x =  i * 400 + 10;
			    carros[index] = new Carros(x, this.app.height-grid*13, grid, grid, 3, app);
			    index++;
			  }


}
public void resetGame() {
  jugador = new Jugador(this.app.width/2-grid/2, this.app.height-grid, grid, app);
  
}

public void pintar() {
  
     
    
    
    switch (pantalla) {
    case 0:
    	this.app.background(0);
    	  this.app.fill(255, 100);
    	  this.app.rect(0, 0, this.app.width, grid*2);
    	  this.app.rect(0, this.app.height-grid, this.app.width, grid);
    	  this.app.rect(0, this.app.height-grid*9, this.app.width, grid);
    	  this.app.rect(0, this.app.height-grid*5, this.app.width, grid);
    	  contadorTiempo++;
    	  this.app.text("Tiempo: "+contadorTiempo, 50, 50);
    	  
    	  jugador.update();
    	  jugador.show();
    	  for (Carros car : carros) {
    	    car.show();
    	    car.update();
    	    Thread nuevoCarro = new Thread(car);
    		nuevoCarro.start();
    	    if (jugador.choque(car)) {
    	      pantalla=1;
    }
    	    
    	  }
    	  if(jugador.y<=50) {
    		  pantalla=2;
    	  }
    	    break;
    case 1:
    	this.app.fill(0);
    	this.app.rect(0,0,800,800);
    	this.app.fill(255);
    	this.app.text("Perdiste",220,370);
    	this.app.text("Presiona R para jugar de nuevo", 150, 390);
    	
    	
    	break;
    	
    case 2:
    	this.app.fill(0);
    	this.app.rect(0,0,800,800);
    	this.app.fill(255);
    	this.app.text("Ganaste",220,370);
    	this.app.text("Presiona R para jugar de nuevo", 150, 390);
    	    	
    	break;
    	
 
  

    }}



public void tecla() {

  if (this.app.keyCode == this.app.UP) {
    jugador.move(0, -1);
  } else if (this.app.keyCode == this.app.DOWN) {
    jugador.move(0, 1);
  } else if (this.app.keyCode == this.app.RIGHT) {
    jugador.move(1, 0);
  } else if (this.app.keyCode == this.app.LEFT) {
    jugador.move(-1, 0);
  } else if (this.app.key == 'r' && pantalla==1 || pantalla==2  ) {
	  resetGame();
	  pantalla=0;
  }
}


}
