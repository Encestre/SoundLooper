/**
 *
 */
package com.soundlooper.system.search;

/**
 * -------------------------------------------------------
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
 * Delete ponctuations in a String
 *
 * @author Alexandre NEDJARI
 * @since 7 mars 2011
 *  -------------------------------------------------------
 */
public class StringTransformerDeletePonctuation extends StringTransformer {

	@Override
	public String processTransformation(String stringToProcess) {
		String initialStringToUse = stringToProcess;
		StringBuffer resultStringBuffer = new StringBuffer();
		for (char ponctuationCharacter : StringTransformer.PONCTUATION_CHAR_ARRAY) {
			int lastIndexFound = initialStringToUse.indexOf(ponctuationCharacter);
			int lastIndexWritedInBuffer = 0;
			while (lastIndexFound != -1) {
				resultStringBuffer.append(initialStringToUse.substring(lastIndexWritedInBuffer, lastIndexFound));
				lastIndexWritedInBuffer = lastIndexFound + 1;
				lastIndexFound = initialStringToUse.indexOf(ponctuationCharacter, lastIndexFound + 1);
			}
			resultStringBuffer.append(initialStringToUse.substring(lastIndexWritedInBuffer));
			initialStringToUse = resultStringBuffer.toString();
			resultStringBuffer = new StringBuffer();
		}
		return initialStringToUse;
	}
}
