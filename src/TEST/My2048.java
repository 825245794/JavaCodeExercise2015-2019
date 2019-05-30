package TEST;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class My2048 {
	final int SRCX = Toolkit.getDefaultToolkit().getScreenSize().width;
	final int SRCY = Toolkit.getDefaultToolkit().getScreenSize().height;
	JFrame mf = new JFrame("2048");
	JPanel bp = new JPanel();
	JPanel fp = new JPanel();
	JLabel[] gezi = new JLabel[16];
	JButton[] items = new JButton[16];
	Point[] ps = new Point[16];
	JButton startButton = new JButton("START");

	public My2048() throws Exception {
		setStartButton();// 设置开始按钮
		setMF();// 设置主frame
		setBP();// 设置背景
		setGezi();// 设置格子
		setFP();// 前端，动火
		setItem();// 动画
		KeyListener();// 键盘监听
		reset();
		mf.setVisible(true);
	}

	private void reset() {
		for (int i = 0; i < 16; i++)
			gezi[i].setText(null);
		int r1 = getRandomP();
		setVal(gezi[r1]);
		int r2 = getRandomP();
		if (r2 == r1) {
			reset();
			return;
		}
		setVal(gezi[r2]);
	}

	private void setVal(JLabel jLabel) {
		if ((int) (Math.random() * 3) == 1) {
			jLabel.setText("4");
//			int size = 80;
//			for (int i = 0; i < 15; i++) {
//				jLabel.setSize(size, size);
//				size += 2;
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		} else {
			jLabel.setText("2");
		}
	}

	private int getRandomP() {
		return new Random().nextInt(16);
	}

	public void KeyListener() throws Exception {
		mf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.out.println("Pressed " + e.getKeyCode());
				if (e.getKeyCode() == KeyEvent.VK_UP)
					moveUp();
				if (e.getKeyCode() == KeyEvent.VK_DOWN)
					moveDown();
				if (e.getKeyCode() == KeyEvent.VK_LEFT)
					moveLeft();
				if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					moveRight();
			}
		});
	}

	private void moveLeft() {
		int flag = 0;
		for (int i = 0; i < 4; i++) {
			if (gezi[flag + 3].getText() == null) {// 3空2不知1不知0不知
				if (gezi[flag + 2].getText() == null) {// 3空2空1不知0不知
					if (gezi[flag + 1].getText() == null) {// 3空2空1空0不知
						if (gezi[flag + 0].getText() == null) {// 3空2空1空0空
							// 都为空,无需操作
						} else {// 3空2空1空0有
							// 0格子不为空，无需操作
						}
					} else {// 3空2空1有0不知
						if (gezi[flag + 0].getText() == null) {// 3空2空1有0空
							move(flag, 1, 0);
						} else {// 3空2空1有0有
							isSame(flag, 1, 0);
						}
					}
				} else {// 3空2有1不知0不知
					if (gezi[flag + 1].getText() == null) {// 3空2有1空0不知
						if (gezi[flag + 0].getText() == null) {// 3空2有1空0空
							move(flag, 2, 0);
						} else {// 3空2有1空0有
							if (!isSame(flag, 2, 0)) {
								move(flag, 2, 1);
							}
						}
					} else {// 3空2有1有0不知
						if (gezi[flag + 0].getText() == null) {// 3空2有1有0空
							if (isSame(flag, 2, 1)) {
								move(flag, 1, 0);
							} else {
								move(flag, 1, 0);
								move(flag, 2, 1);
							}
						} else {// 3空2有1有0有
							if (!isSame(flag, 2, 1)) {
								if (isSame(flag, 1, 0)) {
									move(flag, 2, 1);
								}
							}
						}
					}
				}
			} else {// 3有2不知1不知0不知
				if (gezi[flag + 2].getText() == null) {// 3有2空1不知0不知
					if (gezi[flag + 1].getText() == null) {// 3有2空1空0不知
						if (gezi[flag + 0].getText() == null) {// 3有2空1空0空
							move(flag, 3, 0);
						} else {// 3有2空1空0有
							if (!isSame(flag, 3, 0)) {
								move(flag, 3, 1);
							}
						}
					} else {// 3有2空1有0不知
						if (gezi[flag + 0].getText() == null) {// 3有2空1有0空
							if (isSame(flag, 3, 1)) {
								move(flag, 1, 0);
							} else {
								move(flag, 1, 0);
								move(flag, 3, 1);
							}
						} else {// 3有2空1有0有
							if (!isSame(flag, 3, 1)) {
								move(flag, 3, 2);
							}
						}
					}
				} else {// 3有2有1不知0不知
					if (gezi[flag + 1].getText() == null) {// 3有2有1空0不知
						if (gezi[flag + 0].getText() == null) {// 3有2有1空0空
							if (isSame(flag, 3, 2)) {
								move(flag, 2, 0);
							} else {
								move(flag, 2, 0);
								move(flag, 3, 1);
							}
						} else {// 3有2有1空0有
							if (isSame(flag, 3, 2)) {
								move(flag, 2, 1);
							} else {
								move(flag, 2, 1);
								move(flag, 3, 2);
							}
						}
					} else {// 3有2有1有0不知
						if (gezi[flag + 0].getText() == null) {// 3有2有1有0空
							if (isSame(flag, 3, 2)) {
								move(flag, 1, 0);
								move(flag, 2, 1);
							} else {
								if (isSame(flag, 2, 1)) {
									move(flag, 1, 0);
									move(flag, 3, 1);
								} else {
									move(flag, 1, 0);
									move(flag, 2, 1);
									move(flag, 3, 2);
								}
							}
						} else {// 3有2有1有0有
							if (isSame(flag, 3, 2)) {
								if (isSame(flag, 1, 0)) {
									move(flag, 2, 1);
								}
							} else {
								if (isSame(flag, 2, 1)) {
									move(flag, 3, 2);
								} else {
									if (isSame(flag, 1, 0)) {
										move(flag, 2, 1);
										move(flag, 3, 2);
									}
								}
							}
						}
					}
				}
			}
			flag = flag + 4;
		}
		addOne();
	}

	private void addOne() {
		while (true) {
			int newone = getRandomP();
			int[] had = new int[16];
			for (int i = 0; i < 16; i++) {
				if (gezi[i].getText() != null) {
					had[i] = -1;
				}else {
					had[i] = i;
				}
			}
			
			if (had[newone] != -1) {
				setVal(gezi[newone]);
				break;
			}
			boolean flag = false;
			for (int i = 0; i < 16; i++) {
				if (had[i] != -1) {
					flag = true;
				}
			}
			if (!flag) {
				System.out.println("full");
//				System.out.println(Arrays.toString(had));
				JDialog jd = new JDialog(mf, "You Lose", true);
				
				return;
			}
		}

	}

	private void move(int flag, int i, int j) {
		gezi[flag + j].setText(gezi[flag + i].getText());
		gezi[flag + i].setText(null);
	}

	private boolean isSame(int flag, int j, int k) {
		if (gezi[flag + j].getText().equals(gezi[flag + k].getText())) {
			gezi[flag + k].setText(String.valueOf(Integer.valueOf(gezi[flag + k].getText()) * 2));
			gezi[flag + j].setText(null);
			return true;
		} else {

		}
		return false;
	}

	private void moveDown() {

	}

	private void moveUp() {

	}

	protected void moveRight() {

	}

	private void setStartButton() {
		startButton.setBounds(480, 350, 110, 50);
		startButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// String.valueOf((Integer.valueOf(gezi[5].getText()) + 5));
				// gezi[5].setText(String.valueOf((Integer.valueOf(gezi[5].getText())
				// + 5)));
				reset();
				// mf.requestFocus();
			}
		});
	}

	private void setItem() {
		items[0] = new JButton();
		items[0].setBounds(10, 10, 90, 90);
		items[0].setText("2048");
		fp.add(items[0]);
	}

	private void setFP() {
		// bp.setLayout(null);
		// bp.setBackground(null);
		bp.setBounds(15, 15, 410, 410);
	}

	private void setGezi() {
		int x = 10;
		int y = 10;
		int a = 0;
		for (int i = 0; i < 16; i++) {
			gezi[i] = new JLabel("5");
			gezi[i].setFont(new Font("JLF", Font.BOLD, 29));
			gezi[i].setHorizontalAlignment(SwingConstants.CENTER);
			;
			gezi[i].setBounds(x, y, 90, 90);
			gezi[i].setBackground(Color.LIGHT_GRAY);
			gezi[i].setOpaque(true);
			ps[i] = new Point(x, y);
			a++;
			x = x + 100;
			if (a == 4) {
				a = 0;
				x = 10;
				y = y + 100;
			}
			bp.add(gezi[i]);
		}
	}

	private void setBP() {
		bp.setLayout(null);
		bp.setBackground(Color.darkGray);
		bp.setBounds(10, 10, 410, 410);
	}

	private void setMF() {
		mf.setResizable(false);
		mf.setLayout(null);
		mf.setBounds((SRCX - 640) / 2, (SRCY - 460) / 2, 640, 460);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.getContentPane().setBackground(Color.lightGray);
		mf.setFocusable(true);
		//mf.setAutoRequestFocus(true);
		mf.setFocusCycleRoot(true);
	}

	public void play() {
		mf.add(startButton);
		mf.add(bp);
		// mf.add(fp);
		//mf.setVisible(true);
		//mf.getFocusableWindowState();

	}

	public static void main(String[] args) throws Exception {
		new My2048().play();
	}

}
