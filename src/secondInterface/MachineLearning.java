
package secondInterface;

import java.util.ArrayList;

public interface MachineLearning {
    
    public ArrayList<Imagebean> BindData();
    
    public ArrayList<Commentbean> getcomment();
    
    public float calculateReview(int img_id);
    
    public int findReview(String com);
    
    public int getCommentfor1Word(String key);
    
}
