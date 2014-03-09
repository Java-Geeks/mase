# Introduction

This repository aims to provide a complete use case of modern web application using the following technologies:

## Client side

* [AngularJS](http://angularjs.org/)
* [Twitter bootstrap](http://getbootstrap.com/)
* [HTML5](http://www.w3.org/TR/html5/), [CSS3](http://www.w3schools.com/css/css3_intro.asp), [JQuery](http://jquery.com/)

## Server side

* [MongoDB](https://www.mongodb.org/)
* [NodeJS](http://nodejs.org/)
* [ElasticSearch](http://www.elasticsearch.org/)

The application is a simple yet complete online todo list manager.

Backend services are exposed through RESTful APIs which are documented using [Swagger](https://github.com/wordnik/swagger-core).

# Run the application

To keep running the application as simple as possible, we provide a pre-built [Virtual Box](https://www.virtualbox.org/) VM managed by [Vagrant](http://www.vagrantup.com/).

To run the application, please ensure that you have Virtual Box and Vagrant correctly installed and running. 

Then, please follow these instructions :

1. `git clone https://github.com/Java-Geeks/mongodb-nodejs-angularjs-elasticsearch.git`
2. `cd mongodb-nodejs-angularjs-elasticsearch`
3. `vagrant up`
4. browse the following URL: `http://localhost:9100`

### Optional : packaging the VM

To package the VM for further reuse without re-installing all dependencies, you can proceed as follows:

1. Package the VM into a vagrant box: `vagrant package --output precise32-mongodb-nodejs-elasticsearch.box`
2. Add the box to vagrant managed VMs: `vagrant box add precise32-mangodb-nodejs-elasticsearch precise32-mongodb-nodejs-elasticsearch.box`
3. Edit the `Vagrantfile`, set the property `config.vm.box` to `precise32-mangodb-nodejs-elasticsearch` and comment properties `config.vm.box_url` and `config.vm.provision`
4. Remove or save the box file `precise32-mongodb-nodejs-elasticsearch.box` to a backup directory
5. Run `vagrant up`

Your VM will now be up and running without re-installing all required packages to run the application.