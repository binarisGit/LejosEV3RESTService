# Installation #

1. build project: maven->build->"clean install"
2. copy resulting .jar inside target folder to "~/lejos/lib" via scp (for windows users: https://winscp.net/eng/docs/lang:de)
3. login on EV3 via SSH (for windows users: http://www.putty.org/)
4. from putty-commandline start server on lejos: 
```
#!text

jrun -cp lejos-rest-api-1.0.jar de.binaris.lejos.application.Application
```


# Usage #

You can use the chrome extension "postman" for sending HTTP-Requests: https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop

example request: **10.0.0.44:8080/lejosdifferentpilotapi/beep**


**Hinweis:**

Das Projekt kann lokal als gewöhnliche **JavaApplication** gestartet werden (sinnvoll fürs debuggen). Der REST-Server ist dann über **http://localhost:8080/...** erreichbar.