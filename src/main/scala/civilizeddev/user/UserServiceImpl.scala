package civilizeddev.user

import scala.concurrent.ExecutionContext
import scala.concurrent.Future

class UserServiceImpl()(implicit
    executionContext: ExecutionContext
) extends UserService {

  override def findAll(query: UserQuery): Future[Seq[User]] = Future {
    Seq.empty
  }

  override def findOne(id: String): Future[Option[User]] = Future {
    None
  }

  override def create(entity: User): Future[User] = Future {
    ???
  }

  override def update(id: String, entity: User): Future[User] = Future {
    entity
  }

  override def remove(id: String): Future[Unit] = Future {
    ()
  }
}
