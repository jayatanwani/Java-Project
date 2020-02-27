/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaya tanwani
 */
public class Payment extends Applet implements ActionListener{

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
     Bill b;
    int sum=0;
    String bkname;
    Payment(Bill b,String bookname)
    {
        this.b=b;
        bkname=bookname;
        
    }
    Label lname,lphoneno,laddress,ldisplay,lerror;
        TextField tname,tphoneno,taddress;
        Button b1;
        Font f1,f2,f3;
    public void init() {
        // TODO start asynchronous download of heavy resources
         this.setLayout(null);
        this.setSize(600,600);
        lname=new Label("NAME:*");
        tname= new TextField("");
        lphoneno= new Label("PHONE NUMBER*");
        tphoneno=new TextField("");
        laddress = new Label("ADDRESS*");
        taddress= new TextField("");
        ldisplay=new Label("");
        b1=new Button("DONE");
        lerror=new Label("please fill the above requirements");
        lerror.setFont(f1);
        lerror.setForeground(Color.red);
        lname.setBounds(200,200,100,30);
        tname.setBounds(380,200,100,30);
        lphoneno.setBounds(200,260,150,30);
        tphoneno.setBounds(380,260,100,30);
        laddress.setBounds(200,310,100,30);
        taddress.setBounds(380,310,250,30);
        lerror.setBounds(200,370,250,30);
        b1.setBounds(400,430,200,50);
        ldisplay.setBounds(200,550,500,50);
        add(lname);
        add(tname);
        add(lphoneno);
        add(tphoneno);
        add(laddress);
        add(taddress);
        add(ldisplay);
        f3=new Font("American Text",Font.CENTER_BASELINE,25);
         b1.setFont(f3);
         b1.setForeground(Color.red);
         b1.setBackground(Color.black);
        add(b1);
        add(lerror);
        lerror.setVisible(false);
        b1.addActionListener((ActionListener) this);
    }

    // TODO overwrite start(), stop() and destroy() methods

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            if(tname.getText().equals("")||tname.getText().equals(" ")||tphoneno.getText().equals("")||tphoneno.getText().equals(" ")||taddress.getText().equals("")||taddress.getText().equals(" "))
            {
                lerror.setVisible(true);
            }
            
        
       else
        {
            lerror.setVisible(false);
            for(int i=0;i<20;i++)
            {
                if(b.books[i]==true)
                    sum=sum+b.price[i]*b.qty[i];              
                
            }
            f2=new Font("boulder",Font.ITALIC|Font.PLAIN,30);
            ldisplay.setFont(f2);
            ldisplay.setForeground(Color.red);
            ldisplay.setText("Your Bill is "+sum);
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/shopping","jaya","jaya")) {
                    String query="insert into shopping values(?,?,?,?,?)";
                    PreparedStatement st=con.prepareStatement(query);
                    st.setString(1,bkname);
                    st.setString(2,tname.getText());
                    st.setString(3,tphoneno.getText());
                    st.setString(4,taddress.getText());
                    st.setString(5,String.valueOf(sum));
                    st.execute();
                }
            }   catch (SQLException ex) {
                    Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        }
    }
}
