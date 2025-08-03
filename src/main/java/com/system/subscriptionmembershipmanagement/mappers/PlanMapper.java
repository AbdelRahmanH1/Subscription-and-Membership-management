package com.system.subscriptionmembershipmanagement.mappers;

import com.system.subscriptionmembershipmanagement.dtos.CreatePlanRequest;
import com.system.subscriptionmembershipmanagement.dtos.PlanResponse;
import com.system.subscriptionmembershipmanagement.dtos.UpdatePlanRequest;
import com.system.subscriptionmembershipmanagement.entities.Plan;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PlanMapper {
    Plan toEntity(CreatePlanRequest request);
    PlanResponse toDto(Plan plan);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePlan(UpdatePlanRequest request,@MappingTarget Plan plan);
}
