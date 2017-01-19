# IOT
Vedio:
https://drive.google.com/file/d/0ByIh3eDGAiAmR0FUZ3FDLUswWWs/view?usp=sharing

Project:
1. LED control with Arduino from Andriod app via cloud.
2. Arduino Intel curie reads data from weight sensor sends cloud using wifi module. Mobile app for user to view the data.

Requirements and Prerequisites:
•	An android mobile
•	Arduino IDE installed in a computer with required libraries
•	Access to IBM Bluemix online portal which is accessed through link (https://console.ng.bluemix.net/dashboard/apps/)
•	Connected Arduino circuit
•	ESP8266 uploaded with publish_to_cloud.ino file
•	Arduino uploaded with weighing.ino file
System Setup:
•	Install the apk for controlling LED and to display the data of weight from cloud on the mobile.
•	Start the cloud services and application on the clod dashboard
•	Provide power supply to Arduino using USB or power supply port
•	Using the Arduino IDE edit the variables SSID and Password to reachable wifi SSIB and password in publish_to_cloud.ino. Compile and upload this code to ESP8266 wifi module
Execution:
•	Apply load on load sensor. The load will be reflected on IBM Bluemix dashboard. This can also be seen on mobile app
•	To control the LED open the app. There would be a button in the app to control the LED. When the button is clicked the LED switches on and the text on button changes to off. When the button (which is then an off button) is pressed the LED switches off
