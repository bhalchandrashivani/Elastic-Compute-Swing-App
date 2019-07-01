/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadbalancerswing;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author shivani This is the load balancer and auto scaling class used to
 * balance incoming req load acts as a cushion 
 */
public class LoadBalanceAndAutoScale {

    private int ReqDispatchingBreak = 3; // all req will be dispatched aafter 3 ms
    private Timer ReqDispatchingTimer = new Timer();
    private int ServerReqQueueSize;
    private static int inputReqQSize = 50; // set the input req q size to be 50 
    private static LoadBalanceAndAutoScale lbas = null;
    public static Queue<Request> inReq = new LinkedList<>();

    public int getServerReqQueueSize() {
        return ServerReqQueueSize;
    }

    public void setServerReqQueueSize(int ServerReqProcessingRate) {
        this.ServerReqQueueSize = ServerReqProcessingRate;
    }

    private LoadBalanceAndAutoScale() {

    }
//this method starts dispatching the req as they come to tthe queue at a fixed rate until the queue is empty

    public void startReqDispatch() {
        inReq.clear();
        ReqDispatchingTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!inReq.isEmpty()) {
                    loadRequest();
                }
            }
        }, ReqDispatchingBreak, ReqDispatchingBreak);
    }

    //this method will stop the loading of request
    public void stopLoadingRequests() {
        ReqDispatchingTimer.cancel();
        ReqDispatchingTimer = null;
        ReqDispatchingTimer = new Timer();
    }

    // method to get instances
    public static LoadBalanceAndAutoScale getInstance() {
        if (lbas == null) {
            lbas = new LoadBalanceAndAutoScale();
        }
        return lbas;
    }

    //method will add newly created req to the incoming req Q
    public void queueRequest(Request request) {
        if (inReq.size() == 0) {
            inReq.add(request);
        } else if (inReq.size() < inputReqQSize) {
            inReq.add(request);
        } else {
            System.out.println("The queue is full");
        }

    }
// this class checks for available server vms and assigns them the req object
    // if the vms are full will ask for more servers

    public void loadRequest() {
        if (!inReq.isEmpty()) {
            VM vm = Services.getInstance().availableVM();
            if (vm == null) {
                int extraServer = howManyServer(inReq.size(), ServerReqQueueSize);
                Services.getInstance().addVm(extraServer);

            } else {
                Request ReqObj = inReq.poll();
                ReqObj.setVm(vm);
                vm.getProcessingQ().add(ReqObj);

            }
        }
    }

    //to calculate how many more servers are required from the pool in case all vms are busy
    public static int howManyServer(int inReqsize, int ServerReqQueueSize) {

        int threshold = (inReqsize * 100 / inputReqQSize);
        if (threshold > 80) {
            return 1;
        } else {
            return 0;
        }

    }

}
