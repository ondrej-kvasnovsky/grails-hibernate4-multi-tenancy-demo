import com.example.Item
import com.example.Tenant
import groovy.sql.Sql
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.hibernate.SessionFactory
import org.hibernate.tool.hbm2ddl.SchemaExport

import javax.sql.DataSource

class BootStrap {

    def grailsApplication
    def dataSource

    def init = { servletContext ->
        def connection = dataSource.connection
        def sessionFactory = grailsApplication.mainContext.getBean('&sessionFactory')
        SchemaExport export = new SchemaExport(sessionFactory.configuration, connection)
        export.outputFile = 'dataSource-schema.sql'
        export.delimiter = ';'
        //this must be changed in order to support create, validate etc
        export.execute(true, true, false, true)
    }

//    GrailsApplication grailsApplication

//    def init = { servletContext ->
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
//    }
    def destroy = {
    }
}
