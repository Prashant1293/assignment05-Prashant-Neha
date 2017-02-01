package edu.knoldus

/**
  * Created by prashant on 01-02-2017.
  */

//import java.lang.ClassNotFoundException
import java.sql.{Connection, DriverManager }

abstract class knoldus

class DatabaseOperation {

}

case class Department(d_id: String, d_name: String) extends knoldus {

  val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost/knoldus"
    val username = "root"
    val password = "root"

    var connection: Connection = _

    try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      // creating  the statement, and running the select query
      val statement = connection.createStatement()
      statement.executeUpdate("Insert into department values(" + "'"+d_id +"'"+","+"'"+d_name+"'" +")" )

      val resultSet = statement.executeQuery("SELECT d_id , d_name FROM department")
      while (resultSet.next()) {
        val id = resultSet.getString("d_id")
        val d_name = resultSet.getString("d_name")
        println("Department Id = " + id + " , Department Name = " + d_name)
      }
    } catch {
      case e: Exception => e.printStackTrace()
    }
    connection.close()
}

case class Project (p_id: String,dept_id:String, p_name: String , client_id :String) extends knoldus {

  val driver = "com.mysql.jdbc.Driver"
  val url = "jdbc:mysql://localhost/knoldus"
  val username = "root"
  val password = "root"

  var connection: Connection = _

  try {
    // make the connection
    Class.forName(driver)
    connection = DriverManager.getConnection(url, username, password)

    // creating  the statement, and running the select query
    val statement = connection.createStatement()

    statement.executeUpdate("Insert into project values("+"'"+p_id+"'"+","+"'"+dept_id+"'"+","+"'"+p_name+"'"+","+
      "'"+client_id+"'"+")" )


    val resultSet = statement.executeQuery("SELECT p_id , dept_id , p_name , client_id FROM department")
    while (resultSet.next()) {
      val id = resultSet.getString("p_id")
      val d_id = resultSet.getString("dept_id")
      val p_name = resultSet.getString("p_name")
      val client_id = resultSet.getString("client_id")
      println("Project Id = " + id + " , Department Id = " + d_id + " Project Name= "+p_name+" Client Id="+client_id)
    }
  } catch {
    case e: Exception => e.printStackTrace()
  }
  connection.close()
}



object ScalaJdbcConnect {

  def main(args: Array[String]) {

  Department("d6","office")
  Project("p2","d2","OS","c2")

  }

}
