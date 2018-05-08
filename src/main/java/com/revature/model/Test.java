package com.revature.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table()
public class Test {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqname")
	@SequenceGenerator(initialValue=1, sequenceName="seq_name", allocationSize=1, name="seqname")
	private int tid;
	@Column(name="testName", nullable=false)
	private String testName;
	@Column(name="status")
	private String status;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time", nullable = false, 
	columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP")
	private Date timestamp = new Date();
	public int getTid() {
		return tid;
	}
	public Test() {
		super();
	}
	
	public Test(String testName, String status) {
		super();
		this.testName = testName;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Test [tid=" + tid + ", testName=" + testName + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((testName == null) ? 0 : testName.hashCode());
		result = prime * result + tid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (testName == null) {
			if (other.testName != null)
				return false;
		} else if (!testName.equals(other.testName))
			return false;
		if (tid != other.tid)
			return false;
		return true;
	}
	public Test(int tid, String testName, String status) {
		super();
		this.tid = tid;
		this.testName = testName;
		this.status = status;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
