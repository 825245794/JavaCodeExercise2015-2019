package LQBMONI;

import java.util.Arrays;

public class NO6 {
	static int[] a=new int[12];
	static int[] b=new int[12];
	static int total=0;
	public static boolean f(){
		Arrays.sort(b);
		for(int i=0;i<11;i++){
			if(b[i]==b[i+1])return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i1=1;i1<=13;i1++){
			for(int i2=1;i2<=13;i2++){
				if(i1==i2)continue;
				for(int i3=1;i3<=13;i3++){
					if(i1==i2||i2==i3||i3==i1)continue;
					for(int i4=1;i4<=13;i4++){
						if(i1==i4||i2==i4||i3==i4)continue;
						for(int i5=1;i5<=13;i5++){
							if(i1==i5||i2==i5||i3==i5||i4==i5)continue;
							for(int i6=1;i6<=13;i6++){
								if(i1==i6||i2==i6||i3==i6||i4==i6||i5==i6)continue;
								for(int i7=1;i7<=13;i7++){
									if(i1==i7||i2==i7||i3==i7||i4==i7||i5==i7||i6==i7)continue;
									for(int i8=1;i8<=13;i8++){
										if(i1==i8||i2==i8||i3==i8||i4==i8||i5==i8||i6==i8||i7==i8)continue;
										for(int i9=1;i9<=13;i9++){
											if(i1==i9||i2==i9||i3==i9||i4==i9||i5==i9||i6==i9||i7==i9||i8==i9)continue;
											for(int i10=1;i10<=13;i10++){
												if(i1==i10||i2==i10||i3==i10||i4==i10||i5==i10||i6==i10||i7==i10||i8==i10||i9==i10)continue;
												for(int i11=1;i11<=13;i11++){
													if(i1==i11||i2==i11||i3==i11||i4==i11||i5==i11||i6==i11||i7==i11||i8==i11||i9==i11||i10==i11)continue;
													for(int i12=1;i12<=13;i12++){
														if(i1==i12||i2==i12||i3==i12||i4==i12||i5==i12||i6==i12||i7==i12||i8==i12||i9==i12||i10==i12||i11==i12)continue;
														a[0]=i1;
														a[1]=i2;
														a[2]=i3;
														a[3]=i4;
														a[4]=i5;
														a[5]=i6;
														a[6]=i7;
														a[7]=i8;
														a[8]=i9;
														a[9]=i10;
														a[10]=i11;
														a[11]=i12;
														
														
															if((a[0]*a[1]+a[2]*a[3]==a[4]*a[5])&&(a[6]*a[7]-a[8]*a[9]==a[10]*a[11])){
																total++;
																System.out.println(total);
															
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

}
