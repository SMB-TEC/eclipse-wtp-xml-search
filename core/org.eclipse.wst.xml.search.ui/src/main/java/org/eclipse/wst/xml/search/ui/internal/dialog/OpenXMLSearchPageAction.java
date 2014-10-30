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
package org.eclipse.wst.xml.search.ui.internal.dialog;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.wst.xml.search.ui.internal.Trace;
import org.eclipse.wst.xml.search.ui.internal.XMLSearchUIPlugin;

/**
 * Opens the XML Search Dialog and brings the XML search page to front
 */
public class OpenXMLSearchPageAction implements IWorkbenchWindowActionDelegate {

	private static final String XML_SEARCH_PAGE_ID = "org.eclipse.wst.xml.search.ui.dialog.XMLSearchPage"; //$NON-NLS-1$

	private IWorkbenchWindow fWindow;

	public OpenXMLSearchPageAction() {
	}

	public void init(IWorkbenchWindow window) {
		fWindow = window;
	}

	public void run(IAction action) {
		if (fWindow == null || fWindow.getActivePage() == null) {
			beep();
			logErrorMessage("Could not open the search dialog - for some reason the window handle was null"); //$NON-NLS-1$
			return;
		}
		NewSearchUI.openSearchDialog(fWindow, XML_SEARCH_PAGE_ID);
	}

	public void selectionChanged(IAction action, ISelection selection) {
		// do nothing since the action isn't selection dependent.
	}

	public void dispose() {
		fWindow = null;
	}

	public static void logErrorMessage(String message) {
		Trace.trace(Trace.SEVERE, message);
	}

	protected void beep() {
		Shell shell = XMLSearchUIPlugin.getActiveWorkbenchShell();
		if (shell != null && shell.getDisplay() != null)
			shell.getDisplay().beep();
	}
}
