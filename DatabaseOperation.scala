package edu.knoldus

/**
  * Created by prashant on 01-02-2017.
  */


import java.sql.{Connection, DriverManager}


class DatabaseOperation

class Department {

  val driver: String = "com.mysql.jdbc.Driver"
  val url: String = "jdbc:mysql://localhost/knoldus"
  val username: String = "root"
  val password: String = "root"
  // make the connection
  Class.forName(driver)
  var connection: Connection = _

  connection = DriverManager.getConnection(url, username, password)
  // creating  the statement, and running the select query
  val statement = connection.createStatement

  def insertion(d_id: String, d_name: String): Boolean = {
    try {
      statement.executeUpdate("Insert into department values(" + "'" + d_id + "'" + "," + "'" + d_name + "'" + ")")
      true
    } catch {
      case e: Exception => e.printStackTrace(); false
    }
  }

  def retrieval: Boolean = {
    try {
      val resultSet = statement.executeQuery("SELECT d_id , d_name FROM department")
      while (resultSet.next) {
        val id = resultSet.getString("d_id")
        val d_name = resultSet.getString("d_name")
        println("Department Id = " + id + " , Department Name = " + d_name)
      }
      true
    } catch {
      case e: Exception => e.printStackTrace(); false
    }
  }

  //connection.close()
}

class Project() {

  val driver = "com.mysql.jdbc.Driver"
  val url = "jdbc:mysql://localhost/knoldus"
  val username = "root"
  val password = "root"
  var connection: Connection = _
  // make the connection
  Class.forName(driver)
  connection = DriverManager.getConnection(url, username, password)
  // creating  the statement, and running the select query
  val statement = connection.createStatement

  def insert(p_id: String, dept_id: String, p_name: String, client_id: String): Boolean = {
    try {
      statement.executeUpdate("Insert into project values(" + "'" + p_id + "'" + "," + "'" + dept_id + "'" + ","
        + "'" + p_name + "'" + "," + "'" + client_id + "'" + ")")
      true
    } catch {
      case e: Exception => e.printStackTrace(); false
    }
  }

  def retrieval: Boolean = {
    try {
      val resultSet = statement.executeQuery("SELECT p_id , dept_id , p_name , client_id FROM project")
      while (resultSet.next) {
        val id = resultSet.getString("p_id")
        val d_id = resultSet.getString("dept_id")
        val p_name = resultSet.getString("p_name")
        val client_id = resultSet.getString("client_id")
        println("Project Id = " + id + " , Department Id = " + d_id + " Project Name= " + p_name + " Client Id=" + client_id)
      }
      true
    } catch {
      case e: Exception => e.printStackTrace(); false
    }
  }

  //connection.close()
}


object ScalaJdbcConnect {

  def main(args: Array[String]) {

    val d_obj = new Department
    val p_obj = new Project
    d_obj.insertion("d6", "office")
    d_obj.retrieval
    p_obj.insert("p2", "d2", "OS", "c2")
    p_obj.retrieval

  }

}
