package com.example


import org.hibernate.context.spi.CurrentTenantIdentifierResolver

import javax.servlet.http.HttpServletRequest

class MultiCurrentTenantIdentifierResolver implements CurrentTenantIdentifierResolver {

    //HttpServletRequest request

    @Override
    String resolveCurrentTenantIdentifier() {
        println "MultiCurrentTenantIdentifierResolver.resolveCurrentTenantIdentifier"
        return "1"
    }

    @Override
    boolean validateExistingCurrentSessions() {
        println "MultiCurrentTenantIdentifierResolver.validateExistingCurrentSessions"
        return false
    }
}
