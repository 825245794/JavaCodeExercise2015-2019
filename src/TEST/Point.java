package TEST;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.image.BufferStrategy;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.csvreader.CsvReader;

public class Point {
	int suofangh=88,suofangw=93,hc=0,times=1000,index=0,x=10,y=10,save=0,save2=0;
	JLabel label=new JLabel("Device ID");
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
	JComboBox h;
	private Graphics2D g2d;
	 private BufferStrategy bs;
	String[] id;
	String[] name;
	String[] data;
	String[] calendar;
	String[] calendar2;
	String selectcalendar="全部";
	String selectid;
	String[] chooseid;
	String[] choosecalendar;
	String[] choosename;
	double[] gpsdata;
	double[] longitude;
	double[] latitude;
	double[] choosedata;
	double MaxX=0,MaxY=0,MinX=0,MinY=0;
	JFrame frame=new JFrame("GPS");
	 Graphics g;
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
	public Point(){
		read();
		unselect();
		frame.setSize(880, 560);
		Container c=frame.getContentPane();
		panel[0].setSize(880, 560);
		panel[1].setSize(880, 560);
		frame.add(panel[0]);
		panel[0].add(panel[1]);
		frame.setVisible(true);
		panel_first();
		frame.setResizable(false);
		frame.createBufferStrategy(1);
        bs =frame.getBufferStrategy();
        g2d =(Graphics2D)bs.getDrawGraphics();
        label.setForeground(Color.red);
        label.setOpaque(true);
        label.setBackground(Color.white);
		panel[1].add(label);
		
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
	
	

	public void draw(){
		
		Image image = frame.createImage(frame.getWidth(), frame.getHeight());
		
        Graphics gg = image.getGraphics();
        bufferedPaint(gg);
        gg.dispose();
        
		g2d.clearRect(0, 0, panel[1].getWidth(),panel[1].getHeight());
		
		g2d.setColor(Color.black);
		for(int index=1;index<111;index++){
	    	g2d.drawOval(suofangh*index/10,0,0,frame.getHeight());
		}
			for(int index=1;index<71;index++){
		    	g2d.drawOval(0,suofangw*index/10,frame.getWidth(),0);
			}	
		g2d.setColor(Color.red);
		
			g2d.drawString(selectid,x+8, y+8);
			g2d.drawOval(x,y,3,3);
		bs.show();
		
	}
	private void bufferedPaint(Graphics gg) {
        gg.fillOval(x*2, 2*y, frame.getWidth(), frame.getHeight());
    }
	public void panel_first(){
		g=panel[0].getGraphics();
		paint_panel_first(g);
	}
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
	  		 for(row=0;row<getIndex();row++){
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
	             for(int index=0;index<getIndex();index++){
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
	 	 String r=String.valueOf(h.getSelectedItem());
	 	r= r.substring(0, r.indexOf(":"));
	  		 for(int index=0;index<getIndex();index++){
	      			if(calendar[index].indexOf(r)!=-1){
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
//	  		 String a=choosecalendar[0];
//	  		 a=a.substring(0, a.indexOf(":")-3);
//	  		 System.out.println(a);
	             for(int index=0;index<save2;index++){
	            	 
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
             ArrayList<String[]> csvList = new ArrayList<String[]>(); //�����������  
             String csvFilePath ="c:\\sensorlog.csv";
            //String csvFilePath ="/Users/LJL/Desktop/sensorlog.csv";   
             CsvReader reader = new CsvReader(csvFilePath,',',Charset.forName("utf-8"));    //һ�����������Ϳ�����      
                 
             //reader.readHeaders(); // ����ͷ��  
                 
             while(reader.readRecord()){ //���ж������      
                 csvList.add(reader.getValues());   
             }               
             reader.close();   
             setIndex(csvList.size()); 
             data=new String[getIndex()];
             id=new String[getIndex()];
             name=new String[getIndex()];
             calendar=new String[getIndex()];
             calendar2=new String[getIndex()];
             gpsdata=new double[getIndex()];
             longitude=new double[getIndex()];
         	 latitude=new double[getIndex()];
         	 choosedata=new double[getIndex()];
         	choosename=new String[getIndex()];
         	chooseid=new String[getIndex()];
         	choosecalendar=new String[getIndex()];
             for(int row=0;row<csvList.size();row++){  
                id[row] = csvList.get(row)[0];
            	name[row] = csvList.get(row)[1]; //ȡ�õ�row�е�0�е���� 
                calendar[row]=csvList.get(row)[2];
                calendar2[row]=csvList.get(row)[2];
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
         			double d=panel[1].getWidth()*(choosedata[row]-(int)choosedata[row])/(MaxX-MinX+20);
         			d=(d-(int)d)*300+0.9;
         			setX((int)d);
         			loop++;
         			selectid=chooseid[row];}
         		if(choosename[row].equals("GPS;latitude")){
         			//setY((int)((((MaxY-MinY))/frame.getHeight())*(gpsdata[row]-(int)gpsdata[row])));
         			//setY((int)((((frame.getHeight()*(gpsdata[row]-(int)gpsdata[row]))/(MaxY-MinY)))%1000));
         			double f=panel[1].getHeight()*(choosedata[row]-(int)choosedata[row])/(MaxY-MinY+20);
         			f=(f-(int)f)*300+0.9;
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
	                Thread.sleep(millis);
	                
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	 }}
