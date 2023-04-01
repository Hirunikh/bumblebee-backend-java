package com.hiruni.bumblebee.loyalty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/V1/Loyalty")
public class LoyaltyController {
    private  final LoyaltyService loyaltyService;

    @Autowired
    public LoyaltyController(LoyaltyService loyaltyService) {
        this.loyaltyService = loyaltyService;
    }

    @GetMapping
    public List<Loyalty> getLoyalty() {
        return loyaltyService.getLoyalty();
    }

    @PostMapping
    public void CreateNewLoyalty(@RequestBody Loyalty loyalty) {
        loyaltyService.addNewLoyalty(loyalty);
    }
}
