class Agente {
	float r = 0.0;
	float x = 0.0;
	float y = 0.0;
	float dir = 0.0;
	float aceleracion = 0.0;

	Agente (float _r, float _a) {
		r = _r;
		x = random(width);
		y = random(height);
		dir = radians(PI/25);
		aceleracion = _a;
	}

	void dibujar(){
		ellipse(x, y, r, r);
	}

	void mover(){
		float dx = sin(x*dir);
		float dy = cos(y*dir);

		x+=dx;
		y+=dy;
	}

	PVector getPos(){
		PVector pos = new PVector(x,y);
		return pos;
	}

	void acomodar(){
		dir=radians(PI/random(360));
	}

	void atraer(int _x, int _y){
		x += (_x - x) * aceleracion;
		y += (_y - y) * aceleracion;
	}

}