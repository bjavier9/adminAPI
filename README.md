# API de Seguros - Java

Este es un proyecto base para una API de seguros desarrollada en Java con Spring Boot.

## Comandos Útiles

### Iniciar la aplicación
```sh
mvn spring-boot:run
```

### Ejecutar las pruebas
```sh
mvn test
```

### Empaquetar la aplicación
```sh
mvn package
```

## Librerías y Tecnologías

*   **Java 17**: Versión del lenguaje de programación.
*   **Spring Boot 3.2.1**: Framework principal para el desarrollo de la aplicación.
*   **Spring Security**: Para la autenticación y autorización.
*   **Spring Boot Starter OAuth2 Resource Server**: Para la integración con un servidor de autorización OAuth2.
*   **Springdoc OpenAPI**: Para la generación de documentación de la API en formato OpenAPI 3.
*   **nimbus-jose-jwt**: Para la creación y validación de tokens JWT.
*   **Lombok**: Para reducir el código "boilerplate" en las clases de Java.
*   **Google Generative AI (Gemini)**: SDK para la integración con modelos de IA generativa de Google.
*   **Maven**: Para la gestión de dependencias y el ciclo de vida del proyecto.

## Estructura del Proyecto

```
.
├── .mvn               # Contiene el "Maven Wrapper" para una versión consistente de Maven.
├── .idea              # (Opcional) Configuración del IDE IntelliJ IDEA.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── insurance
│   │   │           └── api
│   │   │               ├── adapters          # Adaptadores para la comunicación con el exterior (UI, DBs, etc.).
│   │   │               │   ├── controller    # Controladores REST que exponen los endpoints de la API.
│   │   │               │   └── repository    # Implementaciones de los repositorios para el acceso a datos.
│   │   │               ├── application       # Lógica de la aplicación y casos de uso.
│   │   │               │   └── usecase       # Clases que orquestan los flujos de la aplicación.
│   │   │               ├── domain            # El núcleo del negocio: modelos y lógica de dominio.
│   │   │               │   ├── model         # Entidades y objetos de valor del dominio (ej: Usuario).
│   │   │               │   └── service       # Interfaces que definen los contratos de los servicios del dominio.
│   │   │               └── infrastructure    # Configuración de frameworks, seguridad y herramientas externas.
│   │   │                   ├── config        # Clases de configuración de Spring (Beans).
│   │   │                   └── security      # Configuración de Spring Security (JWT, filtros, etc.).
│   │   └── resources                         # Archivos de recursos (ej: application.properties).
│   └── test
│       └── java                              # Código fuente para las pruebas (unitarias, integración).
└── pom.xml                                   # Archivo de configuración de Maven (dependencias, build).
```

## Arquitectura Limpia (Clean Architecture)

Este proyecto sigue los principios de la Arquitectura Limpia. Este patrón arquitectónico separa el código en capas distintas, cada una con su propia responsabilidad. Esta separación de intereses hace que la aplicación sea más modular, escalable y fácil de mantener.

### Capas

*   **Dominio (Domain):** Es el núcleo de la aplicación. Contiene la lógica de negocio y las entidades, y es independiente de cualquier otra capa.
*   **Aplicación (Application):** Esta capa orquesta los casos de uso de la aplicación. Depende de la capa de Dominio, pero no de las capas de Infraestructura o Adaptadores.
*   **Adaptadores (Adapters):** Esta capa contiene los adaptadores que interactúan con sistemas externos, como los controladores para la interfaz web y los repositorios para la base de datos. Depende de la capa de Aplicación.
*   **Infraestructura (Infrastructure):** Esta capa contiene los frameworks y las herramientas que utiliza la aplicación, como Spring Boot y el controlador de la base de datos. Es la capa más externa y todas las demás capas dependen de ella.
