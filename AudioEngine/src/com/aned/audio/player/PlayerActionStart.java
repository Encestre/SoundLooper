/**
 *
 */
package com.aned.audio.player;

import org.apache.log4j.Logger;

import com.aned.audio.player.Player.PlayerState;
import com.aned.exception.PlayerException;
import com.aned.exception.StackTracer;

/**
 * AudioEngine is an audio engine based on FMOD
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
 * @author ANEDJARI
 *
 */
public class PlayerActionStart extends PlayerAction {

	/**
	 * Logger for this class
	 */
	private Logger logger = Logger.getLogger(this.getClass());

	/**
	 * Constructor
	 * @param player the player
	 */
	public PlayerActionStart(Player player) {
		super(player);
	}

	@Override
	public void run() {
		try {
			this.getPlayer().setState(PlayerState.STATE_PREPARING_PLAY);
			this.getPlayer().checkCurrentSoundInitialized();
			//this.setState(Controller.Prefetched);
			this.getPlayer().getCurrentSound().start();
			//			while (this.player.getCurrentSound().getState() != Controller.Started) {
			//				//waiting
			//			}
			this.getPlayer().setState(PlayerState.STATE_PLAYING);
		} catch (PlayerException e) {
			this.logger.error(StackTracer.getStackTrace(e));
			this.getPlayer().getMessageNotifier().sendError(e.getMessage());
		}
	}
}
