
#include <hx711.h>
Hx711 scale(A0, A1);

void setup() {
  Serial.begin(9600);
  Serial1.begin(9600);
}

void loop() {
  double value = scale.getGram();
  if (value >10){ 
  Serial.print(value, 1);
  Serial.println(" g");
  }
  Serial1.write(value);
  delay(200);
}




