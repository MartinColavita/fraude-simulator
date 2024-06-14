package com.example.fraudesimulator.controller;


import com.example.fraudesimulator.model.Merchant;
import com.example.fraudesimulator.response.ResponseMerchant;
import com.example.fraudesimulator.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


/**
 * Esta es la clase MerchantController. Su principal responsabilidad es manejar las solicitudes HTTP relacionadas con los comerciantes.
 * Proporciona endpoints para verificar si una transacción es fraudulenta.
 */
@RestController
@RequestMapping("/api/merchants")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;


    /**
     * Este método se utiliza para verificar si una transacción es fraudulenta.
     * Se accede a través de una solicitud POST a /api/merchants/transaction.
     *
     * @param body Un objeto JSON que contiene el ID del terminal del comerciante.
     * @return Un objeto JSON
     * con un campo "success" que indica si la transacción fue aprobada o no, y un campo "message" con un mensaje descriptivo.
     */
    @PostMapping("/transaction")
    public ResponseMerchant checkTransaction(@RequestBody Map<String, String> body) {
        String terminalId = body.get("terminalId");
        boolean isFraud = merchantService.isFraudulentTransaction(terminalId);
        if (isFraud) {
            return new ResponseMerchant(false, "Transaction denied: Possible fraud detected.");
        }
        return new ResponseMerchant(true, "Transaction approved.");
    }


    /**
     * Este método se utiliza para obtener todos los comerciantes.
     * Se accede a través de una solicitud GET a /api/merchants.
     *
     * @return Una lista de todos los comerciantes.
     */
    @GetMapping
    public List<Merchant> getAllMerchants() {
        return merchantService.getAllMerchants();
    }

}

