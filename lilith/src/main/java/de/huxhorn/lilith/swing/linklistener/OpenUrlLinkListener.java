/*
 * Lilith - a log event viewer.
 * Copyright (C) 2007-2015 Joern Huxhorn
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.huxhorn.lilith.swing.linklistener;

import de.huxhorn.lilith.swing.MainFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xhtmlrenderer.swing.BasicPanel;
import org.xhtmlrenderer.swing.LinkListener;

public class OpenUrlLinkListener
	extends LinkListener
{
	private final Logger logger = LoggerFactory.getLogger(OpenUrlLinkListener.class);

	private MainFrame mainFrame;
	private LinkListener originalLinkListener;

	public OpenUrlLinkListener(MainFrame mainFrame, LinkListener originalLinkListener)
	{
		this.mainFrame = mainFrame;
		this.originalLinkListener = originalLinkListener;
	}

	@Override
	public void linkClicked(BasicPanel basicPanel, String uri)
	{
		if(logger.isDebugEnabled()) logger.debug("Link clicked: {}", uri);


		if(!mainFrame.openUriString(uri) && originalLinkListener != null)
		{
			originalLinkListener.linkClicked(basicPanel, uri);
		}
	}
}
