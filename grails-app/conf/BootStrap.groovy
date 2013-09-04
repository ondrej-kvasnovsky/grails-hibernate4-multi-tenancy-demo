import com.example.Item
import com.example.Tenant
import groovy.sql.Sql
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.hibernate.SessionFactory

import javax.sql.DataSource

class BootStrap {

    GrailsApplication grailsApplication

    def init = { servletContext ->
//        println 'Executing BootStrap'
//        SessionFactory sessionFactory = grailsApplication.mainContext.getBean('sessionFactory')
//        println 'sessionFactory: ' + sessionFactory
//        DataSource defaultDataSource = grailsApplication.mainContext.getBean('dataSource')
//        println 'dataSource: ' + defaultDataSource
//        println sessionFactory.openSession()

//        Item item = new Item(name: "something..")
//        item.save(failOnError: true)
//        def q = new Sql(defaultDataSource)
//        q.execute "insert into Item (url) values (?, ?)", ['jdbc:h2:mem:dev1']

//        Tenant ds1 = new Tenant(url: )
//        ds1.save(failOnError: true)
    }
    def destroy = {
    }
}
