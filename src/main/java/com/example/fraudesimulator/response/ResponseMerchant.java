package com.example.fraudesimulator.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Esta es la clase ResponseMerchant. Representa la respuesta de una transacción.
 * Contiene un indicador de éxito y un mensaje.
 */
@Data
@AllArgsConstructor @NoArgsConstructor
public class ResponseMerchant {
    private boolean success;            // Indica si la transacción fue exitosa
    private String message;             // El mensaje de la respuesta
}