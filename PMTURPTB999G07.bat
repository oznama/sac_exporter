@ECHO OFF
SET reportName=%1
SET initDate=%2
SET endDate=%3
@ECHO Executing SAC Exporter automatic
ant Extractor -DreportName=%reportName% -DinitDate=%initDate% -DendDate=%initDate%
@ECHO Finished!