name := """akkademy-db"""

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  // Uncomment to use Akka
  "com.typesafe.akka" %% "akka-actor" % "2.3.9",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.6" % "test",
  "junit"             % "junit"           % "4.12"  % "test",
  "com.novocode"      % "junit-interface" % "0.11"  % "test"
)


fork in run := true