package com.github.dandelion.datatables.thymeleaf.processor.basic;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.IAttributeNameProcessorMatcher;
import org.thymeleaf.processor.ProcessorResult;
import com.github.dandelion.datatables.core.html.HtmlTable;
import com.github.dandelion.datatables.thymeleaf.dialect.AbstractDatatablesAttrProcessor;
import com.github.dandelion.datatables.thymeleaf.util.Utils;

public class TableLengthChangeAttrProcessor extends AbstractDatatablesAttrProcessor {

	public TableLengthChangeAttrProcessor(IAttributeNameProcessorMatcher matcher) {
		super(matcher);
	}

	@Override
	public int getPrecedence(){
		return 8000;
	}

	@Override
	protected ProcessorResult doProcessAttribute(Arguments arguments, Element element, String attributeName, HtmlTable table){
		Boolean attrValue = Utils.parseElementAttribute(arguments, element.getAttributeValue(attributeName), new Boolean(false), Boolean.class);
		table.setLengthChange(attrValue);
		return ProcessorResult.ok();
	}
}