package com.creditharmony.core.cms.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.creditharmony.common.util.Global;
import com.creditharmony.core.persistence.DataEntity;

/**
 * 文章Entity
 * @Class Name ArticlePolicyData
 * @author 张岩
 * @Create In 2017年3月21日
 */
public class ArticlePolicyData extends DataEntity<ArticlePolicyData> {

	private static final long serialVersionUID = 1L;
	private String id;			// 编号
	private String docId;		// 内容
	private String filePath;	// 来源
	private String url;	// 相关文章
	private String allowComment;// 是否允许评论
	private String fileName;
	private ArticlePolicy articlePolicy;
	
	public ArticlePolicyData() {
		super();
		this.allowComment = Global.YES;
	}
	
	public ArticlePolicyData(String id){
		this();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Length(min=1, max=1)
	public String getAllowComment() {
		return allowComment;
	}

	public void setAllowComment(String allowComment) {
		this.allowComment = allowComment;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ArticlePolicy getArticlePolicy() {
		return articlePolicy;
	}

	public void setArticlePolicy(ArticlePolicy articlePolicy) {
		this.articlePolicy = articlePolicy;
	}
}