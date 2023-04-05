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
$ ant Extractor -DreportNum=1 -DinitDate=28/03/2023 -DendDate=29/03/2023
```

Ejecución desde bash

```bash
$ PMTURPTB999G07 1 28/03/2023 29/03/2023
```