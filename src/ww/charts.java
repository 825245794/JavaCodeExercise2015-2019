package ww;
import java.applet.*;  
import java.util.*;  
import java.awt.*;  
import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.Timer;  
/* 
 * java 画sin曲线 
 */  
public class charts extends JPanel {  
  
    static int LEN;  
    static int Xo, Yo; //坐标原点(Xo,Yo)  
    static int X2, Y2; //X轴顶点坐标(Xo,Yo)  
    static final int X1 = 50, Y1 = 30; //Y轴顶点坐标(Xo,Yo)  
    static int Yunit, Xunit;  
    static float Unit;  
    static String Xstr, Ystr;    
    static int[] Xval;  
    static int[] Yval;  
    static float[] Y = new float[5];  
    static int Xmax, Xmin;  
    static float Ymax, Ymin;  
    static int[] Yvalue;  
    static int[] Xvalue;  
    static float tempy;  
    static int here = 0;  
    ;  
    ActionListener timerActionListener = new ActionListener() {  
        public void actionPerformed(ActionEvent evect) {  
            Ystr = "";  
            here++;  
            for (int i = 0 + here; i < 100 + here; i++) {  
                Ystr += (int) (Math.sin(Math.PI * i / 25) * 100 + 100) + ",";  
            }  
            Yvalue = getY(Yunit, tempy, Ymin, Substr(Ystr));  
            re();  
        }  
    };  
  
    public void re() {  
        this.repaint();  
    }  
  
    public void init() {  
        Timer miaobiaoTimer = new Timer(100, timerActionListener);  
        miaobiaoTimer.start();  
        //setBackground(Color.gray);   
        int width = this.getWidth();  
        int height = this.getHeight();  
        setSize(width, height);  
        //Xstr = getParameter("xValue");  
        Ystr = "100,112,124,136,148,158,168,177,184,190,195,198,199,199,198,195,190,184,177,168,158,148,136,124,112,100,87,75,63,51,41,31,22,15,9,4,1,0,0,1,4,9,15,22,31,41,51,63,75,87,100,112,124,136,148,158,168,177,184,190,195,198,199,199,198,195,190,184,177,168,158,148,136,124,112,100,87,75,63,51,41,31,22,15,9,4,1,0,0,1,4,9,15,22,31,41,51,63,75,87,";  
        //Ystr = getParameter("yValue");  
        Xstr = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50";  
        Xval = Substr(Xstr);  
        Yval = Substr(Ystr);  
        LEN = Xval.length;  
        Yvalue = new int[LEN];  
        Xvalue = new int[LEN];  
        Xo = 0;  
        Yo = height/2;  
        X2 = width;  
        Y2 = height/2;  
        Yunit = (height - 100) / 4;  
        Xunit = (width - 100) / LEN;  
        Ymax = getMaxVal(Yval);  
        Ymin = getMinVal(Yval);  
        tempy = ((float) Ymax - (float) Ymin) / 4;  
      
        Unit = (float) (Yunit * 4) / ((float) Ymax - (float) Ymin);  
        Yvalue = getY(Yunit, tempy, Ymin, Yval);  
    }  
  
    public static int[] getY(int unit, float diff, float ymin, int[] value) {  
        int I = 0; //unit=Yunit; diff=temp; ymin=Ymin  
        int[] result = new int[LEN];  
        for (I = 0; I < LEN; I++) {  
            result[I] = (int) (Yo - ((4 * unit) / (diff * 4)) * (value[I] - ymin));  
        }  
        return result;  
    }  
  
    public void paint(Graphics g) {  
       
        int I;  
    g.setColor(Color.black);  
        
        for (I = 0; I < LEN - 1; I++) {  
            g.drawLine(Xo + Xunit * I, Yvalue[I], Xo + Xunit * (I + 1), Yvalue[I + 1]);  
        }  
    }  
  
    public static int[] Substr(String str) {  
        int I = 0;  
        StringTokenizer st = new StringTokenizer(str, ",");  
        int len = st.countTokens();  
        int[] val = new int[len];  
        while (st.hasMoreTokens()) {  
            val[I] = Integer.parseInt(st.nextToken());  
            I++;  
        }  
        return val;  
    }  
  
    public static int getMaxVal(int[] Maxval) {  
        int I, result;  
        result = Maxval[0];  
        for (I = 0; I < Maxval.length; I++) {  
            if (result < Maxval[I]) {  
                result = Maxval[I];  
            }  
        }  
        return result;  
    }  
  
    public static int getMinVal(int[] Minval) {  
        int I, result;  
        result = Minval[0];  
        for (I = 0; I < Minval.length; I++) {  
            if (result > Minval[I]) {  
                result = Minval[I];  
            }  
        }  
        return result;  
    }  
}  