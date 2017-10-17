#define sw_subir 30
#define sw_bajar 29
#define punto3 31
#define punto2 32
#define punto1 33
#define cont 37
#define ubicacion 36
#define start 35
#define ir_der 26
#define ir_izq 25
#define elec 24
#define subir 23
#define bajar 22

//Display 7-seg
#define a 43
#define b 44
#define c 45
#define d 46
#define e 47
#define f 48
#define g 49



void setup()
{
  pinMode(sw_subir, INPUT);
  pinMode(sw_bajar, INPUT);
  pinMode(punto3, INPUT);
  pinMode(punto2, INPUT);
  pinMode(punto1, INPUT);
  pinMode(cont, INPUT);
  pinMode(ubicacion, INPUT);
  pinMode(start, INPUT);
  pinMode(ir_der, OUTPUT);
  pinMode(ir_izq, OUTPUT);
  pinMode(elec, OUTPUT);
  pinMode(subir, OUTPUT);
  pinMode(bajar, OUTPUT);
  pinMode(a, OUTPUT);
  pinMode(b, OUTPUT);
  pinMode(c, OUTPUT);
  pinMode(d, OUTPUT);
  pinMode(e, OUTPUT);
  pinMode(f, OUTPUT);
  pinMode(g, OUTPUT);

  Serial.begin(9600);
}


byte display [11] = {63, 6, 91, 79, 102, 109, 125, 7, 127, 103, 94};
int contador = 0 ;
//PORTL = display[0];

void loop()
{


  while (digitalRead(start) == 0) {
    if (digitalRead(cont) == 1) {
      Serial.println(contador);
      PORTL = display[contador];
      delay(20);
      while (digitalRead(cont) == 1) {
        delay(20);
        PORTL = display[contador];
      }
      if (contador > 8) {
        contador = 0;
      } else {
        contador = contador + 1;
      }
    }

  }


  while (digitalRead(punto1) == 0) {
    digitalWrite(ir_izq, 1);
    PORTL = display[1];
  }

  digitalWrite(ir_izq, 0);

  contador = contador - 1;

  while (contador > 0) {
    if (digitalRead(ubicacion) == 1) {
      while (digitalRead(sw_bajar) == 0) {
        digitalWrite(bajar, 1);
      }
      digitalWrite(bajar, 0);
      digitalWrite(elec, 1);
      while (digitalRead(sw_subir) == 0) {
        digitalWrite(subir, 1);
      }
      digitalWrite(subir, 0);

      while (digitalRead(punto2) == 0) {
        digitalWrite(ir_der, 1);
        PORTL = display[10];
      }
      digitalWrite(ir_der, 0);
      while (digitalRead(sw_bajar) == 0) {
        digitalWrite(bajar, 1);
      }
      digitalWrite(bajar, 0);
      digitalWrite(elec, 0);

      contador = contador - 1;
      PORTL = display[contador];

      while (digitalRead(sw_subir) == 0) {
        digitalWrite(subir, 1);
      }
      digitalWrite(subir, 0);

      while (digitalRead(punto1) == 0) {
        digitalWrite(ir_izq, 1);
        PORTL = display[1];
      }
      digitalWrite(ir_izq, 0);

    }

    if (digitalRead(ubicacion) == 0) {
      while (digitalRead(sw_bajar) == 0) {
        digitalWrite(bajar, 1);
      }
      digitalWrite(bajar, 0);
      digitalWrite(elec, 1);
      while (digitalRead(sw_subir) == 0) {
        digitalWrite(subir, 1);
      }
      digitalWrite(subir, 0);

      while (digitalRead(punto3) == 0) {
        digitalWrite(ir_der, 1);
        PORTL = display[10];
      }
      digitalWrite(ir_der, 0);
      while (digitalRead(sw_bajar) == 0) {
        digitalWrite(bajar, 1);
      }
      digitalWrite(bajar, 0);
      digitalWrite(elec, 0);

      contador = contador - 1;
      PORTL = display[contador];

      while (digitalRead(sw_subir) == 0) {
        digitalWrite(subir, 1);
      }
      digitalWrite(subir, 0);

      while (digitalRead(punto1) == 0) {
        digitalWrite(ir_izq, 1);
        PORTL = display[1];
      }
      digitalWrite(ir_izq, 0);

    }
  }
  while (true) {
    PORTL = display[0];
  }
}
