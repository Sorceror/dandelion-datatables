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

import com.github.dandelion.datatables.core.constants.DTConstants;
import com.github.dandelion.datatables.integration.DomBaseIT;

/**
 * Test the callbacks feature.
 *
 * @author Thibault Duchateau
 */
public class CallbacksIT extends DomBaseIT {

	@Test
	public void should_generate_initcomplete_callback() throws IOException, Exception {
		goTo("/advanced/callback_init.jsp");
		assertThat(getConfigurationFromPage("advanced/callback_init.jsp").getContent()).contains(DTConstants.DT_FN_INIT_COMPLETE);
	}
	
	@Test
	public void should_generate_cookie_callback() throws IOException, Exception {
		goTo("/advanced/callback_cookie.jsp");
		assertThat(getConfigurationFromPage("advanced/callback_cookie.jsp").getContent()).contains(DTConstants.DT_FN_COOKIE_CBK);
	}
	
	@Test
	public void should_generate_createdrow_callback() throws IOException, Exception {
		goTo("/advanced/callback_createdrow.jsp");
		assertThat(getConfigurationFromPage("advanced/callback_createdrow.jsp").getContent()).contains(DTConstants.DT_FN_CREATED_ROW);
	}
	
	@Test
	public void should_generate_draw_callback() throws IOException, Exception {
		goTo("/advanced/callback_draw.jsp");
		assertThat(getConfigurationFromPage("advanced/callback_draw.jsp").getContent()).contains(DTConstants.DT_FN_DRAW_CBK);
	}
	
	@Test
	public void should_generate_footer_callback() throws IOException, Exception {
		goTo("/advanced/callback_footer.jsp");
		assertThat(getConfigurationFromPage("advanced/callback_footer.jsp").getContent()).contains(DTConstants.DT_FN_FOOTER_CBK);
	}
	
	@Test
	public void should_generate_format_callback() throws IOException, Exception {
		goTo("/advanced/callback_format.jsp");
		assertThat(getConfigurationFromPage("advanced/callback_format.jsp").getContent()).contains(DTConstants.DT_FN_FORMAT_NUMBER);
	}
	
	@Test
	public void should_generate_header_callback() throws IOException, Exception {
		goTo("/advanced/callback_header.jsp");
		assertThat(getConfigurationFromPage("advanced/callback_header.jsp").getContent()).contains(DTConstants.DT_FN_HEADER_CBK);
	}
	
	@Test
	public void should_generate_info_callback() throws IOException, Exception {
		goTo("/advanced/callback_info.jsp");
		assertThat(getConfigurationFromPage("advanced/callback_info.jsp").getContent()).contains(DTConstants.DT_FN_INFO_CBK);
	}
	
	@Test
	public void should_generate_predraw_callback() throws IOException, Exception {
		goTo("/advanced/callback_predraw.jsp");
		assertThat(getConfigurationFromPage("advanced/callback_predraw.jsp").getContent()).contains(DTConstants.DT_FN_PRE_DRAW_CBK);
	}
	
	@Test
	public void should_generate_row_callback() throws IOException, Exception {
		goTo("/advanced/callback_row.jsp");
		assertThat(getConfigurationFromPage("advanced/callback_row.jsp").getContent()).contains(DTConstants.DT_FN_ROW_CBK);
	}
}
