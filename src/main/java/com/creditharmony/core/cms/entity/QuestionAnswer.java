package com.creditharmony.core.cms.entity;


import com.creditharmony.core.persistence.DataEntity;

public class QuestionAnswer  extends DataEntity<QuestionAnswer>{
    /**
	 * 
	 */
	private static final long serialVersionUID = -122354202454179229L;

	private String id;

    private String question;

    private String keyword;

    private String answer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }
}