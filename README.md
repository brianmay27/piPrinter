# piPrinter
Web client that allows remote upload and 3d printing from a rasp pi
<b>This is pretty bad on the first gen pi's, recomend using a pi 2

##About
This project is a combination of [replicatorG](http://replicat.org/), an open source project that is used to provide users with a graphical
interface to print 3d objects from on many different 3d printers. [Aura](https://github.com/forcedotcom/aura),
an open source framework that allows client-server web based services. [Apache Shiro](http://shiro.apache.org/) which
may be overkill but provides me with authentication and authority service. Finally some glue to hold them all together.

##Details
I have stripped down replicatorG to mostly just the code to provide a java API. This allows me to treat it as a service
and provide the Aura's java component controllers the bean. I have than created a basic Aura app that currently allows
a user to upload a gcode file and an admin (currently the user is an admin) to see the files uploaded and begin printing.
 Curently, the system is setup to a FlashForge creator pro but can be any machine that replicatorG can print to.

##HowTo
Until I can figure out how to add this to the build, getting librxtx is required by replicatorG so:
<pre><code>sudo apt-get install librxtx-java</code></pre>
Will get the needed java library.
This project is fully maven (Thank Aura-Note for the backbone. So after cloning, simply:
<pre><code>mvn compile</code></pre>
to compile and download all the necessary maven dependencies. And:
<pre><code>mvn jetty:run</code></pre>
to startup the server which runs on port 8080. The default username and password can be located in src/main/webapp/WEB-INF/shiro.ini

To debug use:
<pre><code>export MAVEN_OPTS="-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=4000,server=y,suspend=n"</code></pre>
