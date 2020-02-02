# SeleniumFramework

This Framework will include all modern techniques 



**Browser Supported**

```sh
Chrome, Firefox, PhantomJS

```

### Command line execution

```sh
mvn test -Dmodule={test name} -Dbrowser={browser name}

Example: 
mvn test -Dmodules="main.xml" -Dbrowser=chrome 
```

**To run it on docker/Zelenium , follow below steps**

```sh
1) If Zelenium images not downloaded earliar then start download using below commands
 
docker pull elgalu/selenium  
docker pull dosel/zalenium

docker run --rm -ti --name zalenium -p 4444:4444 ^
  -v /var/run/docker.sock:/var/run/docker.sock ^
  -v /c/Users/your_user_name/temp/videos:/home/seluser/videos ^
  --privileged dosel/zalenium start 
  
2) Once Containers are up and running use mvn test -Dmodules="main.xml" -Dbrowser=remote 

```
