package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import logic.Game;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class MenuPanel extends JPanel{
	
	private JButton btnNewGame;
	private JButton btnExit;
	private JButton btnCustom;
	
	private GamePanel pnlGame = GameWindow.pnlGame;
	private JFrame frmMazeGame = GameWindow.frmMazeGame;
	
	public MenuPanel() {
		super();


		setBackground(java.awt.Color.BLACK);
		setLayout(null);
		
		setNewGameButton();
		setExitButton();
		setCustomButton();
		
		setImage();
	
	
		
	}
	
	
	private void setImage() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(43, 11, 452, 515);
		ImageIcon init = new ImageIcon(this.getClass().getResource("res/keep.png"));
		panel.add(new JLabel(init));
		add(panel);
		
		
	}


	private void setCustomButton() {
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setIcon(new ImageIcon(MenuPanel.class.getResource("/gui/res/rsz_createmap.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String size;
				String ogres;
				
				

				Object[] options = { "5", "6", "7", "8", "9", "10", "11", "12", "13" };
				
				Object[] o_options = {"1","2","3","4","5"};

				size = (String) JOptionPane.showInputDialog(frmMazeGame, "Map Size?", "",
						JOptionPane.PLAIN_MESSAGE, null, options, "5");

				
				
				ogres = (String) JOptionPane.showInputDialog(frmMazeGame, "Number of Ogres?", "",
						JOptionPane.PLAIN_MESSAGE, null, o_options, "1");
				
				GameWindow.pnlGame.setVisible(false);
				GameWindow.pnlMenu.setVisible(false);
				GameWindow.pnlInit.setVisible(false);
				
			
				GameWindow.createEditorPanel(Integer.parseInt(size), Integer.parseInt(ogres));
				GameWindow.pnlCustomMap.setVisible(true);
				

			}
		});
		btnNewButton_1.setBounds(192, 521, 236, 45);
		add(btnNewButton_1);
		
		
	}


	private void setExitButton() {
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setIcon(new ImageIcon(MenuPanel.class.getResource("/gui/res/rsz_exit.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(430, 521, 102, 45);
		add(btnNewButton_2);
		

		
	}


	public void setNewGameButton(){
		
		btnNewGame  = new JButton("");
		btnNewGame.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewGame.setBackground(Color.BLACK);
		btnNewGame.setIcon(new ImageIcon(MenuPanel.class.getResource("/gui/res/rsz_newgame.png")));
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String guard;
				String ogres_number;
				
				

				Object[] g_options = { "Rookie", "Druken", "Suspicious" };

				Object[] o_options = { "1", "2", "3", "4", "5" };

				guard = (String) JOptionPane.showInputDialog(frmMazeGame, "                Chose Guard's Personality.",
						"", JOptionPane.PLAIN_MESSAGE, null, g_options, "Rookie");

				ogres_number = (String) JOptionPane.showInputDialog(frmMazeGame,
						"             Chose the Number of Ogres", "", JOptionPane.PLAIN_MESSAGE, null, o_options, "1");

				GameWindow.setGame(new Game(Integer.parseInt(ogres_number), guard));

				GameWindow.pnlMenu.setVisible(false);
				GameWindow.pnlInit.setVisible(false);
				GameWindow.pnlGame.update();
				GameWindow.pnlGame.requestFocus();
				GameWindow.pnlGame.setVisible(true);
				
			}
		});
		btnNewGame.setBounds(10, 521, 174, 45);
		add(btnNewGame);
		
		
		
	}
}
