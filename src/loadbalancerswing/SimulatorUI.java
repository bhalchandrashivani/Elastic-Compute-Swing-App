/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadbalancerswing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author shivani
 * this program si a swing application to simulate the load on the website and learn how many
 * machines you need to handle a fluctuating load. 
 * Its design allows  us to vary the various parameters and see how the system 
 * behaves under different request arrival and processing rates
 */
public class SimulatorUI extends javax.swing.JFrame {

    static CreateRequest createReq = new CreateRequest();
    Thread mainThread;
    Timer timer;
    int servermapSize = 0;

    /**
     * Creates new form SimulatorUI
     */
    public SimulatorUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        Simulator = new javax.swing.JPanel();
        ReqRate = new javax.swing.JTextField();
        ReqRateLable = new javax.swing.JLabel();
        ReqProcessingtime = new javax.swing.JTextField();
        ReqProcessingTimeLabel = new javax.swing.JLabel();
        SimulateStart = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        returnarea = new javax.swing.JTextArea();
        MaxReqPerServerLabel = new javax.swing.JLabel();
        MaxReqPerServer = new javax.swing.JTextField();
        StopSimulation = new javax.swing.JButton();
        DetailsPanel = new javax.swing.JPanel();
        ServerCount = new javax.swing.JLabel();
        RequestsInQueue = new javax.swing.JLabel();
        TotalReqDisapatched = new javax.swing.JLabel();
        TotalReqProcessed = new javax.swing.JLabel();
        AvgProcessingTime = new javax.swing.JLabel();
        ServerDetails = new javax.swing.JScrollPane();
        ServerDetailsText = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane5.setViewportView(jTextArea4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ReqRate.setToolTipText("");
        ReqRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReqRateActionPerformed(evt);
            }
        });

        ReqRateLable.setText("Enter the Request Rate :");
        ReqRateLable.setToolTipText("");

        ReqProcessingtime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReqProcessingtimeActionPerformed(evt);
            }
        });

        ReqProcessingTimeLabel.setText("Enter processing time for a Request: ");

        SimulateStart.setText("Start Simulation");
        SimulateStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimulateStartActionPerformed(evt);
            }
        });

        returnarea.setColumns(20);
        returnarea.setRows(5);

        MaxReqPerServerLabel.setText("Max Request a Server can handle :");

        MaxReqPerServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaxReqPerServerActionPerformed(evt);
            }
        });

        StopSimulation.setText("Stop Simulation");
        StopSimulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopSimulationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SimulatorLayout = new javax.swing.GroupLayout(Simulator);
        Simulator.setLayout(SimulatorLayout);
        SimulatorLayout.setHorizontalGroup(
            SimulatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SimulatorLayout.createSequentialGroup()
                .addGroup(SimulatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SimulatorLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(SimulatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ReqRateLable)
                            .addComponent(ReqProcessingTimeLabel)
                            .addGroup(SimulatorLayout.createSequentialGroup()
                                .addComponent(MaxReqPerServerLabel)
                                .addGap(111, 111, 111)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(SimulatorLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(SimulateStart)
                        .addGap(18, 18, 18)
                        .addComponent(StopSimulation)))
                .addGap(70, 70, 70)
                .addGroup(SimulatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(returnarea, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SimulatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(MaxReqPerServer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                        .addComponent(ReqProcessingtime, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ReqRate, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        SimulatorLayout.setVerticalGroup(
            SimulatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SimulatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SimulatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReqRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReqRateLable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SimulatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReqProcessingtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReqProcessingTimeLabel))
                .addGap(18, 18, 18)
                .addGroup(SimulatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SimulatorLayout.createSequentialGroup()
                        .addGroup(SimulatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(SimulatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(MaxReqPerServerLabel)
                                .addComponent(MaxReqPerServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(SimulatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SimulateStart)
                            .addComponent(StopSimulation)))
                    .addGroup(SimulatorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(returnarea, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        ServerCount.setText("ServerCount");

        RequestsInQueue.setText("RequestsInQueue");

        TotalReqDisapatched.setText("TotalReqDispatched");

        TotalReqProcessed.setText("TotalReqProcessed");

        AvgProcessingTime.setText("AvgProcessingTime");

        ServerDetailsText.setColumns(20);
        ServerDetailsText.setRows(5);
        ServerDetails.setViewportView(ServerDetailsText);

        jLabel1.setText("Last Updated Server List:");

        javax.swing.GroupLayout DetailsPanelLayout = new javax.swing.GroupLayout(DetailsPanel);
        DetailsPanel.setLayout(DetailsPanelLayout);
        DetailsPanelLayout.setHorizontalGroup(
            DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AvgProcessingTime)
                    .addComponent(TotalReqProcessed)
                    .addComponent(TotalReqDisapatched)
                    .addComponent(RequestsInQueue)
                    .addComponent(ServerCount))
                .addGap(104, 104, 104)
                .addGroup(DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ServerDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(250, Short.MAX_VALUE))
        );
        DetailsPanelLayout.setVerticalGroup(
            DetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DetailsPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(ServerCount)
                .addGap(18, 18, 18)
                .addComponent(RequestsInQueue)
                .addGap(18, 18, 18)
                .addComponent(TotalReqDisapatched)
                .addGap(33, 33, 33)
                .addComponent(TotalReqProcessed)
                .addGap(18, 18, 18)
                .addComponent(AvgProcessingTime)
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DetailsPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ServerDetails)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Simulator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(DetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Simulator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //method when you hit the simulation button
    private void SimulateStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimulateStartActionPerformed

        if (ReqProcessingtime.getText().equals("") | ReqRate.getText().equals("") | MaxReqPerServer.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Input is Empty");
        } else {
            try {
                if (Integer.parseInt(ReqProcessingtime.getText()) < 0) {
                    JOptionPane.showMessageDialog(null, "Enter Valid Processing time");
                } else if (Integer.parseInt(ReqRate.getText()) < 0) {
                    JOptionPane.showMessageDialog(null, "Enter Valid Req Rate time");

                } else if (Integer.parseInt(MaxReqPerServer.getText()) < 0) {
                    JOptionPane.showMessageDialog(null, "Enter Valid MaxReqPerServer");
                } else {

                    int ReqArrivalRate = Integer.parseInt(this.ReqRate.getText());// pass req creation rate
                    createReq.setReqArrivalRate(ReqArrivalRate);
                    createReq.setProcessingTime(Integer.parseInt(this.ReqProcessingtime.getText()));// set processing time for each req
                    mainThread = null;
                    mainThread = new Thread(createReq);// creat the req creation thread
                    
                    //set max req server can handle and start dispatching req from load balancer Q
                    LoadBalanceAndAutoScale.getInstance().setServerReqQueueSize(Integer.parseInt(this.MaxReqPerServer.getText()));
                    LoadBalanceAndAutoScale.getInstance().startReqDispatch();
                    
                    //pass the processing time to each server and max req a server can handle
                    Services.getInstance().setReqProccessingTime(Integer.parseInt(this.ReqProcessingtime.getText()));
                    Services.getInstance().setSizeofmcQ(Integer.parseInt(this.MaxReqPerServer.getText()));
                    
                    //start req generation
                    mainThread.start();

                    //start fetching details of simulation
                    fetchDetail();
                    this.returnarea.setText("Simulation begins");

                }

            } catch (NumberFormatException excep) {
                JOptionPane.showMessageDialog(null, "Fields should contain numbers");
            }
        }

    }//GEN-LAST:event_SimulateStartActionPerformed

    private void ReqRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReqRateActionPerformed

    }//GEN-LAST:event_ReqRateActionPerformed

    private void ReqProcessingtimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReqProcessingtimeActionPerformed
        // TODO add your handling code here:          

    }//GEN-LAST:event_ReqProcessingtimeActionPerformed

    private void MaxReqPerServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaxReqPerServerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaxReqPerServerActionPerformed

    //When you press Stop Simulation  this method gets called
    private void StopSimulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopSimulationActionPerformed

        createReq.stopMethod();// stop genrating new request
        LoadBalanceAndAutoScale.getInstance().stopLoadingRequests();//stop dispatching req        
        endFetchDetailTimer();// stop geting details
        Services.getInstance().clearAllQueue();// clear all the req queue
        this.returnarea.setText("Simulation stopped");

    }//GEN-LAST:event_StopSimulationActionPerformed

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
            java.util.logging.Logger.getLogger(SimulatorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimulatorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimulatorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimulatorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimulatorUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AvgProcessingTime;
    private javax.swing.JPanel DetailsPanel;
    private javax.swing.JTextField MaxReqPerServer;
    private javax.swing.JLabel MaxReqPerServerLabel;
    private javax.swing.JLabel ReqProcessingTimeLabel;
    private javax.swing.JTextField ReqProcessingtime;
    private javax.swing.JTextField ReqRate;
    private javax.swing.JLabel ReqRateLable;
    private javax.swing.JLabel RequestsInQueue;
    private javax.swing.JLabel ServerCount;
    private javax.swing.JScrollPane ServerDetails;
    private javax.swing.JTextArea ServerDetailsText;
    private javax.swing.JButton SimulateStart;
    private javax.swing.JPanel Simulator;
    private javax.swing.JButton StopSimulation;
    private javax.swing.JLabel TotalReqDisapatched;
    private javax.swing.JLabel TotalReqProcessed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea returnarea;
    // End of variables declaration//GEN-END:variables

    //method to fetch detials after every few unit time
    public void fetchDetail() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ObtainDetail();
            }
        }, 500, 500);
    }

    public void endFetchDetailTimer() {
        timer.cancel();
        timer = null;
    }

    // method to fetch ongoing simulation details
    synchronized public void ObtainDetail() {
        int noOfServers = Services.getInstance().getServersInProccess();// get no of servers in use
        int reqInQueue = LoadBalanceAndAutoScale.inReq.size();// get the no of req in load balancer Q
        int inProcess = Services.getInstance().getReqInProcessCount();//get requests in process
        int processed = Services.getInstance().getReqprocessedCount();//get processed requests
        Map<Integer, Integer> servermap = new HashMap<>();
        servermap = Services.getInstance().getServerDetails();// fetch current server details
        long avgProcTime = Services.getInstance().getAvgProccessTime();// get the average processing time
        updateDetails(noOfServers, reqInQueue, inProcess, processed, avgProcTime, servermap);// call update details method
        //if (servermap.size() > servermapSize) {
        ServerDetailsText.setText("");
        PrintServerDetails(servermap);
        //}
        // servermapSize = servermap.size();
    }

    // method to print required details to the UI console
    public void updateDetails(int serCount, int QueueCount, int reqInProc, int procReq, long avgProcTime, Map<Integer, Integer> servermap) {
        ServerCount.setText(" Servers in Use: " + serCount + "/5");
        RequestsInQueue.setText(" Requests in Dispatcher Queue Count : " + QueueCount + "/50");
        TotalReqDisapatched.setText(" Requests in Proccess Count: " + reqInProc);
        TotalReqProcessed.setText(" Processed Request Count: " + procReq);
        AvgProcessingTime.setText(" Avg Processing Time: " + avgProcTime + " ms/request");

    }

    // method to print server details to UI console
    public void PrintServerDetails(Map<Integer, Integer> servermap) {

        for (Map.Entry serverMapSet : servermap.entrySet()) {
            //if (!serverMapSet.getKey().equals(0)) {
            ServerDetailsText.append("Server No " + serverMapSet.getKey() + " : " + serverMapSet.getValue() + "\n");
            //}
        }
    }
}
