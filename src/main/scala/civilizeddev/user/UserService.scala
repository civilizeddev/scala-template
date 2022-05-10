package civilizeddev.user

import civilizeddev.CrudService
import scala.concurrent.Future

trait UserService extends CrudService[Future, User, String, UserQuery] {}
