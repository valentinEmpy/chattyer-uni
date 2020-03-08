export NOCOLOR='\033[0m'
export RED='\033[0;31m'

# Build
echo -e "${RED}Building maven project by running!${NOCOLOR}"
mvn clean install
if [[ "$?" -ne 0 ]] ; then
  exit
fi

#Dockerize
cd docker || exit
echo -e "${RED}Dockerizing the built project!${NOCOLOR}"
./start.sh "$@"