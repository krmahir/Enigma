package web;

public class Server {
    
}
package Web;
import com.sun.net.httpserver.*;
import Machine.Enigma;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.io.*;
public class Server {
 static String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 static String param(String q,String key){for(String part:q.split("&")){String[] p=part.split("=",2);if(p.length>0&&p[0].equals(key))return URLDecoder.decode(p.length>1?p[1]:"",StandardCharsets.UTF_8);}return "";}
 static void send(HttpExchange x,int code,String body,String type)throws IOException{byte[] b=body.getBytes(StandardCharsets.UTF_8);x.getResponseHeaders().set("Content-Type",type+"; charset=utf-8");x.getResponseHeaders().set("X-Content-Type-Options","nosniff");x.sendResponseHeaders(code,b.length);try(OutputStream o=x.getResponseBody()){o.write(b);}}
 static String json(String s){return "\""+s.replace("\\","\\\\").replace("\"","\\\"").replace("\n","\\n").replace("\r","\\r")+"\"";}
 static int pos(String s){int n=Integer.parseInt(s);if(n<1||n>26)throw new IllegalArgumentException("Positions must be between 1 and 26");return n;}
 public static void main(String[] args)throws Exception{
  int port=Integer.parseInt(System.getenv().getOrDefault("PORT","8080"));HttpServer server=HttpServer.create(new InetSocketAddress("0.0.0.0",port),0);
  server.createContext("/api/encrypt",x->{if(!x.getRequestMethod().equals("POST")){send(x,405,"{\"error\":\"POST required\"}","application/json");return;}
   try{byte[] bytes=x.getRequestBody().readNBytes(10001);if(bytes.length>10000)throw new IllegalArgumentException("Request too long");String q=new String(bytes,StandardCharsets.UTF_8);
    String message=param(q,"message");if(message.length()>4000)throw new IllegalArgumentException("Message too long (max 4000 characters)");
    String[] cfg={param(q,"reflector"),param(q,"r1"),param(q,"r2"),param(q,"r3"),param(q,"p1"),param(q,"p2"),param(q,"p3")};
    if(!Arrays.asList("A Reflector","B Reflector").contains(cfg[0]))throw new IllegalArgumentException("Invalid reflector");
    for(int i=1;i<=3;i++)if(!Arrays.asList("I","II","III","IV","V").contains(cfg[i]))throw new IllegalArgumentException("Invalid rotor");
    for(int i=4;i<=6;i++)pos(cfg[i]);
    String mapping=param(q,"mapping").toUpperCase(Locale.ROOT);if(!mapping.matches("[A-Z]{26}")||mapping.chars().distinct().count()!=26)throw new IllegalArgumentException("Plugboard must contain each A-Z letter exactly once");
    String result; synchronized(Enigma.class){result=new Enigma().Enigma(message,cfg,mapping,alphabet);}
    send(x,200,"{\"result\":"+json(result)+"}","application/json");
   }catch(Exception e){send(x,400,"{\"error\":"+json(e.getMessage()==null?"Invalid input":e.getMessage())+"}","application/json");}
  });
  server.createContext("/",x->{String path=x.getRequestURI().getPath();if(!path.equals("/")){send(x,404,"Not found","text/plain");return;}send(x,200,Files.readString(Path.of("web/index.html")),"text/html");});
  server.start();System.out.println("Enigma web app listening on port "+port);
 }
}
