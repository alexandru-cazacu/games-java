package com.cazacu.game;

import com.cazacu.engine.graphics.Sprite;
import com.cazacu.engine.physics.Vector2;
import static java.lang.Math.sqrt;

public class Tetromino {

	public static Tetromino I = new Tetromino("0000111100000000", new Vector2(5, 0));
	public static Tetromino O = new Tetromino("1111", new Vector2(5, 0));
	public static Tetromino T = new Tetromino("111010000", new Vector2(4, 0));
	public static Tetromino S = new Tetromino("011110000", new Vector2(4, 0));
	public static Tetromino Z = new Tetromino("110011000", new Vector2(4, 0));
	public static Tetromino J = new Tetromino("010010110", new Vector2(4, 0));
	public static Tetromino L = new Tetromino("010010011", new Vector2(4, 0));

	public int length;
	public Vector2 spawnPos = new Vector2(0, 0);
	public Sprite[][] grid;

	public Tetromino(Tetromino t) {
		this.length = t.length;
		this.spawnPos = new Vector2(spawnPos);
		grid = new Sprite[length][length];

		for (int y = 0; y < length; y++) {
			for (int x = 0; x < length; x++) {
				this.grid[x][y] = t.grid[x][y];
			}
		}
	}

	public Tetromino(String s, Vector2 spawnPos) {
		this.length = (int) sqrt(s.length());
		this.spawnPos = new Vector2(spawnPos);
		grid = new Sprite[length][length];

		for (int y = 0; y < length; y++) {
			for (int x = 0; x < length; x++) {
				if (s.charAt(x + y * length) == '1') {
					grid[x][y] = Sprite.blockTetromino;
				} else {
					grid[x][y] = Sprite.empty;
				}
			}
		}
	}

	public void rotateLeft() {
		Sprite temp[][] = new Sprite[length][length];
		for (int y = 0; y < length; y++) {
			for (int x = 0; x < length; x++) {
				temp[x][y] = grid[x][y];
			}
		}

		for (int y = 0; y < length; y++) {
			for (int x = 0; x < length; x++) {
				grid[x][y] = temp[length - 1 - y][x];
			}
		}
	}

	public void rotateRight() {
		Sprite temp[][] = new Sprite[length][length];
		for (int y = 0; y < length; y++) {
			for (int x = 0; x < length; x++) {
				temp[x][y] = grid[x][y];
			}
		}

		for (int y = 0; y < length; y++) {
			for (int x = 0; x < length; x++) {
				grid[x][y] = temp[y][length - 1 - x];
			}
		}
	}
}
