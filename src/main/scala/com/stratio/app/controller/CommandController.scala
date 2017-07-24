package com.stratio.app.controller

import com.stratio.app.response.Hello
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RequestParam, RestController}

@RestController
class CommandController {
  @RequestMapping(value=Array("/hello"), method=Array(RequestMethod.GET))
  def getAllAppointmets(@RequestParam(value="id", defaultValue="world!") id: String): Hello = Hello(id)
}
