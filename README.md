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
$ ant Extractor -DreportName=SICLIR0060 -Darg01=0 -Darg02=28/03/2023 -Darg03=29/03/2023

$ ant Extractor -DreportName=SICLIR0077 -Darg01=01 -Darg02=28/03/2023 -Darg03=29/03/2023

$ ant Extractor -DreportName=SICLIR0010 -Darg01=0 -Darg02=22 -Darg03=banco -Darg04=28/03/2023 -Darg05=29/03/2023

$ ant Extractor -DreportName=SICLIR0350 -Darg01=0 -Darg02=105 -Darg03=100 -Darg04=EMI -Darg05=28/03/2023 -Darg06=29/03/2023
```

<!-- $ ant Extractor -DreportName=SICLIR0350 -DpdfName=PMTRPTB999HAAMMDDII12 -DdbHost=x -DdbPort=x -DdbName=x -DdbUser=x -DdbPswd=x -Dejecuto=x -DinitDate=28/03/2023 -DendDate=29/03/2023 -DinitDateOrig=x -DendDateOri=x -Dbanco=x -DagrDia=x -DtipoLiq=x -Drole=x -DnumMisc=105 -DtipoProc=100 -DtipoEmiAdq=EMI -->


Ejecución desde bash

```bash
$ PMTURPTB999G07 SICLIR0060 0 28/03/2023 29/03/2023

$ PMTURPTB999G07 SICLIR0077 01 28/03/2023 29/03/2023

$ PMTURPTB999G07 SICLIR0010 0 22 banco 28/03/2023 29/03/2023

$ PMTURPTB999G07 SICLIR0350 0 105 100 EMI 28/03/2023 29/03/2023
```