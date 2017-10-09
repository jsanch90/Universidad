//sensores de calor derecha a izquierda
#define s_t1 36
#define s_t2 34
#define s_t3 32
#define s_t4 30
#define s_t5 28


//ultrasonido
#define ultra_trig_at 24
#define ultra_echo_at 25

#define ultra_trig_ad 26
#define ultra_echo_ad 27

//sensores de color
#define lineaCen 2 //verde
#define lineaIzq1 4
#define lineaIzq2 3
#define lineaDer1 0
#define lineaDer2 1

//motores
#define enableA 8
#define adelanteA 7
#define atrasA 6
#define adelanteB 5
#define atrasB 4
#define enableB 3

//ventilador
#define apa 29

void setup() {
  pinMode(ultra_echo_at, INPUT);
  pinMode(ultra_echo_ad, INPUT);
  pinMode(s_t1, INPUT);
  pinMode(s_t2, INPUT);
  pinMode(s_t3, INPUT);
  pinMode(s_t4, INPUT);
  pinMode(s_t5, INPUT);
  pinMode(ultra_trig_at, OUTPUT);
  pinMode(ultra_trig_ad, OUTPUT);

  // pinMode(enableA,OUTPUT);
  pinMode(enableB, OUTPUT);
  pinMode (adelanteA, OUTPUT);
  pinMode (atrasA, OUTPUT);
  pinMode (adelanteB, OUTPUT);
  pinMode (atrasB, OUTPUT);
  pinMode (apa, OUTPUT);

  pinMode (lineaCen, INPUT);
  pinMode (lineaIzq1 , INPUT);
  pinMode (lineaIzq2, INPUT);
  pinMode (lineaDer1, INPUT);
  pinMode (lineaDer2, INPUT);

  Serial.begin(9600);

}

void loop() {
  //Blanco entre 500 y 700 // Negro entre 900 y 1k
  int negro = analogRead(lineaCen);
  Serial.println(negro);
  while (!sensor()) {
    Serial.println("aca estoy");
  
    if (analogRead(lineaCen) >= 900 && analogRead(lineaCen) <= 1000 ){
      digitalWrite(enableB , 5);
      digitalWrite(enableA , 5);
      digitalWrite(adelanteA, 5);
      digitalWrite(adelanteB, 5);
    } else {
      digitalWrite(enableB , 0);
      digitalWrite(enableA , 0);
      digitalWrite(adelanteA, 0);
      digitalWrite(adelanteB, 0);
    }
//  }
}
}

bool sensor() {

  if (digitalRead(s_t1) == 1) {
    return true;
  }
  if (digitalRead(s_t2) == 1) {
    return true;
  }
  if (digitalRead(s_t3) == 1) {
    return true;
  }
  if (digitalRead(s_t4) == 1) {
    return true;
  }
  if (digitalRead(s_t5) == 1) {
    return true;
  }
  return false;
}
