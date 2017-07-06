package com.creditharmony.core.supcan.freeform;

import com.creditharmony.core.supcan.SupCommon;
import com.creditharmony.core.supcan.properties.Properties;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 硕正FreeForm
 */
@XStreamAlias("FreeForm")
public class FreeForm extends SupCommon {

	public FreeForm() {
		super();
	}
	
	public FreeForm(Properties properties) {
		this();
		this.properties = properties;
	}
	
}
