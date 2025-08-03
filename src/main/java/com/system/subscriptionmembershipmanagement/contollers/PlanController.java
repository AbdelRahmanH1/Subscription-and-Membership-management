package com.system.subscriptionmembershipmanagement.contollers;

import com.system.subscriptionmembershipmanagement.dtos.CreatePlanRequest;
import com.system.subscriptionmembershipmanagement.dtos.UpdatePlanRequest;
import com.system.subscriptionmembershipmanagement.services.PlanService;
import com.system.subscriptionmembershipmanagement.utils.ResponseUtil;
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
public class PlanController {
    private final PlanService planService;

    @PostMapping()
    public ResponseEntity<?> createPlan(@Valid @RequestBody CreatePlanRequest request) {
        var response = planService.createPlan(request);
        return ResponseUtil.success("Created Plan Successfully", response, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePlan(@PathVariable(name = "id") Long planId, @Valid @RequestBody UpdatePlanRequest request) {
        var response = planService.updatePlan(planId, request);
        return ResponseUtil.success("Updated Plan Successfully", response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlan(@PathVariable(name = "id") Long planId) {
        planService.deletePlan(planId);
        return ResponseUtil.success("deleted Plan Successfully", planId);
    }

}
