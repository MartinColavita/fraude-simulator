package com.example.fraudesimulator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


/**
 * Esta es la clase Merchant. Representa a un comerciante en el sistema.
 * Cada comerciante se identifica por su ID de terminal y tiene un registro del tiempo de su última transacción.
 */
@Data
@AllArgsConstructor @NoArgsConstructor
public class Merchant {
    private String terminalId;                             // El ID del terminal del comerciante
    private LocalDateTime lastTransactionTime;            // El tiempo de la última transacción del comerciante
    private String merchantName;                         // El nombre del comerciante
    private String address;                             // La dirección del comerciante
    private String latitude;                           // La latitud del comerciante
    private String longitude;                         // La longitud del comerciante
}