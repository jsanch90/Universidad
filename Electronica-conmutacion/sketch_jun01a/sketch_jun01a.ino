#include <XBee.h>
#include <SoftwareSerial.h>
// XBee's DOUT (TX) is connected to pin 8 (Arduino's Software RX)
// XBee's DIN (RX) is connected to pin 9 (Arduino's Software TX)
SoftwareSerial serial1(15, 14); // RX, TX

XBee xbee=XBee();
XBeeResponse response = XBeeResponse();
Rx16Response rx16 = Rx16Response();
Rx64Response rx64 = Rx64Response();

uint8_t option = 0;
uint8_t data = 0;
uint8_t rssi = 0;

void setup() 
{
  Serial.begin(9600);
 Serial3.begin(9600);
  xbee.setSerial(Serial3);
}

void loop() 
{
  xbee.readPacket(100);
  if (xbee.getResponse().isAvailable())
  {
    
    if(xbee.getResponse().getApiId() == RX_64_RESPONSE || xbee.getResponse().getApiId() == RX_16_RESPONSE)
    { 
      
      if (xbee.getResponse().getApiId() == RX_16_RESPONSE) 
      {
        xbee.getResponse().getRx16Response(rx16);
        //option = rx16.getOption();
        //data = rx16.getData(0);
        rssi = rx16.getRssi();
        //Serial.print("data: ");Serial.println(data);
        //Serial.print("option: ");Serial.println(option);
        Serial.println(rssi-23);
      } 
      else 
      {
        Serial.println("64");
        xbee.getResponse().getRx64Response(rx64);
        //option = rx64.getOption();
        //data = rx64.getData(0);
        rssi = rx64.getRssi();
        Serial.println(rssi);
      }
    }
  }
}
