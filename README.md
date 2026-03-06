# 🏥 Voll.med API - Clínica Médica

API RESTful desarrollada para la gestión de una clínica médica, permitiendo el control de médicos, pacientes, agendamiento de consultas y autenticación segura.

Este proyecto fue desarrollado como parte de la formación de **Spring Boot** de Alura Latam, aplicando buenas prácticas de desarrollo, diseño arquitectónico y pruebas automatizadas.

## 🚀 Funcionalidades Principales

* **Autenticación y Autorización:** Sistema de login seguro utilizando tokens **JWT** (JSON Web Tokens) y Spring Security.
* **Gestión de Médicos y Pacientes:** Operaciones CRUD completas con validaciones de datos y paginación.
* **Agendamiento de Consultas:** Lógica de negocio avanzada para reservar y cancelar citas, incluyendo:
    * Asignación automática de un médico aleatorio disponible según la especialidad.
    * Validación de horarios de atención y anticipación mínima.
* **Documentación Interactiva:** Interfaz de Swagger UI integrada mediante SpringDoc OpenAPI.
* **Manejo de Errores:** Filtros globales para capturar excepciones y devolver respuestas HTTP estandarizadas (Problem Details).

## 🎨 Diseño de la Interfaz (Frontend)

La API fue construida para respaldar una aplicación. Puedes visualizar el prototipo interactivo y el diseño de las pantallas en Figma a través del siguiente enlace:
* [Prototipo del Proyecto Voll.med en Figma](https://www.figma.com/design/d2NSH19Xym1LXLSmTM8itB/Voll-Med?node-id=0-1&t=JWuMot4YSaOnKNOl-1)

## 🛠️ Tecnologías y Herramientas

* **Java 21**
* **Spring Boot 3.3.10** (Web, Data JPA, Security, Validation)
* **MySQL** (Base de datos relacional)
* **Flyway** (Migraciones de base de datos)
* **Auth0 java-jwt** (Generación y validación de tokens)
* **Lombok** (Reducción de código boilerplate)
* **SpringDoc OpenAPI** (Documentación Swagger)
* **JUnit 5 & Mockito** (Pruebas unitarias y de integración)

## ⚙️ Configuración y Ejecución Local

### Requisitos previos
* Java 21 instalado.
* Maven instalado (o usar el Wrapper incluido `./mvnw`).
* Servidor MySQL corriendo en el puerto 3306.

### Pasos de Instalación

1. Clonar el repositorio:
    ```bash
   git clone https://github.com/yamilrafart2/API-Vollmed
    ```
   
2. Configurar la base de datos:
   Configurar las credenciales en `src/main/resources/application.properties` o pasar las variables de entorno correspondientes.

3. Ejecutar el proyecto mediante Maven:
    ```bash
   ./mvnw spring-boot:run
    ```
   
4. Acceder a la documentación de la API (Swagger UI):
   Abrir el navegador en la siguiente ruta: `http://localhost:8080/swagger-ui.html`

## 🧪 Pruebas Automatizadas

El proyecto cuenta con un entorno de pruebas robusto que aísla la base de datos principal. Para ejecutar la suite de pruebas (Controladores y Repositorios):
```bash
./mvnw clean test
```

## 👨‍💻 Autor

Desarrollado por [Yamil Rafart](https://github.com/yamilrafart2)