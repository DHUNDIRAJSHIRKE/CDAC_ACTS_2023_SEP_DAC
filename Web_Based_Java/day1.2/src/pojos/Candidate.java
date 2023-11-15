package pojos;

public class Candidate {
	private int CandidateId;
	private String name;
	private String party;
	private int votes;

	public Candidate(int candidateId, String name, String party, int votes) {
		super();
		CandidateId = candidateId;
		this.name = name;
		this.party = party;
		this.votes = votes;
	}

	public int getCandidateId() {
		return CandidateId;
	}

	public void setCandidateId(int candidateId) {
		CandidateId = candidateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "Candidate [CandidateId=" + CandidateId + ", name=" + name + ", party=" + party + ", votes=" + votes
				+ "]";
	}

}
