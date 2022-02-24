/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShopSalesSystem;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import com.toedter.calendar.JDateChooser;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
//import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HCA
 */
public class daily_sales extends javax.swing.JFrame {
private JDateChooser txt;
    
int no;
/**i
     * Creates new form addItem
     */
    public daily_sales() {
        initComponents();
          this.setTitle("SHOP SALES MANAGEMENT SYSTEM");
    }

   Connection con;
   PreparedStatement ps;
   ResultSet rs;
   
   public void update(){
   
   String id= txt1.getText();
 String name= txt2.getText();
 String cat= txt3.getText();
 String quant= txt4.getText();
 String date2= txt5.getDate().toString();
 

 try{

String sql="UPDATE sales set quantity=? WHERE id=?";
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopsales","root","");
PreparedStatement pst= con.prepareStatement(sql);
 pst.setString(2, id);
 pst.setString(1, cat);
 pst.executeUpdate();

}
catch(Exception e)
{
JOptionPane.showMessageDialog(this, e);
}          // TODO add your handling code here:

   }
     public void search(){
         int no;
        String item=txt1.getText();
        String sql="select *from item where item_id='"+item+"'";
       try{
            Class.forName("com.mysql.jdbc.Driver");
            
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shopsales","root","");
            ps=con.prepareStatement(sql);
          rs=ps.executeQuery();
       
            if(rs.next()){
            txt2.setText(rs.getString(2));
            txt4.setText(rs.getString(5));
             txt3.setText(rs.getString(4));
            no=rs.getInt(4);
             
             rs.close();
             ps.close();
           
       } 
        else{
            JOptionPane.showMessageDialog(null,"Enter the item id");
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
   // return no; 
     }
      public void search2(){
          int sum=0;
        String date2= txt7.getDate().toString();
      
       try{
            DefaultTableModel model = (DefaultTableModel) tab1.getModel();
   model.setRowCount(0);
     String sql="select * from  sales where date ='"+date2+"'";
            Class.forName("com.mysql.jdbc.Driver");
            
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shopsales","root","");
            ps=con.prepareStatement(sql);
          rs=ps.executeQuery();
       
            while(rs.next()){
           int id = rs.getInt("id");
          String nam = rs.getString("name");
          int job = rs.getInt("quantity");
         double job2 = rs.getDouble("price");
         double job3 = rs.getDouble("total");
        String nam2 = rs.getString("date");
          model.addRow(new Object[]{id, nam,job,job2,job3,nam2}); 
   
        int tt=  sum+= job3;
          txt6.setText(""+tt+"");
         
    rs.close();
             ps.close();
        tab1.setModel(model);     
       } 
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    
     }
     
     
     
     
      public void display(){
         //int c;
      int sum=0;
     try{
           DefaultTableModel model = (DefaultTableModel) tab1.getModel();
   model.setRowCount(0);
           String sql="select id,name,quantity,price,(quantity*price)   AS total,date from  sales";
   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopsales","root","");
   Statement pst =con.createStatement();
   ResultSet rs= pst.executeQuery(sql);
           
           while (rs.next()){
             int id = rs.getInt("id");
          String nam = rs.getString("name");
          int job = rs.getInt("quantity");
         double job2 = rs.getDouble("price");
         double job3 = rs.getDouble("total");
        String nam2 = rs.getString("date");
          model.addRow(new Object[]{id, nam,job,job2,job3,nam2}); 
   
        int tt=  sum+= job3;
          txt6.setText(""+tt+"");
          }tab1.setModel(model);
    pst.close();  
           
       }catch(Exception e){
           
           JOptionPane.showMessageDialog(null, e);
       }
    
    
      }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt1 = new javax.swing.JTextField();
        txt2 = new javax.swing.JTextField();
        txt3 = new javax.swing.JTextField();
        txt4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txt5 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        txt7 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        DT = new javax.swing.JTextField();
        pach = new javax.swing.JTextField();
        pof = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        txt6 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        editMenu = new javax.swing.JMenu();
        helpMenu = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Daily sales");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 13, -1, -1));

        jLabel2.setText("ITEM ID:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 56, -1, -1));

        jLabel3.setText("ITEM NAME:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 94, -1, -1));

        jLabel5.setText("PRICE:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 170, -1, -1));

        jLabel6.setText("QUANTITY:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 132, -1, -1));

        txt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt1ActionPerformed(evt);
            }
        });
        txt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt1KeyPressed(evt);
            }
        });
        jPanel1.add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 267, -1));

        txt2.setEditable(false);
        txt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt2KeyPressed(evt);
            }
        });
        jPanel1.add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 267, -1));

        txt3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt3KeyPressed(evt);
            }
        });
        jPanel1.add(txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 267, -1));

        txt4.setEditable(false);
        txt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt4ActionPerformed(evt);
            }
        });
        txt4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt4KeyPressed(evt);
            }
        });
        jPanel1.add(txt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 267, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 153));
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 80, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 153));
        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 80, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 153));
        jButton4.setText("CLEAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 90, -1));

        txt5.setDateFormatString("dd-MM-yyyy");
        txt5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt5KeyReleased(evt);
            }
        });
        jPanel1.add(txt5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 267, -1));

        jLabel7.setText("DATE");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 199, -1, -1));

        jButton8.setBackground(new java.awt.Color(255, 255, 153));
        jButton8.setText("SEARCH");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 80, -1));

        tab1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM ID", "NAME", "QUANTITY", "PRICE", "TOTAL", "DATE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tab1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab1);

        jButton5.setBackground(new java.awt.Color(255, 255, 153));
        jButton5.setText("DISPLAY");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        jButton6.setBackground(new java.awt.Color(255, 255, 153));
        jButton6.setText("SEARCH ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txt7.setDateFormatString("dd-MM-yyyy");

        jLabel8.setText("DATE:");

        jButton12.setText("PRINT");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(33, 33, 33)
                .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6)
                    .addComponent(jLabel8)
                    .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jButton7.setBackground(new java.awt.Color(255, 255, 153));
        jButton7.setText("BACK");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Dailly Profit..");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 13, -1, -1));

        jLabel11.setText("Daily Total Sales:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel12.setText("Daily Total Purchase:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 74, -1, 20));

        jLabel13.setText("Daily Profit:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        DT.setEditable(false);
        DT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DTActionPerformed(evt);
            }
        });
        DT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DTKeyPressed(evt);
            }
        });
        jPanel3.add(DT, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 240, -1));

        pach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pachKeyPressed(evt);
            }
        });
        jPanel3.add(pach, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 240, -1));

        pof.setEditable(false);
        pof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pofActionPerformed(evt);
            }
        });
        jPanel3.add(pof, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 240, -1));

        jButton9.setBackground(new java.awt.Color(102, 102, 102));
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("GET");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 70, -1));

        jButton10.setBackground(new java.awt.Color(102, 102, 102));
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("PROFIT");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 70, -1));

        jButton11.setBackground(new java.awt.Color(255, 255, 153));
        jButton11.setText("CLEAR");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));

        txt6.setEditable(false);

        jLabel14.setText("TOTAL:");

        fileMenu.setMnemonic('f');
        fileMenu.setText("ADD ITEM");
        fileMenu.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                fileMenuMenuSelected(evt);
            }
        });
        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("DAILY SALES");
        editMenu.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                editMenuMenuSelected(evt);
            }
        });
        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("ITEM PRICE");
        helpMenu.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                helpMenuMenuSelected(evt);
            }
        });
        menuBar.add(helpMenu);

        jMenu2.setText("CHANGE PASSWORD");
        jMenu2.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu2MenuSelected(evt);
            }
        });
        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(49, 49, 49)
                        .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jButton5))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt1ActionPerformed

    private void txt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        SimpleDateFormat df= new SimpleDateFormat("dd-MM-yyyy");
 int id= Integer.parseInt(txt1.getText());
 String name= txt2.getText();
  int cat= Integer.parseInt(txt3.getText());
  double quant= Double.parseDouble(txt4.getText());
 String date2= df.format(txt5.getDate());
 
  String update ="update item set quantity=quantity-? where item_id='"+id+"'";
  String sql="insert into sales(id,name,quantity,price,total,Date) values(?,?,?,?,0,?)  ";
          try{
               search();
    
 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopsales","root","");
 PreparedStatement pst= con.prepareStatement(sql);
 
 pst.setInt(1, id);
 pst.setString(2, name);
 pst.setInt(3, cat);
 pst.setDouble(4, quant);
pst.setString(5,  date2);
 // pst.setDouble(6, cat);

// pst.executeUpdate();
  JOptionPane.showMessageDialog(this,"DATA SUCCESSFUL INSERTED");
 update();
  PreparedStatement rq=con.prepareStatement(update);
  
 
   rq.setInt(1,id);
 

    
 
// rq.setDouble(4, quant);

  pst.executeUpdate();
display();
 }
 catch(Exception e){
     JOptionPane.showMessageDialog(this,e);
 }
        
     // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
