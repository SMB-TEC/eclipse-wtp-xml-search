/**
 *  Copyright (c) 2013-2014 Angelo ZERR.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  Angelo Zerr <angelo.zerr@gmail.com> - initial API and implementation
 */
package org.eclipse.wst.xml.search.core.xpath;

import javax.xml.xpath.XPathExpressionException;

import org.eclipse.core.runtime.IStatus;
import org.w3c.dom.NodeList;

public interface IXPathProcessor {

	String computeXPath(String xpath, String... args);

	NodeList evaluateNodeSet(Object source, String xpath,
			NamespaceInfos namespaceInfo, String... criteria)
			throws XPathExpressionException;

	String evaluateString(Object source, String xpath,
			NamespaceInfos namespaceInfo, String... criteria)
			throws XPathExpressionException;

	IStatus validateXPath(String xpath);

}
