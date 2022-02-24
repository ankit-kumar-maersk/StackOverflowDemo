package com.stackOverflow.project.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VoteTypes")

public class VoteTypes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long votetype_id;

	@Column(name = "vote_name", nullable = false)
	private String VoteName;

	public long getVote_id() {
		return votetype_id;
	}

	public void setVote_id(long vote_id) {
		this.votetype_id = vote_id;
	}

	public String getVoteName() {
		return VoteName;
	}

	public void setVoteName(String voteName) {
		VoteName = voteName;
	}
}
