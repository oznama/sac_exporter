# Extractor Automático SAC

Jar para generar reportes del SAC

## instalación

Generar jar con ant y pegar en /aplic/prod/pmt/rpt/pmgobj.

```cmd
$ ant
```

## Uso


Prueba directa con ant

```cmd
$ ant Extractor -DreportName=SICLIR0060 -DpdfName=PMTRPTB999HAAMMDDII01 -DdbHost=x -DdbPort=x -DdbName=x -DdbUser=x -DdbPswd=x -Dejecuto=x -DinitDate=x -DendDate=x -DinitDateOrig=28/03/2023 -DendDateOri=29/03/2023 -Dbanco=0 -DagrDia=x -DtipoLiq=x -Drole=x -DnumMisc=x -DtipoProc=x -DtipoEmiAdq=x

$ ant Extractor -DreportName=SICLIR0077 -DpdfName=PMTRPTB999HAAMMDDII02 -DdbHost=x -DdbPort=x -DdbName=x -DdbUser=x -DdbPswd=x -Dejecuto=x -DinitDate=x -DendDate=x -DinitDateOrig=28/03/2023 -DendDateOri=29/03/2023 -Dbanco=x -DagrDia=01 -DtipoLiq=x -Drole=x -DnumMisc=x -DtipoProc=x -DtipoEmiAdq=x

$ ant Extractor -DreportName=SICLIR0010 -DpdfName=PMTRPTB999HAAMMDDII03 -DdbHost=x -DdbPort=x -DdbName=x -DdbUser=x -DdbPswd=x -Dejecuto=x -DinitDate=28/03/2023 -DendDate=29/03/2023 -DinitDateOrig=x -DendDateOri=x -Dbanco=x -DagrDia=x -DtipoLiq=22 -Drole=banco -DnumMisc=x -DtipoProc=x -DtipoEmiAdq=x

$ ant Extractor -DreportName=SICLIR0350 -DpdfName=PMTRPTB999HAAMMDDII11 -DdbHost=x -DdbPort=x -DdbName=x -DdbUser=x -DdbPswd=x -Dejecuto=x -DinitDate=28/03/2023 -DendDate=29/03/2023 -DinitDateOrig=x -DendDateOri=x -Dbanco=x -DagrDia=x -DtipoLiq=x -Drole=x -DnumMisc=105 -DtipoProc=100 -DtipoEmiAdq=EMI

$ ant Extractor -DreportName=SICLIR0350 -DpdfName=PMTRPTB999HAAMMDDII12 -DdbHost=x -DdbPort=x -DdbName=x -DdbUser=x -DdbPswd=x -Dejecuto=x -DinitDate=28/03/2023 -DendDate=29/03/2023 -DinitDateOrig=x -DendDateOri=x -Dbanco=x -DagrDia=x -DtipoLiq=x -Drole=x -DnumMisc=105 -DtipoProc=100 -DtipoEmiAdq=EMI
```

Ejecución desde bash

```bash
$ PMTURPTB999G07 SICLIR0060 PMTRPTB999HAAMMDDII01 x x x x x x x x 28/03/2023 29/03/2023 0 x x x x x x

$ PMTURPTB999G07 SICLIR0077 PMTRPTB999HAAMMDDII02 x x x x x x x x 28/03/2023 29/03/2023 x 01 x x x x x

$ PMTURPTB999G07 SICLIR0010 PMTRPTB999HAAMMDDII03 x x x x x x 28/03/2023 29/03/2023 x x x x 22 banco x x x

$ PMTURPTB999G07 SICLIR0350 PMTRPTB999HAAMMDDII11 x x x x x x 28/03/2023 29/03/2023 x x x x x x 105 100 EMI

$ PMTURPTB999G07 SICLIR0350 PMTRPTB999HAAMMDDII12 x x x x x x 28/03/2023 29/03/2023 x x x x x x 105 100 EMI
```