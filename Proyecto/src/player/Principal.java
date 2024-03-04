/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import java.io.*;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author GPS
 */
public class Principal extends javax.swing.JFrame {
    
    Playlist pl=new Playlist();
    
    ArrayList updateList= new ArrayList();
    
    javazoom.jl.player.Player player;
    File simpan;
    

    /**
     * Creates new form PlayerMemo
     */
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    
    void updateList(){
    
        updateList=pl.getListSong();
        DefaultListModel model=new DefaultListModel();
        
        for(int i=0;i<updateList.size();i++)
            {
                int j=1+1;
                model.add(i,j + " | " + ((File) updateList.get(i)).getName());
                
                
            }
        jPlaylist.setModel(model);
           
    }
    
    // panel de control
    
    void add(){
    
        pl.add(this);
        updateList();
    }
    
    void remove(){
    
        try {
              int memoherdez=jPlaylist.getLeadSelectionIndex();
              pl.ls.remove(memoherdez);
              updateList();
            
        } catch (Exception e) {
        }
        
    }

     void up(){
    
         try {
                int s1=jPlaylist.getLeadSelectionIndex();
                simpan=(File)pl.ls.get(s1);
                pl.ls.remove(s1);
                pl.ls.add(s1-1,simpan);
                updateList();
                jPlaylist.setSelectedIndex(s1-1);
             
         } catch (Exception e) {
         }
        
    }
     
      void down(){
          
          try {
                int s1=jPlaylist.getLeadSelectionIndex();
                simpan=(File)pl.ls.get(s1);
                pl.ls.remove(s1);
                pl.ls.add(s1+1,simpan);
                updateList();
                jPlaylist.setSelectedIndex(s1+1);
             
         } catch (Exception e) {
         }
        
    }
      
      void open(){
    
        pl.openPls(this);
        updateList();
    }
      
      void save(){
    
       pl.saveAsPlaylist(this);
       updateList();
    }
      
      File play1;
      static int a=0;
      
      void putar(){
      
          if(a==0)
             {
                 try {
                        int p1=jPlaylist.getSelectedIndex();
                        play1=(File)this.updateList.get(p1);
                        FileInputStream fis=new FileInputStream(play1);
                        BufferedInputStream bis=new BufferedInputStream(fis);
                        player=new javazoom.jl.player.Player(bis);
                        a=1;
                     
                 } catch (Exception e) {
                     System.out.println("Problema al tocar musica");
                     System.out.println(e);
                 }
                 
                 new Thread()
                     {
                         @Override
                         public void run(){
                         
                             try {
                                   player.play();
                                 
                             } catch (Exception e) {
                                 
                             }
                         }
                  
                     }.start();
                 
             }
          else
              {
                 player.close();
                 a=0;
                 putar();
                  
              }
          
      }
      
      File sa;
      void next(){
      
      if(a==0)
             {
                 try {
                        int s1=jPlaylist.getSelectedIndex()+1;
                        sa=(File)this.pl.ls.get(s1);
                        FileInputStream fis=new FileInputStream(sa);
                        BufferedInputStream bis=new BufferedInputStream(fis);
                        player=new javazoom.jl.player.Player(bis);
                        a=1;
                        jPlaylist.setSelectedIndex(s1);
                     
                 } catch (Exception e) {
                     System.out.println("Problema al tocar musica");
                     System.out.println(e);
                 }
                 
                 new Thread()
                     {
                         @Override
                         public void run(){
                         
                             try {
                                   player.play();
                                 
                             } catch (Exception e) {
                                 
                             }
                         }
                  
                     }.start();
                 
             }
          else
              {
                 player.close();
                 a=0;
                 next();
                  
              }    
          
      }
      
      void previous(){
      
             if(a==0)
             {
                 try {
                        int s1=jPlaylist.getSelectedIndex()-1;
                        sa=(File)this.pl.ls.get(s1);
                        FileInputStream fis=new FileInputStream(sa);
                        BufferedInputStream bis=new BufferedInputStream(fis);
                        player=new javazoom.jl.player.Player(bis);
                        a=1;
                        jPlaylist.setSelectedIndex(s1);
                     
                 } catch (Exception e) {
                     System.out.println("Problema al tocar musica");
                     System.out.println(e);
                 }
                 
                 new Thread()
                     {
                         @Override
                         public void run(){
                         
                             try {
                                   player.play();
                                 
                             } catch (Exception e) {
                                 
                             }
                         }
                  
                     }.start();
                 
             }
          else
              {
                 player.close();
                 a=0;
                 previous();
                  
              } 
          
      }
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Exit_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPlaylist = new javax.swing.JList<>();
        EDA_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Exit_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/exit.png"))); // NOI18N
        Exit_button.setText("Exit");
        Exit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit_buttonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jPlaylist);

        EDA_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eda.png"))); // NOI18N
        EDA_button.setText("EDA");
        EDA_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDA_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EDA_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Exit_button, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 131, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Exit_button))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(EDA_button)))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Exit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit_buttonActionPerformed
       //add();
       dispose();
    }//GEN-LAST:event_Exit_buttonActionPerformed

    private void EDA_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDA_buttonActionPerformed
        // TODO add your handling code here:
        Informacion info=new Informacion();
        info.setVisible(true);
    }//GEN-LAST:event_EDA_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EDA_button;
    private javax.swing.JButton Exit_button;
    private javax.swing.JList<String> jPlaylist;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private DefaultListModel DefaultListModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
