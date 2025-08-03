package com.system.subscriptionmembershipmanagement.contollers;

import com.system.subscriptionmembershipmanagement.dtos.CreatePlanRequest;
import com.system.subscriptionmembershipmanagement.dtos.UpdatePlanRequest;
import com.system.subscriptionmembershipmanagement.services.PlanService;
import com.system.subscriptionmembershipmanagement.utils.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plans")
@PreAuthorize("hasRole('ADMIN')")
@AllArgsConstructor
@Tag(name = "Plans", description = "Endpoints for managing Plans plans (Admin only)")
@SecurityRequirement(name = "bearerAuth")
public class PlanController {
    private final PlanService planService;

    @PostMapping()
    @Operation(
            summary = "Create a new subscription plan",
            description = "Creates a new subscription plan. Only accessible to admins."
    )
    public ResponseEntity<?> createPlan(@Valid @RequestBody CreatePlanRequest request) {
        var response = planService.createPlan(request);
        return ResponseUtil.success("Created Plan Successfully", response, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    @Operation(
            summary = "Update a subscription plan",
            description = "Updates an existing subscription plan by ID. Only accessible to admins."
    )
    public ResponseEntity<?> updatePlan(@PathVariable(name = "id") Long planId, @Valid @RequestBody UpdatePlanRequest request) {
        var response = planService.updatePlan(planId, request);
        return ResponseUtil.success("Updated Plan Successfully", response);
    }


    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a subscription plan",
            description = "Deletes a subscription plan by ID. Only accessible to admins."
    )
    public ResponseEntity<?> deletePlan(@PathVariable(name = "id") Long planId) {
        planService.deletePlan(planId);
        return ResponseUtil.success("deleted Plan Successfully", planId);
    }

}
