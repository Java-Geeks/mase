# -*- mode: ruby -*-
# vi: set ft=ruby :

VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|

  # Every Vagrant virtual environment requires a box to build off of.
  config.vm.box = "precise32"

  # The url from where the 'config.vm.box' box will be fetched if it
  # doesn't already exist on the user's system.
  config.vm.box_url = "http://files.vagrantup.com/precise32.box"

  # Provision VM with mongodb, java, tomcat and elasticsearch
  config.vm.provision :shell, :path => "bootstrap.sh"

  # MongoDB port
  config.vm.network :forwarded_port, guest: 27017, host: 27017

  # Apache port
  config.vm.network :forwarded_port, guest: 80, host: 9000

  # Tomcat port
  config.vm.network :forwarded_port, guest: 8080, host: 9100

  # ElasticSearch port
  config.vm.network :forwarded_port, guest: 9200, host: 9200
  
end
