#include <Ethernet.h>
#include <SPI.h>
#include <UbidotsEthernet.h>
#define ID "5931efa77625421365a5df5c"  // Put here your Ubidots variable ID
#define TOKEN "8wG4vlvZPE9HYcKIOBnr769vCCA38G"  // Put here your Ubidots TOKEN
//dfdhdhkhgfdgsfhgfhdgsffhkfhdgfdhgkgjgfdgfhgjkghdfgfkgjhkgjfgjkhgjghgfhgfhdgf
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
//dfhgjfhgdhgjfhdhggdhgfhgghdgjjghfjghjgfhjfghjfg
// Enter a MAC address for your controller below.
// Newer Ethernet shields have a MAC address printed on a sticker on the shield
byte mac[] = { 0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };
// Set the static IP address to use if the DHCP fails to assign
IPAddress ip(192, 168, 0, 177);

Ubidots client(TOKEN);

void setup(){
    Serial.begin(9600);
    // start the Ethernet connection:
    if (Ethernet.begin(mac) == 0) {
      Serial.println("Failed to configure Ethernet using DHCP");
      // try to congifure using IP address instead of DHCP:
      Ethernet.begin(mac, ip);
//edsgfhdfsdafghfhfsdSFGFHGFHDSFDSGHGFJGHDSFDGFHJGFHDGFHGDGSFDSFGDSasfdgfhgjh
      Serial.begin(9600);
 Serial3.begin(9600);
  xbee.setSerial(Serial3);
    }
    // give the Ethernet shield a second to initialize:
    delay(1000);
}
void loop(){
    uint8_t value = nombre();
    client.add(ID, value);
    client.sendAll();
}




uint8_t nombre() 
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
        Serial.println(rssi);
      } 
      else 
      {
        xbee.getResponse().getRx64Response(rx64);
        //option = rx64.getOption();
        //data = rx64.getData(0);
        rssi = rx64.getRssi();
        Serial.println(rssi);
        return rssi;
      }
    }
  }
}
