echo 'parando e removendo container banco do syscam-bd'
docker stop syscam-bd
docker rm syscam-bd
docker rmi -f syscam-bd
echo 'parando e removendo container do spring'
docker stop syscam
docker rm -f syscam 
docker rmi -f syscam/app 

