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

}
