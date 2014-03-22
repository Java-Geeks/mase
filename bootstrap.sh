#!/usr/bin/env bash

sudo apt-get update

#install apache server
echo "### Installing Apache ###"
sudo apt-get install -y apache2

#install mangodb
echo '### Installing MongoDB ###'
sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 7F0CEB10
echo 'deb http://downloads-distro.mongodb.org/repo/ubuntu-upstart dist 10gen' | sudo tee /etc/apt/sources.list.d/mongodb.list
sudo apt-get update
sudo apt-get install mongodb-10gen

#install Java 7
echo '### Installing Java7 ###'
sudo apt-get install -y openjdk-7-jre-headless

#install tomcat 7
echo '### Installing Tomcat7 ###'
sudo apt-get install -y tomcat7

#install elasticsearch
echo '### Installing ElasticSearch ###'
wget https://download.elasticsearch.org/elasticsearch/elasticsearch/elasticsearch-1.0.1.deb
sudo dpkg -i elasticsearch-1.0.1.deb
sudo service elasticsearch start

#install Curl
echo '### Installing Curl ###'
sudo apt-get install -y curl

#install Git
echo '### Installing Git ###'
sudo apt-get install -y git

#create a symbolic link for the web app to be served by apache web server
sudo rm -rf /var/www
if [ ! -d "/vagrant/mase-web/target/www" ]; then
    mkdir -p /vagrant/mase-web/target/www
fi
sudo ln -fs /vagrant/mase-web/target/www /var/www

#create a symbolic link for the web services app to be served by apache tomcat
if [ ! -d "/vagrant/mase-ws/target/mase-ws" ]; then
    mkdir -p /vagrant/mase-ws/target/mase-ws
fi
sudo ln -fs /vagrant/mase-ws/target/mase-ws /var/lib/tomcat7/webapps/mase-ws
