# MAC API Address Look up Application
Java Application to access https://macaddress.io/ to get output the Company Name associated with that MAC address.
# Prerequisites:
Create an API KEY named MAC_API_KEY in the Enivronment Variable. Please generate the API_Key FROM https://macaddress.io/api/documentation/making-requests . Follow the instruction. 
# Docker-image:
The Link is "docker pull  cisco_mac_address_docker_image:latest"   
# How to run the Application in the command line
 $ docker run cisco_mac_address_image "44:38:39:ff:ef:57"

Note : "44:38:39:ff:ef:57" is the MAC address. This Application take one argument.
