/*******************************************************************************
 * Copyright (c) 2011 Angelo ZERR.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:      
 *     Angelo Zerr <angelo.zerr@gmail.com> - initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.xml.search.core.xpath.matcher;

import java.util.Collection;

import org.w3c.dom.Node;

/**
 * XPath node matcher tests if {@link Node} match a fragment of XPath.
 * 
 * 
 */
public interface IXPathNodeMatcher {

	public static final IXPathNodeMatcher[] EMPTY_NODE_MATCHER = new IXPathNodeMatcher[0];

	public enum MatcherType {
		ELEMENT, ATTRIBUTE
	}

	/**
	 * Returns the owner matcher.
	 * 
	 * @return
	 */
	XPathMatcher getOwnerMatcher();

	/**
	 * Returns matcher type.
	 * 
	 * @return
	 */
	MatcherType getType();

	/**
	 * Match the {@link Node} and fill wildcard values if node matcher define
	 * widcard.
	 * 
	 * @param testNode
	 *            node to test.
	 * @param wildcardValues
	 *            wildcard values if node matcher define widcard.
	 * @return
	 */
	boolean match(Node testNode, Collection<String> wildcardValues);

	/**
	 * Returns true if matcher is any (Node is every time matched) and false
	 * otherwise.
	 * 
	 * @return
	 */
	boolean isAny();

}
