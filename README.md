# Hoja de Trabajo #4  
## Pilas, Listas y Patrones de Diseño  

###  Descripción

Este programa permite evaluar expresiones en notación infix.

El sistema:
1. Lee una expresión desde el archivo `datos.txt`
2. Convierte la expresión de infix a postfix
3. Evalúa la expresión postfix
4. Muestra el resultado en consola

### 🏗 Estructura del Proyecto

#### ADT Pila
- Stack<T> (Interfaz)
- AbstractStack<T> (Clase abstracta)
- ArrayListStack<T>
- VectorStack<T>
- ListStack<T>

#### ADT Lista
- List<T> (Interfaz)
- AbstractList<T> (Clase abstracta)
- SinglyLinkedList<T>
- DoublyLinkedList<T>

---

###  Patrones de Diseño Utilizados

- Factory Pattern (para selección de implementación)
- Template Method (clase abstracta)
- Strategy Pattern (selección dinámica de estructuras)

---

###  Cómo ejecutar el programa

1. Colocar expresión en `datos.txt`
2. Ejecutar la clase `Main`
3. Seleccionar implementación deseada

---

###  Pruebas Unitarias

Se incluyen pruebas con JUnit para:
- Implementaciones de pila
- Implementaciones de lista


### Integrante

- José Leonel Hernández Suchini 25041


### 🔗 Repositorio
[https://github.com/Leo141592/Hoja-de-trabajo-4]