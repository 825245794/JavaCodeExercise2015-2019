package web;

public class CheckCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImagePreProcess.srcPath = ctrackcode_srcimg;
		ImagePreProcess.trainPath = ctrackcode_trainimg;
		String name = request.getParameter("c").toString();      //给图片加个缓存名称
	        String checkcodeUrl = request.getParameter("url").toString();  //此图片的地址

		String checkCodeImg="a";
		String secretcode = "";
				try{
					 checkCodeImg = ImagePreProcess.downloadImage(checkcodeUrl+"?", name+".png");				 
				}catch(Exception e){
				}
				if (checkCodeImg != "a" ||checkCodeImg != null ) {
						secretcode = ImagePreProcess.getAllOcr(checkCodeImg);
						File ml =new File(checkCodeImg);
						ml.delete();
						out.print(secretcode);
				}
	}

}
