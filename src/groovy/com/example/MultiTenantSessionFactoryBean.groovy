package com.example

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.orm.hibernate.ConfigurableLocalSessionFactoryBean
import org.hibernate.tool.hbm2ddl.SchemaExport

import javax.sql.DataSource
import java.sql.Connection
import java.sql.SQLException

class MultiTenantSessionFactoryBean extends ConfigurableLocalSessionFactoryBean {

    private Map<String, DataSource> dataSourceMap;
    GrailsApplication grailsApp

    @Override
    public void afterPropertiesSet() throws IOException {
        // create schema for the default dataSource
        dataSourceMap = [
                'dataSource': grailsApp.mainContext.getBean('dataSource')
//                ,
//                '1': grailsApp.mainContext.getBean('dataSource_1')
        ]
        println dataSourceMap

        super.afterPropertiesSet();

        for (Map.Entry<String, DataSource> entry : dataSourceMap.entrySet()) {

            Connection connection = null;

            try {

                connection = entry.getValue().getConnection();

                SchemaExport export = new SchemaExport(getConfiguration(), connection);
                export.setOutputFile(entry.getKey() + "-schema.sql");
                export.setDelimiter(";");

                //this must be changed in order to support create, validate etc
                export.execute(true, true, false, true);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setDataSourceMap(Map<String, DataSource> dataSourceMap) {
        this.dataSourceMap = dataSourceMap;
    }
}
