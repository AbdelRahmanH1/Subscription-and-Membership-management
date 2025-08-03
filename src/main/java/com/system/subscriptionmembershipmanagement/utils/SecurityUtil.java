package com.system.subscriptionmembershipmanagement.utils;

import com.system.subscriptionmembershipmanagement.security.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static Long getUserId(){
        var userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getId();
    }
}
