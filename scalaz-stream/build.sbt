name                := "scalaz-stream-csv"

resolvers           += "Scalaz Bintray Repo" at "https://dl.bintray.com/scalaz/releases"

libraryDependencies += "org.scalaz.stream" %% "scalaz-stream" % "0.7.3"

libraryDependencies += "org.scalatest"        %% "scalatest"  % "2.2.5"  % "test"

libraryDependencies += "org.scalacheck"       %% "scalacheck" % "1.12.5" % "test"
