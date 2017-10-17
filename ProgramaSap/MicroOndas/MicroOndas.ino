#define unidades 30
#define decenas 31
#define a 43
#define b 44
#define c 45
#define d 46
#define e 47
#define f 48
#define g 49
#define sw 37
#define sw1 36
#define start 34
int contador = 0;
void setup() {
  // put your setup code here, to run once:
  pinMode(unidades, OUTPUT);
  pinMode(decenas, OUTPUT);
  pinMode(a, OUTPUT);
  pinMode(b, OUTPUT);
  pinMode(c, OUTPUT);
  pinMode(d, OUTPUT);
  pinMode(e, OUTPUT);
  pinMode(f, OUTPUT);
  pinMode(g, OUTPUT);
  pinMode(sw, INPUT);
  pinMode(sw1, INPUT);
  pinMode(start, INPUT);
}

byte display [10] = {63, 6, 91, 79, 102, 109, 125, 7, 127, 103};

void loop() {

  
  if (digitalRead(start) == 1) {
    while(contador > 0){
      for( int i = 0 ; i < 30 ; i ++ ){
      mostrar(contador);
      }
      contador = contador - 1;
      }
    mostrar(contador);
  }
  

  if (digitalRead(sw1) == 1) {
    mostrar (contador);
    while (digitalRead(sw1) == 1) {
      mostrar(contador);
    }
    contador = contador - 1;

  }
  mostrar(contador);
  if (digitalRead(sw) == 1) {
    mostrar (contador);
    while (digitalRead(sw) == 1) {
      mostrar(contador);
    }
    contador = contador + 1;

  }
  mostrar(contador);

  
}



void mostrar(int valor) {
  int dec = valor / 10 ;
  int uni = valor % 10;


  PORTL = display[dec];
  digitalWrite(decenas , 1);
  digitalWrite(unidades , 0);
  delay(5);
  PORTL = display[uni];
  digitalWrite(decenas, 0);
  digitalWrite(unidades , 1);
  delay(5);

}
