package com.creditharmony.core.cms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.cache.redis.util.RedisUtils;
import com.creditharmony.common.util.ArrayHelper;
import com.creditharmony.common.util.Global;
import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.cms.dao.ArticlePolicyDao;
import com.creditharmony.core.cms.dao.ArticlePolicyDataDao;
import com.creditharmony.core.cms.dao.CategoryPolicyDao;
import com.creditharmony.core.cms.dao.CmsPushDao;
import com.creditharmony.core.cms.dao.PolicyRoleOrgDao;
import com.creditharmony.core.cms.entity.Article;
import com.creditharmony.core.cms.entity.ArticlePolicy;
import com.creditharmony.core.cms.entity.ArticlePolicyData;
import com.creditharmony.core.cms.entity.Category;
import com.creditharmony.core.cms.entity.CategoryPolicy;
import com.creditharmony.core.cms.entity.PolicyRoleOrg;
import com.creditharmony.core.common.type.DeleteFlagType;
import com.creditharmony.core.common.util.PageUtil;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.mybatis.paginator.domain.PageList;
import com.creditharmony.core.persistence.Page;
import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.users.entity.Role;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.entity.UserRoleOrg;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 文章Manager
 * @Class Name ArticlePolicyManager
 * @author 张岩
 * @Create In 2017年3月22日
 */
@Service
public class ArticlePolicyManager extends CoreManager<ArticlePolicyDao, ArticlePolicy> {

	@Autowired
	private ArticlePolicyDataDao articlePolicyDataDao;
	@Autowired
	private CategoryPolicyDao categoryPolicyDao;
	@Autowired
	private CmsPushDao cmsPushDao;
	
	@Value("${portalLink}")
	private String portalLink;
	@Value("${frontPath}")
	private String frontPath;
	@Autowired
	private PolicyRoleOrgDao policyRoleOrgDao;
	
    @Transactional(readOnly = false)
	public Page<ArticlePolicy> findPage(Page<ArticlePolicy> page, ArticlePolicy articlePolicy, boolean isDataScopeFilter) {
		// 更新过期的权重，间隔为“6”个小时
		Date updateExpiredWeightDate =  (Date)RedisUtils.getObject("updateExpiredWeightDate");
		if (updateExpiredWeightDate == null || (updateExpiredWeightDate != null 
				&& updateExpiredWeightDate.getTime() < new Date().getTime())){
			dao.updateExpiredWeight(articlePolicy);
			RedisUtils.saveObject("updateExpiredWeightDate", DateUtils.addHours(new Date(), 6));
		}
        if (articlePolicy.getCategoryPolicy() != null
                && StringUtils.isNotBlank(articlePolicy.getCategoryPolicy().getId())
                && !Category.isRoot(articlePolicy.getCategoryPolicy().getId())) {
            CategoryPolicy categoryPolicy = categoryPolicyDao.get(articlePolicy.getCategoryPolicy().getId());
            if (categoryPolicy == null) {
                categoryPolicy = new CategoryPolicy();
            }
            categoryPolicy.setParentIds(categoryPolicy.getId());
            categoryPolicy.setSite(categoryPolicy.getSite());
            articlePolicy.setCategoryPolicy(categoryPolicy);
        } else {
            articlePolicy.setCategoryPolicy(new CategoryPolicy());
        }
		return super.findPage(page, articlePolicy);
	}
    
    @Transactional(readOnly = false)
  	public Page<ArticlePolicy> findPage(Page<ArticlePolicy> page, ArticlePolicy articlePolicy, List<Map<String,String>> orgRoleList) {
  		// 更新过期的权重，间隔为“6”个小时
  		Date updateExpiredWeightDate =  (Date)RedisUtils.getObject("updateExpiredWeightDateByArticle");
  		if (updateExpiredWeightDate == null || (updateExpiredWeightDate != null 
  				&& updateExpiredWeightDate.getTime() < new Date().getTime())){
  			dao.updateExpiredWeight(articlePolicy);
  			RedisUtils.saveObject("updateExpiredWeightDateByArticle", DateUtils.addHours(new Date(), 6));
  		}
  		Map<String, Object> filter = Maps.newHashMap();
  		filter.put("delFlag", "0");
  		filter.put("orgRoleList", orgRoleList);
  		filter.put("categoryPolicyId", articlePolicy.getCategoryPolicy().getId());
  		PageBounds pageBounds = new PageBounds(page.getPageNo(), page.getPageSize());
  		PageList<ArticlePolicy> pageList = (PageList<ArticlePolicy>) dao.findListByMap(filter, pageBounds);
  		PageUtil.convertPage(pageList, page);
  		return page;
  	}

