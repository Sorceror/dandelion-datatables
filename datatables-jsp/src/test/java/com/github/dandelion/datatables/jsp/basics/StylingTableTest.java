/*
 * [The "BSD licence"]
 * Copyright (c) 2013 Dandelion
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

package com.github.dandelion.datatables.jsp.basics;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import com.github.dandelion.datatables.jsp.tag.DomBaseTest;
import com.github.dandelion.datatables.mock.Mock;
import com.github.dandelion.datatables.utils.TableBuilder;

/**
 * Styling table.
 * 
 * @author Thibault Duchateau
 */
public class StylingTableTest extends DomBaseTest {

	@Override
	public void buildTable() {
		tableBuilder = new TableBuilder(Mock.persons, "myTableId").context(mockPageContext)
				.defaultTable()
				.cssClass("myClass")
				.cssStripes("myStrip1,myStrip2")
				.cssStyle("myStyle");
	}
	
	@Test
	public void should_set_css_style_using_class() {
		assertThat(table.getCssClass().toString()).isEqualTo("myClass");
	}
	
	@Test
	public void should_set_strip_classes() {
		assertThat(table.getStripeClasses()).isEqualTo("['myStrip1','myStrip2']");
	}
	
	@Test
	public void should_set_css_style() {
		assertThat(table.getCssStyle().toString()).isEqualTo("myStyle");
	}
}