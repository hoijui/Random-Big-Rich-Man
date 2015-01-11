import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Game_Setting {
	public JFrame games1 = new JFrame("Player1 Setting");
	public Game_Setting2 gs2 = new Game_Setting2();
	public Game_Setting(){
		games1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public void show(JFrame f, game Game){
		games1.setSize(450, 320);
		games1.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(122, 40, 46, 15);
		games1.getContentPane().add(lblNewLabel);
		
		JEditorPane dtrpnPlayer = new JEditorPane();
		dtrpnPlayer.setText("Player1");
		dtrpnPlayer.setBounds(205, 34, 106, 21);
		games1.getContentPane().add(dtrpnPlayer);
		
		JLabel lblHumanai = new JLabel("Human/AI");
		lblHumanai.setBounds(122, 79, 68, 15);
		games1.getContentPane().add(lblHumanai);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Human", "AI"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(205, 76, 106, 21);
		games1.getContentPane().add(comboBox);
		
		JLabel lblIcon = new JLabel("Icon");
		lblIcon.setBounds(122, 124, 46, 15);
		games1.getContentPane().add(lblIcon);
		
		JComboBox<ImageIcon> comboBox_1 = new JComboBox<ImageIcon>();
		comboBox_1.setBounds(205, 118, 106, 21);
		ImageIcon array[] = new ImageIcon[] {Game.image1, Game.image2, Game.image3, Game.image4, Game.image5, Game.image6, Game.image7, Game.image8};
		comboBox_1.setModel(new DefaultComboBoxModel<ImageIcon>(array));
		comboBox_1.setSelectedIndex(0);
		games1.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("Money");
		lblNewLabel_1.setBounds(122, 165, 46, 15);
		games1.getContentPane().add(lblNewLabel_1);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setText("15000");
		editorPane.setBounds(205, 159, 106, 21);
		games1.getContentPane().add(editorPane);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				games1.setVisible(false);
				f.setVisible(true);
			}
		});
		btnCancel.setBounds(103, 214, 87, 23);
		games1.getContentPane().add(btnCancel);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.p1_name = dtrpnPlayer.getText();
				Game.p1_type = comboBox.getSelectedIndex();
				Game.p1_icon = comboBox_1.getSelectedIndex();
				Game.p1_money = Long.parseLong(editorPane.getText());
				games1.setVisible(false);
				gs2.show(games1, Game);
			}
		});
		btnNext.setBounds(224, 214, 94, 23);
		games1.getContentPane().add(btnNext);
		games1.setVisible(true);
	}
}