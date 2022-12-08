Proyecto Gestión de Campamentos Diputación Foral de Álava
============================

Esta aplicación está pensada para realizar una tarea de gestión interna de campamentos ofrecidos al público a través de la Diputación Foral de Álava.

La funcionalidad de la aplicación se basará en la gestión de los diferentes campamentos registrados y de las inscripciones de las personas que soliciten entrar en los mismos.

#  Índice de Contenidos 
* [Información técnica](#información-técnica)
    * [Requerimientos](#requerimientos)
    * [Almacenamiento](#almacenamiento)
    * [A tener en cuenta](#a-tener-en-cuenta)
* [Estructura](#estructura)
    * [Login](#login)
    * [Registro](#registro)
    * [Ventana principal](#ventana-principal)
        * [Pestaña campamentos](#pestaña-campamentos)
            * [Crear campamento](#crear-campamento)
            * [Modificar campamento](#modificar-campamento)
            * [Eliminar campamento](#eliminar-campamento)
            * [Ver campamento](#ver-campamento)
            * [Ver inscripciones campamento](#ver-inscripciones-campamento)
        * [Pestaña personas](#pestaña-personas)
            * [Crear persona](#crear-persona)
            * [Inscribir persona](#inscribir-persona)
            * [Retirar persona](#retirar-persona)
            * [Exportar XML personas????](#exportar-xml-personas)
            * [Inscribir XML personas????](#inscribir-xml-personas)
            * [Ver campamentos inscritos](#ver-campamentos-inscritos)
        * [Pestaña salir](#pestaña-salir)
            * [Cerrar sesión](#cerrar-sesión)
            * [salir](#salir)
---

# Información Técnica
---
## Requerimientos

* JDK 18
* JCalendar-1.14.jar

## Almacenamiento

Se lleva a cabo en ficheros .dat en los cuales se hará la escritura directa de los objetos serializables.
* campamentos.dat
* personas.dat
* campamentoPersona.dat
* usuarios.dat

## A tener en cuenta
Las vistas están hechas basadas en JFrame desde Netbeans, es posible que para visualizar de manera acertada su diseñador se necesite dicho IDE.

---
# Estructura
---

## Login

El login se compone del campo usuario y contraseña desde el cual se accederá a la aplicación. Esta será la ventana inicial de la aplicación al ejecutarla.

Para iniciar sesión se deberán de indicar un usuario y una contraseña registradas en el sistema, en caso de que no se propicien credenciales válidas informará de ello a través de una etiqueta roja.

Consta de un botón de registrar que redirige a otra ventana para poder registrar nuevos usuarios.

![Login](https://drive.google.com/uc?export=view&id=1CI5qKSNm0vdlvN4m5yp2NgQ7zrJ7gKlV)

## Registro

El registro consta de un formulario sencillo donde se pide un usuario + confirmación y una contraseña + confirmación.

Para que un usuario se pueda registrar deberán coincidir usuario/confirmarUsuario y contraseña/confirmarContraseña, además, el usuario deberá ser único entre los registrados, por lo que se validará que no exista el usuario.

Contiene etiquetas rojas para informar de las validaciones que no pase el formulario a la hora de registrar.

Una vez registrado un usuario, la ventana se encargará de volver al login.

![Registro](https://drive.google.com/uc?export=view&id=1kF1ZExM03y5IGn2OEhk8VAce0ZFlXOba)

## Ventana Principal
---
La ventana principal consta de: un menú con diferentes pestañas para navegar por la aplicación, de un título y de botones para cerrar sesión o salir definitivamente de la aplicación (parar su ejecución).

![principal](https://drive.google.com/uc?export=view&id=1vULPkGlyMnRPxhk0oYVYDwjyveifFb-P)

## Pestaña Campamentos

![principal-campamentos](https://drive.google.com/uc?export=view&id=1dUKSzcT6dfOq9TQFoSsjxBxMpHwJtffS)

### Crear Campamento
La ventana de crear campamentos consta de un formulario que recogerá datos del campamento:
* Nombre
* Lugar
* Fecha de inicio
* Fecha de fin
* Capacidad

Esta ventana validará que no haya datos vacíos, que la fecha de inicio no sea posterior a la de fin y que la capacidad sea un numero entero mayor a cero. Para ello consta de etiquetas rojas que se mostrarán en función de las validaciones que no pase el formulario a la hora de crear el campamento.

![crear-campamento](https://drive.google.com/uc?export=view&id=1zW3-Iar9ei2eRXNZ4mGoix4dfc5XktE7)

### Modificar Campamento
Este enlace redirige a una ventana intermedia donde se seleccionará el campamento a modificar. Dicha ventana está compuesta por un desplegable con los distintos campamentos donde se puede seleccionar uno y se mostrarán los datos de dicho campamento seleccionado. 

![modificar-campamento1](https://drive.google.com/uc?export=view&id=1QbcIqS_XvuRN4Rs35puQy0Ruq-mlePEu)

Una vez seleccionado un campamento se podrá dar a "Modificar" y llevará a la siguiente ventana.

La siguiente ventana, como la de "Crear Campamento" consta de los campos necesarios a rellenar para modificar el campamento.

Nuevamente se hacen las validaciones de que no estén vacíos los campos, que la fecha inicial no sea posterior a la final, y que la capacidad sea un número entero mayor a cero, con un añadido de que la capacidad no sea menor al número de personas ya inscritas en dicho campamento.

![modificar-campamento2](https://drive.google.com/uc?export=view&id=1O3nyiEAl3lr50l9ypZGryjZf2wDrkuDD)

### Eliminar Campamento
Al igual que en "Modificar Campamento" este enlace redirige a una ventana intermedia donde se seleccionará el campamento a eliminar. Dicha ventana está compuesta por un desplegable con los distintos campamentos donde se puede seleccionar uno y se mostrarán los datos de dicho campamento seleccionado. 

![eliminar-campamento](https://drive.google.com/uc?export=view&id=1SdzJVCsKcmXmin-RP3wnAb14DCpos6ou)

Una vez seleccionado un campamento se podrá dar a "Eliminar". Paso seguido aparecerá un mensaje de confirmación para eliminar el campamento.

![confirmacion-eliminar-campamento](https://drive.google.com/uc?export=view&id=1noBq9FcBVxWb8MEfzxzltVeRKqc_OSbb)

### Ver Campamento
Este enlace redirige a una ventana intermedia donde se seleccionará el campamento del que se quieren ver los daots. Dicha ventana está compuesta por un desplegable con los distintos campamentos.

![ver-campamento](https://drive.google.com/uc?export=view&id=1Eu4OH-8uqOgLcjnSdVYUd1ebu5iVQ5KM)

### Ver Inscripciones Campamento

TODO

## Pestaña Personas

![principal-personas](https://drive.google.com/uc?export=view&id=180NhNuqJUj8Ah-ZTt4IsmfKq5qDJL04X)

### Crear persona
La ventana de crear personas consta de un formulario que recogerá datos de la persona:
* DNI
* Nombre
* Primer apellido
* Segundo apellido

Esta ventana validará que no haya datos vacíos, y que el DNI no esté ya registrado. Para ello consta de etiquetas rojas que se mostrarán en función de las validaciones que no pase el formulario a la hora de crear a la persona.

![crear-persona](https://drive.google.com/uc?export=view&id=1pb12WRkf1nveKrafMUG3H94tuiYya9je)

### Inscribir persona
Esta ventana está conformada por 2 bloques de datos.

El primero será el del campamento. Consta de un desplegable para seleccionar el campamento al que se inscribirá la persona seleccionada en el siguiente bloque, que de la misma manera que los campamentos, contiene un desplegable con el que se elegirá a la persona que se quiere inscribir.

Para poder realizar la inscripción será obligatorio tener un campamento y una persona seleccionada.

![inscribir-persona](https://drive.google.com/uc?export=view&id=1nsnno8zP-V73Vuw5uCJJu-Gd9ClaD9xu)

### Retirar persona
Esta ventana, como la de inscripción, está conformada por 2 bloques de datos.

El primero será el de la persona. Consta de un desplegable para seleccionar la persona de la cual se quiere retirar de un campamento, que de la misma manera que en el primer bloque, se seleccionará a través de un desplegable relleno con los campamentos a los que está inscrita la persona seleccionada arriba.

Para poder realizar el proceso de retirar la inscripción será obligatorio tener una persona y un campamento seleccionado.

![retirar-persona](https://drive.google.com/uc?export=view&id=1PZt8DtgKumoFxQcke8BXAMJAk_Muq_0N)

### Exportar XML personas

TODO

### Inscribir XML personas

TODO

### Ver Campamentos Inscritos
Esta ventana, como la de [retirar persona](#retirar-persona), está conformada por 2 bloques de datos.

Funciona exactamente igual que la ventana anteriormente mencionada, pero no tendrá opción de retirar a la persona.

![ver-campamentos-de-la-persona](https://drive.google.com/uc?export=view&id=16_t6zELn9lKdq6p17BbdUzBN6urCSwx2)

## Pestaña Salir

![principal-salir](https://drive.google.com/uc?export=view&id=14e8-dydd2kkVyiXbf7XLjCOEKE_Bknka)

### Cerrar Sesión
Al hacer click en esta pestaña se cerrará la sesión y se volverá al login de la aplicación.

### Salir
Al hacer click en esta pestaña se cerrará la aplicación deteniendo su ejecución.
