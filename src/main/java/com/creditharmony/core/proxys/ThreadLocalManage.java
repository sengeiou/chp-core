package com.creditharmony.core.proxys;

import java.util.HashMap;

public class ThreadLocalManage {

	public static ThreadLocal<HashMap<String, Object>> tdl = new ThreadLocal<HashMap<String, Object>>();
}
