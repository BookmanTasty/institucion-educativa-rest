# institucion-educativa-rest Project

Esta es una prueba de proyecto para un backend con quarkus

Para ejecutar el proyecto en modo dev, ejecute el siguiente comando:

```
shell script
./mvnw compile quarkus:dev
```


## Enpoints

El servicio incluye 5 endpoints y un endpoint que se encarga de generar datos de prueba:

### findMaestrosByMateriaId
```shell script
wget --no-check-certificate --quiet \
  --method GET \
  --timeout=0 \
  --header '' \
   'http://localhost:8080/institucion/maestro/materia/56539a2d-a977-42f6-b5ba-d63b6afe56bb'
```
### findAlumnosByPromedio
```shell script
wget --no-check-certificate --quiet \
  --method GET \
  --timeout=0 \
  --header '' \
   'http://localhost:8080/institucion/alumnos/promedio/85'
```
### findAlumnosByMaestroId
```shell script
wget --no-check-certificate --quiet \
  --method GET \
  --timeout=0 \
  --header '' \
   'http://localhost:8080/institucion/alumnos/maestro/6f6f267a-434d-48e4-9bf1-fa796b5c8c2b'
```
### findMateriasBySalonId
```shell script
wget --no-check-certificate --quiet \
  --method GET \
  --timeout=0 \
  --header '' \
   'http://localhost:8080/institucion/materias/salon/78a7d33f-9655-4504-8b9d-02d00b1b347a'
```
### createCalificacion
```shell script
wget --no-check-certificate --quiet \
  --method POST \
  --timeout=0 \
  --header 'Content-Type: application/json' \
  --body-data '{"alumnoId":"89ec6230-dadb-409f-83b4-6caf5735f08e",
"materiaId":"8caaedbd-cd2c-4282-8ef3-46a49186b798",
"porcentaje":95}' \
   'http://localhost:8080/institucion/materias/calificacion'
```
### Crear datos de prueba

```shell script
wget --no-check-certificate --quiet \
  --method GET \
  --timeout=0 \
  --header '' \
   'http://localhost:8080/generardatos'
```

