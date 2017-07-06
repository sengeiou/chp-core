package com.creditharmony.core.sync.data.type;

import com.creditharmony.core.common.service.RunningNumberEncodable;


/**
 * 同步数据的业务编码
 * 即：同步数据包括同步哪些数据表
 * @Class Name SyncBizCode
 * @author 张永生
 * @Create In 2015年12月5日
 */
public abstract interface SyncBizConstants {

	public static enum SyncTableName implements RunningNumberEncodable {
		SyncOrg("sync_org", false),
		SyncUser("sync_user",false),
		@Deprecated
		SyncUserOrg("sync_user_org",false),
		SyncRole("sync_role",false),
		SyncDict("sync_dict",false),
		@Deprecated
		SyncUserRole("sync_user_role",false),
		SyncUserRoleOrg("sync_user_role_org",false),
		ThreeNetOrg("threenet_org", false),
		ThreeNetUser("threenet_user", false),
		ThreeNetRole("threenet_role", false);
		
		private String prefix;
		private boolean needRowNumber;
		    
		private SyncTableName(String prefix, boolean needRowNumber) { 
		  this.prefix = prefix;
	      this.needRowNumber = needRowNumber;
	    }
		
		public String getPrefix() {
			return this.prefix;
		}

		public String encode(int indexNumber, int rowNumber, String areaCode) {
			return Integer.toString(indexNumber);
		}

		public boolean isNeedRowNumber() {
			return needRowNumber;
		}

		public void setNeedRowNumber(boolean needRowNumber) {
			this.needRowNumber = needRowNumber;
		}

		public void setPrefix(String prefix) {
			this.prefix = prefix;
		}
		
	}

}