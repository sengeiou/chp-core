package com.creditharmony.core.common.service;

import java.util.ConcurrentModificationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.common.util.IdGen;
import com.creditharmony.core.common.dao.RunningNumberDao;
import com.creditharmony.core.common.entity.RunningNumber;
import com.creditharmony.core.service.CoreManager;

@Service
public class RunningNumberManager extends CoreManager<RunningNumberDao, RunningNumber> {

	private static Logger logger = LoggerFactory.getLogger(RunningNumberManager.class);

	@Autowired
	private RunningNumberDao runningNumberDao;

	@Transactional(readOnly = false)
	public int[] createNextNumber(String type, int count) throws ConcurrencyFailureException {
		int[] result = null;
		for (int fetchCount = 0; fetchCount < 1; fetchCount++) {
			try {
				result = generateNextNumber(type, count);
			} catch (ConcurrentModificationException ex) {
				logger.info("获取RunningNumber失败，准备再次重试", ex);
			}
		}
		if (result == null) {
			throw new ConcurrencyFailureException("获取RunningNumber失败，服务可能暂时不可用");
		}
		return result;
	}

	@Transactional(readOnly = false)
	public int[] generateNextNumber(String type, int count) {
		RunningNumber runningNumber = runningNumberDao.findByType(type);
		int indexNumber;
		if (runningNumber == null) {
			indexNumber = 1;
			runningNumber = new RunningNumber();
			runningNumber.setType(type);
		} else {
			indexNumber = Integer.parseInt(runningNumber.getNumber());
			indexNumber++;
		}
		int[] result = new int[count];
		for (int i = 0; i < count; i++) {
			result[i] = (indexNumber + i);
		}
		runningNumber.setNumber(String.valueOf(indexNumber + count - 1));
		saveRunningNumber(runningNumber);
		return result;
	}

	@Transactional(readOnly = false)
	public void saveRunningNumber(RunningNumber runningNumber) {
		if (runningNumber.getId() == null) {
			runningNumber.setId(IdGen.uuid());
			runningNumberDao.insert(runningNumber);
		} else {
			runningNumberDao.update(runningNumber);
		}
	}
}