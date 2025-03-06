# Hotel Management API
## Descripción
Esta es una API REST para la gestión de hoteles desarrollada en Java con Spring Boot y JPA. La aplicación maneja entidades como Customer, Employee, Reservation, Payment y Room, permitiendo su creación, actualización, eliminación y consulta.

## Prerrequisitos
Asegúrate de tener instalados los siguientes requisitos antes de ejecutar la aplicación:

Docker
Docker Compose
Java 17+
Maven

## Instalación y ejecución

### 1. Levantar los contenedores con Docker
La aplicación depende de servicios como la base de datos, que se manejan con Docker.  
Para iniciarlos, ejecuta el siguiente comando en la raíz del proyecto:

```sh
docker compose up -d
```

### 2. Ejecutar la aplicación Spring Boot  
Una vez que los contenedores están en ejecución, inicia la aplicación Spring Boot desde el archivo principal.

### Opción 1: Desde un IDE (IntelliJ, Eclipse, VS Code)  
1. Abre el proyecto en tu IDE favorito.  
2. Encuentra la clase `MainApplication` (o el nombre de tu clase principal).  
3. Ejecuta la aplicación.

### 3. Verificar que la API está funcionando  
Una vez que la aplicación está corriendo, puedes verificar que la API responde correctamente accediendo a:  

```sh
[docker compose up -d](http://localhost:4500/api/customers/getCustomers)
```

O usando herramientas como **Postman** :

```bash
GET http://localhost:8080/api/customers/getCustomers
```
