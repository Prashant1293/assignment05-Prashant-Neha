package edu.knoldus

import org.scalatest.FunSuite

/**
  * Created by prashant on 01-02-2017.
  */
class DatabaseTest extends FunSuite {
  val dept= new Department("d3","akka_dept")
  test ("insert") {
    assert(dept.insertion("d7","akka_dept")==true)
  }
  test("retrieve"){
    assert(dept.retrieval==true)
  }

}
