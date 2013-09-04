import com.example.MultiTenantSessionFactoryBean
import com.example.MultiCurrentTenantIdentifierResolver
import com.example.MultiTenantConnectionProviderImpl
import com.example.ShouldBeInDB
import org.codehaus.groovy.grails.orm.hibernate.GrailsHibernateTransactionManager

beans = {

    transactionManager(GrailsHibernateTransactionManager) {
        sessionFactory = ref('sessionFactory')
        dataSource = ref('dataSource')
    }

    // UNCOMMENT THIS IN ORDER TO CREATE DB SCHEMA
//    sessionFactory(MultiTenantSessionFactoryBean) { bean ->
//        bean.parent = 'abstractSessionFactoryBeanConfig'
//        grailsApp = ref('grailsApplication')
//        dataSource = ref('dataSource')
//    }

//    multiCurrentTenantIdentifierResolver(MultiCurrentTenantIdentifierResolver) {
//        proxyTargetClass = true
//    }

//    multiTenantConnectionProviderImpl(MultiTenantConnectionProviderImpl) {
//        grailsApplication = ref('grailsApplication')
//    }
}
