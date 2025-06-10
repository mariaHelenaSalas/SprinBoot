# ☕ Trabajo CRUD con Spring Boot 

Este proyecto es una aplicación CRUD desarrollada con **Spring Boot**, cuyo propósito es gestionar personas mediante una API REST. La aplicación permite crear, consultar, actualizar y eliminar registros en una base de datos conectada mediante JPA (Hibernate).

---

## 🧰 Tecnologías utilizadas

- ⚙️ **Spring Boot**
- 🔧 **Spring Data JPA**
- 🐬 **MySQL**
- 🌐 **Spring Web**
- ☕ **Java 17**
- 🧪 **Postman** (para pruebas de la API)
- 🖥️ IDE: IntelliJ IDEA / VS Code

---

## 🚀 Funcionalidades

- 📥 Crear una nueva persona (`POST`)
- 📄 Consultar todas las personas (`GET`)
- 🔍 Consultar una persona por ID (`GET`)
- ✏️ Actualizar datos de una persona (`PUT`)
- 🗑️ Eliminar una persona (`DELETE`)

---

## 🗂️ Estructura del proyecto

```plaintext
└── src
    └── main
        └── java
            └── com.maria.sprinboot
                ├── controller     # Controladores REST
                ├── model          # Clase Persona
                ├── repository     # Interface JPA
                └── service        # Lógica de negocio
