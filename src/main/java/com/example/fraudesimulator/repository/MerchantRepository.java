package com.example.fraudesimulator.repository;

import com.example.fraudesimulator.model.Merchant;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;


/**
 * Esta es la clase MerchantRepository. La responsabilidad es manejar las operaciones de almacenamiento y recuperación de los comerciantes.
 * - Utiliza un Map para simular una base de datos en memoria.
 */
@Repository
public class MerchantRepository {
    // Map que simula una base de datos en memoria para los comerciantes
    private final Map<String, Merchant> merchantData = new HashMap<>();

    // Inicializa la base de datos en memoria con datos de ejemplo
    @PostConstruct
    public void init() {
        Merchant merchant1 = new Merchant();
        merchant1.setTerminalId("T123");
        merchant1.setMerchantName("Café Tortoni");
        merchant1.setAddress("Avenida de Mayo 825, Buenos Aires");
        merchant1.setLatitude("-34.6095");
        merchant1.setLongitude("-58.3807");
        merchantData.put(merchant1.getTerminalId(), merchant1);

        Merchant merchant2 = new Merchant();
        merchant2.setTerminalId("T456");
        merchant2.setMerchantName("Librería El Ateneo Grand Splendid");
        merchant2.setAddress("Avenida Santa Fe 1860, Buenos Aires");
        merchant2.setLatitude("-34.5956");
        merchant2.setLongitude("-58.3948");
        merchantData.put(merchant2.getTerminalId(), merchant2);

        Merchant merchant3 = new Merchant();
        merchant3.setTerminalId("T789");
        merchant3.setMerchantName("Pizzería Güerrin");
        merchant3.setAddress("Avenida Corrientes 1368, Buenos Aires");
        merchant3.setLatitude("-34.6037");
        merchant3.setLongitude("-58.3776");
        merchantData.put(merchant3.getTerminalId(), merchant3);
    }


    /**
     * Este método se utiliza para buscar un comerciante por su ID de terminal.
     *
     * @param terminalId El ID de terminal del comerciante.
     * @return Un objeto Optional que contiene al comerciante si se encuentra, o vacío en caso contrario.
     */
    public Optional<Merchant> findByTerminalId(String terminalId) {
        return Optional.ofNullable(merchantData.get(terminalId));
    }


    /**
     * Este método se utiliza para guardar un comerciante en la base de datos.
     *
     * @param merchant El comerciante a guardar.
     * @return El comerciante guardado.
     */
    public Merchant save(Merchant merchant) {
        merchantData.put(merchant.getTerminalId(), merchant);
        return merchant;
    }


    /**
     * Este método se utiliza para obtener todos los comerciantes almacenados en la base de datos.
     *
     * @return Una lista de todos los comerciantes.
     */
    public List<Merchant> findAll() {
        return new ArrayList<>(merchantData.values());
    }

}
