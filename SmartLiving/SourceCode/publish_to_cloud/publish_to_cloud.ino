#include <ESP8266WiFi.h>
#include <PubSubClient.h> // https://github.com/knolleary/pubsubclient/releases/tag/v2.3


const char* ssid = "Aliens";
const char* password = "idontremember";

#define ORG "0cwgsy"
#define DEVICE_TYPE "esp8266"
#define DEVICE_ID "5CCF7F2D61E9"
#define TOKEN "qE!i+z&&foIwo1kmLh"

char server[] = ORG ".messaging.internetofthings.ibmcloud.com";
char topic[] = "iot-2/evt/status/fmt/json";
char ledTopic[] = "iot-2/cmd/test/fmt/String";
char authMethod[] = "use-token-auth";
char token[] = TOKEN;
char clientId[] = "d:" ORG ":" DEVICE_TYPE ":" DEVICE_ID;

String ip = "";
int ledPin = 13;
void callback(char* topic, byte* payload, unsigned int length);
WiFiClient wifiClient;
PubSubClient client(server, 1883, callback, wifiClient);


void setup() {
// Serial.begin(115200);
Serial1.begin(9600);
Serial.begin(9600);
 Serial.println();
 
  pinMode(ledPin, OUTPUT);
  digitalWrite(ledPin, LOW);
 Serial.print("Connecting to "); Serial.print(ssid);
 WiFi.begin(ssid, password);
 while (WiFi.status() != WL_CONNECTED) {
 delay(500);
 Serial.print(".");
 } 
 Serial.println("");

 Serial.print("WiFi connected, IP address: "); 
 Serial.println(WiFi.localIP());
 IPAddress ipAddress = WiFi.localIP();

  ip = String(ipAddress[0]) + String(".") +\
  String(ipAddress[1]) + String(".") +\
  String(ipAddress[2]) + String(".") +\
  String(ipAddress[3])  ; 
  Serial.println(ip);
  
}

int counter = 0;

void loop() {
  
  double dato2 = Serial1.read();
  double data0 = Serial.read(); 

  
double value = data0;
 
  if (dato2 > 10){
    value = dato2;
  }
  if (data0 >10){
    value = data0;
}
  
 if (!client.connected()) {
 Serial.print("Reconnecting client to ");
 Serial.println(server);
 while (!client.connect(clientId, authMethod, token)) {
 Serial.print(".");
 delay(500);
 }
 initManagedDevice();
 Serial.println();
 }

 String payload = "{\"d\":{\"Name\":\"18FE34D81E46\"";
 payload += ",\"weight\":";
 payload += value;
 payload += "}}";
 
 Serial.print("Sending payload: ");
 Serial.println(payload);
 
 
 if (value >10){ 
  Serial.print(value, 1);
  Serial.println(" g");
  //String payload = (String)value;
 if (client.publish(topic, (char*) payload.c_str())) {
 Serial.println("Publish ok");
 } else {
 Serial.println("Publish failed");
 }
}
 delay(5000);
}

void initManagedDevice() {
  if (client.subscribe("iot-2/cmd/test/fmt/String")) {
    Serial.println("subscribe to cmd OK");
  } else {
    Serial.println("subscribe to cmd FAILED");
  }
}
void callback(char* topic, byte* payload, unsigned int payloadLength) {
  if (strcmp (ledTopic, topic) == 0) {   
  Serial.print("callback invoked for topic: "); Serial.println(topic);
  Serial.println(payloadLength);
  for (int i = 0; i < payloadLength; i++) {
    Serial.print((char)payload[i]);
  }
  if((char)payload[0]== '0'){
    digitalWrite(ledPin, LOW );
  }
  else if((char)payload[0]== '1'){
    digitalWrite(ledPin, HIGH);
  }
  }
}
