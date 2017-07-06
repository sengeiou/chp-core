package com.creditharmony.core.users.entity;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.creditharmony.core.common.type.UseableType;
import com.creditharmony.core.persistence.TreeEntity;

/**
 * 组织机构实体
 * @Class Name Org
 * @author 张永生
 * @Create In 2015年12月4日
 */
@SuppressWarnings("rawtypes")
public class Org extends TreeEntity<Org> implements Comparable {

	private static final long serialVersionUID = 1L;
	private Area area;					 // 归属区域
	private String code; 				 // 机构编码
	private String type; 				 // 机构类型
	private String typeId; 				 // 机构类型
	private String grade; 				 // 机构等级（1：一级；2：二级；3：三级；4：四级）
	private String address; 			 // 联系地址
	private String zipCode; 			 // 邮政编码
	private String master; 				 // 负责人
	private String phone; 				 // 电话
	private String fax; 				 // 传真
	private String email; 				 // 邮箱
	private String useable;              // 是否可用
	private String provinceId;           // 省份Id
	private String cityId;               // 城市Id
	private String districtId;           // 区县Id 
	private String partyType;            // 主体类型:用于描述该组织机构隶属于哪个主体,参见PartyType.java
	private String storeCode;            // 门店编码
	private Integer systemFlag;          // 系统标识
	private String creditPaperless = UseableType.YES;      // 信借是否无纸化, 1-是,0-否
	private String carPaperless =  UseableType.YES;        // 车借是否无纸化, 1-是,0-否
	private String departmentId; //当前用户所属机构
	// 以下是辅助字段
	private List<Org> children;          //
	private User user;				     // 根据用户ID查询组织机构列表
	private String typeName;             // 组织机构类型的名称
	private String storesSelected;		 // 查询汇金门店时选择的门店
	private String sourceType;   		 // 标记门店和小组分派关系类型
	private String carLoanCode;          // 车借编码
	private String frozenUser;           // 是否冻结当前机构和子机构下所有用户
	
	public Org(){
		super();
	}

	public Org(String id){
		super(id);
	}
	
	public Org(User user){
		super();
		this.user = user;
	}

	public String getUseable() {
		return useable;
	}

	public void setUseable(String useable) {
		this.useable = useable;
	}

	public Org getParent() {
		return parent;
	}

	public void setParent(Org parent) {
		this.parent = parent;
	}
	
	@NotNull
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	@Length(min=1, max=10)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Length(min=1, max=1)
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Length(min=0, max=255)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Length(min=0, max=100)
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Length(min=0, max=100)
	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	@Length(min=0, max=200)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Length(min=0, max=200)
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Length(min=0, max=200)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Length(min=0, max=100)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public List<Org> getChildren() {
		return children;
	}

	public void setChildren(List<Org> children) {
		this.children = children;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPartyType() {
		return partyType;
	}

	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	
	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public Integer getSystemFlag() {
		return systemFlag;
	}

	public void setSystemFlag(Integer systemFlag) {
		this.systemFlag = systemFlag;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getStoresSelected() {
		return storesSelected;
	}

	public void setStoresSelected(String storesSelected) {
		this.storesSelected = storesSelected;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	
	public String getCarLoanCode() {
		return carLoanCode;
	}

	public void setCarLoanCode(String carLoanCode) {
		this.carLoanCode = carLoanCode;
	}

	@Override
	public int compareTo(Object o) {
		Org org = (Org)o;
		return this.id.compareTo(org.getId());
	}

	public String getFrozenUser() {
		return frozenUser;
	}

	public void setFrozenUser(String frozenUser) {
		this.frozenUser = frozenUser;
	}

	public String getCreditPaperless() {
		return creditPaperless;
	}

	public void setCreditPaperless(String creditPaperless) {
		this.creditPaperless = creditPaperless;
	}

	public String getCarPaperless() {
		return carPaperless;
	}

	public void setCarPaperless(String carPaperless) {
		this.carPaperless = carPaperless;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	
}