package controllers

import javax.inject.Inject
import play.api.mvc._
import tables.UserModel

import scala.concurrent.ExecutionContext

class HomeController @Inject()(userModel: UserModel)(implicit ex: ExecutionContext) extends ApplicationController {

  def index = Action.async { implicit request =>

    currentLoginUser(request.session, userModel).map { user =>
      Ok(views.html.home.index(user))
    }

  }
}
