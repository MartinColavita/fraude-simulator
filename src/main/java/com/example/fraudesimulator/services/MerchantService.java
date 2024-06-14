package com.example.fraudesimulator.services;

import com.example.fraudesimulator.model.Merchant;
import com.example.fraudesimulator.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

/**
 * Esta es la clase MerchantService. Su principal responsabilidad es manejar las operaciones relacionadas con los comerciantes.
 * Esto incluye la detección de transacciones fraudulentas.
 */
@Service
public class MerchantService {

    @Autowired
    private MerchantRepository merchantRepository;


    /**
     * Este método se utiliza para verificar si una transacción es fraudulenta.
     * Una transacción se considera fraudulenta si el tiempo entre la última transacción y la actual es menor a 10 segundos.
     *
     * @param terminalId El ID del terminal del comerciante.
     * @return Verdadero si la transacción es fraudulenta, falso en caso contrario.
     */
    public boolean isFraudulentTransaction(String terminalId) {
        // Buscamos al comerciante por su ID de terminal
        Optional<Merchant> optionalMerchant = merchantRepository.findByTerminalId(terminalId);

        // Si el comerciante existe
        if (optionalMerchant.isPresent()) {
            Merchant merchant = optionalMerchant.get();
            LocalDateTime now = LocalDateTime.now();

            // Si el tiempo entre la última transacción y la actual es menor a 10 segundos
            if (merchant.getLastTransactionTime() != null && ChronoUnit.SECONDS.between(merchant.getLastTransactionTime(), now) < 10) {
                // Actualizamos el tiempo de la última transacción y guardamos al comerciante
                merchant.setLastTransactionTime(now);
                merchantRepository.save(merchant);
                // Retornamos verdadero ya que la transacción es fraudulenta
                return true;
            }

            // Actualizamos el tiempo de la última transacción y guardamos al comerciante
            merchant.setLastTransactionTime(now);
            merchantRepository.save(merchant);
        } else {
            // Si el comerciante no existe, creamos uno nuevo y lo guardamos
            Merchant newMerchant = new Merchant();
            newMerchant.setTerminalId(terminalId);
            newMerchant.setLastTransactionTime(LocalDateTime.now());
            merchantRepository.save(newMerchant);
        }

        // Retornamos falso ya que la transacción no es fraudulenta
        return false;
    }


    /**
     * Este método se utiliza para obtener todos los comerciantes almacenados en el sistema.
     *
     * @return Una lista de todos los comerciantes.
     */
    public List<Merchant> getAllMerchants() {
        return merchantRepository.findAll();
    }

}