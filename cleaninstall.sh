#!/bin/bash

# building gateway

cd APIGateway
mvn clean install -q
cd ..

echo -e "\033[0;36m==========================================================================\033[0m"

# building logic buisness
cd BuisnessLogic
mvn clean install -q
cd ..

echo -e "\033[0;36m==========================================================================\033[0m"

# cd InfosApp
# mvn clean install
# cd ..

# building user manager
cd ManageUser
mvn clean install -q
cd ..
echo -e "\033[0;36m==========================================================================\033[0m"

# buidling market receivr
cd RecieveDataMarket
mvn clean install -q
cd ..
echo -e "\033[0;36m=========================BUILDING ENDS=====================================\033[0m"
