
1. java -jar selenium-server-standalone-3.141.59.jar -role hub


2. java -Dwebdriver.chrome.driver="D:\SeleniumProject\src\main\resources\chromedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -port 7766 -hub http://192.168.43.73:4444/grid/register


replace http://192.168.43.73 in second command and MyTest1.java

