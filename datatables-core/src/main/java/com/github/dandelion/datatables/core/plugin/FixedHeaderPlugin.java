/*
 * [The "BSD licence"]
 * Copyright (c) 2012 Dandelion
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * 3. Neither the name of Dandelion nor the names of its contributors 
 * may be used to endorse or promote products derived from this software 
 * without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.github.dandelion.datatables.core.plugin;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONValue;

import com.github.dandelion.datatables.core.asset.JsResource;
import com.github.dandelion.datatables.core.asset.ResourceType;
import com.github.dandelion.datatables.core.constants.DTConstants;
import com.github.dandelion.datatables.core.html.HtmlTable;

/**
 * Java implementation of the DataTables FixedHeader plugin.
 * 
 * @author Thibault Duchateau
 * @see <a href="http://datatables.net/extras/fixedheader/">Reference</a>
 */
public class FixedHeaderPlugin extends AbstractPlugin {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return "FixedHeader";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getVersion() {
		return "2.0.6";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setup(HtmlTable table) {

		Map<String, Object> specificConfObj = getSpecificCongiguration(table);
		String specificConfStr = null;
		if (!specificConfObj.isEmpty()) {
			specificConfStr = JSONValue.toJSONString(specificConfObj);
			appendToBeforeEndDocumentReady("new FixedHeader(oTable_" + table.getId() + ","
					+ specificConfStr + ");");
		} else {
			appendToBeforeEndDocumentReady("new FixedHeader(oTable_" + table.getId() + ");");
		}

		addJsResource(new JsResource(ResourceType.PLUGIN, "FixedHeader", "datatables/plugins/fixedheader/fixedheader.min.js"));
	}

	/**
	 * Depending on the attributes, the FixedHeader object may need a JSON
	 * object as configuration.
	 * 
	 * @param table
	 *            The HTML table.
	 * @return Map<String, Object> Map of property used by the FixedHeader
	 *         plugin.
	 */
	private Map<String, Object> getSpecificCongiguration(HtmlTable table) {
		Map<String, Object> conf = new HashMap<String, Object>();

		// fixedPosition attribute (default "top")
		if (StringUtils.isNotBlank(table.getFixedPosition())) {
			if (table.getFixedPosition().equals("bottom")) {
				conf.put("bottom", true);
			} else if (table.getFixedPosition().equals("right")) {
				conf.put("right", true);
			} else if (table.getFixedPosition().equals("left")) {
				conf.put("left", true);
			} else {
				appendToBeforeEndDocumentReady("new FixedHeader(oTable_" + table.getId() + ");");
			}
		} else {
			conf.put("top", true);
		}

		// offsetTop attribute
		if (table.getFixedOffsetTop() != null) {
			conf.put(DTConstants.DT_OFFSETTOP, table.getFixedOffsetTop());
		}

		return conf;
	}
}
