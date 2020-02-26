package com.bookshare.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Subject")
public class Subject {
		
		@Id
		@Column(name = "subjectId",length = 3)
		private int subjectId;
		
		@Column(name="subjectName",length = 10,nullable = false)
		private String subjectName;
		
		@Column(name="subjectCode",length = 7,nullable = false)
		private String subjectCode;
		
		@Column(name="semester",length = 1,nullable = false)
		private String semester;
		
		@ManyToOne
		private Branch branch;

		public int getSubjectId() {
			return subjectId;
		}

		public void setSubjectId(int subjectId) {
			this.subjectId = subjectId;
		}

		public String getSubjectName() {
			return subjectName;
		}

		public void setSubjectName(String subjectName) {
			this.subjectName = subjectName;
		}

		public String getSubjectCode() {
			return subjectCode;
		}

		public void setSubjectCode(String subjectCode) {
			this.subjectCode = subjectCode;
		}

		public String getSemester() {
			return semester;
		}

		public void setSemester(String semester) {
			this.semester = semester;
		}

		public Branch getBranch() {
			return branch;
		}

		public void setBranch(Branch branch) {
			this.branch = branch;
		}

}
