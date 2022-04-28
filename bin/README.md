# Setting up your laptop for local Testing
## Install packages
* install docker, maven
* install docker-compose 
```
sudo curl -L "https://github.com/docker/compose/releases/download/1.25.4/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose"
sudo chmod +x /usr/local/bin/docker-compose
```
## Maven Build
* mvn clean install ..blah blah. ( dont do docker:build here.)

## Running the app
* `docker-compose -f local.yml up -d`

#### Open your Browser and point to http://localhost:8084/ 

* --------------------------------------------------------------------------- *

# Setting up production hosting
## Install packages
* install docker
* install compose 
    curl -L "https://github.com/docker/compose/releases/download/1.25.4/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
* install awscli
    apt install aws-cli

## Configure host
* docker login to gitlab registry
* configure aws key for db backup

## Firewall Settings
* configure GCE FW/AWS security group whatever to allow only ports 80,443,22
* block everything else.

## Configure NGINX proxy
* `apt install nginx`
* copy nginx.conf file into /etc/nginx/sites-enabled/ 
* delete /etc/nginx/sites-enabled/default
* install certbot and configure SSL ( allow redirect also )
* `service nginx restart`

## Running the app
* `docker-compose up -d`

## Point the DNS to host IP.
* ask customer to point DNS A record to IP of the host. ( if it is changed )
