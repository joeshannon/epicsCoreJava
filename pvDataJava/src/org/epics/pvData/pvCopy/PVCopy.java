/**
 * Copyright - See the COPYRIGHT that is included with this distribution.
 * EPICS pvData is distributed subject to a Software License Agreement found
 * in file LICENSE that is included with this distribution.
 */
package org.epics.pvData.pvCopy;
import org.epics.pvData.pv.*;


/**
 * @author mrk
 *
 */
public interface PVCopy {
    PVRecord getPVRecord();
    Structure getStructure();
    PVStructure createPVStructure();
    int getOffset(PVField recordPVField);
    int getOffset(PVStructure recordPVStructure,PVField recordPVField);
    PVField getPVField(int offset);
}
