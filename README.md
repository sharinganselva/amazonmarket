# amazonmarket

Disclaimer: 
===========
This is my first time coding in JAVA since my school. So, I had to spend a little bit more time understanding the language and the technologies that come with it such as JDK, Maven, etc. 

This is also another reason I chose not to use the vanilla repo which now, I believe would have been the better thing to do. But, with absolutely no knowledge on Java, I felt starting from clean repo would make it easier for the purpose of solving the given problem. 

My main focus was to create proper structure around the page objects and knocking down the tasks and prove that I can be hands-on. But, I did want to timebox my effort on this to get this done over the weekend. What I realize is that, I could make this framework much more better. I am still quite happy with what I have got so far over this weekend. 

Also, please watch the two videos that I have sent where I was successfully able to run locally in Chrome browser, as well as against the docker container. 

How to Run Locally with Chrome Driver: 
=======================================
0. Install latest JDK and Install Eclipse IDE
2. Clone this repo to your local desktop
3. Open the project in Eclipse IDE
4. Open TestNG.xml file
5. Right Click >> Run As >> TestNG Suite



How to Run against Docker Container using remote webdriver:
============================================================
0. Install Docker
1. Open this file in Eclipse IDE: https://github.com/sharinganselva/amazonmarket/blob/master/amazonMarketV1/src/test/java/com/amazonMarket/testCases/BaseClass.java
2. Enable Remote WebDriver  
  3. Uncomment Ln27 and Ln28
  4. Comment Ln31 and Ln32
5. Start a docker container to run the test against using the following command:
  6. Open Terminal and run: "docker run -d -p 4444:4444 --shm-size="2g" selenium/standalone-chrome:4.1.4-20220427"
7. Open TestNG.xml file in Eclipse IDE
8. Right Click >> Run As >> TestNG Suite 


Where are the main SRC files located: 
======================================
1. PageObjects: https://github.com/sharinganselva/amazonmarket/tree/master/amazonMarketV1/src/test/java/com/amazonMarket/pageObjects
2. Test Cases: https://github.com/sharinganselva/amazonmarket/tree/master/amazonMarketV1/src/test/java/com/amazonMarket/testCases
3. Log4j2.xml: https://github.com/sharinganselva/amazonmarket/tree/master/amazonMarketV1/Resources
4. Pom.xml: https://github.com/sharinganselva/amazonmarket/blob/master/amazonMarketV1/pom.xml
5. TestNG.xml: https://github.com/sharinganselva/amazonmarket/blob/master/amazonMarketV1/TestNG.xml
6. ChromeDriver: https://github.com/sharinganselva/amazonmarket/tree/master/amazonMarketV1/Drivers
7. Dockerfile: https://github.com/sharinganselva/amazonmarket/blob/master/amazonMarketV1/Dockerfile
