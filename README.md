# `wto.lib` - library for working with API of the WildTanksOnline game

Official group of the game in VK - https://vk.com/wild_tanks_online_official_group

Official group of the WTOmod in VK - https://vk.com/wildtanksmod

How use?

`git clone https://github.com/timursergeevichname/wto.lib.git`

`cd wto.lib/`

`mvn clean compile assembly:single`

`java -jar target/wto.lib-1.0-jar-with-dependencies.jar YouLogin YouPassword TimeSleep`

example:

`java -jar target/wto.lib-1.0-jar-with-dependencies.jar testlogin testpassword 60`