Java Spring Demo.

You should modify the db source in <a href="src/main/java/tw/com/demo/config/APConfig.java" >this.</a>

And you should do something follow below

On Eclipse :
    
1. Right-click on this project.
2. Choice "Run as", then choice "Maven install". 
3. Ok. Let's start your Tomcat server or others and add this project.
    

When you try to connect to Oracle db, have some exception like:

    javax.servlet.ServletException: Servlet.init() for servlet dispatcherServlet threw exception
    	org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
    	org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
    	org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
    	org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:445)
    	org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
    	org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
    	org.apache.tomcat.util.net.JIoEndpoint$SocketProcessor.run(JIoEndpoint.java:316)
    	java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
    	java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
    	org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
    	java.lang.Thread.run(Thread.java:748)
    	
please check your db status on open.

p.s You don't create tables by yourself.