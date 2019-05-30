package TEST;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.csvreader.CsvReader;

import TEST.testpoint2.UpdateThread;
import jxl.write.Border;

@SuppressWarnings("deprecation")
public class testpoint2 {
	int suofangh=88,suofangw=93,hc=0,times=1000,index=0,x=10,y=10,save=0,save2=0;
	String[] choosecalendar;
	JComboBox h;
	int i=1;
	JLabel[] label={new JLabel("选定时间"),new JLabel("正常速度"),new JLabel("无放大")};
	JButton[] button={new JButton("恢复"),new JButton("暂停"),new JButton("快进"),new JButton("放大"),new JButton("缩小")};
	public int getSuofangh() {
		return suofangh;
	}
	public void setSuofangh(int suofangh) {
		this.suofangh = suofangh;
	}
	public int getSuofangw() {
		return suofangw;
	}
	public void setSuofangw(int suofangw) {
		this.suofangw = suofangw;
	}
	public int getHc() {
		return hc;
	}
	public void setHc(int hc) {
		this.hc = hc;
	}

	private Graphics2D g2d;
	 private BufferStrategy bs;
	String[] id;
	String[] name;
	String[] data;
	String[] calendar;
	String selectcalendar="全部";
	String selectid;
	String[] chooseid;
	String[] choosename;
	double[] gpsdata;
	double[] longitude;
	double[] latitude;
	double[] choosedata;
	double MaxX=0,MaxY=0,MinX=0,MinY=0;
	JFrame frame=new JFrame("GPS");
	 Graphics g;
	 JLabel imagel;
	JPanel[] panel={new JPanel(null),new JPanel(null)};
	public String getSelectcalendar() {
		return selectcalendar;
	}
	public void setSelectcalendar(String selectcalendar) {
		this.selectcalendar = selectcalendar;
	}
	 public int getTimes() {
			return times;
		}
		public void setTimes(int times) {
			this.times = times;
		}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getIndex() {
		return index;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public testpoint2(){
		read();
		unselect();
		frame.setSize(1120, 560);
		Container c=frame.getContentPane();
		frame.getLayeredPane().setLayout(null); 
		frame.setLayout(null);
		panel[1].setBounds(0, 0, 880, 560);
		panel[0].setBounds(880, 0, 240, 560);
		panel[1].setOpaque(false);
		panel[0].setOpaque(true);
		imagel.setBounds(0, 0, 880, 540);
		panel[1].add(imagel);
		
		panel[0].setBackground(Color.red);
		//panel[1].add(panel[0]);
		c.add(panel[1]);
		c.add(panel[0]);
		frame.setVisible(true);
		
		frame.getLayeredPane().add(panel[1],new Integer(Integer.MIN_VALUE));
		frame.getLayeredPane().add(panel[0],new Integer(Integer.MAX_VALUE));
		frame.setResizable(false);
		frame.createBufferStrategy(2);
        bs =frame.getBufferStrategy();
        ImageIcon background = new ImageIcon();
        background.setImage(bs);
        imagel=new JLabel(bs);
        g2d =(Graphics2D)bs.getDrawGraphics();
        choose_calendar();
		choosecalendar[0]="全部";
        h=new JComboBox(choosecalendar);
		label[0].setBounds(10+880, 3, 70, 70);
		h.setBounds(80, 30, 150, 20);
		button[0].setBounds(10+880, 80, 60, 20);
		button[1].setBounds(80, 80, 60, 20);
		button[2].setBounds(150, 80, 60, 20);
		label[1].setBounds(10, 100, 70, 70);
		button[3].setBounds(10, 160, 60, 20);
		button[4].setBounds(80, 160, 60, 20);
		label[2].setBounds(10, 180, 70, 70);
		panel[0].add(h);
		panel[0].add(label[0]);
		panel[0].add(label[1]);
		panel[0].add(label[2]);
		panel[0].add(button[0]);
		panel[0].add(button[1]);
		panel[0].add(button[2]);
		panel[0].add(button[3]);
		panel[0].add(button[4]);
		panel[0].setVisible(true);
		button[4].setEnabled(false);
		listener();
		
		
		new UpdateThread().start();
//		new Thread(new Runnable(){
//        	
//            public void run(){
//            	int loop=0;
//            	for(int row=0;row<save;row++){
//            		if(choosename[row].equals("GPS;longitude")){
//            			//setX((int)((((MaxX-MinX))/frame.getWidth())*(gpsdata[row]-(int)gpsdata[row])));
//            			 //setX((int)((((frame.getWidth()*(gpsdata[row]-(int)gpsdata[row]))/(MaxX-MinX)))%1000));
//            			double d=frame.getWidth()*(choosedata[row]-(int)choosedata[row])*200;
//            			d=(d-(int)d)*200;
//            			setX((int)d);
//            			loop++;}
//            		if(choosename[row].equals("GPS;latitude")){
//            			//setY((int)((((MaxY-MinY))/frame.getHeight())*(gpsdata[row]-(int)gpsdata[row])));
//            			//setY((int)((((frame.getHeight()*(gpsdata[row]-(int)gpsdata[row]))/(MaxY-MinY)))%1000));
//            			double f=frame.getHeight()*(choosedata[row]-(int)choosedata[row])*200;
//            			f=(f-(int)f)*200;
//            			setX((int)f);
//            			setY((int)f);
//            			loop++;}
//            		if(loop==2){
//            			loop=0;
//            			
//            			continue;
//            		}
//            		if(choosename[row]==null){
//            			break;
//            		}
//            		try {
//						Thread.sleep(200);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//            	}
//            }}).start();
	}
	
	public void choose_calendar(){
		String a;
		int i=1,d=1;
		int j=0;
		for(int k=0;k<calendar.length;k++){
			a=calendar[k];
			a=a.substring(0, a.indexOf(":")+3);
			for(i=1;i<calendar.length;i++){
				if(a.equals(choosecalendar[i])){
					j=1;
				}}
				 if(j==0){
					choosecalendar[d]=a;
					d++;
				   
				}else if(j==1){
					j=0;
					continue;
				}
		}
			
		}
	public void listener(){
		h.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			
			if(h.getSelectedIndex()==0){
				setSelectcalendar("全部");
				clear();
				unselect();
			}
			else{
				setSelectcalendar(choosecalendar[h.getSelectedIndex()]);
				clear();
				select();
			}
			
		}
		});
		
		
		button[0].addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			setTimes(1000);
			button[2].setEnabled(true);
					i=1;
			label[1].setText("正常速度");
		}});
		button[1].addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			
			if(button[1].getText().equals("暂停")){
				button[1].setText("播放");
				setHc(1);
			}
			else if(button[1].getText().equals("播放")){
				button[1].setText("暂停");
				setHc(0);
			}
		}});
		button[2].addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			i++;
			if(i>=10){
				i=10;
			button[2].setEnabled(false);}
			setTimes(1000/i);
			label[1].setText("快进"+i+"倍");
			
		}});
		button[3].addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			setSuofangh(88*2);
			setSuofangw(93*2);
			button[3].setEnabled(false);
			button[4].setEnabled(true);
			label[2].setText("已放大");
		}});
		button[4].addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			setSuofangh(88);
			setSuofangw(93);
			button[3].setEnabled(true);
			button[4].setEnabled(false);
			label[2].setText("无放大");
			
		}});
	}
	

	public void draw(){
		
		Image image = panel[1].createImage(880, 540);
		frame.getLayeredPane().add(panel[0],new Integer(Integer.MAX_VALUE));
        Graphics gg = image.getGraphics();
        bufferedPaint(gg);
        gg.dispose();
        
		g2d.clearRect(0, 0,880,540);
		
		g2d.setColor(Color.black);
		for(int index=1;index<11;index++){
	    	g2d.drawOval(suofangh*index,0,0,panel[1].getHeight());
		}
			for(int index=1;index<7;index++){
		    	g2d.drawOval(0,suofangw*index,panel[1].getWidth(),0);
			}	
		g2d.setColor(Color.red);
		g2d.drawString(selectid,x+50, y+50);
    	g2d.drawOval(x,y,40,40);	
		bs.show();
		
	
	}
	private void bufferedPaint(Graphics gg) {
        gg.fillOval(x, y, panel[1].getWidth(), panel[1].getHeight());
    }
