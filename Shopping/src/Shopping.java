/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaya tanwani
 */
class Bill
{
    int price[];
    boolean books[];
     int qty[];
     String bookname;
    Bill()
    {
        price=new int[20];
                price[0]=250;
                price[1]=350;
                price[2]=300;
                price[3]=400;
                price[4]=350;
                price[5]=400;
                price[6]=450;
                price[7]=450;
                price[8]=300;
                price[9]=300;
                price[10]=300;
                price[11]=250;
                price[12]=275;
                price[13]=400;
                price[14]=400;
                price[15]=250;
                price[16]=350;
                price[17]=400;
                price[18]=425;
                price[19]=350;
        books=new boolean[20];
        qty= new int[20];
       // bookname=str;
    }
}
public class Shopping extends Applet implements ActionListener{

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
     Label ltitle,lerror,lnovels,lbooks,lbookname1,laddress,lphoneno,lbill,lname;
     CheckboxGroup cnovels,cbooks;
     TextField tname;
     Checkbox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20;
     Choice q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,q16,q17,q18,q19,q20;
     Button b1,b2,b3,b4,b5,b6;
     Font f1,f2,f3,f4,f5,f6,f7;
     String bookname="";
     String sdbname="";
     String sname="";
     int flag;
     
    public void init() {
        // TODO start asynchronous download of heavy resources
        this.setLayout(null);
       this.setSize(2000,2000);
       f1=new Font("curlz",Font.ITALIC|Font.PLAIN,15);
       setFont(f1);
       setBackground(Color.PINK);
       setForeground(Color.BLACK);
       ltitle = new Label("BOOKENDS BOOKSHOP ANDHERI");
       lnovels = new Label("NOVELS");
       lbooks=new Label("BOOKS");
         cnovels=new CheckboxGroup();
         cbooks=new CheckboxGroup();     
         c1=new Checkbox("OUTSIDER~~Stephen king (RS. 250)",null,false);
         c2=new Checkbox("12 RULES FOR LIFE~~Jordan peterson (RS. 350)",null,false);
         c3=new Checkbox("SUMMER OF FIRE AND FURY~~Michael wolfe (RS. 300)",null,false);
         c4=new Checkbox("GREAT ALONE~~Kristin hannah (RS. 400)",null,false);
         c5=new Checkbox("ALL WE EVER WANTED~~Emily griffin (RS. 350)",null,false);
         c6=new Checkbox("OUR HOUSE~~Louise candish (RS. 400)",null,false);
         c7=new Checkbox("DARK IN THE DEATH~~Nora roberts (RS. 450)",null,false);
         c8=new Checkbox("THE FAVOURITE SISTER~~Jessica knoll (RS. 450)",null,false);
         c9=new Checkbox("SURPRISE ME~~Sophie kinsella (RS. 300)",null,false);
         c10=new Checkbox("HARKIN-THE TUSCAN CHILD~~Janet quin (RS. 300)",null,false);
         c11=new Checkbox("ALICE ADVENTURE IN WONDERLAND~~Lewis caroll (RS. 300)",null,false);
         c12=new Checkbox("CHARLIE AND CHOCOLATE FACTORY~~Roald dahl (RS. 250)",null,false);
         c13=new Checkbox("WHERE THE WILD THINGS ARE~~Maurice sendak (RS. 275)",null,false);
         c14=new Checkbox("CHARLOTTE'S WEB~~E.B white (RS. 400)",null,false);
         c15=new Checkbox("THE CAT IN THE HAT~~Dr.seuss (RS. 400)",null,false);
         c16=new Checkbox("THE VERY HUNGRY CATERPILLAR~~Eric carle (RS. 250)",null,false);
         c17=new Checkbox("GOODNIGHT MOON~~Margaret wise (RS. 350)",null,false);
         c18=new Checkbox("THE WONDERFUL WIZARD OF OZ~~ L frank baum (RS. 400)",null,false);
         c19=new Checkbox("THE SECRET GARDEN~~Frances hodgson (RS. 425)",null,false);
         c20=new Checkbox("THE SNOWY DAY~~Ezra javk keats (RS. 350)",null,false);
         q1=new Choice();
         q2=new Choice();
         q3=new Choice();
         q4=new Choice();
         q5=new Choice();
         q6=new Choice();
         q7=new Choice();
         q8=new Choice();
         q9=new Choice();
         q10=new Choice();
         q11=new Choice();
         q12=new Choice();
         q13=new Choice();
         q14=new Choice();
         q15=new Choice();
         q16=new Choice();
         q17=new Choice();
         q18=new Choice();
         q19=new Choice();
         q20=new Choice();
         lname=new Label("Name:");
         tname=new TextField("");
         b1= new Button("NOVELS");
         b2= new Button("CHILDREN BOOKS");
         b3= new Button("PROCEED FOR PAYMENT");
         b4= new Button("DONE");
         b5=new Button("Admin login");
         b6=new Button("Enter");
         b4.addActionListener((ActionListener) this);
        b6.addActionListener((ActionListener) this);
         lerror=new Label("please  enter name");
        ltitle.setBounds(320,20,500,100);
        b5.setBounds(1450,20,400,100);
        b6.setBounds(200,800,400,100);
        lname.setBounds(200,20,100,30);
        tname.setBounds(330,20,100,30);
        lbookname1=new Label("");
        lphoneno=new Label("");
        laddress=new Label("");
        lbill=new Label("");
        lbookname1.setBounds(200,80,1500,50);
        lphoneno.setBounds(200,160,100,30);
        laddress.setBounds(200,220,500,30);
        lbill.setBounds(200,280,50,30);
       b1.setBounds(100,150,200,50);
       b2.setBounds(850,150,280,50);
        lnovels.setBounds(100,250,100,30);
       c1.setBounds(100,300,400,30);
       q1.setBounds(530,300,100,30);
       c2.setBounds(100,350,400,30);
       q2.setBounds(530,350,100,30);
       c3.setBounds(100,400,400,30);
       q3.setBounds(530,400,100,30);
       c4.setBounds(100,450,400,30);
       q4.setBounds(530,450,100,30);
       c5.setBounds(100,500,400,30);
       q5.setBounds(530,500,100,30);
       c6.setBounds(100,550,400,30);
       q6.setBounds(530,550,100,30);
       c7.setBounds(100,600,400,30);
       q7.setBounds(530,600,100,30);
       c8.setBounds(100,650,400,30);
       q8.setBounds(530,650,100,30);
       c9.setBounds(100,700,400,30);
       q9.setBounds(530,700,100,30);
       c10.setBounds(100,750,400,30);
       q10.setBounds(530,750,100,30);
       lbooks.setBounds(850,250,100,30);
       c11.setBounds(850,300,450,30);
       q11.setBounds(1330,300,100,30);
       c12.setBounds(850,350,450,30);
       q12.setBounds(1330,350,100,30);
       c13.setBounds(850,400,450,30);
       q13.setBounds(1330,400,100,30);
       c14.setBounds(850,450,450,30);
       q14.setBounds(1330,450,100,30);
       c15.setBounds(850,500,450,30);
       q15.setBounds(1330,500,100,30);
       c16.setBounds(850,550,450,30);
       q16.setBounds(1330,550,100,30);
       c17.setBounds(850,600,450,30);
       q17.setBounds(1330,600,100,30);
       c18.setBounds(850,650,450,30);
       q18.setBounds(1330,650,100,30);
       c19.setBounds(850,700,450,30);
       q19.setBounds(1330,700,100,30);
       c20.setBounds(850,750,450,30);
       q20.setBounds(1330,750,100,30);
       b3.setBounds(600,850,350,50);
       for(int i=1;i<=20;i++)
       {
           q1.add(String.valueOf(i));
            q2.add(String.valueOf(i));
            q3.add(String.valueOf(i));
            q4.add(String.valueOf(i));
            q5.add(String.valueOf(i));
            q6.add(String.valueOf(i));
            q7.add(String.valueOf(i));
            q8.add(String.valueOf(i));
            q9.add(String.valueOf(i));
            q10.add(String.valueOf(i));
            q11.add(String.valueOf(i));
            q12.add(String.valueOf(i));
            q13.add(String.valueOf(i));
            q14.add(String.valueOf(i));
            q15.add(String.valueOf(i));
            q16.add(String.valueOf(i));
            q17.add(String.valueOf(i));
            q18.add(String.valueOf(i));
            q19.add(String.valueOf(i));
            q20.add(String.valueOf(i));
            
       }
       f2=new Font("boulder",Font.ITALIC|Font.PLAIN,30);
       ltitle.setFont(f2);
       ltitle.setForeground(Color.red);
       ltitle.setBackground(Color.BLACK);
       add(ltitle);
       f3=new Font("American Text",Font.CENTER_BASELINE,25);
       b1.setFont(f3);
       b1.setForeground(Color.red);
       b1.setBackground(Color.black);
       add(b1);
       f4=new Font("American Text",Font.CENTER_BASELINE,25);
       b2.setFont(f4);
       b2.setForeground(Color.red);
       b2.setBackground(Color.black);
       f6=new Font("American Text",Font.CENTER_BASELINE,25);
       b5.setFont(f6);
       b5.setForeground(Color.red);
       b5.setBackground(Color.black);
       f7=new Font("American Text",Font.CENTER_BASELINE,25);
       b6.setFont(f6);
       b6.setForeground(Color.red);
       b6.setBackground(Color.black);
     
       add(b2);
       add(b5);
       b1.addActionListener((ActionListener) this);
       b2.addActionListener((ActionListener) this);
        b3.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        
      
       
       

         
    }

