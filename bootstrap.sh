#!/usr/bin/env bash

#install mangodb
echo '### Installing MongoDB ###'
sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 7F0CEB10
echo 'deb http://downloads-distro.mongodb.org/repo/ubuntu-upstart dist 10gen' | sudo tee /etc/apt/sources.list.d/mongodb.list
sudo apt-get update
sudo apt-get install mongodb-10gen

#install nodejs
echo '### NodeJs ###'
sudo apt-get install -y python-software-properties
sudo apt-get update
sudo apt-get install -y nodejs

#install Java 7
echo '### Installing Java7 ###'
sudo apt-get install -y openjdk-7-jre-headless

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