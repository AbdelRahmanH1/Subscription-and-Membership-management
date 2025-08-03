package com.system.subscriptionmembershipmanagement.contollers;

import com.system.subscriptionmembershipmanagement.services.SubscriptionService;
import com.system.subscriptionmembershipmanagement.utils.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscriptions")
@AllArgsConstructor
@Tag(name = "Subscriptions", description = "Endpoints for managing user subscriptions")
@SecurityRequirement(name = "bearerAuth")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @PostMapping("/{planId}")
    @Operation(
            summary = "Subscribe to a plan",
            description = "Subscribes the current user to a plan by plan ID"
    )
    public ResponseEntity<?> subscribeToPlan(@PathVariable Long planId) {
        var response = subscriptionService.subscribe(planId);
        return ResponseUtil.success("Subscription has been subscribed", response);
    }

    @PutMapping("/cancel")
    @Operation(
            summary = "Cancel current subscription",
            description = "Cancels the current active subscription for the logged-in user"
    )
    public ResponseEntity<?> getSubscription(){
        var response = subscriptionService.cancelSubscription();
        return ResponseUtil.success("Subscription has been cancelled", response);
    }
    @GetMapping()
    @Operation(
            summary = "Get active subscription",
            description = "Returns the current active subscription for the logged-in user"
    )
    public ResponseEntity<?> getMyActiveSubscription(){
        var response = subscriptionService.getMySubscription();
        return ResponseUtil.success("Get my subscribe", response);
    }
}
