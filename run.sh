echo 'Iniciando container do banco syscam-bd'
docker build -t syscam/bd ./postgres
docker run -p 5434:5432 --name syscam-bd -d syscam/bd 

echo 'Iniciando container do spring'
mvn clean package -DskipTests=true
mvn install -DskipTests=true
docker build -t syscam/app .
docker run -p 8090:8090 --name syscam -d --link syscam-bd syscam/app
echo 'Containers iniciados!'