admin_dasboard obj  =new admin_dasboard();
   obj.show();
   this.hide();           // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void fileMenuMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_fileMenuMenuSelected
addItem obj  =new addItem();
   obj.show();
   this.hide();          // TODO add your handling code here:
    }//GEN-LAST:event_fileMenuMenuSelected

    private void editMenuMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_editMenuMenuSelected
daily_sales obj  =new daily_sales();
   obj.show();
   this.hide();          // TODO add your handling code here:
    }//GEN-LAST:event_editMenuMenuSelected

    private void helpMenuMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_helpMenuMenuSelected
items obj  =new items();
   obj.show();
   this.hide();          // TODO add your handling code here:
    }//GEN-LAST:event_helpMenuMenuSelected

    private void jMenu2MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu2MenuSelected
ChangePassword obj  =new ChangePassword();
   obj.show();
   this.hide();          // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2MenuSelected

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     int id= Integer.parseInt(txt1.getText());
int p= JOptionPane.showConfirmDialog(null,"Do you want to delete this record","WARNING",JOptionPane.YES_NO_OPTION);
       if(p==0){
           
           String sql="DELETE from sales WHERE  id=?";
           
             try{


Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopsales","root","");
PreparedStatement pst= con.prepareStatement(sql);
 pst.setInt(1, id);
pst.executeUpdate();


  
 display();
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this, e);
}     
       }
 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
