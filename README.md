# Installation #

1.  download [lejos.zip](https://bitbucket.org/Cappin79/lejosev3restservice/downloads/lejos.zip) and move the contained unzipped directory to your local maven repository (e.g. C:\Users\Christian.Asus-F550LC\\.m2\repository\lejos). Do not forget to update your maven afterwards!
2.  build project: maven->build->"clean install"
3.  copy resulting .jar inside target folder to "~/lejos/lib" via scp (for windows users: https://winscp.net/eng/docs/lang:de)
4.  login on EV3 via SSH (for windows users: http://www.putty.org/)
5.  from putty-commandline start server on lejos: 
```
#!text

jrun -cp lejos-rest-api-1.0.jar de.binaris.lejos.application.Application
```

**Achtung: ev3classes.jar muss ebenfalls im lib-Ordner liegen und der CLASS-PATH in der Pom korrekt angepasst werden!**


# Usage #

You can use the chrome extension "postman" for sending HTTP-Requests: https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop

example request: **10.0.0.44:8080/lejosdifferentpilotapi/beep**


**Hinweis:**

Das Projekt kann lokal als gewöhnliche **JavaApplication** gestartet werden (sinnvoll fürs debuggen). Der REST-Server ist dann über **http://localhost:8080/...** erreichbar.