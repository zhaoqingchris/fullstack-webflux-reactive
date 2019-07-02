import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

class BootLoadSimulation extends Simulation {
  private val httpConf = http
    .baseURL("http://localhost:8081")
    .acceptHeader(" application/json")

  private val scn: ScenarioBuilder = scenario("Initial Scenario")
    .exec(http("Get all reactive ports")
      .get("/ports"))

  setUp(
    scn.inject(atOnceUsers(1000))
  ).protocols(httpConf)

}