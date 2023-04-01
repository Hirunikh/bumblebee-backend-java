package com.hiruni.bumblebee.referral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/V1/Referral")
public class ReferralController {

    private  final ReferralService referralService;

    @Autowired
    public ReferralController(ReferralService referralService) {
        this.referralService = referralService;
    }

    @GetMapping
    public List<Referral> getReferral() {
        return referralService.getReferral();
    }

    @PostMapping
    public void CreateNewReferral(@RequestBody Referral referral) {
        referralService.addNewReferral(referral);
    }
}
