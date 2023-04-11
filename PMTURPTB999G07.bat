@ECHO OFF
SET reportName=%1
SET pdfName=%2
SET dbHost=%3
SET dbPort=%4
SET dbName=%5
SET dbUser=%6
SET dbPswd=%7
SET ejecuto=%8
SET initDate=%9
SET endDate=%10
SET initDateOrig=%11
SET endDateOrig=%12
SET banco=%13
SET agrDia=%14
SET tipoLiq=%15
SET role=%16
SET numMisc=%17
SET tipoProc=%18
SET tipoEmiAdq=%19
@ECHO Executing SAC Exporter automatic
ant Extractor -DreportName=%reportName% -DpdfName=%pdfName% -DdbHost=%dbHost% -DdbPort=%dbPort% -DdbName=%dbName% -DdbUser=%dbUser% -DdbPswd=%dbPswd% -Dejecuto=%ejecuto% -DinitDate=%initDate% -DendDate=%endDate% -DinitDateOrig=%initDateOrig% -DendDateOrig=%endDateOrig% -Dbanco=%banco% -DagrDia=%agrDia% -DtipoLiq=%tipoLiq% -Drole=%role% -DnumMisc=%numMisc% -DtipoProc=%tipoProc% -DtipoEmiAdq=%tipoEmiAdq%
@ECHO Finished!