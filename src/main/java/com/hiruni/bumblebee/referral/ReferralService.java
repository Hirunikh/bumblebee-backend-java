package com.hiruni.bumblebee.referral;

import com.hiruni.bumblebee.customers.Customers;
import com.hiruni.bumblebee.customers.CustomersRepository;
import com.hiruni.bumblebee.customers.CustomersService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.List;
@Service
public class ReferralService {

    private final ReferralRepository referralRepository;

    @Autowired
    public ReferralService(ReferralRepository referralRepository) {
        this.referralRepository = referralRepository;
    }

    public void addNewReferral(Referral referral) {
        referralRepository.save(referral);
    }

    public List<Referral> getReferral() {
        return referralRepository.findAll();
    }
}
