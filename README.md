# Simulador de Detección de Fraude

Esta aplicación es un simulador de detección de fraude para transacciones de comerciantes. Está construida con Java y Spring Boot y proporciona una API REST para interactuar con ella.

La aplicación mantiene un registro de comerciantes, cada uno identificado por un ID de terminal. Cada comerciante tiene asociado un registro del tiempo de su última transacción.

La funcionalidad principal de la aplicación es la detección de transacciones fraudulentas. Una transacción se considera fraudulenta si el tiempo entre la última transacción y la actual es menor a 10 segundos. Esta lógica se implementa en el método `isFraudulentTransaction(String terminalId)` de la clase `MerchantService`. Si se detectan reiterados intentos de transacción desde el mismo ID de terminal en un intervalo de menos de 10 segundos, la transacción se considera fraudulenta.

La aplicación expone dos endpoints principales:

1. `POST /api/merchants/transaction`: Este endpoint acepta un objeto JSON que contiene el ID del terminal del comerciante. Devuelve un objeto JSON con un campo "success" que indica si la transacción fue aprobada o no, y un campo "message" con un mensaje descriptivo.

   URL completa para pruebas: `http://localhost:8080/api/merchants/transaction`

   Ejemplo de solicitud:
   ```json
   {
       "terminalId": "T123"
   }
    ```
    Ejemplo de respuesta:
    ```json
    {
        "success": true,
        "message": "Transaction approved"
    }
    ```  
   
2. `GET /api/merchants`: Este endpoint devuelve un objeto JSON con un campo "merchants" que contiene un arreglo con todos los comerciantes registrados en la aplicación y el tiempo de su última transacción.
      
     URL completa para pruebas: `http://localhost:8080/api/merchants`
        
     Ejemplo de respuesta:
     ```json
     {
         "merchants": [
             {
                 "terminalId": "T123",
                 "lastTransactionTime": "2021-07-01T12:00:00"
             },
             {
                 "terminalId": "T456",
                 "lastTransactionTime": "2021-07-01T12:00:10"
             }
         ]
     }
     ``` 
   

# SWAGGER
Para acceder a la documentación de la API, se puede ingresar a la siguiente URL: `http://localhost:8080/fraude-simulator/swagger-ui.html`
   