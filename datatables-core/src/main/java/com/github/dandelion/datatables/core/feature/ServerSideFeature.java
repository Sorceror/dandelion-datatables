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
package com.github.dandelion.datatables.core.feature;

import com.github.dandelion.datatables.core.asset.Configuration;
import com.github.dandelion.datatables.core.asset.Configuration.Mode;
import com.github.dandelion.datatables.core.asset.JavascriptFunction;
import com.github.dandelion.datatables.core.callback.CallbackType;
import com.github.dandelion.datatables.core.exception.BadConfigurationException;
import com.github.dandelion.datatables.core.html.HtmlTable;

/**
 * <p>
 * Feature that is always enabled when server-side processing has been
 * activated.
 * <p>
 * Removing the fnAddjustColumnSizing will cause strange column's width at each
 * interaction with the table (paging, sorting, filtering ...)
 * 
 * @author Thibault Duchateau
 * @since 0.8.2
 */
public class ServerSideFeature extends AbstractFeature {

	@Override
	public String getName() {
		return null;
	}

	@Override
	public String getVersion() {
		return null;
	}

	@Override
	public void setup(HtmlTable table) throws BadConfigurationException {
		addConfiguration(
				new Configuration(
						CallbackType.INIT.getName(), 
						new JavascriptFunction("oTable_" + table.getId() + ".fnAdjustColumnSizing(true);",CallbackType.INIT.getArgs()),
						Mode.APPEND));
	}
}