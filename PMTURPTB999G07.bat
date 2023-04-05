@ECHO OFF
SET reportNum=%1
SET initDate=%2
SET endDate=%3
@ECHO Executing SAC Exporter automatic
ant Extractor -DreportNum=%reportNum% -DinitDate=%initDate% -DendDate=%initDate%
@ECHO Finished!