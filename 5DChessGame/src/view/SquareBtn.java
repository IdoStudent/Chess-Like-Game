package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import control.SquareActionListener;
import model.CombinablePiece;
import model.GameEngine;
import model.Square;

public class SquareBtn extends JButton{
	private int x;
	private int y;
	
	private GameEngineGUI frame;
	private GameEngine model;
	public SquareBtn(GameEngineGUI frame, GameEngine model, int x, int y) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		this.model = model;
		this.x = x;
		this.y =y;
	}
	
	public int getPosX() {
		return this.x;
	}

	public int getPosY() {
		return this.y;
	}

}
