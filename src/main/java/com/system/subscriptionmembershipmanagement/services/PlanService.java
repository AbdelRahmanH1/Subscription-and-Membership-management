package com.system.subscriptionmembershipmanagement.services;

import com.system.subscriptionmembershipmanagement.dtos.CreatePlanRequest;
import com.system.subscriptionmembershipmanagement.dtos.PlanResponse;
import com.system.subscriptionmembershipmanagement.dtos.UpdatePlanRequest;
import com.system.subscriptionmembershipmanagement.exceptions.DuplicateResourceException;
import com.system.subscriptionmembershipmanagement.exceptions.PlanNotFound;
import com.system.subscriptionmembershipmanagement.mappers.PlanMapper;
import com.system.subscriptionmembershipmanagement.repositories.PlanRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlanService {
    private final PlanMapper planMapper;
    private final PlanRepository planRepository;
    // creating
    // updating
    // deleting

    @Transactional
    public PlanResponse createPlan(CreatePlanRequest request) {

        if(planRepository.existsByNameIgnoreCase(request.name())){
            throw new DuplicateResourceException();
        }
        var plan = planMapper.toEntity(request);
        planRepository.save(plan);
        return  planMapper.toDto(plan);
    }

    public PlanResponse updatePlan(Long planId, UpdatePlanRequest request) {
        var plan = planRepository.findById(planId).orElseThrow(PlanNotFound::new);
        planMapper.updatePlan(request,plan);
        planRepository.save(plan);
        return  planMapper.toDto(plan);
    }

    @Transactional
    public void deletePlan(Long planId) {
        int deleted =  planRepository.deleteByIdIfExists(planId);
        if(deleted == 0){
            throw new PlanNotFound();
        }

    }
}
