package ssbr.datasync

import slick.driver.MySQLDriver.api._
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.concurrent.ExecutionContext.Implicits.global

object SlicTest extends App {
  
  val db = Database.forConfig("fromdb")
  
  try {
    val dept: TableQuery[FromDept] = TableQuery[FromDept]
    val filterQuery = dept.filter(_.useYn === 1).map(_.useYn).sum /*.map(dept => (dept.deptId, dept.deptName, dept.parId, dept.seq, dept.deptIdFull, dept.deptNameFull))*/
//(deptId, deptName, parId, repProfile, seq, updtDt, useYn, deptNameFull, deptIdFull, svId)
    // Print the SQL for the filter query
    println("Generated SQL for filter query:\n" + filterQuery.result.statements)

    // Execute the query and print the Seq of results
    val combinedFuture = db.run(filterQuery.result).map(_.toList)
    
    val aList = Await.result(combinedFuture, Duration.Inf)
  
    println(aList)

    aList.foreach(println)

  } finally db.close
  
  
  println("end")
  
}