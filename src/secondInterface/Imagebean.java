
package secondInterface;

public class Imagebean {
    private int img_id;
    private String uploader;
    private byte[] image;
    private String uploader_id;
    public Imagebean(){}
    public Imagebean(int img_id,String uploader,byte[] image,String uploader_id){
        this.img_id=img_id;
        this.uploader=uploader;
        this.image=image;
        this.uploader_id=uploader_id;
    }
    public int getImgid(){
        return img_id;
    }
    public String getUploader(){
        return uploader;
    }
    public byte[] getMyImage(){
        return image;
    }
    public String getUploaderid(){
        return uploader_id;
    }
}
