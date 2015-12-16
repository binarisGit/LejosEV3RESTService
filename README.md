
# Installation #

1. build project: maven->build->"clean install"
2. copy resulting .jar inside target folder to "~/lejos/lib" via scp (for windows users: https://winscp.net/eng/docs/lang:de)
3. login on EV3 via SSH (for windows users: http://www.putty.org/)
4. from putty-commandline start server on lejos: jrun -cp lejos-rest-api-1.0.jar de.binaris.lejos.application.Application

# Usage #

You can use the chrome extension "postman" for sending HTTP-Requests: https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop


**Hinweis:**

Server kann lokal als gewöhnliche JavaApplication gestartet werden (sinnvoll fürs debuggen).