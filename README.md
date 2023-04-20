# Extractor Automático SAC

Componente para generar reportes del SAC

## Instalación

Generar jar con ant

* Dprofile		perfil de ambiente de despliegue [dev, qa, prod]

```cmd
$ ant
$ ant -Dprofile dev
$ ant -Dprofile qa
$ ant -Dprofile prod
```

- Copiar archivo PMTURPTB999G07_01.jar y pegar en /aplic/prod/pmt/rpt/pmgobj.
- Copiar carpeta lib y pegar en /aplic/prod/pmt/rpt/pmgobj.
- Copiar carpeta ReportEngine y pegar en /aplic/prod/pmt/rpt/pmgobj.
- Copiar carpeta reports y pegar en /aplic/prod/pmt/rpt/pmgobj.

## Uso


Prueba directa con ant

```cmd
$ java -jar PMTURPTB999G07_01.jar SICLIR0060 PMTRPTB999HAAMMDDII01 0 28/03/2023 29/03/2023

$ java -jar PMTURPTB999G07_01.jar SICLIR0077 PMTRPTB999HAAMMDDII02 01 28/03/2023 29/03/2023

$ java -jar PMTURPTB999G07_01.jar SICLIR0010 PMTRPTB999HAAMMDDII03 0 22 admin 28/03/2023 29/03/2023

$ java -jar PMTURPTB999G07_01.jar SICLIR0011 PMTRPTB999HAAMMDDII04 0 22 admin 28/03/2023 29/03/2023

$ java -jar PMTURPTB999G07_01.jar SICLIR0350 PMTRPTB999HAAMMDDII11 0 105 100 EMI 28/03/2023 29/03/2023

$ java -jar PMTURPTB999G07_01.jar SICLIR0350 PMTRPTB999HAAMMDDII12 0 105 100 EMI 28/03/2023 29/03/2023

$ java -jar PMTURPTB999G07_01.jar SICLIR0320 PMTRPTB999HAAMMDDII1 22,65 28/03/2023 29/03/2023
```

<!-- $ ant Extractor -DreportName=SICLIR0350 -DpdfName=PMTRPTB999HAAMMDDII12 -DdbHost=x -DdbPort=x -DdbName=x -DdbUser=x -DdbPswd=x -Dejecuto=x -DinitDate=28/03/2023 -DendDate=29/03/2023 -DinitDateOrig=x -DendDateOri=x -Dbanco=x -DagrDia=x -DtipoLiq=x -Drole=x -DnumMisc=105 -DtipoProc=100 -DtipoEmiAdq=EMI -->


Ejecución desde bash

```bash
$ PMTURPTB999G07 SICLIR0060 PMTRPTB999HAAMMDDII01 0 28/03/2023 29/03/2023

$ PMTURPTB999G07 SICLIR0077 PMTRPTB999HAAMMDDII02 01 28/03/2023 29/03/2023

$ PMTURPTB999G07 SICLIR0010 PMTRPTB999HAAMMDDII03 0 22 admin 28/03/2023 29/03/2023

$ PMTURPTB999G07 SICLIR0350 PMTRPTB999HAAMMDDII11 0 105 100 EMI 28/03/2023 29/03/2023

$ PMTURPTB999G07 SICLIR0350 PMTRPTB999HAAMMDDII12 0 105 100 EMI 28/03/2023 29/03/2023
```