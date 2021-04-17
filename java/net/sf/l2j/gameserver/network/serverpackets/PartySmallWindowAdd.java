/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.l2j.gameserver.network.serverpackets;

import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;

/**
 * This class ...
 *
 * @version $Revision: 1.4.2.1.2.5 $ $Date: 2005/03/27 15:29:57 $
 */
public final class PartySmallWindowAdd extends L2GameServerPacket
{
	private static final String _S__64_PARTYSMALLWINDOWADD = "[S] 4f PartySmallWindowAdd";

	private L2PcInstance _member;

	public PartySmallWindowAdd(L2PcInstance member)
	{
		_member = member;
	}

	@Override
	protected final void writeImpl()
	{
		writeC(0x4f);
		L2PcInstance player =  getClient().getActiveChar();
		writeD(player.getObjectId()); // c3
		writeD(0);//writeD(0x04); ?? //c3
		writeD(_member.getObjectId());
		writeS(_member.getName());

		writeD((int) _member.getCurrentCp()); //c4
		writeD(_member.getMaxCp()); //c4

		writeD((int) _member.getCurrentHp());
		writeD(_member.getMaxHp());
		writeD((int) _member.getCurrentMp());
		writeD(_member.getMaxMp());
		writeD(_member.getLevel());
		writeD(_member.getClassId().getId());
		writeD(0);//writeD(0x01); ??
		writeD(0);
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
	 */
	@Override
	public String getType()
	{
		return _S__64_PARTYSMALLWINDOWADD;
	}
}