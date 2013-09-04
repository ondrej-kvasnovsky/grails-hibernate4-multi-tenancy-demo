import com.example.DomainInGroovySrc
import com.example.MultiTenantSessionFactoryBean
import com.example.MultiCurrentTenantIdentifierResolver
import com.example.MultiTenantConnectionProviderImpl
import org.codehaus.groovy.grails.orm.hibernate.GrailsHibernateTransactionManager

beans = {

//    sessionFactory(MultiTenantSessionFactoryBean) {
//        dataSource = ref('dataSource')
//        hibernateProperties = [
//                "hibernate.dialect": "org.hibernate.dialect.H2Dialect",
//                "hibernate.multiTenancy": "DATABASE",
//                "hibernate.tenant_identifier_resolver": ref('multiCurrentTenantIdentifierResolver'),
//                "hibernate.multi_tenant_connection_provider": ref('multiTenantConnectionProviderImpl'),
//                //"hibernate.hbm2ddl.auto": false,
//                "hibernate.show_sql": true
//        ]
//    }

    transactionManager(GrailsHibernateTransactionManager) {
        sessionFactory = ref('sessionFactory')
        dataSource = ref('dataSource')
    }

    multiCurrentTenantIdentifierResolver(MultiCurrentTenantIdentifierResolver) {
//        proxyTargetClass = true
    }

    multiTenantConnectionProviderImpl(MultiTenantConnectionProviderImpl) {
//        grailsApplication = ref('grailsApplication')
    }

//    sessionFactory(MultiTenantSessionFactoryBean) { bean ->
//        bean.parent = 'abstractSessionFactoryBeanConfig'
//        packagesToScan = ['com.example']
//        annotatedClasses = [DomainInGroovySrc]
//        grailsApp = ref('grailsApplication')
//        dataSource = ref('dataSource')
//    }

//    sessionFactory(AnnotationConfigurableLocalSessionFactoryBean) { bean ->
//        bean.parent = 'abstractSessionFactoryBeanConfig'
//        packagesToScan = ['com.example']
//        annotatedClasses = [Item]
//    }


}
