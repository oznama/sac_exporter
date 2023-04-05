# Extractor Automático SAC

Jar para generar reportes del SAC

## instalación

Generar jar con ant y pegar en /aplic/prod/pmt/rpt/pmgobj.

```bash
ant
```

## Uso

```cmd
Prueba directa con ant
$ ant Extractor -DreportName=SICLIR0060 -DinitDate=28/03/2023 -DendDate=29/03/2023
Ejecución desde bash
$ PMTURPTB999G07 SICLIR0060 28/03/2023 29/03/2023