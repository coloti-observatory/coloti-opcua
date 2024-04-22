package coloti.opcua;

import coloti.opcua.server.MonitorNodeImpl;
import coloti.tcs.TCS;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.apache.commons.codec.digest.MurmurHash3.IncrementalHash32;
import org.eclipse.milo.opcua.sdk.server.nodes.UaNode;
import org.eclipse.milo.opcua.sdk.server.nodes.UaVariableNode;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.DateTime;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.StatusCode;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import coloti.tcs.TCS;

public class ConsumerLibrary {

    // mode: boolean X axis, boolean Y axis, boolean Dome axis
    private final static TCS tcs = new TCS();//false,false,true,"","","/dev/ttyUSB0"); // /dev/ttyUSB0
    
    private static final Logger logger = LoggerFactory.getLogger(ConsumerLibrary.class);

    public ConsumerLibrary() {
        
    }


    public static boolean connect() {
        boolean connected = tcs.connect();
        Sleep(3000);
        System.out.println("++++");
        System.out.println("++++");
        System.out.println("++++");
        System.out.println(connected);
        System.out.println("++++");
        System.out.println("++++");
        System.out.println("++++");
        if (connected){
            tcs.CmdGoLoaded(true);
            System.out.println("-----");
            System.out.println("-----");
            System.out.println("OKAY");
            System.out.println("-----");
            System.out.println("-----");
        }
        else{
            logger.error("Connection failed");
            System.out.println("-----");
            System.out.println("-----");
            System.out.println("ERRORE");
            System.out.println("-----");
            System.out.println("-----");
        }

        //while (!tcs.connect())
            //Sleep(200);
        return connected;
    }


