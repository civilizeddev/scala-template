package civilizeddev.machine

import civilizeddev.CrudService
import scala.concurrent.Future

trait MachineService extends CrudService[Future, Machine, String, MachineQuery] {}
