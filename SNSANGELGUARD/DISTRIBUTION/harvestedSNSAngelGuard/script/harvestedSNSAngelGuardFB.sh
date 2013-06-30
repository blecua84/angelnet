#!/bin/bash

DATE=$(date +%Y_%m_%d);
logFile=/Users/josejavierblecuadepedro1/Documents/WS_SNSANGELGUARDFB/harvestedSNSAngelGuard/execute_harvesting_SNSAngelGuardFB_$DATE\.log;
cd /Users/josejavierblecuadepedro1/Documents/WS_SNSANGELGUARDFB/harvestedSNSAngelGuard/
mvn clean dependency:copy-dependencies package >> $logFile
mvn exec:java -Dexec.mainClass="es.uah.cc.ie.harvestedsnsangelguard.Main http://localhost:8080/ /Users/josejavierblecuadepedro1/.keystore blecua" >> $logFile