    public static void Sleep(int millisecondsTime) { // VERIFICATO 
        try {
          TimeUnit.MILLISECONDS.sleep(millisecondsTime);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
    }

    // ---------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------

    //#region COMMANDS


    public static Consumer<DataValue> cmdGoLoadedConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdGoLoaded((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> cmdGoStandbyConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdGoStandby((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> cmdGoOnlineConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdGoOnline((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> cmdGoMaintenanceConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdGoMaintenance((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> cmdEnableAzMotorsConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdEnableAzMotors((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> cmdEnableElMotorsConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdEnableElMotors((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> cmdDisableAzMotorsConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdDisableAzMotors((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> cmdDisableElMotorsConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdDisableElMotors((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> cmdStartMotionConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdStartMotion((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> cmdStopMotionConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdStopMotion((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> cmdStartAzMotionConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdStartAzMotion((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> cmdStopAzMotionConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdStopAzMotion((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> cmdStartElMotionConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdStartElMotion((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> cmdStopElMotionConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdStopElMotion((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> cmdEmergencyStopConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdEmergencyStop((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue>  cmdStartParkingConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdStartParking((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue>  cmdStopParkingConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdStopParking((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue>  cmdStartAzParkingConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdStartAzParking((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue>  cmdStopAzParkingConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdStopAzParking((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue>  cmdStartElParkingConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdStartElParking((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue>  cmdStopElParkingConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdStopElParking((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue>  cmdStartTrackingConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdStartTracking((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue>  cmdStopTrackingConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdStopTracking((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue>  cmdStartPointingConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdStartPointing((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue>  cmdStopPointingConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdStopPointing((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

        // comandi aggiuntivi

    public static Consumer<DataValue>  cmdOpenCupolaConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdOpenCupola((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue>  cmdCloseCupolaConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdCloseCupola((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue>  cmdStartCupolaPointingConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdStartCupolaPointing((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue>  cmdStartCupolaParkingConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdStartCupolaParking((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue>  cmdStopCupolaConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdStopCupola((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue>  cmdStopPointMotionConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdStopPointMotion((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };


    public static Consumer<DataValue>  cmdsetZeroCupolaConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdSetZeroCupola((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue>  cmdHomePosConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdHomePos((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue>  cmdCupolaEstConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdCupolaEst((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue>  cmdCupolaOvestConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.CmdCupolaOvest((boolean) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };


    // ---------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------

    //#region SETTERS
    
    public static Consumer<DataValue> setCupolaTargetPositionConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetCupolaTargetPosition((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };





    public static Consumer<DataValue> setAzMaxVelConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetAzMaxVel((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setAzMaxAccConsumer = new Consumer<DataValue>() {
        
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetAzMaxAcc((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };


    public static Consumer<DataValue> setMotionTypeConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
            tcs.SetMotionType((int)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

        // AZ setters

    public static Consumer<DataValue> setAzJogDirectionConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetAzJogDirection((int)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setAzTelPositionConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetAzTelPosition((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setAzJogVelocityConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetAzJogVelocity((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setAzSlewVelocityConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetAzSlewVelocity((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setAzSlewAccelerationConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetAzSlewAcceleration((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setAzSlewDecelerationConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetAzSlewDeceleration((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    /*
    public static Consumer<DataValue> setAzMaxVelConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
            tcs.SetAzMaxVel((double)t.getValue().getValue());
}
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setAzMaxAccConsumer = new Consumer<DataValue>() {
        
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
            tcs.SetAzMaxAcc((double)t.getValue().getValue());
}
            System.out.println("READ:" + t.toString());
        }
    };
    */

    public static Consumer<DataValue> setAzMinVelConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetAzMinVel((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setAzMinAccConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetAzMinAcc((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setAzTelMinPosConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetAzTelMinPos((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setAzTelMaxPosConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetAzTelMaxPos((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setAzLsOpCwConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetAzLsOpCwPos((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setAzLsOpCcwConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetAzLsOpCcwPos((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };



        // EL setters

    public static Consumer<DataValue> setElJogDirectionConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetElJogDirection((int)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setElTelPositionConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetElTelPosition((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setElJogVelocityConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetElJogVelocity((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setElSlewVelocityConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetElSlewVelocity((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setElSlewAccelerationConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetElSlewAcceleration((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setElSlewDecelerationConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetElSlewDeceleration((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    
    public static Consumer<DataValue> setElMaxVelConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetElMaxVel((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setElMaxAccConsumer = new Consumer<DataValue>() {
        
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetElMaxAcc((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };
    

    public static Consumer<DataValue> setElMinVelConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetElMinVel((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setElMinAccConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetElMinAcc((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setElTelMinPosConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetElTelMinPos((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setElTelMaxPosConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetElTelMaxPos((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setElLsOpLowConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetElLsOpLowPos((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setElLsOpHighConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetElLsOpHighPos((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setObserverLatConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetObserverLat((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setObserverLongConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetObserverLong((double)t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue> setObserverHeightConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                String stringaAltezza = t.getValue().getValue().toString();
                int Height = (int) Double.parseDouble(stringaAltezza);
                tcs.SetObserverAlt(Height);
            }
            System.out.println("READ:" + t.toString());
        }
    };

     // setters aggiuntivi
        
    public static Consumer<DataValue>  setAzParkingPositionConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetAzParkingPosition((double) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue>  setElParkingPositionConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetElParkingPosition((double) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };

    public static Consumer<DataValue>  setCupolaParkingPositionConsumer = new Consumer<DataValue>() {
        @Override
        public void accept(DataValue t) {
            if(t.getStatusCode().isGood()){
                tcs.SetCupolaParkingPosition((double) t.getValue().getValue());
            }
            System.out.println("READ:" + t.toString());
        }
    };


    // ---------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------

    //#region GETTERS
    
    public static MonitorNodeImpl getCupolaPositionMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                double a = tcs.GetCupolaPosition();
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };
    
    public static MonitorNodeImpl getAzLsOpCwMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                boolean a = tcs.GetAzLsOpCw();
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getAzLsOpCcwMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                boolean a = tcs.GetAzLsOpCcw();
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getElLsOpLowMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                boolean a = tcs.GetElLsOpLow();
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getElLsOpHighMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                boolean a = tcs.GetElLsOpHigh();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getAzMotorsStatusMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                int a = tcs.GetAzMotorStatus();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        }
    };

    public static MonitorNodeImpl getElMotorsStatusMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                int a = tcs.GetElMotorStatus();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getAzTelPosMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                double a = tcs.GetAzTelPos();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getAzActVelMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                double a = tcs.GetAzActVel();
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    // questa mi sa che non c'è
    public static MonitorNodeImpl getAzActAccMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                double a = tcs.GetAzActAcc();
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getAzCommandedPosMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                double a = tcs.GetAzCommandedPos();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getAzCommandedVelMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                double a = tcs.GetAzCommandedVel();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getAzCommandedAccMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                double a = tcs.GetAzCommandedAcc();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getElTelPosMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                double a = tcs.GetElTelPos();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getElActVelMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                double a = tcs.GetElActVel();
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    // questa mi sa che non c'è
    public static MonitorNodeImpl getElActAccMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                double a = tcs.GetElActAcc();
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getElCommandedPosMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                double a = tcs.GetElCommandedPos();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getElCommandedVelMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                double a = tcs.GetElCommandedVel();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getElCommandedAccMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                double a = tcs.GetElCommandedAcc();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getAzMotionStateMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                int a = tcs.GetAzMotionState();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        }
    }; 
    public static MonitorNodeImpl getElMotionStateMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                int a = tcs.GetElMotionState();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        }
    };


    public static MonitorNodeImpl getMachineStateMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                int a = tcs.GetMachineState();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getMachineStatePhaseMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                int a = tcs.GetMachineStatePhase();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };


    public static MonitorNodeImpl getTCUModeMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                int a = tcs.GetTCUMode();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };


    public static MonitorNodeImpl getGoLoadedInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetGoLoadedInfo();
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getGoStandbyInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetGoStandbyInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getGoOnlineInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetGoOnlineInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    
    public static MonitorNodeImpl getGoMaintenanceInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetGoMaintenanceInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };    

    public static MonitorNodeImpl getAzEnableMotorsInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetAzEnableMotorsInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getAzDisableMotorsInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetAzDisableMotorsInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getElEnableMotorsInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetAzEnableMotorsInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getElDisableMotorsInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetAzDisableMotorsInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };


    public static MonitorNodeImpl getStartMotionInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetStartMotionInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getStopMotionInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetStopMotionInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getAzStartMotionInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetAzStartMotionInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getAzStopMotionInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetAzStopMotionInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getElStartMotionInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetElStartMotionInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getElStopMotionInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetElStopMotionInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getEmergencyStopInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetEmergencyStopInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getZeroDomeInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetZeroDomeInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };


    public static MonitorNodeImpl getErrorNumberMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                int a = tcs.GetErrorNumber();
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };


    public static MonitorNodeImpl getErrorBufferMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetErrorBuffer();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };


    public static MonitorNodeImpl getErrorBufferOutOfRangeMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                boolean a = tcs.GetErrorBufferOutOfRange();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };


    public static MonitorNodeImpl getErrorBufferSizeMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                int a = tcs.GetErrorBufferSize();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getHeartBeatMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                int a = tcs.GetHeartBeat();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getOpenDomeInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetOpenDomeInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getCloseDomeInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetCloseDomeInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getStartPointingDomeInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetStartPointingDomeInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getStartParkingDomeInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetStartParkingDomeInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getStopDomeInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetStopDomeInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getDomeWestInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetDomeWestInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getDomeEastInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetDomeEastInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };

    public static MonitorNodeImpl getHomePosInfoMonitor = new MonitorNodeImpl() {
        @Override
        public void run() {
            if(run.get()){
                String a = tcs.GetHomePosInfo();   
                node.setValue(new DataValue(new Variant(a), StatusCode.GOOD, DateTime.now()));
            }
        } 
    };








    // -----------------------------------------------------------------------------
    // -----------------------------------------------------------------------------
    // -----------------------------------------------------------------------------
    // -----------------------------------------------------------------------------
    // -----------------------------------------------------------------------------
    // -----------------------------------------------------------------------------
    // -----------------------------------------------------------------------------
    // -----------------------------------------------------------------------------
    // -----------------------------------------------------------------------------





    /*
    public static Map<String, Consumer<DataValue>> consumerMapCmd;
    static {
        consumerMapCmd = new HashMap<>();
        
        consumerMapCmd.put("GO_LOADED",cmdGoLoadedConsumer);
        consumerMapCmd.put("GO_STANDBY",cmdGoStandbyConsumer);
        consumerMapCmd.put("GO_ONLINE",cmdGoOnlineConsumer);
        consumerMapCmd.put("GO_MAINTENANCE",cmdGoMaintenanceConsumer);
        consumerMapCmd.put("ENABLE_AZ_MOTORS",cmdEnableAzMotorsConsumer);
        consumerMapCmd.put("DISABLE_AZ_MOTORS",cmdDisableAzMotorsConsumer);
        consumerMapCmd.put("ENABLE_EL_MOTOR",cmdEnableElMotorsConsumer);
        consumerMapCmd.put("DISABLE_EL_MOTOR",cmdDisableElMotorsConsumer);
        consumerMapCmd.put("START_MOTION",cmdStartMotionConsumer);
        consumerMapCmd.put("STOP_MOTION",cmdStopMotionConsumer);
        consumerMapCmd.put("START_AZ_MOTION",cmdStartAzMotionConsumer);
        consumerMapCmd.put("STOP_AZ_MOTION",cmdStopAzMotionConsumer);
        consumerMapCmd.put("START_EL_MOTION",cmdStartElMotionConsumer);
        consumerMapCmd.put("STOP_EL_MOTION",cmdStopElMotionConsumer);
        consumerMapCmd.put("EMERGENCY_STOP",cmdEmergencyStopConsumer);
        consumerMapCmd.put("START_AZ_PARKING",cmdStartAzParkingConsumer);
        consumerMapCmd.put("STOP_AZ_PARKING",cmdStopAzParkingConsumer);
        consumerMapCmd.put("START_EL_PARKING",cmdStartElParkingConsumer);
        consumerMapCmd.put("STOP_EL_PARKING",cmdStopElParkingConsumer);
        consumerMapCmd.put("START_PARKING",cmdStartParkingConsumer);
        consumerMapCmd.put("STOP_PARKING",cmdStopParkingConsumer);
        consumerMapCmd.put("START_TRACKING",cmdStartTrackingConsumer);
        consumerMapCmd.put("STOP_TRACKING",cmdStopTrackingConsumer);
        consumerMapCmd.put("START_POINTING",cmdStartPointingConsumer);
        consumerMapCmd.put("STOP_POINTING",cmdStopPointingConsumer);
    }    */

    public static Map<String, Consumer<DataValue>> consumerMap;
    static {
        consumerMap = new HashMap<>();
        
        consumerMap.put("AZ_TEL_POSITION", setAzTelPositionConsumer);
        consumerMap.put("AZ_JOG_DIRECTION", setAzJogDirectionConsumer);
        consumerMap.put("AZ_TEL_POSITION", setAzTelPositionConsumer);
        consumerMap.put("AZ_JOG_VELOCITY", setAzJogVelocityConsumer);
        consumerMap.put("EL_TEL_POSITION", setElTelPositionConsumer);
        consumerMap.put("EL_JOG_VELOCITY", setElJogVelocityConsumer);
        consumerMap.put("EL_JOG_DIRECTION", setElJogDirectionConsumer);
        consumerMap.put("MOTION_TYPE", setMotionTypeConsumer);
        consumerMap.put("AZ_SLEW_VELOCITY", setAzSlewVelocityConsumer);
        consumerMap.put("AZ_SLEW_ACCELERATION", setAzSlewAccelerationConsumer);
        consumerMap.put("AZ_SLEW_DECELERATION", setAzSlewDecelerationConsumer);
        consumerMap.put("EL_SLEW_VELOCITY", setElSlewVelocityConsumer);
        consumerMap.put("EL_SLEW_ACCELERATION", setElSlewAccelerationConsumer);
        consumerMap.put("EL_SLEW_DECELERATION", setElSlewDecelerationConsumer);
        consumerMap.put("AZ_MIN_ACC", setAzMinAccConsumer);
        consumerMap.put("AZ_MAX_ACC", setAzMaxAccConsumer);
        consumerMap.put("AZ_MIN_VEL", setAzMinVelConsumer);
        consumerMap.put("AZ_MAX_VEL", setAzMaxVelConsumer);
        consumerMap.put("AZ_TEL_MIN_POS", setAzTelMinPosConsumer);
        consumerMap.put("AZ_TEL_MAX_POS", setAzTelMaxPosConsumer);
        consumerMap.put("EL_MIN_ACC", setElMinAccConsumer);
        consumerMap.put("EL_MAX_ACC", setElMaxAccConsumer);
        consumerMap.put("EL_MIN_VEL", setElMinVelConsumer);
        consumerMap.put("EL_MAX_VEL", setElMaxVelConsumer);
        consumerMap.put("EL_TEL_MIN_POS", setElTelMinPosConsumer);
        consumerMap.put("EL_TEL_MAX_POS", setElTelMaxPosConsumer);
        consumerMap.put("AZ_LS_O_CW_POS", setAzLsOpCwConsumer);
        consumerMap.put("AZ_LS_O_CCW_POS", setAzLsOpCcwConsumer);
        consumerMap.put("EL_LS_O_LOW_POS", setElLsOpLowConsumer);
        consumerMap.put("EL_LS_O_HIGH_POS", setElLsOpHighConsumer);
        consumerMap.put("OBSERVER_LAT", setObserverLatConsumer);
        consumerMap.put("OBSERVER_LONG", setObserverLongConsumer);
        consumerMap.put("OBSERVER_HE", setObserverHeightConsumer);
        consumerMap.put("AZIMUTH_PARK_POSITION", setAzParkingPositionConsumer);
        consumerMap.put("ELEVATION_PARK_POSITION", setElParkingPositionConsumer);
        
        consumerMap.put("DOME_POSITION", setCupolaTargetPositionConsumer);


        //consumerMap.put("AZ_LS_E_CW_POS", setAzLsEmCwConsumer);
        //consumerMap.put("AZ_LS_E_CCW_POS", setAzLsEmCcwConsumer);
        //consumerMap.put("EL_LS_E_LOW_POS", setElLsEmLowConsumer);
        //consumerMap.put("EL_LS_E_HIGH_POS", setElLsEmHighConsumer);





        consumerMap.put("GO_LOADED",cmdGoLoadedConsumer);
        consumerMap.put("GO_STANDBY",cmdGoStandbyConsumer);
        consumerMap.put("GO_ONLINE",cmdGoOnlineConsumer);
        consumerMap.put("GO_MAINTENANCE",cmdGoMaintenanceConsumer);
        consumerMap.put("ENABLE_AZ_MOTORS",cmdEnableAzMotorsConsumer);
        consumerMap.put("DISABLE_AZ_MOTORS",cmdDisableAzMotorsConsumer);
        consumerMap.put("ENABLE_EL_MOTOR",cmdEnableElMotorsConsumer);
        consumerMap.put("DISABLE_EL_MOTOR",cmdDisableElMotorsConsumer);
        consumerMap.put("START_MOTION",cmdStartMotionConsumer);
        consumerMap.put("STOP_MOTION",cmdStopMotionConsumer);
        consumerMap.put("START_AZ_MOTION",cmdStartAzMotionConsumer);
        consumerMap.put("STOP_AZ_MOTION",cmdStopAzMotionConsumer);
        consumerMap.put("START_EL_MOTION",cmdStartElMotionConsumer);
        consumerMap.put("STOP_EL_MOTION",cmdStopElMotionConsumer);
        consumerMap.put("EMERGENCY_STOP",cmdEmergencyStopConsumer);
        consumerMap.put("START_AZ_PARKING",cmdStartAzParkingConsumer);
        consumerMap.put("STOP_AZ_PARKING",cmdStopAzParkingConsumer);
        consumerMap.put("START_EL_PARKING",cmdStartElParkingConsumer);
        consumerMap.put("STOP_EL_PARKING",cmdStopElParkingConsumer);
        consumerMap.put("START_PARKING",cmdStartParkingConsumer);
        consumerMap.put("STOP_PARKING",cmdStopParkingConsumer);
        consumerMap.put("START_TRACKING",cmdStartTrackingConsumer);
        consumerMap.put("STOP_TRACKING",cmdStopTrackingConsumer);
        consumerMap.put("START_POINTING",cmdStartPointingConsumer);
        consumerMap.put("STOP_POINTING",cmdStopPointingConsumer);

        consumerMap.put("HOME_POS",cmdHomePosConsumer);

        

        // comandi aggiuntivi per la CUPOLA

        
        consumerMap.put("OPEN_DOME",cmdOpenCupolaConsumer);
        consumerMap.put("CLOSE_DOME",cmdCloseCupolaConsumer);
        consumerMap.put("START_POINTING_DOME",cmdStartCupolaPointingConsumer);
        consumerMap.put("START_PARKING_DOME",cmdStartCupolaParkingConsumer);
        consumerMap.put("STOP_DOME",cmdStopCupolaConsumer);
        consumerMap.put("ZERO_DOME",cmdsetZeroCupolaConsumer);
        consumerMap.put("DOME_WEST",cmdCupolaOvestConsumer);
        consumerMap.put("DOME_EAST",cmdCupolaEstConsumer);




    }

    public static Map<String, MonitorNodeImpl> monitorMap;
    static {
        monitorMap = new HashMap<>();
        monitorMap.put("AZ_ACT_VEL", getAzActVelMonitor);
        monitorMap.put("AZ_ACT_ACC", getAzActAccMonitor);
        monitorMap.put("AZ_LS_O_CW", getAzLsOpCwMonitor);
        monitorMap.put("AZ_LS_O_CCW", getAzLsOpCcwMonitor);
        monitorMap.put("EL_LS_O_LOW", getElLsOpLowMonitor);
        monitorMap.put("EL_LS_O_HIGH", getElLsOpHighMonitor);
        monitorMap.put("AZ_MOTORS_STATUS", getAzMotorsStatusMonitor);
        monitorMap.put("EL_MOTOR_STATUS",getElMotorsStatusMonitor);
        monitorMap.put("AZ_TEL_POS", getAzTelPosMonitor);
        monitorMap.put("AZ_ACT_VEL", getAzActVelMonitor);
        monitorMap.put("AZ_ACT_ACC", getAzActAccMonitor);
        monitorMap.put("AZ_COMMANDED_POS", getAzCommandedPosMonitor);
        monitorMap.put("AZ_COMMANDED_VEL", getAzCommandedVelMonitor);
        monitorMap.put("AZ_COMMANDED_ACC", getAzCommandedAccMonitor);
        monitorMap.put("EL_TEL_POS", getElTelPosMonitor);
        monitorMap.put("EL_ACT_VEL", getElActVelMonitor);
        monitorMap.put("EL_ACT_ACC", getElActAccMonitor);
        monitorMap.put("EL_COMMANDED_POS", getElCommandedPosMonitor);
        monitorMap.put("EL_COMMANDED_VEL", getElCommandedVelMonitor);
        monitorMap.put("EL_COMMANDED_ACC", getElCommandedAccMonitor);
        monitorMap.put("MOTION_STATE_AZIMUTH", getAzMotionStateMonitor);
        monitorMap.put("MOTION_STATE_ELEVATION", getElMotionStateMonitor);
        monitorMap.put("MACHINE_STATE", getMachineStateMonitor);
        monitorMap.put("MACHINE_STATE_PHASE", getMachineStatePhaseMonitor);
        monitorMap.put("TCU_MODE", getTCUModeMonitor);
        monitorMap.put("GO_LOADED_INFO", getGoLoadedInfoMonitor);
        monitorMap.put("GO_STANDBY_INFO", getGoStandbyInfoMonitor);
        monitorMap.put("GO_ONLINE_INFO", getGoOnlineInfoMonitor);
        monitorMap.put("GO_MAINTENANCE_INFO", getGoMaintenanceInfoMonitor);
        monitorMap.put("ENABLE_AZ_MOTORS_INFO", getAzEnableMotorsInfoMonitor);
        monitorMap.put("DISABLE_AZ_MOTORS_INFO", getAzDisableMotorsInfoMonitor);
        monitorMap.put("ENABLE_EL_MOTOR_INFO", getElEnableMotorsInfoMonitor);
        monitorMap.put("DISABLE_EL_MOTOR_INFO", getElDisableMotorsInfoMonitor);
        monitorMap.put("START_MOTION_INFO", getStartMotionInfoMonitor);
        monitorMap.put("STOP_MOTION_INFO", getStopMotionInfoMonitor);
        monitorMap.put("START_AZ_MOTION_INFO", getAzStartMotionInfoMonitor);
        monitorMap.put("STOP_AZ_MOTION_INFO", getAzStopMotionInfoMonitor);
        monitorMap.put("START_EL_MOTION_INFO", getElStartMotionInfoMonitor);
        monitorMap.put("STOP_EL_MOTION_INFO", getElStopMotionInfoMonitor);
        monitorMap.put("EMERGENCY_STOP_INFO", getEmergencyStopInfoMonitor);
        monitorMap.put("ZERO_DOME_INFO", getZeroDomeInfoMonitor);
        monitorMap.put("OPEN_DOME_INFO", getOpenDomeInfoMonitor);
        monitorMap.put("CLOSE_DOME_INFO", getCloseDomeInfoMonitor);
        monitorMap.put("START_POINTING_DOME_INFO", getStartPointingDomeInfoMonitor);
        monitorMap.put("START_PARKING_DOME_INFO", getStartParkingDomeInfoMonitor);
        monitorMap.put("STOP_DOME_INFO", getStopDomeInfoMonitor);
        monitorMap.put("DOME_WEST_INFO", getDomeWestInfoMonitor);
        monitorMap.put("DOME_EAST_INFO", getDomeEastInfoMonitor);
        monitorMap.put("HOME_POS_INFO", getHomePosInfoMonitor);

        monitorMap.put("ERROR_NUMBER", getErrorNumberMonitor);
        monitorMap.put("ERROR_BUFFER", getErrorBufferMonitor);
        monitorMap.put("ERROR_BUFFER_OUT_OF_RANGE", getErrorBufferOutOfRangeMonitor);
        monitorMap.put("ERROR_BUFFER_SIZE", getErrorBufferSizeMonitor);
        monitorMap.put("HEARTBEAT", getHeartBeatMonitor);
        monitorMap.put("DOME_POS", getCupolaPositionMonitor);

    }
    

    /*public TCS getTcs() {
        return tcs;
    }*/



    public Map<String, Consumer<DataValue>> getConsumerMap() {
        return consumerMap;
    }


    
}
