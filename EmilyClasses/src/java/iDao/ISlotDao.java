
package iDao;

import bookingclass.entity.Slot;
import java.sql.ResultSet;
import java.util.Date;

public interface ISlotDao {
    public boolean insertNewSlot (Slot s);
    public ResultSet selectSlotJoinClasses(Date d);
    public Slot getSlot(int slotId);
}
