//Se importan las bibliotecas requeridas para establecer la comunicacion entre los modulos Xbee, enviar los datos de señal
//a la plataforma Ubidots y configurar el modulo Ethernet Shield para permitir conectar el arduino a internet y poder enviar 
//los datos de señal rssi registrados por el arduino. 
#include <Ethernet.h>
#include <SPI.h>
#include <XBee.h>
#include <SoftwareSerial.h>
#include <UbidotsEthernet.h>

//Se definen los pines de los leds que nos mostraran la intensidad de la señal rssi, cuantos mas leds hayan encendidos mejor es la señal. 
#define led1 22
#define led2 23
#define led3 24
#define led4 25
#define led5 26
#define led6 27
#define led7 28
#define led8 29
#define led9 30
#define led10 31
#define led11 32
#define led12 33
#define led13 34
#define led14 35
#define led15 36
#define led16 37
//Se define el id de la variable que tomara los valores de la señal rssi en ubidots.
#define ID "5931efa77625421365a5df5c"
//Se define el id del token de ubidots.
#define TOKEN "8wG4vlvZPE9HYcKIOBnr769vCCA38G"

//Se crea una conexion de un modulo Xbee con el arduino por medio de un puerto serial.
SoftwareSerial serial1(15, 14); // RX, TX
//Se crera una instancia de la clase XBee que viene incluida en la biblioteca "XBee.h"
XBee xbee=XBee();
//Se crera una instancia de la clase XBeeResponse que viene incluida en la biblioteca "XBee.h"
XBeeResponse response = XBeeResponse();
//Se crera una instancia de la clase Rx16Response que viene incluida en la biblioteca "XBee.h"
Rx16Response rx16 = Rx16Response();
//Se crera una instancia de la clase Rx64Response que viene incluida en la biblioteca "XBee.h"
Rx64Response rx64 = Rx64Response();


//Se define una variable de tipo uint8_t que guardara el valor de la señal rssi.
uint8_t rssi = 0;

//se define la direccion mac del Ethernet Shield necesaria  para establcer la conexion con ubidots.
byte mac[] = { 0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };
//se define la direccion ip del Ethernet Shield necesaria  para establcer la conexion con ubidots.
IPAddress ip(192, 168, 0, 177);

//Se crera una instancia de la clase Ubidots que viene incluida en la biblioteca "UbidotsEthernet.h" y se le pasa como
//parametro la variable token que se habia definido previamente
Ubidots client(TOKEN);

void setup(){
    //Se inicia el puerto serial principal a 9600 baudios.
    Serial.begin(9600);    
    //Se inicia el puerto serial 3 a 9600 baudios.
    Serial3.begin(9600);
    //Se asigna el puerto serial 3 al objeto de tipo Xbee para que en este puerto se muestre la actividad entre ambos Xbee.
    xbee.setSerial(Serial3);
    //Se estable la conexion a internet del arduino.
    if(Ethernet.begin(mac) == 0) {
        Serial.println("Failed to configure Ethernet using DHCP");
        Ethernet.begin(mac, ip);
    }
    delay(1000);
    //Se Establecen todos los pines de los leds como salida.
    pinMode(led1,OUTPUT);
    pinMode(led2, OUTPUT);
    pinMode(led3, OUTPUT);
    pinMode(led4, OUTPUT);
    pinMode(led5, OUTPUT);
    pinMode(led6, OUTPUT);
    pinMode(led7, OUTPUT);
    pinMode(led8, OUTPUT);
    pinMode(led9, OUTPUT);
    pinMode(led10, OUTPUT);
    pinMode(led11, OUTPUT);
    pinMode(led12, OUTPUT);
    pinMode(led13, OUTPUT);
    pinMode(led14, OUTPUT);
    pinMode(led15, OUTPUT);
    pinMode(led16, OUTPUT);
  }
  


