package com.creditharmony.core.persistence;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import com.creditharmony.common.util.IdGen;
import com.creditharmony.core.users.util.UserUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 数据Entity类
 * @Class Name DataEntity
 * @author 张永生
 * @Create In 2015年12月15日
 * @param <T>
 */
public class DataEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = 1L;
	
	protected String remarks;	// 备注
	protected String createBy;	// 创建者
	protected Date createTime;	// 创建时间
	protected String modifyBy;	// 更新者
	protected Date modifyTime;	// 更新时间
	protected String delFlag; 	// 删除标记（0:正常;1:删除）
	private String verTime;     // 取modifyTime
	
	public DataEntity() {
		super();
		this.delFlag = DEL_FLAG_NORMAL;
	}
	
	public DataEntity(String id) {
		super(id);
	}
	
	/**
	 * 插入之前执行方法，需要手动调用
	 */
	@Override
	public void preInsert() {
		// 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
		if (!this.isNewRecord){
			setId(IdGen.uuid());
		}
		String userId = UserUtils.getUserId();
		if (StringUtils.isNotBlank(userId)){
			setCreateBy(userId);
			setModifyBy(userId);
		}
		setCreateTime(new Date());
		setModifyTime(getCreateTime());
	}
	
	/**
	 * 更新之前执行方法，需要手动调用
	 */
	@Override
	public void preUpdate() {
		String userId = UserUtils.getUserId();
		if (StringUtils.isNotBlank(userId)){
			setModifyBy(userId);
		}
		setModifyTime(new Date());
	}
	
	@Length(min=0, max=255)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@JsonIgnore
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@JsonIgnore
	public String getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	public void create(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	@JsonIgnore
	@Length(min=1, max=1)
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getVerTime() {
		return verTime;
	}

	public void setVerTime(String verTime) {
		this.verTime = verTime;
	}
	
	
}
