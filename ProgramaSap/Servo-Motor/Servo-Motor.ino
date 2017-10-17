#define p1 27
#define p2 26
#define p3 25
#define p4 24
#define sw1 28
#define sw2 29
#define subir 31
#define bajar 30
#define led1 32
#define led2 33
#define led3 34
#define led4 35


void setup() {
  // put your setup code here, to run once:+
  pinMode(p1, INPUT);
  pinMode(p2, INPUT);
  pinMode(p3, INPUT);
  pinMode(p4, INPUT);
  pinMode(sw1, INPUT);
  pinMode(sw2, INPUT);
  pinMode(subir, OUTPUT);
  pinMode(bajar, OUTPUT);

}

void loop() {
  //digitalWrite(subir,1);
  while (digitalRead(p1) == 0) {}
  unsigned int tFinal = millis();
  unsigned int tInicial = millis();

  while (digitalRead(sw1) == 0 ) {
    digitalWrite(bajar, 0);
    digitalWrite(subir, 1);
    digitalWrite(led4, 0);
    digitalWrite(led2, 1);

    if (digitalRead ( p4) == 1) {
      digitalWrite(subir, 0);
      while (digitalRead(p1) == 0) {
        digitalWrite(led2,0);
        digitalWrite(led1, 1);
      }
    }

    if (digitalRead(p2) == 1) {
      digitalWrite(subir, 0);
      digitalWrite(bajar, 0);


      while (digitalRead(p3) == 0) {
        digitalWrite(led1, 1);
      }
    }
  }

  tFinal = millis();
  tInicial = millis();

  while (tFinal - tInicial < 2000) {
    tFinal = millis();
    digitalWrite(led2, 0);
    digitalWrite(led4, 1);
    if (digitalRead ( p4) == 1) {
      digitalWrite(subir, 0);
      while (digitalRead(p1) == 0) {
        digitalWrite(led1, 1);
      }
    }
  }

  while (digitalRead(sw2) == 0) {
    digitalWrite(subir, 0);
    digitalWrite(bajar, 1);
    digitalWrite(led4, 0);
    digitalWrite(led2, 0);
    digitalWrite(led3, 1);
    if (digitalRead ( p4) == 1) {
      digitalWrite(bajar, 0);
      while (digitalRead(p1) == 0) {}
    }
    if (digitalRead(p2) == 1) {
      digitalWrite(subir, 0);
      digitalWrite(bajar, 0);


      while (digitalRead(p3) == 0) {
        digitalWrite(led3, 0);
        digitalWrite(led1, 1);
      }
    }
  }

  tFinal = millis();
  tInicial = millis();

  if (digitalRead ( p4) == 1) {
    digitalWrite(subir, 0);
    while (digitalRead(p1) == 0) {
      digitalWrite(led1, 1);
    }
  }


  while (tFinal - tInicial < 2000) {
    tFinal = millis();
    digitalWrite(led3, 0);
    digitalWrite(led4, 1);

  }


}
//}
