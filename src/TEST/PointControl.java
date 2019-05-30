package TEST;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import TEST.Point.UpdateThread;

public class PointControl extends Point {
	
	
	int i=1;
	JLabel[] label={new JLabel("选定时间"),new JLabel("正常速度"),new JLabel("无放大")};
	JButton[] button={new JButton("恢复"),new JButton("暂停"),new JButton("快进"),new JButton("放大"),new JButton("缩小")};
	public PointControl(){
		choose_calendar();
		JFrame f=new JFrame("Controler");
		f.setLayout(null);
		f.setSize(240, 560);
		choosecalendar[0]="全部";
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		h=new JComboBox(choosecalendar);
		label[0].setBounds(10, 3, 70, 70);
		h.setBounds(80, 30, 150, 20);
		button[0].setBounds(10, 80, 60, 20);
		button[1].setBounds(80, 80, 60, 20);
		button[2].setBounds(150, 80, 60, 20);
		label[1].setBounds(10, 100, 70, 70);
		button[3].setBounds(10, 160, 60, 20);
		button[4].setBounds(80, 160, 60, 20);
		label[2].setBounds(10, 180, 70, 70);
		f.add(h);
		f.add(label[0]);
		f.add(label[1]);
		f.add(label[2]);
		f.add(button[0]);
		f.add(button[1]);
		f.add(button[2]);
		f.add(button[3]);
		f.add(button[4]);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screensize.getWidth();
		int screenHeight = (int)screensize.getHeight();
		f.setLocation(895,0);
		f.setVisible(true);
		button[4].setEnabled(false);
		listener();
		new UpdateThread().start();
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
//	public void choose_calendar(){
//		String a;
//		int i=1,d=1;
//		int j=0;
//		for(int k=0;k<calendar.length;k++){
//			a=calendar[k];
//			a=a.substring(0, a.indexOf(":")+3);
//			for(i=1;i<calendar.length;i++){
//				if(a.equals(choosecalendar[i])){
//					j=1;
//				}}
//				 if(j==0){
//					choosecalendar[d]=a;
//					d++;
//				   
//				}else if(j==1){
//					j=0;
//					continue;
//				}
//		}}
		public void choose_calendar() {
			int h1=0;
			int max=0;
			int min=0;
			try{
			for(int i=1;i<calendar.length;i++){
				String aa=calendar[i];
				String bb=calendar[i-1];
				String aa2;
				String bb2;
			aa2=aa.substring(aa.indexOf(" ")-aa.indexOf(" "),aa.indexOf(" "));
				bb2=bb.substring(0);
				System.out.println(bb2);
				String afore=calendar[i];
				String bfore=calendar[i-1];
				String aafter=calendar[i];
				String bafter=calendar[i-1];
				
			
					afore=afore.substring(afore.indexOf(":")-2, afore.indexOf(":"));
					
					 bfore=bfore.substring(bfore.indexOf(":")-2, bfore.indexOf(":"));
					 aafter= aafter.substring( aafter.indexOf(":")+1,  aafter.indexOf(":")+3);
					 String aafter2=aafter;
					bafter=bafter.substring(bafter.indexOf(":")+1,bafter.indexOf(":")+3);
					
					if(aafter2.substring(0, 1).equals(" ")){
						aafter=aafter.substring(1);
					}
					System.out.println(Integer.parseInt(bafter)-Integer.parseInt(aafter));
					if(aa2.indexOf(bb2)!=-1||afore.equals(bfore)&&(Integer.parseInt(bafter)-Integer.parseInt(aafter)<=1)){
						continue;
					}
					else{
						max=i-1;
						;
						calendar[max]=calendar[max].substring(calendar[max].indexOf(":")-2,calendar[max-1].indexOf(":")+3);
						choosecalendar[h1]=calendar2[min]+"~"+calendar[max];
						min=i+1;
						h1++;
						
					}
			}}catch(Exception e){}
			
		}
		
//	public void choose_calendar(){
//		String a="";
//		int j=1;
//		for(int i=0;i<calendar.length;i++){
//			if(a.equals(calendar[i])){
//				continue;
//			}
//			else{
//				choosecalendar[j]=calendar[i];
//				j++;
//				a=calendar[i];
//				
//			}
//		}
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Point a=new Point();
		PointControl a=new PointControl();
		
		
	}
}

//label[0].setBounds(30, 3, 100, 100);
//h.setBounds(80, 30, 160, 50);
//button[0].setBounds(30, 80, 50, 20);
//button[1].setBounds(90, 80, 50, 20);
//button[2].setBounds(150, 80, 50, 20);
//label[1].setBounds(30, 100, 90, 50);
//button[3].setBounds(30, 150, 50, 20);
//button[4].setBounds(90, 150, 50, 20);
//label[2].setBounds(30, 170, 90, 50);