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

package com.github.dandelion.datatables.integration.advanced;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;

import com.github.dandelion.datatables.integration.DomBaseIT;

/**
 * Test the RowId feature.
 *
 * @author Thibault Duchateau
 */
public class RowIdIT extends DomBaseIT {

	@Test
	public void should_generate_rowid_with_only_base() throws IOException, Exception {
		goTo("/advanced/row_id_only_base.jsp");
		assertThat(getTable().find("tbody").findFirst("tr").getId()).isEqualTo("1");
	}
	
	@Test
	public void should_generate_rowid_with_prefix() throws IOException, Exception {
		goTo("/advanced/row_id_with_prefix.jsp");
		assertThat(getTable().find("tbody").findFirst("tr").getId()).isEqualTo("id_1");
	}
	
	@Test
	public void should_generate_rowid_with_sufix() throws IOException, Exception {
		goTo("/advanced/row_id_with_sufix.jsp");
		assertThat(getTable().find("tbody").findFirst("tr").getId()).isEqualTo("1_id");
	}
	
	@Test
	public void should_generate_rowid_with_prefix_and_sufix() throws IOException, Exception {
		goTo("/advanced/row_id_with_prefix_and_sufix.jsp");
		assertThat(getTable().find("tbody").findFirst("tr").getId()).isEqualTo("id_1_di");
	}
}
