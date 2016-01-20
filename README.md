![binarisInformatikHeadBanner.PNG](https://bitbucket.org/repo/96p5ar/images/3651728320-binarisInformatikHeadBanner.PNG)
# Description #

This project contains a RESTful Webservice for the lejOS EV3 LEGO MINDSTORMS brick based on an embedded jetty server and JAX-RS. It uses the [lejOS EV3 API](http://www.lejos.org/ev3/docs/) to let robots run, rotate, scan colors and make noises.


# Installation #

1.  download [lejos.zip](https://bitbucket.org/Cappin79/lejosev3restservice/downloads/lejos.zip) and move the contained unzipped directory to your local maven repository (e.g. C:\Users\<USER>\.m2\repository\lejos). **If a folder named "lejos" already exists, replace it.** Do not forget to update your maven afterwards!
2.  build project: maven->build->"clean install"
3.  copy resulting .jar inside target folder to "~/lejos/lib" via scp (for windows users: https://winscp.net/eng/docs/lang:de)
4.  login on EV3 via SSH (for windows users: http://www.putty.org/)
5.  change to lib directory and start server on lejos: 


```
#!text

cd ~/lejos/lib
```


```
#!text

jrun -cp lejos-rest-api-1.0.jar de.binaris.lejos.application.Applicati
```


*Attention*: **ev3classes.jar** must reside inside the folder and the class-path inside the pom.xml must be configured correctly!

# Usage #

You can use the chrome extension "postman" for sending HTTP-Requests: https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop

example URLs: 

```
#!text

<replace_with_your_IP>:8080/sound/beep
```


```
#!text

<replace_with_your_IP>:8080/differentialpilot/run/5
```


```
#!text

<replace_with_your_IP>:8080/color/getcolor
```