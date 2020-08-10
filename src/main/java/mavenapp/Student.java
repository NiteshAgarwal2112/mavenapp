package mavenapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tbl_stud")
public class Student {
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
      private long studid;
      private String studname;
      private String studbranch;
      private String studsem;
	public String getStudname() {
		return studname;
	}
	public void setStudname(String studname) {
		this.studname = studname;
	}
	public String getStudbranch() {
		return studbranch;
	}
	public void setStudbranch(String studbranch) {
		this.studbranch = studbranch;
	}
	public String getStudsem() {
		return studsem;
	}
	public void setStudsem(String studsem) {
		this.studsem = studsem;
	}
	@Override
	public String toString() {
		return "Student [studid=" + studid + ", studname=" + studname + ", studbranch=" + studbranch + ", studsem="
				+ studsem + "]";
	}
	
}
