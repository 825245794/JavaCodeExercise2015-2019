package TEST;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * @description Robot帮助类，实现基本的功能

 * @date 2013/5/18
 *
 */
public class COC extends Thread {

	
	static Robot r;
	
    /**
     * 鼠标单击（左击）,要双击就连续调用
     * 
     * @param r
     * @param x
     *            x坐标位置
     * @param y
     *            y坐标位置
     * @param delay
     *            该操作后的延迟时间
     */
	public int x,y,x1,y1;
    public void setX1(int x1) {
		this.x1 = x1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	static Color color;
	public COC()
	{
		
		try {
		 r=new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		color=r.getPixelColor(x, y);
		System.out.println();
//		clickLMouse(r,x,y,1000);
//		movemouse(x1,y1);
//		clickLMouse(r,x1,y1,1000);
//		clickLMouse(r,x1,y1,1000);
//		clickLMouse(r,x1,y1,1000);
		}
	}
	public void clickLMouse(Robot r, int x2, int y2,int delay) {
		//r.delay(1000);
        r.mouseMove(x2, y2);
        r.mousePress(InputEvent.BUTTON1_MASK);
        r.delay(900);
        r.mouseRelease(InputEvent.BUTTON1_MASK);
        r.delay(delay);
        
    }
	
	public void movemouse(int x2,int y2)
	{
		r.mouseMove(x2, y2);
	}
	
    /**
     * 捕捉全屏慕
     * 
     * @param r
     * @return
     */
	public void run()
	{
		Color t = null;
		t.getHSBColor(192, 225, 104);
		Color s = null;
		
		s=r.getPixelColor(x, y);
		clickLMouse(r,x,y,1000);
		clickLMouse(r,x,y,1000);
		//a.clickLMouse(r,47,135,100);
		clickLMouse(r,x1,y1,1000);
		clickLMouse(r,x1,y1,1000);
		clickLMouse(r,x1,y1,1000);
		clickLMouse(r,x1,y1,1000);
		//clickLMouse(r,x,y,1000);
		r.delay(5000);
		
			
		
	}
	public void run2()
	{
		Scanner in=new Scanner(System.in);
		int i[]={KeyEvent.VK_F1};
		
		//r.delay(1000);
		run();
	}
	
    public Icon captureFullScreen(Robot r) {
        BufferedImage fullScreenImage = r.createScreenCapture(new Rectangle(
                Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIcon icon = new ImageIcon(fullScreenImage);
        return icon;
    }

    /**
     * 捕捉屏幕的一个矫形区域
     * 
     * @param r
     * @param x
     *            x坐标位置
     * @param y
     *            y坐标位置
     * @param width
     *            矩形的宽
     * @param height
     *            矩形的高
     * @return
     */
    public Icon capturePartScreen(Robot r, int x, int y, int width, int height) {
        r.mouseMove(x, y);
        BufferedImage fullScreenImage = r.createScreenCapture(new Rectangle(
                width, height));
        ImageIcon icon = new ImageIcon(fullScreenImage);
        return icon;
    }







	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1280*720
		COC a=new COC();
		int x=1073,y=790;
		int x1=1217,y1=467;
		a.setX(x);
		a.setY(y);
		a.setX1(x1);
		a.setY1(y1);
		Color t;
		 t=r.getPixelColor(x, y);
		int j=0;
		while(t!=color)
		{
		 t=r.getPixelColor(x, y);
			if(j==2)
				break;
		a.run2();
		j++;
		}
//		for(int i=0;i<5;i++)
//		{		
//		
//		a.run2();
//		System.out.println(i);
//		r.delay(3000);
//		}
		
	
	}

}