txt1.setText("");
txt2.setText("");
txt3.setText("");
txt4.setText("");
txt5.setDate(null); 

// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txt1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1KeyPressed
int a=evt.getKeyCode();
if(a==10){
    txt2.requestFocus();}        // TODO add your handling code here:
    }//GEN-LAST:event_txt1KeyPressed

    private void txt2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2KeyPressed
int a=evt.getKeyCode();
if(a==10){
    txt3.requestFocus();}        // TODO add your handling code here:
    }//GEN-LAST:event_txt2KeyPressed

    private void txt3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3KeyPressed
int a=evt.getKeyCode();
if(a==10){
    txt4.requestFocus();}        // TODO add your handling code here:
    }//GEN-LAST:event_txt3KeyPressed

    private void txt4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt4KeyPressed
int a=evt.getKeyCode();
if(a==10){
    txt5.requestFocus();}        // TODO add your handling code here:
    }//GEN-LAST:event_txt4KeyPressed

    private void txt5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt5KeyReleased

    private void DTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DTKeyPressed
int a=evt.getKeyCode();
if(a==10){
    pach.requestFocus();}        // TODO add your handling code here:
    }//GEN-LAST:event_DTKeyPressed

    private void pachKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pachKeyPressed
int a=evt.getKeyCode();
if(a==10){
    pof.requestFocus();}        // TODO add your handling code here:
    }//GEN-LAST:event_pachKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int sum=0;
     try{
           DefaultTableModel model = (DefaultTableModel) tab1.getModel();
   model.setRowCount(0);
           String sql="select id,name,quantity,price,(quantity*price)   AS total,date from  sales ORDER BY date";
   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopsales","root","");
   Statement pst =con.createStatement();
   ResultSet rs= pst.executeQuery(sql);
           
           while (rs.next()){
             int id = rs.getInt("id");
          String nam = rs.getString("name");
          int job = rs.getInt("quantity");
         double job2 = rs.getDouble("price");
         
         double job3 = rs.getDouble("total");
        String nam2 = rs.getString("date");
          model.addRow(new Object[]{id, nam,job,job2,job3,nam2}); 
   
        int tt=  sum+= job3;
          txt6.setText("  "+tt+" ");
          }tab1.setModel(model);
    pst.close();  
           
       }catch(Exception e){
           
           JOptionPane.showMessageDialog(null, e);
       }
    
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tab1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab1MouseClicked
 DefaultTableModel df =(DefaultTableModel) tab1.getModel();
      int index=tab1.getSelectedRow();
      txt1.setText(df.getValueAt(index,0).toString());
         txt2.setText(df.getValueAt(index,1).toString());
            txt3.setText(df.getValueAt(index,2).toString());
               txt4.setText(df.getValueAt(index,3).toString());
           //       txt5.setText(df.getValueAt(index,4).toString());        // TODO add your handling code here:
    }//GEN-LAST:event_tab1MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
      search();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
      DT.setText(txt6.getText());
        
        
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
      
        double num1,num2;
        String answer;
        double result;
        
        num1 =Double.parseDouble(DT.getText());
        num2 = Double.parseDouble(pach.getText());
        
        result=num1-num2;
        
        answer=String.format("%.2f",result);
        pof.setText(answer);
      
   
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
   //  search2();
         int sum=0;
         SimpleDateFormat df= new SimpleDateFormat("dd-MM-yyyy");
          String date2= df.format(txt7.getDate());
         String dat=txt7.getDate().toString();

       try{

    DefaultTableModel model = (DefaultTableModel) tab1.getModel();
    model.setRowCount(0);
String sql="select id,name,quantity,price,(quantity*price)   AS total,date from  sales WHERE date='"+date2+"'";
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopsales","root","");
PreparedStatement pst= con.prepareStatement(sql);
//pst.setString(1, txt1.getText());
//pst.setString(1,txt5.getDate().toString());

ResultSet rs=pst.executeQuery();


while (rs.next()) {
         
            int id = rs.getInt("id");
            String nam = rs.getString("name");
            int quant = rs.getInt("quantity");
             Double pric = rs.getDouble("price");
            Double ic = rs.getDouble("total");
            String job = rs.getString("date");

           
   model.addRow(new Object[]{id, nam,quant,pric,ic,job});
    
 int tt=sum+=ic;
 txt6.setText(""+ tt);
 }
tab1.setModel(model);

pst.close();

}

catch(Exception e)
{

JOptionPane.showMessageDialog(this, e);

} 
    
// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
DT.setText("");
pach.setText("");
pof.setText("");
//txt6.setText("");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
try {
    String tt="SALES REPORT";
               
              tab1.print();
            //  tab1.print();
         } catch (PrinterException ex) {

         }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void pofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pofActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pofActionPerformed

    private void DTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DTActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(daily_sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(daily_sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(daily_sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(daily_sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new daily_sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DT;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextField pach;
    private javax.swing.JTextField pof;
    private javax.swing.JTable tab1;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txt4;
    private com.toedter.calendar.JDateChooser txt5;
    private javax.swing.JTextField txt6;
    private com.toedter.calendar.JDateChooser txt7;
    // End of variables declaration//GEN-END:variables

}
