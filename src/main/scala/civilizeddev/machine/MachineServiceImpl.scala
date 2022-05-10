package civilizeddev.machine

import scala.concurrent.ExecutionContext
import scala.concurrent.Future

class MachineServiceImpl()(implicit
    executionContext: ExecutionContext
) extends MachineService {

  override def findAll(query: MachineQuery): Future[Seq[Machine]] = Future {
    Seq.empty
  }

  override def findOne(id: String): Future[Option[Machine]] = Future {
    None
  }

  override def create(entity: Machine): Future[Machine] = Future {
    ???
  }

  override def update(id: String, entity: Machine): Future[Machine] = Future {
    entity
  }

  override def remove(id: String): Future[Unit] = Future {
    ()
  }
}
