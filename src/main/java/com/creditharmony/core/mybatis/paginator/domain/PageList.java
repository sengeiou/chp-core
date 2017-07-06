package com.creditharmony.core.mybatis.paginator.domain;

import java.util.ArrayList;
import java.util.Collection;


/**
 * 包含分页信息的List
 * 要得到总页数请使用 getPaginator().getTotalCount()
 * @Class Name PageList
 * @author 张永生
 * @Create In 2015年12月1日
 * @param <E>
 */
public class PageList<E> extends ArrayList<E> {
	
    private static final long serialVersionUID = 1412759446332294208L;
    
    private Paginator paginator;

    public PageList() {}
    
	public PageList(Collection<? extends E> c) {
		super(c);
	}

	
	public PageList(Collection<? extends E> c,Paginator p) {
        super(c);
        this.paginator = p;
    }

    public PageList(Paginator p) {
        this.paginator = p;
    }


	/**
	 * 得到分页器，通过Paginator可以得到总页数等值
	 * @return
	 */
	public Paginator getPaginator() {
		return paginator;
	}
	public void setPaginator(Paginator p) {
		this.paginator = p;
	}
	
}
