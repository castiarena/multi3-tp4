int radio = 5;
int cant = 600;
Agente[] agente = new Agente[cant];

void setup() {
	size(displayWidth, displayHeight);
	smooth();

	for (int i = 0; i < cant; ++i) {
		agente[i] = new Agente(radio,random(1));	
	}
}

void draw() {
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

void mouseMoved() {
	for (int i = 0; i < cant; ++i) {
		agente[i].atraer(mouseX,mouseY);
	}
}
void mousePressed(){
	for (int i = 0; i < cant; ++i) {
		agente[i].acomodar();
	}
}