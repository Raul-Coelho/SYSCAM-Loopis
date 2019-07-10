# Parando o container com o nome 'Agenda'
docker stop syscam-bd
# revemor o container com o nome 'Agenda'
docker rm syscam-bd
#removendo as images
docker rmi -f syscam-bd

docker stop bd
docker rm bd
docker rmi -f getplace/bd
