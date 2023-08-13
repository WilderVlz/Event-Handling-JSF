package beans.lifecycle;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.apache.logging.log4j.*;

/*para que pueda funcionar como un listener de jsf debe 
de implementar la interface PhaseListener */
public class DebuggerListener implements PhaseListener {

    private Logger log = LogManager.getRootLogger();
    
    @Override
    public void beforePhase(PhaseEvent pe) {
        if(log.isInfoEnabled())
            log.info("Antes de la fase: " + pe.getPhaseId().toString());
        
    }

    @Override
    public void afterPhase(PhaseEvent pe) {
        if(log.isInfoEnabled())
            log.info("Despues de la fase: " + pe.getPhaseId().toString());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}
