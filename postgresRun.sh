echo 'Iniciando container do banco syscam-bd'
docker build -t syscam/bd ./postgres
docker run -p 5434:5432 --name syscam-bd -d syscam/bd 


