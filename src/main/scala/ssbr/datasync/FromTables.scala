package ssbr.datasync

import slick.driver.H2Driver.api._
import slick.lifted.ProvenShape
import slick.lifted.ProvenShape.proveShapeOf

class FromDept(tag: Tag)
  extends Table[(String, String, String, Int, Int, String,Int, String, String, Int)](tag,"post_dept") {
  
    def deptId: Rep[String] = column[String]("dept_id", O.PrimaryKey)
    def deptName: Rep[String] = column[String]("dept_name")
    def parId: Rep[String] = column[String]("par_id")
    def repProfile: Rep[Int] = column[Int]("rep_profile")
    def seq: Rep[Int] = column[Int]("seq")
    def updtDt: Rep[String] = column[String]("updt_dt")
    def useYn: Rep[Int] = column[Int]("use_yn")
    def deptNameFull: Rep[String] = column[String]("dept_name_full")
    def deptIdFull: Rep[String] = column[String]("dept_id_full")
    def svId: Rep[Int] = column[Int]("sv_id")
    
    def * : ProvenShape[(String, String, String, Int, Int, String,Int, String, String, Int)] = 
      (deptId, deptName, parId, 1, seq, updtDt, useYn, deptNameFull, deptIdFull, 1)
 }