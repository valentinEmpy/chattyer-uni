cp ../chattyer-web/target/*.jar chattyer/chattyer.jar
echo -e "${RED}Building docker images, running 'docker-compose build'${NOCOLOR}"
docker-compose build
if [ $# -eq 0 ]
then
  echo -e "${RED}Running docker-compose up, recreating only chattyer-web container, keeping database untouched${NOCOLOR}"
  docker-compose up -d --force-recreate --no-deps chattyer
else
  echo -e "${RED}Running docker-compose up, recreating everything${NOCOLOR}"
  docker-compose up -d --force-recreate
fi
echo -e "${RED}Real time logs from chattyer-web container:${NOCOLOR}"
docker logs -f chattyer-web