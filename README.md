# AsyncTask

Ejercicio práctico donde se usa la anotación `@Async` que nos aporta Spring Boot. El ejercicio consiste en desarrollar un servicio rest que implemente tareas que tardan al rededor de 6 segundos en responder y posterior a ello se creó otro donde se implementa asincronía con el fin de reducir en un 50% el tiempo de ejecución de la tarea.

## End-Points

1. URL que implementa servicio sin procesos asincronos: `http://localhost:8080/api/products`

2. URL que implementa la asincronía: `http://localhost:8080/api/products/products-async`