void loop(){
 //El Xbee inicia a recibir y leer paquetes.
 xbee.readPacket(100);
 //Se verifica si el Xbee esta recibiendo paquetes.
 if (xbee.getResponse().isAvailable()){
    if(xbee.getResponse().getApiId() == RX_64_RESPONSE || xbee.getResponse().getApiId() == RX_16_RESPONSE){
      //Se verifica si la conexion entre los Xbee es de tipo rx16. 
      if (xbee.getResponse().getApiId() == RX_16_RESPONSE) {
          xbee.getResponse().getRx16Response(rx16);
          //Si la verificacion de conexion es exitosa se guarda el valor de la señal rssi en la variable "rssi"
          rssi = rx16.getRssi();
          //se imprime en el serial el valor de la señal rssi guardado en la variable.
          Serial.println("-------------------");
          Serial.println(rssi);
          Serial.println("-------------------");
        //Se encienden los leds dependiendo de la intensidad de la señal rssi.
        if(rssi >= 23 && rssi <=26){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 1);
                  digitalWrite(led8, 1);
                  digitalWrite(led9, 1);
                  digitalWrite(led10, 1);
                  digitalWrite(led11, 1);
                  digitalWrite(led12, 1);
                  digitalWrite(led13, 1);
                  digitalWrite(led14, 1);
                  digitalWrite(led15, 1);
                  digitalWrite(led16, 1);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=26 && rssi < 29){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 1);
                  digitalWrite(led8, 1);
                  digitalWrite(led9, 1);
                  digitalWrite(led10, 1);
                  digitalWrite(led11, 1);
                  digitalWrite(led12, 1);
                  digitalWrite(led13, 1);
                  digitalWrite(led14, 1);
                  digitalWrite(led15, 1);
                  digitalWrite(led16, 0);  
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=29 && rssi < 32){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 1);
                  digitalWrite(led8, 1);
                  digitalWrite(led9, 1);
                  digitalWrite(led10, 1);
                  digitalWrite(led11, 1);
                  digitalWrite(led12, 1);
                  digitalWrite(led13, 1);
                  digitalWrite(led14, 1);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=32 && rssi < 35){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 1);
                  digitalWrite(led8, 1);
                  digitalWrite(led9, 1);
                  digitalWrite(led10, 1);
                  digitalWrite(led11, 1);
                  digitalWrite(led12, 1);
                  digitalWrite(led13, 1);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=35 && rssi < 38){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 1);
                  digitalWrite(led8, 1);
                  digitalWrite(led9, 1);
                  digitalWrite(led10, 1);
                  digitalWrite(led11, 1);
                  digitalWrite(led12, 1);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=38 && rssi < 41){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 1);
                  digitalWrite(led8, 1);
                  digitalWrite(led9, 1);
                  digitalWrite(led10, 1);
                  digitalWrite(led11, 1);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=41 && rssi < 44){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 1);
                  digitalWrite(led8, 1);
                  digitalWrite(led9, 1);
                  digitalWrite(led10, 1);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=44 && rssi < 47){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 1);
                  digitalWrite(led8, 1);
                  digitalWrite(led9, 1);
                  digitalWrite(led10, 0);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=47 && rssi < 50){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 1);
                  digitalWrite(led8, 1);
                  digitalWrite(led9, 0);
                  digitalWrite(led10, 0);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=50 && rssi < 53){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 1);
                  digitalWrite(led8, 0);
                  digitalWrite(led9, 0);
                  digitalWrite(led10, 0);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=53 && rssi < 56){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 0);
                  digitalWrite(led8, 0);
                  digitalWrite(led9, 0);
                  digitalWrite(led10, 0);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=56 && rssi < 59){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 0);
                  digitalWrite(led7, 0);
                  digitalWrite(led8, 0);
                  digitalWrite(led9, 0);
                  digitalWrite(led10, 0);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=59 && rssi < 62){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 0);
                  digitalWrite(led6, 0);
                  digitalWrite(led7, 0);
                  digitalWrite(led8, 0);
                  digitalWrite(led9, 0);
                  digitalWrite(led10, 0);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=62 && rssi < 65){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 0);
                  digitalWrite(led5, 0);
                  digitalWrite(led6, 0);
                  digitalWrite(led7, 0);
                  digitalWrite(led8, 0);
                  digitalWrite(led9, 0);
                  digitalWrite(led10, 0);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=65 && rssi < 68){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 0);
                  digitalWrite(led4, 0);
                  digitalWrite(led5, 0);
                  digitalWrite(led6, 0);
                  digitalWrite(led7, 0);
                  digitalWrite(led8, 0);
                  digitalWrite(led9, 0);
                  digitalWrite(led10, 0);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=68 && rssi < 71){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 0);
                  digitalWrite(led3, 0);
                  digitalWrite(led4, 0);
                  digitalWrite(led5, 0);
                  digitalWrite(led6, 0);
                  digitalWrite(led7, 0);
                  digitalWrite(led8, 0);
                  digitalWrite(led9, 0);
                  digitalWrite(led10, 0);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=71 && rssi < 1000){
                  digitalWrite(led1, 0);
                  digitalWrite(led2, 0);
                  digitalWrite(led3, 0);
                  digitalWrite(led4, 0);
                  digitalWrite(led5, 0);
                  digitalWrite(led6, 0);
                  digitalWrite(led7, 0);
                  digitalWrite(led8, 0);
                  digitalWrite(led9, 0);
                  digitalWrite(led10, 0);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
                }
      //Se añade el ID de la variable y el valor de la señal rssi al cliente de ubidots.
      client.add(ID,rssi);
      //Se envian todos los datos a la plataforma de ubidots.
      client.sendAll();
      } 
      else 
      {
        //se verifica si la conexion entre los Xbee es de tipo rx64. 
        xbee.getResponse().getRx64Response(rx64);
        //Si la verificacion de conexion es exitosa se guarda el valor de la señal rssi en la variable "rssi".
        rssi = rx64.getRssi();
        //se imprime en el serial el valor de la señal rssi guardado en la variable.
        Serial.println("-------------------");
        Serial.println(rssi);
        Serial.println("-------------------");
        //Se encienden los leds dependiendo de la intensidad de la señal rssi.
        if(rssi >= 23 && rssi <=26){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 1);
                  digitalWrite(led8, 1);
                  digitalWrite(led9, 1);
                  digitalWrite(led10, 1);
                  digitalWrite(led11, 1);
                  digitalWrite(led12, 1);
                  digitalWrite(led13, 1);
                  digitalWrite(led14, 1);
                  digitalWrite(led15, 1);
                  digitalWrite(led16, 1);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=26 && rssi < 29){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 1);
                  digitalWrite(led8, 1);
                  digitalWrite(led9, 1);
                  digitalWrite(led10, 1);
                  digitalWrite(led11, 1);
                  digitalWrite(led12, 1);
                  digitalWrite(led13, 1);
                  digitalWrite(led14, 1);
                  digitalWrite(led15, 1);
                  digitalWrite(led16, 0);  
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=29 && rssi < 32){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 1);
                  digitalWrite(led8, 1);
                  digitalWrite(led9, 1);
                  digitalWrite(led10, 1);
                  digitalWrite(led11, 1);
                  digitalWrite(led12, 1);
                  digitalWrite(led13, 1);
                  digitalWrite(led14, 1);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=32 && rssi < 35){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 1);
                  digitalWrite(led8, 1);
                  digitalWrite(led9, 1);
                  digitalWrite(led10, 1);
                  digitalWrite(led11, 1);
                  digitalWrite(led12, 1);
                  digitalWrite(led13, 1);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=35 && rssi < 38){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 1);
                  digitalWrite(led8, 1);
                  digitalWrite(led9, 1);
                  digitalWrite(led10, 1);
                  digitalWrite(led11, 1);
                  digitalWrite(led12, 1);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=38 && rssi < 41){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 1);
                  digitalWrite(led8, 1);
                  digitalWrite(led9, 1);
                  digitalWrite(led10, 1);
                  digitalWrite(led11, 1);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=41 && rssi < 44){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 1);
                  digitalWrite(led8, 1);
                  digitalWrite(led9, 1);
                  digitalWrite(led10, 1);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=44 && rssi < 47){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 1);
                  digitalWrite(led8, 1);
                  digitalWrite(led9, 1);
                  digitalWrite(led10, 0);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=47 && rssi < 50){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 1);
                  digitalWrite(led8, 1);
                  digitalWrite(led9, 0);
                  digitalWrite(led10, 0);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=50 && rssi < 53){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 1);
                  digitalWrite(led8, 0);
                  digitalWrite(led9, 0);
                  digitalWrite(led10, 0);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=53 && rssi < 56){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 1);
                  digitalWrite(led7, 0);
                  digitalWrite(led8, 0);
                  digitalWrite(led9, 0);
                  digitalWrite(led10, 0);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=56 && rssi < 59){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 1);
                  digitalWrite(led6, 0);
                  digitalWrite(led7, 0);
                  digitalWrite(led8, 0);
                  digitalWrite(led9, 0);
                  digitalWrite(led10, 0);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=59 && rssi < 62){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 1);
                  digitalWrite(led5, 0);
                  digitalWrite(led6, 0);
                  digitalWrite(led7, 0);
                  digitalWrite(led8, 0);
                  digitalWrite(led9, 0);
                  digitalWrite(led10, 0);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=62 && rssi < 65){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 1);
                  digitalWrite(led4, 0);
                  digitalWrite(led5, 0);
                  digitalWrite(led6, 0);
                  digitalWrite(led7, 0);
                  digitalWrite(led8, 0);
                  digitalWrite(led9, 0);
                  digitalWrite(led10, 0);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=65 && rssi < 68){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 1);
                  digitalWrite(led3, 0);
                  digitalWrite(led4, 0);
                  digitalWrite(led5, 0);
                  digitalWrite(led6, 0);
                  digitalWrite(led7, 0);
                  digitalWrite(led8, 0);
                  digitalWrite(led9, 0);
                  digitalWrite(led10, 0);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=68 && rssi < 71){
                  digitalWrite(led1, 1);
                  digitalWrite(led2, 0);
                  digitalWrite(led3, 0);
                  digitalWrite(led4, 0);
                  digitalWrite(led5, 0);
                  digitalWrite(led6, 0);
                  digitalWrite(led7, 0);
                  digitalWrite(led8, 0);
                  digitalWrite(led9, 0);
                  digitalWrite(led10, 0);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
          //Se encienden los leds dependiendo de la intensidad de la señal rssi.
          }else if(rssi >=71 && rssi < 1000){
                  digitalWrite(led1, 0);
                  digitalWrite(led2, 0);
                  digitalWrite(led3, 0);
                  digitalWrite(led4, 0);
                  digitalWrite(led5, 0);
                  digitalWrite(led6, 0);
                  digitalWrite(led7, 0);
                  digitalWrite(led8, 0);
                  digitalWrite(led9, 0);
                  digitalWrite(led10, 0);
                  digitalWrite(led11, 0);
                  digitalWrite(led12, 0);
                  digitalWrite(led13, 0);
                  digitalWrite(led14, 0);
                  digitalWrite(led15, 0);
                  digitalWrite(led16, 0);
                }
        //Se añade el ID de la variable y el valor de la señal rssi al cliente de ubidots.
        client.add(ID,rssi);
        //Se envian todos los datos a la plataforma de ubidots.
        client.sendAll();

      }
    }
  }
}





