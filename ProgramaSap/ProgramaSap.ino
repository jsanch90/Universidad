//INPUTS
#define LDAA 53
#define ADDA 52
#define SUBA 51
#define MULA 50
#define DIVA 49
#define GOTOA 48
#define GOTORA 47
#define OUTA 46
#define RETURNA 45
#define HLTA 44
//OUTPUTS
#define LMA 43
#define ERA 42
#define LIRA 41
#define EIRA 40
#define LRA 39
#define LBA 38
#define SUMAA 37
#define RESTAA 36
#define MULTA 35
#define DIVIA 34
#define EAA 33
#define LAA 32
#define PC1 31
#define PC2 30
#define PC3 29
#define PC4 28
#define EP 27
#define ALUTOBUSA 26

int pc = 0;

void setup() {
  //INPUTS
  pinMode(LDAA, INPUT);
  pinMode(ADDA, INPUT);
  pinMode(SUBA, INPUT);
  pinMode(MULA, INPUT);
  pinMode(DIVA, INPUT);
  pinMode(GOTOA, INPUT);
  pinMode(GOTORA, INPUT);
  pinMode(OUTA, INPUT);
  pinMode(RETURNA, INPUT);
  pinMode(HLTA, INPUT);
  //OUTPUTS
  pinMode(LMA, OUTPUT);
  pinMode(ERA, OUTPUT);
  pinMode(LIRA, OUTPUT);
  pinMode(EIRA, OUTPUT);
  pinMode(LRA, OUTPUT);
  pinMode(LBA, OUTPUT);
  pinMode(SUMAA, OUTPUT);
  pinMode(RESTAA, OUTPUT);
  pinMode(MULA, OUTPUT);
  pinMode(DIVA, OUTPUT);
  pinMode(EAA, OUTPUT);
  pinMode(LAA, OUTPUT);
  pinMode(PC1, OUTPUT);
  pinMode(PC2, OUTPUT);
  pinMode(PC3, OUTPUT);
  pinMode(PC4, OUTPUT);
  pinMode(EP, OUTPUT);
  pinMode(ALUTOBUSA, OUTPUT);
}

void loop() {
  if ((pc & 0b00000001) > 0) {
    digitalWrite(PC1, 1);
  }

  if ((pc & 0b00000010) > 0) {
    digitalWrite(PC2, 1);
  }

  if ((pc & 0b00000011) > 0) {
    digitalWrite(PC3, 1);
  }

  if ((pc & 0b00001000) > 0) {
    digitalWrite(PC4, 1);
  }

  //Cargar el contador(PC) en el bus
  digitalWrite(EP, 1);

  //Tomar una posicion de la memoria
  digitalWrite(LMA, 1);   //  LMA -> LOAD MAR
  digitalWrite(LMA, 0);
  digitalWrite(EP, 0);    //EP -> Enable To BUS (Program Counter)
  digitalWrite(ERA, 1);   //ERA -> Enable PROM
  digitalWrite(LIRA, 1);   //LIRA -> Load Instruction register
  digitalWrite(LIRA, 0);
  digitalWrite(ERA, 0); 
  digitalWrite(EIRA, 1); // Enable Instruction Register
  digitalWrite(LMA, 1);  //Load Mar
  digitalWrite(LMA, 0);
  digitalWrite(EIRA, 0); 



  if (digitalRead(LDAA) == 1) {
    digitalWrite(ERA, 1); // Enable PROM
    digitalWrite(LAA, 1); // Load Acumulator
    digitalWrite(LAA, 0);  
    digitalWrite(ERA, 0);

  }

  if (digitalRead(ADDA) == 1) {
    operaciones();
    digitalWrite(SUMAA, 1);
    digitalWrite(SUMAA, 0);
    operaciones2();
    pc = pc + 1;
  }

  if(digitalRead(SUBA)==1){
    operaciones();
    digitalWrite(RESTAA,1);
    digitalWrite(RESTAA,0);
    operaciones2();
    pc = pc + 1;
  }

  if(digitalRead(MULA)==1){
    operaciones();
    digitalWrite(MULTA,1);
    digitalWrite(MULTA,0);
    operaciones2();
    pc = pc + 1;
  }


  if(digitalRead(DIVA)==1){
    operaciones();
    digitalWrite(DIVIA,1);
    digitalWrite(DIVIA,0);
    operaciones2();
    pc = pc + 1;  
  }

  if(digitalRead(OUTA)==1){
      digitalWrite(EAA,1);//enable acumulator A
      digitalWrite(LRA,1);//load output register
      digitalWrite(LRA,0);
      digitalWrite(EAA,0);
      pc = pc + 1;
      
    }


}

void operaciones() {
  digitalWrite(ERA, 1); // Enable prom
  digitalWrite(LBA, 1); // Load Register  B
  digitalWrite(ERA, 0); 
  digitalWrite(LBA, 0);
}

void operaciones2() {
  digitalWrite(ALUTOBUSA, 1); // Enable ALU
  digitalWrite(LAA, 1); // Load acumulator
  digitalWrite(LAA, 0); // Load acumulator
  digitalWrite(ALUTOBUSA, 0); // Enable ALU
}


