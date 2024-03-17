#!/bin/bash

cp /usr/local/share/ca-certificates/zscaler-ca.crt .
docker build -t myjava:20240316-1 .
rm zscaler-ca.crt