//	public void panel_first(){
//		g=panel[0].getGraphics();
//		paint_panel_first(g);
//	}
	public void paint_panel_first(Graphics g){
//		for(int index=1;index<11;index++){
//    	g.drawOval(88*index,0,0,frame.getHeight());
//	}
//		for(int index=1;index<7;index++){
//	    	g.drawOval(0,90*index,frame.getWidth(),0);
//		}	
	}
	
	public void unselect(){
	      int row=0;
	     
	  		 for(int index=0;index<getIndex();index++){
	      			
	  				choosedata[row]=gpsdata[index];
	  				choosename[row]=name[index];
	  				chooseid[row]=id[index];
	  				row++;
	  				// System.out.println(choosename[row-1]);
	      			}
	  		 System.out.println(choosedata[row-1]);
	  		 	save=row;
	  		 	int i=0;
	  		 for(row=0;row<save;row++){
	  			if(choosename[row].equals("GPS;longitude"))
	  			{
	  				longitude[i]=choosedata[row];
	  				i++;
	  			}
	  			if(choosename[row].equals("GPS;latitude"))
	  			{
	  				latitude[i]=choosedata[row];
	  				i++;
	  			}
	  			if(choosename[row]==null){
	  				break;
	  			}
	          }
	  		i=save2;
	             for(int index=0;index<save;index++){
	     			if(longitude[index]!=0){
	 				MaxX=Math.max(longitude[index], MaxX);}
	     			
	     			if(latitude[index]!=0){
	     				MaxY=Math.max(latitude[index], MaxY);}
	 				
	 		}
	             for(int index=0;index<save;index++){
	            	 if(longitude[index]!=0){
	  				MinX=Math.min(longitude[index], MaxX);}
	            	 if(latitude[index]!=0){
	  				MinY=Math.min(latitude[index], MaxY);
	            	 }
	  		}
	             System.out.println(MaxX-MinX);
	             
	         }
	public void clear(){
		for(int i=0;i<save;i++){
			choosedata[i]=0;
			choosename[i]="";
			chooseid[i]="";
		}
		for(int i=0;i<save2;i++){
			longitude[i]=0;
			latitude[i]=0;
		}
		
	}
	
	public void select(){
	      int row=0;
	 	 
	  		 for(int index=0;index<getIndex();index++){
	      			if(calendar[index].indexOf(getSelectcalendar())!=-1){
	  				choosedata[row]=gpsdata[index];
	  				choosename[row]=name[index];
	  				chooseid[row]=id[index];
	  				row++;
	  				// System.out.println(choosename[row-1]);
	      			}}
	  		 	save=row;
	  		 	int i=0;
	  		 for(row=0;row<save;row++){
	  			if(choosename[row].equals("GPS;longitude"))
	  			{
	  				longitude[i]=choosedata[row];
	  				i++;
	  			}
	  			if(choosename[row].equals("GPS;latitude"))
	  			{
	  				latitude[i]=choosedata[row];
	  				i++;
	  			}
	  			if(choosename[row]==null){
	  				break;
	  			}
	          }
	  		 i=save2;
	             for(int index=0;index<save;index++){
	     			if(longitude[index]!=0){
	 				MaxX=Math.max(longitude[index], MaxX);}
	     			
	     			if(latitude[index]!=0){
	     				MaxY=Math.max(latitude[index], MaxY);}
	 				
	 		}
	             for(int index=0;index<save;index++){
	            	 if(longitude[index]!=0){
	  				MinX=Math.min(longitude[index], MaxX);}
	            	 if(latitude[index]!=0){
	  				MinY=Math.min(latitude[index], MaxY);
	            	 }
	  		}
	             System.out.println(MaxX-MinX);
	             
	         }
	
	
	public void read(){
		 try {       
             ArrayList<String[]> csvList = new ArrayList<String[]>(); //用来保存数据  
             String csvFilePath ="c:\\sensorlog.csv";
            //String csvFilePath ="/Users/LJL/Desktop/sensorlog.csv";   
             CsvReader reader = new CsvReader(csvFilePath,',',Charset.forName("utf-8"));    //一般用这编码读就可以了      
                 
             //reader.readHeaders(); // 跳过表头。  
                 
             while(reader.readRecord()){ //逐行读入数据      
                 csvList.add(reader.getValues());   
             }               
             reader.close();   
             setIndex(csvList.size()); 
             data=new String[getIndex()];
             id=new String[getIndex()];
             name=new String[getIndex()];
             calendar=new String[getIndex()];
             gpsdata=new double[getIndex()];
             longitude=new double[getIndex()];
         	 latitude=new double[getIndex()];
         	 choosedata=new double[getIndex()];
         	choosename=new String[getIndex()];
         	chooseid=new String[getIndex()];
         	choosecalendar=new String[getIndex()];
             for(int row=0;row<csvList.size();row++){  
                id[row] = csvList.get(row)[0];
            	name[row] = csvList.get(row)[1]; //取得第row行第0列的数据 
                calendar[row]=csvList.get(row)[2];
                data[row] = csvList.get(row)[3];
                gpsdata[row]=Math.abs(Double.parseDouble(data[row]));
             } }catch (Exception ex) {
            	
                 System.out.println(ex);   
             }  
            
             
         
    
		 }
	
	 class UpdateThread extends Thread {
	        public void run() {
	        	int loop=0;
	        	for(;;){
	        	if(hc==1){
                	sleep(1000);
                	continue;
                }
	        	
            	for(int row=0;row<save;row++){
            		if(hc==0){
            		if(choosename[row].equals("GPS;longitude")){
            			//setX((int)((((MaxX-MinX))/frame.getWidth())*(gpsdata[row]-(int)gpsdata[row])));
            			 //setX((int)((((frame.getWidth()*(gpsdata[row]-(int)gpsdata[row]))/(MaxX-MinX)))%1000));
            			double d=frame.getWidth()*(choosedata[row]-(int)choosedata[row])/(MaxX-MinX+1);
            			d=(d-(int)d)*300;
            			setX((int)d);
            			loop++;
            			selectid=chooseid[row];}
            		if(choosename[row].equals("GPS;latitude")){
            			//setY((int)((((MaxY-MinY))/frame.getHeight())*(gpsdata[row]-(int)gpsdata[row])));
            			//setY((int)((((frame.getHeight()*(gpsdata[row]-(int)gpsdata[row]))/(MaxY-MinY)))%1000));
            			double f=frame.getHeight()*(choosedata[row]-(int)choosedata[row])/(MaxY-MinY+1);
            			f=(f-(int)f)*300;
            			setX((int)f);
            			setY((int)f);
            			loop++;
            			selectid=chooseid[row];}
            		if(loop==2){
            			loop=0;
            			 draw();
            				
            			 sleep(times);
            			 
            			continue;
            		}
            		if(choosename[row]==null){
            			break;
            		}}}}
	        	
	        }
	        
	        private void sleep(int millis) {
	            try {
	            	frame.getLayeredPane().add(panel[0],new Integer(Integer.MAX_VALUE));
	                Thread.sleep(millis);
	                
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	  
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			//Point a=new Point();
			testpoint2 a=new testpoint2();
			
			
		}
	

}
