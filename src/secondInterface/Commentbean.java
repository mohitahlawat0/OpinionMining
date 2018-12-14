
package secondInterface;

public class Commentbean {
    private String commenter;
    private String comment;
    private int review;
    public Commentbean(){}
    public Commentbean(String commenter,String comment,int review){
        this.commenter=commenter;
        this.comment=comment;
        this.review=review;
    }
    public String getCommenter(){
        return commenter;
    }
    public String getComment(){
        return comment;
    }
    public int getReview(){
        return review;
    }
}
