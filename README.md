# APTPIntegradorJava
Trabajo Practico Integrador. Java Intermedio. Argentina Programa. Grupo 5

Si al correr el codigo, los metodos de las estadisticas de los tecnicos devuelven "null" o tira error, en MySQL en la base de datos 
que esten sincronizando con el proyecto, corran las siguientes lineas:

ALTER TABLE Incidente MODIFY COLUMN fechaInicio TIMESTAMP
ALTER TABLE Incidente MODIFY COLUMN fechaResolucion TIMESTAMP

Nos pasó que a veces MySQL no nos cargaba los datos que estan como LocalDate y con eso se solucionó.
