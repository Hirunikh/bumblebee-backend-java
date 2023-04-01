package com.hiruni.bumblebee.loyalty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoyaltyService {
    private final LoyaltyRepository loyaltyRepository;

    @Autowired
    public LoyaltyService(LoyaltyRepository loyaltyRepository) {
        this.loyaltyRepository = loyaltyRepository;
    }

    public void addNewLoyalty(Loyalty loyalty) {
        loyaltyRepository.save(loyalty);
    }


    public List<Loyalty> getLoyalty() {
        return loyaltyRepository.findAll();
    }
}
