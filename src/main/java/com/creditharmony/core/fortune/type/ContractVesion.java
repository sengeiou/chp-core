package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 合同版本
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum ContractVesion {
	D10BB("0"), // 1.0
	D11BB("1"), // 1.1
	D12BB("2"), // 1.2
	D13BB("3"), // 1.3
	D13XTBB("4"), // 1.3续投
	D14BB("5"), // 1.4
	D141BB("6"), // 1.4.1
	D15BB("7"), // 1.5
	D16BB("8"), // 1.6
	D161BB("9"),// 1.6.1
	D20BB("10"), // 2.0
	D21BB("11"), // 2.1
	D22BB("12"), // 2.2
	D23BB("13"), // 2.3
	D30BB("14"), // 3.0
	D31BB("15"), // 3.1
	D32BB("16"), // 3.2
	D17BB("17"), // 1.7
	D24BB("18"); // 2.4

	public static Map<String, String> contractVesionMap = new Hashtable<String, String>();

	static {
		contractVesionMap.put(ContractVesion.D10BB.value, "1.0");
		contractVesionMap.put(ContractVesion.D11BB.value, "1.1");
		contractVesionMap.put(ContractVesion.D12BB.value, "1.2");
		contractVesionMap.put(ContractVesion.D13BB.value, "1.3");
		contractVesionMap.put(ContractVesion.D13XTBB.value, "1.3续投");
		contractVesionMap.put(ContractVesion.D14BB.value, "1.4");
		contractVesionMap.put(ContractVesion.D141BB.value, "1.4.1");
		contractVesionMap.put(ContractVesion.D15BB.value, "1.5");
		contractVesionMap.put(ContractVesion.D16BB.value, "1.6");
		contractVesionMap.put(ContractVesion.D161BB.value, "1.6.1");
		contractVesionMap.put(ContractVesion.D17BB.value, "1.7");
		contractVesionMap.put(ContractVesion.D20BB.value, "2.0");
		contractVesionMap.put(ContractVesion.D21BB.value, "2.1");
		contractVesionMap.put(ContractVesion.D22BB.value, "2.2");
		contractVesionMap.put(ContractVesion.D23BB.value, "2.3");
		contractVesionMap.put(ContractVesion.D24BB.value, "2.4");
		contractVesionMap.put(ContractVesion.D30BB.value, "3.0");
		contractVesionMap.put(ContractVesion.D31BB.value, "3.1");
		contractVesionMap.put(ContractVesion.D32BB.value, "3.2");
	}

	public final String value;

	private ContractVesion(String value) {
		this.value = value;
	}

	public static String getContractVesion(String value) {
		return contractVesionMap.get(value);
	}
}