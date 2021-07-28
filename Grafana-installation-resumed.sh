# Trois logiciels:
# - InfluxDB qui aggregate toutes les mesures venant des OhmGraphite
# - OhmGraphite qui aggregate les mesures d'une machine en local https://github.com/nickbabcock/OhmGraphite#influxdb-configuration
# - Grafana Serveur web venant taper dans InfluxDB pour afficher les mesures

### InfluxDB ###
sudo apt-get update
sudo apt-get install influxdb
sudo chown -R influxdb:influxdb /var/lib/influxdb
### crontab ###
killall influxdb
sudo /usr/bin/influxd -config /etc/influxdb/influxdb.conf
### end crontab ###
sudo systemctl unmask influxdb
sudo systemctl enable influxdb
### end influxdb



### OhmGraphite ###
### windows: ###
.\OhmGraphite.exe install
PS E:\Monitoring\OhmGraphite> .\OhmGraphite.exe start
PS E:\Monitoring\OhmGraphite> .\OhmGraphite.exe restart
PS E:\Monitoring\OhmGraphite> .\OhmGraphite.exe stop
PS E:\Monitoring\OhmGraphite> .\OhmGraphite.exe start
### end OhmGraphite ###



### Telegraf ###
### Linux: ###
sudo apt-get install -y telegraf
### end Telegraf ###



### Grafana ###
wget -q -O - https://packages.grafana.com/gpg.key | sudo apt-key add -
echo "deb https://packages.grafana.com/oss/deb stable main" | sudo tee -a /etc/apt/sources.list.d/grafana.list
sudo apt-get update
sudo apt-get install -y grafana
sudo /bin/systemctl enable grafana-server
sudo /bin/systemctl start grafana-server
grafana-cli plugins install vonage-status-panel
### http://<ip address>:3000 user:admin password:admin


### On raspian buster
sudo apt-get install -y ufw
sudo ufw --force enable
sudo apt-get install -y grafana-rpi
sudo systemctl daemon-reload
sudo systemctl enable grafana-server
sudo systemctl start grafana-server

#dashboards imports
11601
928
### end Grafana ###


### InfluxDB, telegraf, grafana from scratch raspbian ###
sudo apt-get update
sudo apt-get upgrade

sudo apt install influxdb
sudo apt install influxdb-client
# if /etc/os-release == VARIABLE #
curl -sL https://repos.influxdata.com/influxdb.key | sudo apt-key add -
echo "deb https://repos.influxdata.com/debian VARIABLE stable" | sudo tee /etc/apt/sources.list.d/influxdb.list
sudo apt-get update
sudo apt-get install telegraf
# endif #

 
wget -q -O - https://packages.grafana.com/gpg.key | sudo apt-key add -
echo "deb https://packages.grafana.com/oss/deb stable main" | sudo tee -a /etc/apt/sources.list.d/grafana.list
sudo apt-get update
sudo apt-get install -y grafana

sudo /bin/systemctl enable influxdb
sudo /bin/systemctl enable telegraf
sudo /bin/systemctl enable grafana-server

sudo systemctl start influxdb
sudo systemctl start telegraf
sudo systemctl start grafana-server