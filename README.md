# MAC API Address Look up Application
Java Application to access https://macaddress.io/ to get output the Company Name associated with that MAC address.
# Prerequisites:
 Please generate the API_Key FROM https://macaddress.io/api/documentation/making-requests . Follow the instruction. Pass this in the argument MAC_API_KEY while running the application.
# Docker-image:
The Link is "docker pull  cisco_mac_address_docker_image:latest"   
# How to run the Application in the command line
 $  docker run --env MAC_API_KEY=${MAC_API_KEY}  cisco_mac_address_docker_image  "44:38:39:ff:ef:57"

Note : "44:38:39:ff:ef:57" is the MAC address. This Application takes one argument.
