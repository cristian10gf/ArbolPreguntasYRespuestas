# Proyecto de Árbol de Preguntas y Respuestas

Este es un proyecto Java que implementa un árbol de preguntas y respuestas. El proyecto utiliza Apache Ant para la construcción y gestión.

## Estructura del Proyecto

El proyecto tiene la siguiente estructura de directorios:

- [`src/`](command:_github.copilot.openRelativePath?%5B%22src%2F%22%5D "src/"): Contiene el código fuente del proyecto.
  - `arbolpreguntasyrespuestas/`: Contiene las clases Java `Arbol.java`, [`ArbolPreguntasYRespuestas.java`](command:_github.copilot.openRelativePath?%5B%22src%2Farbolpreguntasyrespuestas%2FArbolPreguntasYRespuestas.java%22%5D "src\arbolpreguntasyrespuestas\ArbolPreguntasYRespuestas.java") y `Nodo.java`.
- [`build/`](command:_github.copilot.openRelativePath?%5B%22build%2F%22%5D "build/"): Contiene los archivos generados por la compilación.
  - `classes/`: Contiene las clases compiladas.
- [`nbproject/`](command:_github.copilot.openRelativePath?%5B%22nbproject%2F%22%5D "nbproject/"): Contiene los archivos de configuración del proyecto para NetBeans.
- [`test/`](command:_github.copilot.openRelativePath?%5B%22test%2F%22%5D "test/"): Este directorio está reservado para las pruebas unitarias.
- [`build.xml`](command:_github.copilot.openRelativePath?%5B%22build.xml%22%5D "build.xml"): Es el archivo de construcción de Ant.

## Cómo construir el proyecto

Para construir el proyecto, ejecute el siguiente comando en la terminal:

```sh
ant -f build.xml
```

Esto generará los archivos de clase en el directorio [`build/classes`](command:_github.copilot.openRelativePath?%5B%22build%2Fclasses%22%5D "build/classes").

## Cómo ejecutar el proyecto

Para ejecutar el proyecto, primero debe construirlo. Luego, puede ejecutar la clase principal `ArbolPreguntasYRespuestas` con el siguiente comando:

```sh
java -cp build/classes arbolpreguntasyrespuestas.ArbolPreguntasYRespuestas
```

Por favor, asegúrese de tener instalado Java y Apache Ant en su sistema para construir y ejecutar este proyecto.
