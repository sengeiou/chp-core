package com.creditharmony.core.users.entity;

import com.creditharmony.core.persistence.DataEntity;

public class WorkflowConfig extends DataEntity<WorkflowConfig> {
	
	private static final long serialVersionUID = 1L;
	
	private String workflowId;
	private String workflowName;
	private String nodeId;
	private String nodeName;
	private String systemFlag;
	private String systemName;
	private int maxNum;//最大单量
	private int totalNum;//总人数
	
	//小组id。当dispatchFlag为2时，即全体自动分单时，此处为分单类型singleType（合同审核组contract(或者contractTG)或者利率审核组--rate）
	private String groupId;
	//自动分单标记。true：自动分单
	private boolean autoDispatch;
	/**
	 * 分单标记
	 * 1：指定审核小组自动分担，参见groupId
	 * 2：所有审核小组自动分担。
	 * 以下分单为2016-5需求变更门店分配改为chp2.0样子后适应性调整开启自动分单，以上的1和2为早期chp3.0的实现所需，功能已经废弃
	 * 8: 保留。没有这个配置，用以适应chp-taskDispatchService的自动分单时，原利率审核也有自动分单而如今却没有此功能的情况
	 * 
	 * 3. 小组自动分单---空模式合同审核标记
	 * 4. 小组自动分单---TG模式合同审核标记
	 * 6. 整组自动分单---空模式合同审核标记
	 * 7. 整组自动分单---TG模式合同审核标记
	 */
	private int dispatchFlag;
	public WorkflowConfig(){
		super();
	}
	public WorkflowConfig(String id){
		super(id);
	}
	public String getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}

	public String getWorkflowName() {
		return workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getSystemFlag() {
		return systemFlag;
	}

	public void setSystemFlag(String systemFlag) {
		this.systemFlag = systemFlag;
	}

	public int getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public boolean getAutoDispatch() {
		return autoDispatch;
	}

	public void setAutoDispatch(boolean autoDispatch) {
		this.autoDispatch = autoDispatch;
	}

	public int getDispatchFlag() {
		return dispatchFlag;
	}

	public void setDispatchFlag(int dispatchFlag) {
		this.dispatchFlag = dispatchFlag;
	}

}
