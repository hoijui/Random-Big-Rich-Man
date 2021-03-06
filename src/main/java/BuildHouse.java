/*
 * Copyright (C) 2017 Simon <ficstudio@yahoo.com.tw>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BuildHouse {

	private final Game game;
	private final GameMap gameMap;
	private final GameLoop gameLoop;
	private final JFrame bh;

	BuildHouse(final Game game, final GameMap gameMap, final GameLoop gameLoop) {
		this.bh = new JFrame("Building");
		this.bh.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.game = game;
		this.gameMap = gameMap;
		this.gameLoop = gameLoop;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void show() {
		String h;
		String button_name;
		final long spent;
		final int turn_id = game.turn;

		switch (gameMap.level[game.p_dest_id[turn_id]]) {
			case 4:
				gameLoop.susp = false;
				return;
			case 3:
				h = "hotel";
				button_name = "Build Hotel";
				spent = (long) (gameMap.value[game.p_dest_id[turn_id]] * 0.4);
				break;
			default:
				h = "house";
				button_name = "Build House";
				spent = (long) (gameMap.value[game.p_dest_id[turn_id]] * 0.2);
				break;
		}

		bh.getContentPane().removeAll();
		bh.setSize(450, 300);
		bh.getContentPane().setLayout(null);

		final JLabel lblNewLabel = new JLabel("Hi, " + game.p_name[turn_id] + ":");
		lblNewLabel.setBounds(10, 10, 414, 15);
		bh.getContentPane().add(lblNewLabel);

		final JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				bh.dispose();
				gameLoop.susp = false;
			}
		});
		btnNewButton.setBounds(55, 214, 124, 23);
		bh.getContentPane().add(btnNewButton);

		final JButton btnNewButton_1 = new JButton(button_name);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				game.deal(-1 * spent, turn_id, "Spent: ");
				gameMap.level[game.p_dest_id[turn_id]] += 1;
				bh.dispose();
				gameLoop.susp = false;
			}
		});
		btnNewButton_1.setBounds(219, 214, 188, 23);
		bh.getContentPane().add(btnNewButton_1);

		final JLabel lblNewLabel_1 = new JLabel("Do you want to spent $" + spent + " to build a " + h + "?");
		lblNewLabel_1.setBounds(20, 26, 404, 15);
		bh.getContentPane().add(lblNewLabel_1);

		if (spent > game.p_money[turn_id]) {
			final JLabel lblNewLabel_2 = new JLabel("You have NOT enough money!");
			lblNewLabel_2.setBounds(20, 189, 404, 15);
			lblNewLabel_2.setForeground(Color.RED);
			bh.getContentPane().add(lblNewLabel_2);
			btnNewButton_1.setEnabled(false);
		}
		bh.setVisible(true);
	}
}
