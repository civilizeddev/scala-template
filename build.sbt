ThisBuild / organization      := "civilizeddev.github.io"
ThisBuild / organizationName  := "David Lee"
ThisBuild / scalaVersion      := "2.13.8"
ThisBuild / scalafixOnCompile := true
ThisBuild / javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

ThisBuild / dockerRepository := Some("ghcr.io/civilizeddev")
ThisBuild / publishTo        := Some("github-maven".at("https://maven.pkg.github.com/civilizeddev/scala-template"))

name             := "scala-template"
Docker / version := "latest"

libraryDependencies += "ch.qos.logback"               % "logback-classic"         % "1.2.11"
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-core"              % "1.0.0-M9"
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-json-circe"        % "1.0.0-M9"
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-akka-http-server"  % "1.0.0-M9"
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-swagger-ui-bundle" % "1.0.0-M9"
libraryDependencies += "com.softwaremill.macwire"    %% "macros"                  % "2.5.7"    % Provided
libraryDependencies += "com.softwaremill.macwire"    %% "util"                    % "2.5.7"
libraryDependencies += "com.softwaremill.macwire"    %% "proxy"                   % "2.5.7"
libraryDependencies += "org.scalameta"               %% "munit"                   % "1.0.0-M1" % Test

enablePlugins(GitVersioning, JavaServerAppPackaging, DockerPlugin)
dockerExposedPorts := Seq(9000)

dockerLabels ++= Map("org.opencontainers.image.source" -> "https://github.com/civilizeddev/scala-template")
