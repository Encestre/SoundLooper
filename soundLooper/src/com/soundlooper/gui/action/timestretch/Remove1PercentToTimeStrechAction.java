/**
 *
 */
package com.soundlooper.gui.action.timestretch;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.aned.audio.player.Player;

/**
 *-------------------------------------------------------
 * Sound Looper is an audio player that allow user to loop between two points
 * Copyright (C) 2014 Alexandre NEDJARI
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
 *
 *
 * @author Alexandre NEDJARI
 * @since  16 f�vr. 2014
 *-------------------------------------------------------
 */
public class Remove1PercentToTimeStrechAction extends AbstractAction {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		int timeStretch = Player.getInstance().getTimeStretch();
		timeStretch -= 1;
		if (timeStretch < 50) {
			timeStretch = 50;
		}
		Player.getInstance().setTimestretch(timeStretch);
	}

	@Override
	public boolean isEnabled() {
		return Player.getInstance().isSoundInitialized();
	}

}
