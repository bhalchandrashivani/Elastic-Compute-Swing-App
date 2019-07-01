/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadbalancerswing;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author shivani
 * this class is basically a virtual machine or a server
 * it will process each incoming request
 */
public class VM implements Runnable {

    Queue<Request> processingQ;
    int vmId;
    private boolean inUse;

    public VM() {
        this.processingQ = new LinkedList<>();
        this.inUse = inUse;

    }

    public Queue<Request> getProcessingQ() {
        return processingQ;
    }

    public void setProcessingQ(Queue<Request> processingQ) {
        this.processingQ = processingQ;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    //this method will process the req q unitll all the processing q is empty
    @Override
    public void run() {
        while (isInUse()) {
            if (getProcessingQ().isEmpty()) {
                //System.out.println("Server Q empty");
            } else {
                Request request = getProcessingQ().peek();
                if (request != null) {
                    processCurrentRequest(request);
                }
            }
        }
    }

    public int getVmId() {
        return vmId;
    }

    public void setVmId(int vmId) {
        this.vmId = vmId;
    }
    // method will wait for the given processing time and mark the req processed and then dequeu it from the req pool
    public void processCurrentRequest(Request request) {
        try {
            Thread.sleep(Services.getInstance().getReqProccessingTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        request.setProcesssed(true);
        DequeReq(request);
    }

    // method will dequeu the req from the procesing q of the server
    //set the req count to be processed and remove it from the pool of in process req
    // also will calculate the avg processing times
    public void DequeReq(Request request) {
        Request req = request.getVm().getProcessingQ().poll();
        Services service = Services.getInstance();
        service.setReqInProcessCount(service.getReqInProcessCount() - 1);
        service.setReqprocessedCount(service.getReqprocessedCount() + 1);

        if (request.getVm().getProcessingQ().isEmpty()) {
            service.freeVM(request.getVm());
        }

        if (req != null) {
            long calculated_time = System.currentTimeMillis() - req.getRequestTime();
            long avgProcessingTime = service.getStorePreviousProccessTime();
            int ReqProccessedCount = service.getReqprocessedCount();

            if (ReqProccessedCount > 100) {
                service.setStorePreviousProccessTime(avgProcessingTime - service.getAvgProccessTime() + calculated_time);
                service.setAvgProccessTime(service.getStorePreviousProccessTime() / 100);
            } else {
                service.setStorePreviousProccessTime(avgProcessingTime + calculated_time);
                service.setAvgProccessTime(service.getStorePreviousProccessTime() / ReqProccessedCount);
            }
        }
    }

}
