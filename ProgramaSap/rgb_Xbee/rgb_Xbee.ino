
int h;

#define b 6
#define g 7
#define r 8


void setup()
{
  Serial1.begin(9600);
  Serial.begin(9600);
  pinMode(b, OUTPUT);
  pinMode(g, OUTPUT);
  pinMode(r, OUTPUT);
}

void loop()

{
  while (Serial1.available() == 0)
  {
  }
  h = Serial1.read();
  delay(5);
  Serial.println(h);
    if(h==2){
      analogWrite(r, 255);
      analogWrite(g, 0);
      analogWrite(b, 0);
    }
    if(h==3){
      analogWrite(g, 255);
      analogWrite(r, 0);
      analogWrite(b, 0);
    }
    if(h==4){
      analogWrite(b, 255);
      analogWrite(g, 0);
      analogWrite(r, 0);
    }
  }




