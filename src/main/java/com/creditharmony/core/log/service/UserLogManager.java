package com.creditharmony.core.log.service;

import org.springframework.stereotype.Service;

import com.creditharmony.core.log.dao.UserLogDao;
import com.creditharmony.core.log.entity.UserLog;
import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.type.SystemFlag;
import com.creditharmony.core.users.entity.User;


@Service
public class UserLogManager extends CoreManager<UserLogDao, UserLog>  {
	
	public void insertUserLog(final User oldUser,final User newUser,final String type) {
		new Thread(new Runnable(){
			@Override
			public void run() {
				UserLog user=new UserLog();		
				try {
					user=(UserLog) setValue(user, oldUser, newUser);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(); 
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if(type.equals("1")){		
					user.setUserId(newUser.getId());
					user.setLoginName(newUser.getLoginName());
				}else{
					user.setUserId(oldUser.getId());
					user.setLoginName(oldUser.getLoginName());
				}
				user.setDepartmentId(oldUser.getDepartment()!=null?oldUser.getDepartment().getId():null);
				user.setDepartmentIdNew(newUser.getDepartment()!=null?newUser.getDepartment().getId():null);
				user.setUserName(oldUser.getName());
				user.setUserNameNew(newUser.getName());
				user.setOperateType(type);
				user.setSystemFlag(SystemFlag.SYS_MANAGE.value);
				user.preInsert();				
				dao.insertSelective(user);				
			}
		}).start();
		
	}	
}
