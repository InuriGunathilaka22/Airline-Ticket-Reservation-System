
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Inuri
 */
public class SearchCustomer extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddCustomer
     */
    public SearchCustomer() {
        initComponents();
   
    }
    
    Connection con;
     PreparedStatement pst;
     String path = null;
     byte[] userimage = null;
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtfirstname = new javax.swing.JTextField();
        txtlastname = new javax.swing.JTextField();
        txtnic = new javax.swing.JTextField();
        txtpassport = new javax.swing.JTextField();
        txtcontact = new javax.swing.JTextField();
        txtcity = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtphoto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();
        r1 = new javax.swing.JRadioButton();
        r2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtdob = new com.toedter.calendar.JDateChooser();
        txtcustid = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setTitle("View Customer Details");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Customer Details");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, 166, 28));

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel2.setText("Customer ID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 51, 132, 39));

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel4.setText("First Name:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 129, -1, -1));

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel5.setText("Last Name:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 206, -1, -1));

        jLabel6.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel6.setText("NIC:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 280, -1, -1));

        jLabel7.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel7.setText("Passport No:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 352, -1, -1));

        jLabel8.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel8.setText("Address:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 421, -1, -1));

        jLabel9.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel9.setText("Date of Birth:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 129, -1, -1));

        jLabel10.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel10.setText("Gender:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 206, -1, -1));

        jLabel11.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel11.setText("Contact No:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 280, -1, -1));

        jLabel12.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel12.setText("City:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 352, -1, -1));

        txtfirstname.setBackground(new java.awt.Color(204, 255, 255));
        txtfirstname.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        txtfirstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfirstnameActionPerformed(evt);
            }
        });
        getContentPane().add(txtfirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 124, 151, -1));

        txtlastname.setBackground(new java.awt.Color(204, 255, 255));
        txtlastname.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        getContentPane().add(txtlastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 201, 149, -1));

        txtnic.setBackground(new java.awt.Color(204, 255, 255));
        txtnic.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        getContentPane().add(txtnic, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 275, 149, -1));

        txtpassport.setBackground(new java.awt.Color(204, 255, 255));
        txtpassport.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        getContentPane().add(txtpassport, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 347, 149, -1));

        txtcontact.setBackground(new java.awt.Color(204, 255, 255));
        txtcontact.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        getContentPane().add(txtcontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 275, 214, -1));

        txtcity.setBackground(new java.awt.Color(204, 255, 255));
        txtcity.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        getContentPane().add(txtcity, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 347, 214, -1));

        txtemail.setBackground(new java.awt.Color(204, 255, 255));
        txtemail.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 429, 214, -1));

        jLabel13.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel13.setText("E-mail:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 434, -1, -1));

        txtphoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(txtphoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(948, 124, 250, 250));

        txtaddress.setBackground(new java.awt.Color(204, 255, 255));
        txtaddress.setColumns(20);
        txtaddress.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        txtaddress.setRows(5);
        jScrollPane1.setViewportView(txtaddress);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 421, 151, 76));

        r1.setBackground(new java.awt.Color(255, 255, 255));
        r1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        r1.setText("Male");
        r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1ActionPerformed(evt);
            }
        });
        getContentPane().add(r1, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 200, -1, -1));

        r2.setBackground(new java.awt.Color(255, 255, 255));
        r2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        r2.setText("Female");
        r2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2ActionPerformed(evt);
            }
        });
        getContentPane().add(r2, new org.netbeans.lib.awtextra.AbsoluteConstraints(744, 200, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 153, 204));
        jButton1.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(979, 421, 204, 51));

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 520, 190, 51));

        jButton4.setBackground(new java.awt.Color(0, 153, 255));
        jButton4.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 520, 190, 50));

        txtdob.setBackground(new java.awt.Color(204, 255, 255));
        txtdob.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        getContentPane().add(txtdob, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 124, 212, -1));

        txtcustid.setBackground(new java.awt.Color(204, 255, 255));
        txtcustid.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        getContentPane().add(txtcustid, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 54, 151, -1));

        jButton3.setBackground(new java.awt.Color(0, 153, 204));
        jButton3.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 48, 126, 46));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Inuri\\Downloads\\turismo_digitalizzazione.jpg")); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -80, 1260, 660));

        setBounds(0, 0, 1266, 616);
    }// </editor-fold>//GEN-END:initComponents

    private void r2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r2ActionPerformed

    private void r1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r1ActionPerformed

    private void txtfirstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfirstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfirstnameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        try {
            JFileChooser picchooser = new JFileChooser();
            picchooser.showOpenDialog(null);
            File pic = picchooser.getSelectedFile();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images","png","jpg");
            picchooser.addChoosableFileFilter(filter);
            path= pic.getAbsolutePath();
            BufferedImage img;
            img = ImageIO.read(picchooser.getSelectedFile());
            ImageIcon imageIcon = new ImageIcon(new
            ImageIcon(img).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
            txtphoto.setIcon(imageIcon);

            File image = new File(path);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream baos= new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            for(int readNum; (readNum=fis.read(buff)) !=-1 ; )
            {
                baos.write(buff,0,readNum);
            }
            userimage=baos.toByteArray();

        } catch (IOException ex) {
            Logger.getLogger(SearchCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        String id = txtcustid.getText();
        String firstname = txtfirstname.getText();
        String lastname = txtlastname.getText();
        String nic = txtnic.getText(); 
        String passport = txtpassport.getText();
        String address = txtaddress.getText();
        
        DateFormat da = new SimpleDateFormat("yyyy-MM-dd");
        String date = da.format(txtdob.getDate());
        String gender;
        
        if(r1.isSelected())
        {
            gender = "Male";
        }
        else
        {
            gender = "Female";
        }
        
        String contact = txtcontact.getText();
        String city = txtcity.getText();
        String email = txtemail.getText();
        
        
        
         
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/airline_ticket_reservation_system","root","");
            pst = con.prepareStatement("update customer set firstname = ?,lastname = ?,nic = ?,passport = ?,address= ?,dob = ?,gender = ?,contact_no = ?,city = ? , email = ? ,photo = ? where id = ?");
            

            pst.setString(1, firstname);
            pst.setString(2, lastname);
            pst.setString(3, nic);
            pst.setString(4, passport);
            pst.setString(5, address);
            pst.setString(6, date);
            pst.setString(7, gender);
            pst.setString(8, contact);
            pst.setString(9, city);
            pst.setString(10, email);
            pst.setBytes(11, userimage);
            pst.setString(12, id);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Record has been updated!");
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SearchCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }


        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        
        String id = txtcustid.getText();
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/airline_ticket_reservation_system","root","");
            pst = con.prepareStatement("select * from customer where id = ?");
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next() == false)
            {
                JOptionPane.showMessageDialog(this, "Record not Found");
            }
            else
            {
                String fname = rs.getString("firstname");
                String lname = rs.getString("lastname");
                String nic = rs.getString("nic");
                String passport = rs.getString("passport");
                 
                String address = rs.getString("address");
                String dob = rs.getString("dob");
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
                String gender =rs.getString("gender");
                
                Blob blob = rs.getBlob("photo");
                byte[ ]  _imagebytes=blob.getBytes( 1, (int) blob.length( ) );
                ImageIcon image = new ImageIcon(_imagebytes);
                Image im = image.getImage();
                Image myImg = im.getScaledInstance(txtphoto.getWidth(), txtphoto.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImg);
                 
                if(gender.equals("Female"))
                {
                    r1.setSelected(false);
                    r2.setSelected(true);
                     
                }
                 else
                {
                    r1.setSelected(true);
                    r2.setSelected(false);
                }
                String contact = rs.getString("contact_no");
                String city = rs.getString("city");
                String email = rs.getString("email");
                
          
                 
                txtfirstname.setText(fname.trim());
                txtlastname.setText(lname.trim());
                txtnic.setText(nic.trim());
                txtpassport.setText(passport.trim());
                txtaddress.setText(address.trim());
                txtdob.setDate(date1);
                txtcontact.setText(contact.trim());
                txtcity.setText(city.trim());
                txtemail.setText(email.trim());
                txtphoto.setIcon(newImage);
                
            }
                    

              
              
              
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SearchCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SearchCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        this.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    private javax.swing.JTextArea txtaddress;
    private javax.swing.JTextField txtcity;
    private javax.swing.JTextField txtcontact;
    private javax.swing.JTextField txtcustid;
    private com.toedter.calendar.JDateChooser txtdob;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfirstname;
    private javax.swing.JTextField txtlastname;
    private javax.swing.JTextField txtnic;
    private javax.swing.JTextField txtpassport;
    private javax.swing.JLabel txtphoto;
    // End of variables declaration//GEN-END:variables
}
