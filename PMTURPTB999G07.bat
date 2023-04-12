@ECHO OFF
SET reportName=%1
SET arg01=%2
SET arg02=%3
SET arg03=%4
@ECHO Executing SAC Exporter automatic
ant Extractor -DreportName=%reportName% -Darg01=%arg01% -Darg02=%arg02% -Darg03=%arg03%
@ECHO Finished!