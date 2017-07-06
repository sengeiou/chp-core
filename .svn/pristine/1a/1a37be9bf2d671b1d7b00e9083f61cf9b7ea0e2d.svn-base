package com.creditharmony.core.sync.data.compare;

import java.util.Comparator;

import com.creditharmony.core.threenet.entity.ThreeNetDataBatch;

/**
 * ThreeNetDataBatch类比较器
 * @Class Name ThreeNetDataBatchComparator
 * @author 张永生
 * @Create In 2015年12月7日
 */
public class ThreeNetDataBatchComparator implements Comparator<ThreeNetDataBatch> {
    
	/**
	 * 按照批次号由小到大排序
	 */
	@Override
    public int compare(ThreeNetDataBatch d1, ThreeNetDataBatch d2) {
		int batchNo1 = d1.getBatchNo();
		int batchNo2 = d2.getBatchNo();
		if (batchNo1 == batchNo2) {
			return 0;
		} else if (batchNo1 > batchNo2) {
			return -1;
		} else {
			return 1;
		}
    }
	
}
