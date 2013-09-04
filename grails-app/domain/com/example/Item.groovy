package com.example

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Version;

//@Entity
class Item {

//    @Column(name = 'name', nullable = false)
    String name

//    @Id
//    @GeneratedValue
    Long id

//    @Version
//    @Column(nullable = false)
    Long version
}
