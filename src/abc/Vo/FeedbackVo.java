package abc.Vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class FeedbackVo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedbackId;
	
	@Column(name="Title")
	private String feedtitle;
	
	@Column(name="Feedback")
	private String feedback;

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedtitle() {
		return feedtitle;
	}

	public void setFeedtitle(String feedtitle) {
		this.feedtitle = feedtitle;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

}
