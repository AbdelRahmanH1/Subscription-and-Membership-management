package com.system.subscriptionmembershipmanagement.contollers;

import com.system.subscriptionmembershipmanagement.services.SubscriptionService;
import com.system.subscriptionmembershipmanagement.utils.ResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscriptions")
@AllArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @PostMapping("/{planId}")
    public ResponseEntity<?> subscribeToPlan(@PathVariable Long planId) {
        var response = subscriptionService.subscribe(planId);
        return ResponseUtil.success("Subscription has been subscribed", response);
    }

    @PutMapping("/cancel")
    public ResponseEntity<?> getSubscription(){
        var response = subscriptionService.cancelSubscription();
        return ResponseUtil.success("Subscription has been cancelled", response);
    }
    @GetMapping()
    public ResponseEntity<?> getMyActiveSubscription(){
        var response = subscriptionService.getMySubscription();
        return ResponseUtil.success("Get my subscribe", response);
    }
}
