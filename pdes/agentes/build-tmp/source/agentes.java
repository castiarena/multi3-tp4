import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class agentes extends PApplet {

int radio = 5;
int cant = 600;
Agente[] agente = new Agente[cant];

public void setup() {
	size(displayWidth, displayHeight);
	smooth();

	for (int i = 0; i < cant; ++i) {
		agente[i] = new Agente(radio,random(1));	
	}
}

public void draw() {
	background(200, 200);
	noStroke();
	fill(0);
	for (int i = 0; i < cant; ++i) {
		agente[i].mover();
		agente[i].dibujar();
		stroke(0);
		if(i != cant){
			line( agente[i+1].getPos().x,agente[i+1].getPos().y,agente[i].getPos().x,agente[i].getPos().y);

		}
	}
}

public void mouseMoved() {
	for (int i = 0; i < cant; ++i) {
		agente[i].atraer(mouseX,mouseY);
	}
}
public void mousePressed(){
	for (int i = 0; i < cant; ++i) {
		agente[i].acomodar();
	}
}
class Agente {
	float r = 0.0f;
	float x = 0.0f;
	float y = 0.0f;
	float dir = 0.0f;
	float aceleracion = 0.0f;

	Agente (float _r, float _a) {
		r = _r;
		x = random(width);
		y = random(height);
		dir = radians(PI/25);
		aceleracion = _a;
	}

	public void dibujar(){
		ellipse(x, y, r, r);
	}

	public void mover(){
		float dx = sin(x*dir);
		float dy = cos(y*dir);

		x+=dx;
		y+=dy;
	}

	public PVector getPos(){
		PVector pos = new PVector(x,y);
		return pos;
	}

	public void acomodar(){
		dir=radians(PI/random(360));
	}

	public void atraer(int _x, int _y){
		x += (_x - x) * aceleracion;
		y += (_y - y) * aceleracion;
	}

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "agentes" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
