instructions on how to build, run the container

Building the Docker Image  
After opening the project, run on terminal  
  <b>docker build -t restapi-server .</b>  

Running the Docker container to map port 8080 on your local machine to port 8080 in the container:   
  <b>docker run -d -p 8080:8080 --name restapi-server restapi-server</b>  
Name the cotainer <b>restapi-server</b>    

Testing the API  
on local machine:  
  http://localhost:8080/coinList?targetAmt=8  
Using public IP:   
  http://134.185.85.152:8080/coinList?targetAmt=100.32  

To stop the container:  
  <b>docker stop restapi-server</b>  

To remove the container:  
  <b>docker rm restapi-server</b>    
