package com.creditharmony.core.cms.entity;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import com.creditharmony.core.cms.utils.PolicyUtils;
import com.creditharmony.core.persistence.DataEntity;
import com.creditharmony.core.users.entity.Org;
import com.creditharmony.core.users.entity.Role;
import com.creditharmony.core.users.entity.User;
import com.google.common.collect.Lists;

/**
 * 文章Entity
 * @Class Name Article
 * @author 张岩
 * @Create In 2017年3月21日
 */
public class ArticlePolicy extends DataEntity<ArticlePolicy> {

    public static final String DEFAULT_TEMPLATE = "frontViewArticle";
	
	private static final long serialVersionUID = 1L;
	private CategoryPolicy categoryPolicy;			// 分类编号
	private String title;				// 标题
    private String link;				// 外部链接
	private String color;				// 标题颜色（red：红色；green：绿色；blue：蓝色；yellow：黄色；orange：橙色）
	private String image;				// 文章图片
	private String keywords;			// 关键字
	private String description;			// 描述、摘要
	private Integer weight;				// 权重，越大越靠前
	private Date weightDate;			// 权重期限，超过期限，将weight设置为0
	private Integer hits;				// 点击数
	private String posid;				// 推荐位，多选（1：首页焦点图；2：栏目页文章推荐；）
    private String customContentView;	// 自定义内容视图
   	private String viewConfig;			// 视图参数
	private ArticlePolicyData articlePolicyData;	// 文章副表
	
	private Date beginDate;				// 开始时间
	private Date endDate;				// 结束时间
	private Date releaseTime;
	private String pushFlag;
	private User user;
	private List<PolicyRoleOrg> policyRoleOrgList= Lists.newArrayList(); 
	private List<Role> roleList = Lists.newArrayList(); // 拥有角色列表
	private List<Org> orgList = Lists.newArrayList();   // 拥有的组织机构列表
	private String policyRoleOrgListString;
	
	public ArticlePolicy() {
		super();
		this.weight = 0;
		this.hits = 0;
		this.posid = "";
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getPushFlag() {
		return pushFlag;
	}

	public void setPushFlag(String pushFlag) {
		this.pushFlag = pushFlag;
	}

	public ArticlePolicy(String id){
		this();
		this.id = id;
	}
	
	public ArticlePolicy(CategoryPolicy categoryPolicy){
		this();
		this.categoryPolicy = categoryPolicy;
	}

	public void prePersist(){
		//TODO 后续处理，暂不知有何用处
		//super.prePersist();
		articlePolicyData.setId(this.id);
	}
	
	public CategoryPolicy getCategoryPolicy() {
		return categoryPolicy;
	}

	public void setCategoryPolicy(CategoryPolicy categoryPolicy) {
		this.categoryPolicy = categoryPolicy;
	}

	public String getPolicyRoleOrgListString() {
		return policyRoleOrgListString;
	}

	public void setPolicyRoleOrgListString(String policyRoleOrgListString) {
		this.policyRoleOrgListString = policyRoleOrgListString;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

    @Length(min=0, max=255)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

	@Length(min=0, max=50)
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Length(min=0, max=255)
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
        this.image = image;//CmsUtils.formatImageSrcToDb(image);
	}

	@Length(min=0, max=255)
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Length(min=0, max=255)
	public String getDescription() {
		return description;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@NotNull
	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Date getWeightDate() {
		return weightDate;
	}

	public void setWeightDate(Date weightDate) {
		this.weightDate = weightDate;
	}

	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

	@Length(min=0, max=10)
	public String getPosid() {
		return posid;
	}

	public void setPosid(String posid) {
		this.posid = posid;
	}

    public String getCustomContentView() {
        return customContentView;
    }

    public void setCustomContentView(String customContentView) {
        this.customContentView = customContentView;
    }

    public String getViewConfig() {
        return viewConfig;
    }

    public void setViewConfig(String viewConfig) {
        this.viewConfig = viewConfig;
    }

	public ArticlePolicyData getArticlePolicyData() {
		return articlePolicyData;
	}

	public void setArticlePolicyData(ArticlePolicyData articlePolicyData) {
		this.articlePolicyData = articlePolicyData;
	}

	public List<String> getPosidList() {
		List<String> list = Lists.newArrayList();
		if (posid != null){
			for (String s : StringUtils.split(posid, ",")) {
				list.add(s);
			}
		}
		return list;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setPosidList(List<String> list) {
		posid = ","+StringUtils.join(list, ",")+",";
	}

	public List<PolicyRoleOrg> getPolicyRoleOrgList() {
		return policyRoleOrgList;
	}

	public void setPolicyRoleOrgList(List<PolicyRoleOrg> policyRoleOrgList) {
		this.policyRoleOrgList = policyRoleOrgList;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<Org> getOrgList() {
		return orgList;
	}

	public void setOrgList(List<Org> orgList) {
		this.orgList = orgList;
	}
	
   	public String getUrl() {
        return PolicyUtils.getUrlDynamic(this);
   	}

}


