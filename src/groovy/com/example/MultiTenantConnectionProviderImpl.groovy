package com.example

import org.codehaus.groovy.grails.commons.ApplicationHolder
import org.hibernate.HibernateException
import org.hibernate.service.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl

import javax.sql.DataSource
import org.apache.commons.dbcp.BasicDataSource

class MultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

    @Override
    protected DataSource selectAnyDataSource() {
        def grailsApplication = ApplicationHolder.application
        def source = grailsApplication.mainContext.getBean('dataSource')
        println "selectAnyDataSource: " + source
        return source
    }

    @Override
    protected DataSource selectDataSource(String tenantIdentifier) {
//        DataSource dataSource =
//        long tenantId = Long.parseLong(tenantIdentifier)
//        if (tenantIdentifier <= 0) {
//            throw new HibernateException("Unknown tenant identifier")
//        }
//        Tenant dsInfo = Tenant.findById(tenantId)
//        if (!dsInfo || !dsInfo.url) {
//            throw new HibernateException("Unknown tenant identifier")
//        }
        // TODO: create JNDI and lookup
//        DataSource dataSource = new BasicDataSource()
//        dataSource.url = 'jdbc:h2:mem:dev1'
        DataSource dataSource = ApplicationHolder.application.mainContext.getBean('dataSource')
        return dataSource
    }
}