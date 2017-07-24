import sbt._
import sbt.Keys._

object Dependencies {
  val name         = "sbt-docker-container"
  val organizacion = "com.stratio"
  val scalaVersion = "2.11.11"
  val version      = "0.1.0-SNAPSHOT"
  val resolvers    = Seq.empty[Resolver]
  val crossPaths   = false

  /* SpringBoot stuff */
  lazy val springBoot: ModuleID             = "org.springframework.boot" % "spring-boot" % "1.5.4.RELEASE"
  lazy val springBootStarterWeb: ModuleID   = "org.springframework.boot" % "spring-boot-starter-web" % "1.5.4.RELEASE"

  /* SpringBoot test stuff */
  lazy val springBootStarterTest: ModuleID  = "org.springframework.boot" % "spring-boot-starter-test" % "1.5.4.RELEASE"
  lazy val jaywayJsonPath: ModuleID         = "com.jayway.jsonpath" % "json-path" % "2.4.0"

  /* Postgresql */
  lazy val postgresJDBC: ModuleID           = "org.postgresql" % "postgresql" % "42.1.3"

}

trait Dependencies {
  val currentScalaVersion = Dependencies.scalaVersion
  val currentVersion      = Dependencies.version
  val commonResolvers     = Dependencies.resolvers
  val mainDeps            = Seq.empty[ModuleID]
  val testDeps            = Seq.empty[ModuleID]
  val enabledPlugins      = Seq.empty[AutoPlugin]
  val disabledPlugins     = Seq.empty[AutoPlugin]

  def moduleSettings: Seq[SettingsDefinition] = Seq(
    organization in ThisBuild := Dependencies.organizacion,
    version in ThisBuild      := currentVersion,
    scalaVersion in ThisBuild := currentScalaVersion,
    crossPaths in ThisBuild   := Dependencies.crossPaths,
    resolvers                 := commonResolvers,
    libraryDependencies       ++= mainDeps,
    libraryDependencies       ++= testDeps map (_  % "test")
  )
}