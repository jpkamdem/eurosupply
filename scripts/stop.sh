#!/bin/bash
#!/bin/bash
engine=$1
while [ -z "${engine}" ] || [ "${engine}" != "d" ] && [ "${engine}" != "p" ];
do
  read -p "Podman (p) ou Docker (d) : " engine
done

if [ "${engine}" = "d" ]; then
engine="docker"
else
engine="podman"
fi

"${engine}" stop \
  eurosupply-web \
  eurosupply-monitoring \
  eurosupply-monitoring-engine \
  eurosupply-database \
  eurosupply-database-manager \
  eurosupply-server

"${engine}" rm \
  eurosupply-web \
  eurosupply-monitoring \
  eurosupply-monitoring-engine \
  eurosupply-database \
  eurosupply-database-manager \
  eurosupply-server
