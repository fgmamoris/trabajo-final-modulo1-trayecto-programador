# Trabajo práctico final

_Este es un trabajo práctico, con todo lo aprendido durante el primer módulo del trayecto formativo de programador brindado por el GCBA (CFP36)_

### Contenido
1. [Comenzando :rocket:](#comenzando-rocket)    
2. [Enunciado del trabajo práctico :pencil:](#enunciado-del-trabajo-práctico-pencil)
3. [Ejecución :factory:](#ejecución-factory)
4. [ScreenShot del sistema :camera:](#screenShot-del-sistema-camera)
5. [Construido con :wrench:](#construido-con-wrench)
6. [Autores :black_nib:](#autores-black_nib)

### Comenzando :rocket:

_Si bien se utilizó POO, no era condición necesaria ni obligatoria para esta parte del curso, de todas formas, se busco avanzar un poco más de lo aprendido en el mismo, y tratar de aplicar los conceptos adquiridos_


### Enunciado del trabajo práctico :pencil:

_CFP ASEGURA TU AUTO
Se necesita un programa que permita la emisión de una póliza de seguro para un vehículo. Con las siguientes características:_

* 1) En la primera parte debe mostrar una JOption con el logo de la compañía
* 2) Solicitar datos del cliente:
    * a. Nombre y Apellido
    * b. Teléfono
    * c. EMAIL
    
En este caso podemos utilizar variables para cada uno de los puntos y solicitarlo por JOPTION

* 3) Datos del vehículo
    * a. Marca, utilizar un JOption combobox a un vector
    * b. Modelo, JOPtion input
    * c. Dominio, JOPtion input
    * d. Años de antigüedad, JOPtion input
    
Luego que se solicita la antigüedad del automóvil se debe realizar el cálculo para calcular la cuota. Este cálculo se realiza de la siguiente manera:
* a. Si el vehículo es menor igual a 5 años pagara u extra de 500
* b. Si el vehículo es mayor a 5 años pero menor a 10 paga un extra de 1000
* c. Si el vehículo tiene una edad mayor igual a 10 pero menor a 15 paga 1500
* d. Si el vehículo tiene más de 15 años y menor 20 paga 2000
* e. Si el vehículo es mayor a 20 años no se asegura (mostrar cartel antes de seguir avanzando)



* 4) Tipo de Cobertura

Utilizar un Joption combo con las opciones Terceros Completos, Todo Riesgo y Responsabilidad Civil

Los valores de cada cobertura son:
 * RC :1000
 * TC:2000
 * TR: 3000

* 5) Adicionales de la cobertura. Utilizar un Joption combo con las opciones:
    * a. Granizo
    * b. Llantas deportivas
    * c. Asistencia Mecánica
    * d. Localizador GPS

Puede seleccionar más de un adicional. Por cada dos que selecciona se cobra uno el valor de cada adicional es 300

_Cálculos del seguro:_

El cálculo de lo que el cliente va a abonar se calcula con:


Valor de la cuota = Tipo de cobertura (valor) + Adicionales (valor)+ antigüedad del vehículo

* 6) Impresión de póliza (opcional función)
Mostrar en un joption o en consola como lo prefieran, los datos que deben mostrarse son:
    * a. Datos del Usuario (datos cargados)
    * b. Datos del Vehículo (datos cargados)
    * c. Tipo de cobertura (detalle seleccionado)
    * d. Adicionales de la cobertura (detalles seleccionado)
    * e. Valor de la prima total
_

## Ejecución :factory:

_Clonar el proyecto desde el repositorio, a su máquina local, puede ser desde la consola o bien desde el entorno gráfico de la página de GitHub_

```
git clone https://github.com/fgmamoris/trabajo-final-modulo1-trayecto-programador.git
```

_Abrir el proyecto desde un IDE, ya sea NetBeans, IntellijIdea, Eclipse o cualquier otro IDE de que usted utiice para ejecutar aplicaciones en JAVA_

_Correr el programa_



### ScreenShot del sistema :camera:

#### Inicio
![inicio](/images/inicio.png)
##### Funcion para verificar si el dato ingresado es un número
![checkIsNumber](/images/checkIsNumber.png)
![validacionNumero](/images/validacionNumero.png)
##### Ejemplo de validación 
![validacion](/images/validacion.png)
##### Funcion tipo de cobertura
![funcionTipoDeCobertura](/images/funcionTipoDeCobertura.png)
![tipoDeCobertura](/images/tipoCobertura.png)
##### Funcion para imprimir la poliza
![imprimirPoliza](/images/imprimirPoliza.png)
![poliza](/images/poliza.png)


### Construido con :wrench:

* [Java](https://openjdk.java.net/) - OpenJdk, licencia libre
* [NetBeans](https://netbeans.apache.org/) - Ide para desarrollo y entorno de Java


### Autores :black_nib:


* **Federico Mamoris** - *Trabajo final* - [fgmamoris](https://github.com/fgmamoris)

### A su consideración :gift:

* Comenta a otros sobre este proyecto :mega:
* Invita una cerveza :beer: o un café :coffee: a alguien del equipo. 
* Muchas gracias por tomarse el tiempo de ver el repositorio :grin:.


---
:hammer_and_wrench: con :hearts: por [fgmamoris](https://github.com/fgmamoris) :blush: