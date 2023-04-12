@ECHO OFF
SET reportName=%1
SET pdfName=%2
SET arg01=%3
SET arg02=%4
SET arg03=%5
@ECHO Executing SAC Exporter automatic
ant Extractor -DreportName=%reportName% -DpdfName=%pdfName% -Darg01=%arg01% -Darg02=%arg02% -Darg03=%arg03%
@ECHO Finished!