    // TODO overwrite start(), stop() and destroy() methods

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==b1)
         {
             
             add(c1);
             add(q1);
             add(c2);
             add(q2);
             add(c3);
             add(q3);
             add(c4);
             add(q4);
             add(c5);
             add(q5);
             add(c6);
             add(q6);
             add(c7);
             add(q7);
             add(c8);
             add(q8);
             add(c9);
             add(q9);
             add(c10);
             add(q10);
             b6.setVisible(false);
             
         }
          if(e.getSource()==b2)
         {
             b6.setVisible(false);
              add(c11);
             add(q11);
             add(c12);
             add(q12);
             add(c13);
             add(q13);
             add(c14);
             add(q14);
             add(c15);
             add(q15);
             add(c16);
             add(q16);
             add(c17);
             add(q17);
             add(c18);
             add(q18);
             add(c19);
             add(q19);
             add(c20);
             add(q20);
             
         }
         if(e.getSource()==b1||e.getSource()==b2)
         {
             f5=new Font("American Text",Font.CENTER_BASELINE,25);
             b3.setFont(f5);
             b3.setForeground(Color.red);
             b3.setBackground(Color.black);
             add(b3);
         }
             
              if(e.getSource()==b3)
              {
                  
                  ltitle.setVisible(false);
                  b5.setVisible(false);
            c1.setVisible(false);
            c2.setVisible(false);
            c3.setVisible(false);
            c4.setVisible(false);
            c5.setVisible(false);
            c6.setVisible(false);
            c7.setVisible(false);
            c8.setVisible(false);
            c9.setVisible(false);
            c10.setVisible(false);
            q1.setVisible(false);
            q2.setVisible(false);
            q3.setVisible(false);
            q4.setVisible(false);
            q5.setVisible(false);
            q6.setVisible(false);
            q7.setVisible(false);
            q8.setVisible(false);
            q9.setVisible(false);
            q10.setVisible(false);
            c11.setVisible(false);
            c12.setVisible(false);
            c13.setVisible(false);
            c14.setVisible(false);
            c15.setVisible(false);
            c16.setVisible(false);
            c17.setVisible(false);
            c18.setVisible(false);
            c19.setVisible(false);
            c20.setVisible(false);
            q11.setVisible(false);
            q12.setVisible(false);
            q13.setVisible(false);
            q14.setVisible(false);
            q15.setVisible(false);
            q16.setVisible(false);
            q17.setVisible(false);
            q18.setVisible(false);
            q19.setVisible(false);
            q20.setVisible(false);
            b1.setVisible(false);
            b2.setVisible(false);
            lnovels.setVisible(false);
            lbooks.setVisible(false);
            
              Bill b= new Bill();
              
              if(c1.getState())
            {
                b.books[0]=true;
                b.qty[0]=Integer.parseInt(q1.getSelectedItem());
                bookname=bookname+c1.getLabel()+"\n"; 
            }
              if(c2.getState())
            {
                b.books[1]=true;
                b.qty[1]=Integer.parseInt(q2.getSelectedItem());
                bookname=bookname+c2.getLabel()+"\n";
                
            }
              if(c3.getState())
            {
                b.books[2]=true;
                b.qty[2]=Integer.parseInt(q3.getSelectedItem());
                bookname=bookname+c3.getLabel()+"\n";
                
            }
              if(c4.getState())
            {
                b.books[3]=true;
                b.qty[3]=Integer.parseInt(q4.getSelectedItem());
                bookname=bookname+c4.getLabel()+"\n";
                
            }
              if(c5.getState())
            {
                b.books[4]=true;
                b.qty[4]=Integer.parseInt(q5.getSelectedItem());
                bookname=bookname+c5.getLabel()+"\n";
                
            }
              if(c6.getState())
            {
                b.books[5]=true;
                b.qty[5]=Integer.parseInt(q6.getSelectedItem());
                bookname=bookname+c6.getLabel()+"\n";
                
            }
              if(c7.getState())
            {
                b.books[6]=true;
                b.qty[6]=Integer.parseInt(q7.getSelectedItem());
                bookname=bookname+c7.getLabel()+"\n";
                
            }
              if(c8.getState())
            {
                b.books[7]=true;
                b.qty[7]=Integer.parseInt(q8.getSelectedItem());
                bookname=bookname+c8.getLabel()+"\n";
                
            }
              if(c9.getState())
            {
                b.books[8]=true;
                b.qty[8]=Integer.parseInt(q9.getSelectedItem());
                bookname=bookname+c9.getLabel()+"\n";
                
            }
              if(c10.getState())
            {
                b.books[9]=true;
                b.qty[9]=Integer.parseInt(q10.getSelectedItem());
                bookname=bookname+c10.getLabel()+"\n";
                
            }
              if(c11.getState())
            {
                b.books[10]=true;
                b.qty[10]=Integer.parseInt(q11.getSelectedItem());
                bookname=bookname+c11.getLabel()+"\n";
                
            }
              if(c12.getState())
            {
                b.books[11]=true;
                b.qty[11]=Integer.parseInt(q12.getSelectedItem());
                bookname=bookname+c12.getLabel()+"\n";
                
            }
              if(c13.getState())
            {
                b.books[12]=true;
                b.qty[12]=Integer.parseInt(q13.getSelectedItem());
                bookname=bookname+c13.getLabel()+"\n";
                
            }
              if(c14.getState())
            {
                b.books[13]=true;
                b.qty[13]=Integer.parseInt(q14.getSelectedItem());
                bookname=bookname+c14.getLabel()+"\n";
                
            }
              if(c15.getState())
            {
                b.books[14]=true;
                b.qty[14]=Integer.parseInt(q15.getSelectedItem());
                bookname=bookname+c15.getLabel()+"\n";
                
            }
              if(c16.getState())
            {
                b.books[15]=true;
                b.qty[15]=Integer.parseInt(q16.getSelectedItem());
                bookname=bookname+c16.getLabel()+"\n";
                
            }
              if(c17.getState())
            {
                b.books[16]=true;
                b.qty[16]=Integer.parseInt(q17.getSelectedItem());
                bookname=bookname+c17.getLabel()+"\n";
                
            }
              if(c18.getState())
            {
                b.books[17]=true;
                b.qty[17]=Integer.parseInt(q18.getSelectedItem());
                bookname=bookname+c18.getLabel()+"\n";
            }
              if(c19.getState())
            {
                b.books[18]=true;
                b.qty[18]=Integer.parseInt(q19.getSelectedItem());
                bookname=bookname+c19.getLabel()+"\n";
                
            }
              if(c20.getState())
            {
                b.books[19]=true;
                b.qty[19]=Integer.parseInt(q20.getSelectedItem());
                bookname=bookname+c20.getLabel()+"\n";
                
            }
          
              
              
              
              
                  System.out.println(bookname);
                  Payment p1= new Payment(b,bookname);
            
            p1.init();
            
            add(p1);
            b3.setVisible(false);
            
              
         }
              if(e.getSource()==b5)
                    {
                         add(b6);
                        add(lname);
                        add(tname);
                        b5.setVisible(false);
                        b6.setVisible(true);
                           ltitle.setVisible(false);
                            c1.setVisible(false);
                            c2.setVisible(false);
                            c3.setVisible(false);
                            c4.setVisible(false);
                            c5.setVisible(false);
                            c6.setVisible(false);
                            c7.setVisible(false);
                            c8.setVisible(false);
                            c9.setVisible(false);
                            c10.setVisible(false);
                            q1.setVisible(false);
                            q2.setVisible(false);
                            q3.setVisible(false);
                            q4.setVisible(false);
                            q5.setVisible(false);
                            q6.setVisible(false);
                            q7.setVisible(false);
                            q8.setVisible(false);
                            q9.setVisible(false);
                            q10.setVisible(false);
                            c11.setVisible(false);
                            c12.setVisible(false);
                            c13.setVisible(false);
                            c14.setVisible(false);
                            c15.setVisible(false);
                            c16.setVisible(false);
                            c17.setVisible(false);
                            c18.setVisible(false);
                            c19.setVisible(false);
                            c20.setVisible(false);
                            q11.setVisible(false);
                            q12.setVisible(false);
                            q13.setVisible(false);
                            q14.setVisible(false);
                            q15.setVisible(false);
                            q16.setVisible(false);
                            q17.setVisible(false);
                            q18.setVisible(false);
                            q19.setVisible(false);
                            q20.setVisible(false);
                            b1.setVisible(false);
                            b2.setVisible(false);
                            b3.setVisible(false);
                            lnovels.setVisible(false);
                            lbooks.setVisible(false);
                    }       
                            
                    
                            
                            if (e.getSource()==b6)
                            {
                                b6.setVisible(false);
                                System.out.println("b6 is pressed");
                                try{
                             Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                            Connection con =DriverManager.getConnection("jdbc:derby://localhost:1527/shopping","jaya","jaya");    
                            Statement st=con.createStatement();
                            String query="select * from shopping";
                            ResultSet rs= st.executeQuery(query);
                                    System.out.println("db entered");
                            sname=tname.getText();
                                    //System.out.println(tname);
                                    System.out.println(sname);
                            int flag=0;
                                
                            while (rs.next())
                            {
                            sdbname=(rs.getString("name"));
                            if (sdbname.equals(sname))
                                {
                                    System.out.println("i entered if");
                                    flag=1;
                                    lbookname1.setText(rs.getString("bookname"));
                                    System.out.println(lbookname1);
                                    lphoneno.setText(rs.getString("phoneno"));
                                    System.out.println(lphoneno);
                                    laddress.setText(rs.getString("address"));
                                    System.out.println(laddress);
                                    lbill.setText(rs.getString("bill"));
                                    System.out.println(lbill);
                                    add(lbookname1);
                                    add(lphoneno);
                                    add(laddress);
                                    add(lbill);
                                }
                            }
                             if(flag==0)
                lerror.setText("name  does not exist");
                            } catch (SQLException ex) {
                                Logger.getLogger(Shopping.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(Shopping.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (InstantiationException ex) {
                                Logger.getLogger(Shopping.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IllegalAccessException ex) {
                                Logger.getLogger(Shopping.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                    }
    }       }

