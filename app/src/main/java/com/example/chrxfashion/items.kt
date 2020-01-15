package com.example.chrxfashion

class item {
    var name: String?=null
    var desc: String?=null
    var image: Int?=null

    //constructor to initilise the class
    constructor(name:String,desc:String,image: Int) {  //this is a construdctore with three parameters
    this.name=name
        this.desc=desc
        this.image=image
    }
}