package com.hibernate.model.onetomany;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;
	private String name;
	private String author;

	@Enumerated(EnumType.ORDINAL)
	private SkillLevel level;
	private String description;
	private String prereqs;
	private BigDecimal fee;
	private String endGoal;
	private String type;

	@ManyToMany(fetch = FetchType.LAZY, cascade =
        { CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        },targetEntity=Student.class)
	@JoinTable(name = "Student_Course", joinColumns = {
			@JoinColumn(name = "CourseId", nullable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "StudentId", nullable = false) })
	private List<Student> students = new ArrayList<>();
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// @OrderColumn(name="idx")
	@OrderColumn
	//@Fetch(FetchMode.JOIN) // JOIN(one query to get both course and topic),SELECT(two queries to get course and topic)
	private List<Topic> topics = new ArrayList<>();

	private LocalDateTime createdDateTime;

	@Version
	private LocalDateTime updatedDateTime;

	@Transient
	private String authorFullName;

	public Course() {

	}

	public Course(String name, String author, SkillLevel level, String description, String prereqs, BigDecimal fee,
			String endGoal, String type) {
		super();
		this.name = name;
		this.author = author;
		this.level = level;
		this.description = description;
		this.prereqs = prereqs;
		this.fee = fee;
		this.endGoal = endGoal;
		this.type = type;
		this.createdDateTime = LocalDateTime.now();
		this.updatedDateTime = LocalDateTime.now();
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public SkillLevel getLevel() {
		return level;
	}

	public void setLevel(SkillLevel level) {
		this.level = level;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrereqs() {
		return prereqs;
	}

	public void setPrereqs(String prereqs) {
		this.prereqs = prereqs;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public String getEndGoal() {
		return endGoal;
	}

	public void setEndGoal(String endGoal) {
		this.endGoal = endGoal;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Student> getStudents() {
		return students;
	}
	
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	public String getAuthorFullName() {
		return authorFullName;
	}

	public void setAuthorFullName(String authorFullName) {
		this.authorFullName = authorFullName;
	}

}
