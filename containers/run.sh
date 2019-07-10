docker build -t syscam/bd ./postgres
docker run -p 5434:5432 --name syscam-bd -d syscam/bd 

#cd app && mvn clean package && cd ..
#docker build -t dionesgomes/app ./app
#docker run -p 8080:8080 --name app -d --link bd:host-banco getplace/app
#echo 'Finalizou!'
