
package secondInterface;

import connection.Createconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static secondInterface.Display.img_id;

public class MachineLearningImpl implements MachineLearning{
    //Function for BindData with ImageBean Object
    @Override
    public ArrayList<Imagebean> BindData(){
        ArrayList<Imagebean> list=new ArrayList<Imagebean>();
        try{
            Imagebean imgbean;
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con=null;
            if(con==null)
                con=connection.Createconnection.Connect();
            //DriverManager.getConnection("jdbc:mysql://localhost:3306/opinionmining","root","mysql@123456");
            PreparedStatement ps=null;
            ps=con.prepareStatement("select * from imgtbl order by img_id desc");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
               imgbean=new Imagebean(rs.getInt("img_id"),rs.getString("uploader"),rs.getBytes("image"),rs.getString("uploader_id"));
               list.add(imgbean);
               
            }
            ps.close();
            con.close();    
        }catch(SQLException  e){JOptionPane.showMessageDialog(null, e);}
        return list;
    }
    // This function Provides comment to display form
    @Override
    public ArrayList<Commentbean> getcomment(){
        Connection con=null;
        ArrayList<Commentbean> list=new ArrayList<Commentbean>();
        Commentbean comment;
        String query="select commenter,comment,review from ReviewTable where img_id=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        if(con==null)
            con=Createconnection.Connect();
        try{
            ps=con.prepareStatement(query);
            ps.setString(1, img_id);
            rs=ps.executeQuery();
            while(rs.next()){
                comment=new Commentbean(rs.getString(1),rs.getString(2),rs.getInt(3));
                list.add(comment);
            }
            ps.close();
            rs.close();
            con.close();
        }catch(SQLException e){System.out.println(e);}
        return list;
    }
    //This function return the Review for the Image
    @Override
    public float calculateReview(int img_id){
        float review=0.0f;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String query="select avg(review) from ReviewTable where img_id=?";
        Connection con=null;
        if(con==null)
            con=Createconnection.Connect();
        try{
            ps=con.prepareStatement(query);
            ps.setInt(1, img_id);
            rs=ps.executeQuery();
            if(rs.next()){
                review=rs.getFloat(1);
            }
            else
                review=0.0f;
            
        }catch(SQLException e){System.out.println(e);}
        finally{
                try{
                    if(ps!=null)
                        ps.close();
                    if(rs!=null)
                        rs.close();
                    if(con!=null)
                        con.close();}
                catch(SQLException e){System.out.println(e);}
                }
        
        return review;
    }
    @Override
    // This function return the review for one word
    public int getCommentfor1Word(String key){
        int j=0;
        if(key.equalsIgnoreCase("worst") || key.equalsIgnoreCase("ugly") || key.equalsIgnoreCase("dirty")
    || key.equalsIgnoreCase("off") || key.equalsIgnoreCase("waste") || key.equalsIgnoreCase("wtf") 
    || key.equalsIgnoreCase("fuck") || key.equalsIgnoreCase("looser")|| key.equalsIgnoreCase("donkey") 
    || key.equalsIgnoreCase("suck") || key.equalsIgnoreCase("lack")|| key.equalsIgnoreCase("useless") 
    || key.equalsIgnoreCase("boring") || key.equalsIgnoreCase("never") || key.equalsIgnoreCase("wrong")
    || key.equalsIgnoreCase("insult")|| key.equalsIgnoreCase("irresponsible") || key.equalsIgnoreCase("bully")
    || key.equalsIgnoreCase("rude")  || key.equalsIgnoreCase("untrusting")||key.equalsIgnoreCase("untrustable")
    || key.equalsIgnoreCase("stupid") || key.equalsIgnoreCase("dull") || key.equalsIgnoreCase("irritated")
    || key.equalsIgnoreCase("hell") || key.equalsIgnoreCase("fucked") || key.equalsIgnoreCase("bullshit")
    || key.equalsIgnoreCase("awful") || key.equalsIgnoreCase("dissatisfactory")|| key.equalsIgnoreCase("erroneous")
    || key.equalsIgnoreCase("faulty") || key.equalsIgnoreCase("inadequate") || key.equalsIgnoreCase("incorrect")
    || key.equalsIgnoreCase("unsatisfactory") || key.equalsIgnoreCase("unsatisfy")|| key.equalsIgnoreCase("lowest")
    || key.equalsIgnoreCase("inferior")|| key.equalsIgnoreCase("least")|| key.equalsIgnoreCase("unfavorable")
    || key.equalsIgnoreCase("mad") || key.equalsIgnoreCase("dissatisfied") || key.equalsIgnoreCase("dissatisfy"))
                        j=1;
    else if(key.equalsIgnoreCase("poor") || key.equalsIgnoreCase("bad")  || key.equalsIgnoreCase("overacting")
    || key.equalsIgnoreCase("hate")  || key.equalsIgnoreCase("dark")  || key.equalsIgnoreCase("out")  
    || key.equalsIgnoreCase("back")  || key.equalsIgnoreCase("cut")  || key.equalsIgnoreCase("trash")
    || key.equalsIgnoreCase("unfair") || key.equalsIgnoreCase("nobody") || key.equalsIgnoreCase("nothing")
    || key.equalsIgnoreCase("less") || key.equalsIgnoreCase("problem") || key.equalsIgnoreCase("careful")
    || key.equalsIgnoreCase("issue")|| key.equalsIgnoreCase("danger") || key.equalsIgnoreCase("dangerous")
    || key.equalsIgnoreCase("use") || key.equalsIgnoreCase("comparing") || key.equalsIgnoreCase("stressful")
    || key.equalsIgnoreCase("expensive") || key.equalsIgnoreCase("scary") || key.equalsIgnoreCase("horrible")
    || key.equalsIgnoreCase("fade") || key.equalsIgnoreCase("rough")|| key.equalsIgnoreCase("fake")
    || key.equalsIgnoreCase("cheap")|| key.equalsIgnoreCase("greedy") || key.equalsIgnoreCase("selfish")
    || key.equalsIgnoreCase("acceptable") || key.equalsIgnoreCase("crack")|| key.equalsIgnoreCase("cheater")
    || key.equalsIgnoreCase("sad") || key.equalsIgnoreCase("garbage") || key.equalsIgnoreCase("imperfect")
    || key.equalsIgnoreCase("careless")|| key.equalsIgnoreCase("tough")|| key.equalsIgnoreCase("correct"))
                        j=2;
    else if(key.equalsIgnoreCase("ok") || key.equalsIgnoreCase("good")  || key.equalsIgnoreCase("care")
    || key.equalsIgnoreCase("honest")  || key.equalsIgnoreCase("cool")  || key.equalsIgnoreCase("supportive")
    || key.equalsIgnoreCase("interest")  || key.equalsIgnoreCase("interested")  || key.equalsIgnoreCase("nice")
    || key.equalsIgnoreCase("positive")  || key.equalsIgnoreCase("well")  || key.equalsIgnoreCase("truth")
    || key.equalsIgnoreCase("handsome") || key.equalsIgnoreCase("cute") || key.equalsIgnoreCase("beautiful")
    || key.equalsIgnoreCase("smart") || key.equalsIgnoreCase("soft") || key.equalsIgnoreCase("clean")
    || key.equalsIgnoreCase("clear") || key.equalsIgnoreCase("killer") || key.equalsIgnoreCase("sweet")
    || key.equalsIgnoreCase("helpful") || key.equalsIgnoreCase("care") || key.equalsIgnoreCase("caring")
    || key.equalsIgnoreCase("sweet") || key.equalsIgnoreCase("happy") || key.equalsIgnoreCase("sexy")
    || key.equalsIgnoreCase("most") || key.equalsIgnoreCase("dream") || key.equalsIgnoreCase("favorable")
    || key.equalsIgnoreCase("positive") || key.equalsIgnoreCase("choice") || key.equalsIgnoreCase("welcome")
    || key.equalsIgnoreCase("congenial") || key.equalsIgnoreCase("neat")|| key.equalsIgnoreCase("fine")
    || key.equalsIgnoreCase("ideal")|| key.equalsIgnoreCase("terrific")|| key.equalsIgnoreCase("strong")
    || key.equalsIgnoreCase("big")|| key.equalsIgnoreCase("stable")|| key.equalsIgnoreCase("vigorous")
    || key.equalsIgnoreCase("hearty")|| key.equalsIgnoreCase("muscular")|| key.equalsIgnoreCase("manage")
    || key.equalsIgnoreCase("managed")|| key.equalsIgnoreCase("respect")|| key.equalsIgnoreCase("enjoyment")
    || key.equalsIgnoreCase("hot"))
                        j=3;
    else if(key.equalsIgnoreCase("better")  || key.equalsIgnoreCase("pretty") || key.equalsIgnoreCase("right")
    || key.equalsIgnoreCase("inspirational")||key.equalsIgnoreCase("perceptive")|| key.equalsIgnoreCase("beautiful")
    || key.equalsIgnoreCase("satisfied") || key.equalsIgnoreCase("satisfy") || key.equalsIgnoreCase("lovely")
    || key.equalsIgnoreCase("blessed") || key.equalsIgnoreCase("blessing") || key.equalsIgnoreCase("powerful")
    || key.equalsIgnoreCase("capable") || key.equalsIgnoreCase("crazy") || key.equalsIgnoreCase("craziest")
    || key.equalsIgnoreCase("impressive") || key.equalsIgnoreCase("attracted") || key.equalsIgnoreCase("memorable")
    || key.equalsIgnoreCase("hero") || key.equalsIgnoreCase("amazing") || key.equalsIgnoreCase("brave")
    || key.equalsIgnoreCase("superman") || key.equalsIgnoreCase("avengers") || key.equalsIgnoreCase("heaven")
    || key.equalsIgnoreCase("cutiepie") || key.equalsIgnoreCase("cutie") || key.equalsIgnoreCase("shona")
    || key.equalsIgnoreCase("baby") || key.equalsIgnoreCase("enamurous") || key.equalsIgnoreCase("desires")
    || key.equalsIgnoreCase("desire") || key.equalsIgnoreCase("desirable")|| key.equalsIgnoreCase("attractive")
    || key.equalsIgnoreCase("favourite") || key.equalsIgnoreCase("satisfactory") || key.equalsIgnoreCase("satisfying")
    || key.equalsIgnoreCase("valuable") || key.equalsIgnoreCase("boss") || key.equalsIgnoreCase("pleasing")
    || key.equalsIgnoreCase("worthy") || key.equalsIgnoreCase("admire") || key.equalsIgnoreCase("admirable")
    || key.equalsIgnoreCase("agreeable") || key.equalsIgnoreCase("commendable") || key.equalsIgnoreCase("deluxe")
    || key.equalsIgnoreCase("gratifying") || key.equalsIgnoreCase("precious")|| key.equalsIgnoreCase("alluring")
    || key.equalsIgnoreCase("appealing")|| key.equalsIgnoreCase("charming")|| key.equalsIgnoreCase("delicate")
    || key.equalsIgnoreCase("elegant")|| key.equalsIgnoreCase("fasciting")|| key.equalsIgnoreCase("graceful")
    || key.equalsIgnoreCase("pleasing")|| key.equalsIgnoreCase("pleasant")|| key.equalsIgnoreCase("passion") || key.equalsIgnoreCase("cloying")
            || key.equalsIgnoreCase("sugared") || key.equalsIgnoreCase("obliging") || key.equalsIgnoreCase("bright")
           || key.equalsIgnoreCase("lulu")  )
                        j=4; 
    else if(key.equalsIgnoreCase("Excellent") || key.equalsIgnoreCase("best") || key.equalsIgnoreCase("winner")
    || key.equalsIgnoreCase("famous") || key.equalsIgnoreCase("motivational") || key.equalsIgnoreCase("love")
    || key.equalsIgnoreCase("awesome") || key.equalsIgnoreCase("osm") || key.equalsIgnoreCase("perfect")
    || key.equalsIgnoreCase("wow") || key.equalsIgnoreCase("gorgeous") || key.equalsIgnoreCase("proud")
    || key.equalsIgnoreCase("great") || key.equalsIgnoreCase("stunning")  || key.equalsIgnoreCase("success")
    || key.equalsIgnoreCase("waow") || key.equalsIgnoreCase("fantastic") || key.equalsIgnoreCase("customized")
    || key.equalsIgnoreCase("wonderful") || key.equalsIgnoreCase("fabulous") || key.equalsIgnoreCase("incredible")
    || key.equalsIgnoreCase("superb") || key.equalsIgnoreCase("marvelous") || key.equalsIgnoreCase("ace")
    || key.equalsIgnoreCase("super") || key.equalsIgnoreCase("superior") || key.equalsIgnoreCase("honorable")
    || key.equalsIgnoreCase("reputable") || key.equalsIgnoreCase("reputed")|| key.equalsIgnoreCase("magnificent")
    || key.equalsIgnoreCase("classy")|| key.equalsIgnoreCase("outstanding")|| key.equalsIgnoreCase("champion")
    || key.equalsIgnoreCase("chief")|| key.equalsIgnoreCase("premium")|| key.equalsIgnoreCase("greatest")
    || key.equalsIgnoreCase("matchless")|| key.equalsIgnoreCase("supreme")|| key.equalsIgnoreCase("charming")
    || key.equalsIgnoreCase("delightful")|| key.equalsIgnoreCase("fab"))
                        j=5;
        return j;
    }
    // This function return review for the comment
    @Override
    public int findReview(String com){
            int total=0,i=0,j=0,review=0;
            String newcom[]=com.split(" ");
            int l=newcom.length;
            
            while(i<l){
                j=0;
                
                if(newcom[i].equalsIgnoreCase("not")){
                    if(i!=(l-1)){
                        if(newcom[i+1].equalsIgnoreCase("even"))
                            j=1;
                        else if(newcom[i+1].equalsIgnoreCase("good") || (newcom[i+1].equalsIgnoreCase("so")))
                            j=2;
                        else if(newcom[i+1].equalsIgnoreCase("expensive") || (newcom[i+1].equalsIgnoreCase("bad")))
                            j=3;
                        i++;
                    }
                }
                
        else if(newcom[i].equalsIgnoreCase("so") || (newcom[i].equalsIgnoreCase("very"))){
                    if(i!=(l-1)){
        if(newcom[i+1].equalsIgnoreCase("ugly") || (newcom[i+1].equalsIgnoreCase("disgusting"))
         || newcom[i].equalsIgnoreCase("awful")||(newcom[i+1].equalsIgnoreCase("bad") 
        || (newcom[i+1].equalsIgnoreCase("cheap")) || newcom[i].equalsIgnoreCase("greedy") 
        || newcom[i].equalsIgnoreCase("selfish"))|| (newcom[i+1].equalsIgnoreCase("dirty")))
                            j=1;
        
        else if(newcom[i+1].equalsIgnoreCase("well") || (newcom[i+1].equalsIgnoreCase("expensive")) 
         || (newcom[i+1].equalsIgnoreCase("helpful")) || (newcom[i+1].equalsIgnoreCase("cool")))
                            j=3;
        else if(newcom[i+1].equalsIgnoreCase("much") || (newcom[i+1].equalsIgnoreCase("pretty"))
        || (newcom[i+1].equalsIgnoreCase("cute")) || (newcom[i+1].equalsIgnoreCase("hot"))
        ||(newcom[i+1].equalsIgnoreCase("beautiful")) || (newcom[i+1].equalsIgnoreCase("nice"))
        || (newcom[i+1].equalsIgnoreCase("much")) || (newcom[i+1].equalsIgnoreCase("smart"))
        || (newcom[i+1].equalsIgnoreCase("attractive")) || (newcom[i+1].equalsIgnoreCase("sweet"))
        || newcom[i].equalsIgnoreCase("sexy") || (newcom[i+1].equalsIgnoreCase("good"))
        || (newcom[i+1].equalsIgnoreCase("clean")) || (newcom[i+1].equalsIgnoreCase("clear"))
        || newcom[i].equalsIgnoreCase("neat") || (newcom[i+1].equalsIgnoreCase("supportive"))
        || newcom[i].equalsIgnoreCase("strong"))
                            j=4;
        else if(newcom[i+1].equalsIgnoreCase("handsome") || newcom[i].equalsIgnoreCase("reputed")
        || newcom[i].equalsIgnoreCase("reputing") || newcom[i].equalsIgnoreCase("reputable")
        || newcom[i].equalsIgnoreCase("big")|| newcom[i].equalsIgnoreCase("capable")
        || (newcom[i+1].equalsIgnoreCase("fab")))
                            j=5;
                        i++;
                    }
                }
        else if(newcom[i].equalsIgnoreCase("never")){
                    if(i!=(l-1)){
                        if(newcom[i+1].equalsIgnoreCase("use") || (newcom[i+1].equalsIgnoreCase("buy"))
                        || (newcom[i+1].equalsIgnoreCase("purchase")))
                            j=1;
                        
                        i++;
                    }
                }
        else if(newcom[i].equalsIgnoreCase("what")){
                    if(i!=(l-1)){
                        if(newcom[i+1].equalsIgnoreCase("the"))
                            j=2;
                        else if(newcom[i+1].equalsIgnoreCase("a"))
                            j=3;
                        i++;
                    }
                }
        else if(newcom[i].equalsIgnoreCase("tip")){
                    if(i!=(l-1)){
                        if(newcom[i+1].equalsIgnoreCase("top"))
                            j=4;
                        i++;
                    }
        }
        else if(newcom[i].equalsIgnoreCase("highly")){
                    if(i!=(l-1)){
                        if(newcom[i+1].equalsIgnoreCase("reputed")|| (newcom[i+1].equalsIgnoreCase("recommendable")))
                            j=5;
                        else if(newcom[i+1].equalsIgnoreCase("aggresive") ||(newcom[i+1].equalsIgnoreCase("disgusting")))
                            j=2;
                        i++;
                    }
                }
        else if(newcom[i].equalsIgnoreCase("high")){
                    if(i!=(l-1)){
                        if(newcom[i+1].equalsIgnoreCase("class")|| (newcom[i+1].equalsIgnoreCase("rated")))
                            j=5;
                        
                        i++;
                    }
                }
       
        else if(newcom[i].equalsIgnoreCase("bull")){
                    if(i!=(l-1)){
                        if(newcom[i+1].equalsIgnoreCase("shit"))
                            j=1;
                        i++;
                    }
                }
        else if(newcom[i].equalsIgnoreCase("first")){
                    if(i!=(l-1)){
                        if(newcom[i+1].equalsIgnoreCase("class") || (newcom[i].equalsIgnoreCase("rate")))
                            j=4;
                        i++;
                    }
                }
        else if(newcom[i].equalsIgnoreCase("pissed") || (newcom[i].equalsIgnoreCase("piss")) || 
                        (newcom[i].equalsIgnoreCase("lack"))){
                    if(i!=(l-1)){
                        if(newcom[i+1].equalsIgnoreCase("of"))
                            j=2;
                        i++;
                    }
                }
               
        else if(newcom[i].equalsIgnoreCase("don't")){
                    if(i!=(l-1)){
                        if(newcom[i+1].equalsIgnoreCase("use") || (newcom[i+1].equalsIgnoreCase("buy"))
                        ||  (newcom[i+1].equalsIgnoreCase("love")) || (newcom[i+1].equalsIgnoreCase("like")))
                            j=1;
                    else if(newcom[i+1].equalsIgnoreCase("want"))
                            j=2;
                        i++;
                    }
                }
        else if(newcom[i].equalsIgnoreCase("looking")){
                    if(i!=(l-1)){
                        if(newcom[i+1].equalsIgnoreCase("ugly") || (newcom[i+1].equalsIgnoreCase("dirty")))
                            j=1;
                        else if(newcom[i+1].equalsIgnoreCase("bad") || (newcom[i+1].equalsIgnoreCase("horrible")))
                            j=2;
                        else if(newcom[i+1].equalsIgnoreCase("good") )
                            j=3;
                        else if(newcom[i+1].equalsIgnoreCase("handsome") || (newcom[i+1].equalsIgnoreCase("smart"))
                                 || (newcom[i+1].equalsIgnoreCase("beautiful"))|| (newcom[i+1].equalsIgnoreCase("hot"))
                                || (newcom[i+1].equalsIgnoreCase("crazy"))|| (newcom[i+1].equalsIgnoreCase("sexy")))
                            j=4;
                        else if(newcom[i+1].equalsIgnoreCase("gorgeous") || (newcom[i+1].equalsIgnoreCase("amazing"))
                                || (newcom[i+1].equalsIgnoreCase("marvelous")))
                            j=5;
                        i++;
                    }
                }
                else{
            StringBuilder sb=new StringBuilder();
                sb=new Synonyms().searchWord(newcom[i]);
                //if(sb.equals(null))
                String syn[]=sb.toString().split(",");
                int k=0,len=syn.length;
                while(k<len){
                    j=getCommentfor1Word(syn[k]);
                     if(j!=0)
                            total++;
                             review+=j;
                     k++;
                }
               }
                //JOptionPane.showMessageDialog(null, "reveiw "+ j);
               
             if(j!=0)
                total++;
             review+=j;
             i++;
            }
            
           if(total!=0)
           return review/total;
           else
           return 2;
        }
}
