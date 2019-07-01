/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadbalancerswing;

/**
 *
 * @author shivani this method is used to create request object and add
 * processing time to it and send them to load balancer in continuous thread
 */
public class CreateRequest implements Runnable {

    int processingTime = 100;
    boolean stopCreation = false;
    boolean pauseCreation = false;
    int ReqArrivalRate = 0;

    public int getReqArrivalRate() {
        return ReqArrivalRate;
    }

    public void setReqArrivalRate(int noOfReqPerSec) {
        this.ReqArrivalRate = noOfReqPerSec;
    }

    @Override
    public void run() {
        stopCreation = false;
        while (!stopCreation) {
            Request req = new Request();
            req.setProcessTime(getProcessingTime());
            LoadBalanceAndAutoScale.getInstance().queueRequest(req);
            try {
                Thread.sleep(ReqArrivalRate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("stopped here");

    }

    public int getProcessingTime() {
        return processingTime;
    }
    //method for stop creation
    synchronized public void stopMethod() {
        stopCreation = true;
    }
    //set req processing time
    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }
}