	@Transactional(readOnly = false)
	public void save(ArticlePolicy articlePolicy) {
		// 如果栏目不需要审核，则将该内容设为发布状态
		if (articlePolicy.getCategoryPolicy()!=null&&StringUtils.isNotBlank(articlePolicy.getCategoryPolicy().getId())){
			CategoryPolicy categoryPolicy = categoryPolicyDao.get(articlePolicy.getCategoryPolicy().getId());
			articlePolicy.getCategoryPolicy().setOrg(categoryPolicy.getOrg());
			if (!Global.YES.equals(categoryPolicy.getIsAudit())&&!Article.DEL_FLAG_DELETE.equals(articlePolicy.getDelFlag())){
				articlePolicy.setDelFlag(Article.DEL_FLAG_NORMAL);
			}
		}
        ArticlePolicyData articlePolicyData = new ArticlePolicyData();;
		if (StringUtils.isBlank(articlePolicy.getId())){
			articlePolicy.preInsert();
			articlePolicyData = articlePolicy.getArticlePolicyData();
			articlePolicyData.setId(articlePolicy.getId());
			dao.insert(articlePolicy);
			articlePolicyDataDao.insert(articlePolicyData);
		}else{
			articlePolicy.preUpdate();
			articlePolicyData = articlePolicy.getArticlePolicyData();
			articlePolicyData.setId(articlePolicy.getId());
			dao.update(articlePolicy);
			articlePolicyDataDao.update(articlePolicy.getArticlePolicyData());
		}
		List<PolicyRoleOrg> policyRoleOrgList=new ArrayList<PolicyRoleOrg>();
		String policyRoleOrgListString=articlePolicy.getPolicyRoleOrgListString();
		String[] tmp;
		String[] tmp1;
		PolicyRoleOrg pro=new PolicyRoleOrg();
		if(policyRoleOrgListString!=null&&!policyRoleOrgListString.equals("")){
			tmp=policyRoleOrgListString.split(",");
			for(int i=0;i<tmp.length;i++){
				pro=new PolicyRoleOrg();
				tmp1=tmp[i].split("##");
				pro.setOrgId(tmp1[0]);
				pro.setRoleId(tmp1[1]);
				pro.setPolicyId(articlePolicy.getId());
				pro.preInsert();
				policyRoleOrgList.add(pro);
			}
		}
		Map<String,Object> delParams = Maps.newHashMap();
		delParams.put("policyId", articlePolicy.getId());
		policyRoleOrgDao.deletePolicyRoleOrg(delParams);
		policyRoleOrgDao.insertPolicyRoleOrg(policyRoleOrgList);		
	}
	
	@Transactional(readOnly = false)
	public void delete(ArticlePolicy articlePolicy, Boolean isRe) {
		articlePolicy.setDelFlag(isRe != null && isRe ? Article.DEL_FLAG_NORMAL : Article.DEL_FLAG_DELETE);
		dao.updateDelFlag(articlePolicy);
	}
	
	/**
	 * 通过编号获取内容标题
	 * @return new Object[]{栏目Id,文章Id,文章标题}
	 */
	public List<Object[]> findByIds(String ids) {
		if(ids == null){
			return new ArrayList<Object[]>();
		}
		List<Object[]> list = Lists.newArrayList();
		String[] idss = StringUtils.split(ids,",");
		ArticlePolicy e = null;
		for(int i=0;(idss.length-i)>0;i++){
			e = dao.get(idss[i]);
			list.add(new Object[]{e.getCategoryPolicy().getId(),e.getId(),StringUtils.abbr(e.getTitle(),50)});
		}
		return list;
	}
	
	/**
	 * 点击数加一
	 */
	@Transactional(readOnly = false)
	public void updateHitsAddOne(String id) {
		dao.updateHitsAddOne(id);
	}
	
	/**
	 * 更新索引
	 */
	public void createIndex(){
		//dao.createIndex();
	}
	
	public List<PolicyRoleOrg> getPolicyForOrg(String id) {
		List<PolicyRoleOrg> orgList = policyRoleOrgDao.selPolicyRoleOrg(id);
		List<PolicyRoleOrg> orgNewList = new ArrayList<PolicyRoleOrg>();
		Set<String> orgIdSet = new HashSet<String>();
		for(PolicyRoleOrg policyRoleOrgN:orgList){
			String orgId = policyRoleOrgN.getOrgId();
			if(orgIdSet.contains(orgId)){
				continue;
			}
			orgIdSet.add(orgId);
			List<Role> roles = new ArrayList<Role>();
			for(PolicyRoleOrg policyRoleOrgN2:orgList){
				if(orgId.equals(policyRoleOrgN2.getOrgId())){
					Role roleN = new Role();
					roleN.setId(policyRoleOrgN2.getRoleId());
					roleN.setName(policyRoleOrgN2.getRoleName());
					roles.add(roleN);
				}
			}
			policyRoleOrgN.setRoles(roles);
			orgNewList.add(policyRoleOrgN);
		}
		return orgNewList;
	}
	
	
}
