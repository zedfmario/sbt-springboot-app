import com.typesafe.sbt.packager.archetypes.JavaAppPackaging
import sbt._
import com.typesafe.sbt.packager.Keys._
import com.typesafe.sbt.packager.docker.DockerPlugin.autoImport.Docker

object DefaultSettings extends Dependencies {}

object DockerSettings extends Dependencies {

  val username        = "zedfmariostratio"
  val repository      = "index.docker.io"
  val maintainerName  = "Mario Fernández <mariofernandez@stratio.com>"
  val summary         = "A small SpringBoot app for testing purposes"
  val description     = "Docker micro service [testing purposes]"
  val name            = "springboot-docker-app"
  val ports: Seq[Int] = Seq(9000)

  override val enabledPlugins  = Seq(JavaAppPackaging)

  override def moduleSettings: Seq[SettingsDefinition] = super.moduleSettings ++ Seq(
    maintainer in Docker         := DockerSettings.maintainerName,
    packageSummary in Docker     := DockerSettings.summary,
    packageDescription in Docker := DockerSettings.description,
    packageName in Docker        := DockerSettings.name,
    dockerExposedPorts           := DockerSettings.ports,
    dockerUsername               := Some(DockerSettings.username),
    dockerRepository             := Some(DockerSettings.repository)
  )
}

object SpringBootSettings extends Dependencies {
  override val mainDeps = Seq(Dependencies.springBoot, Dependencies.springBootStarterWeb) ++ DefaultSettings.mainDeps
  override val testDeps = Seq(Dependencies.springBootStarterTest, Dependencies.jaywayJsonPath) ++ DefaultSettings.testDeps
}