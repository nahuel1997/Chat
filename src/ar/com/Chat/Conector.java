package ar.com.Chat;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Conector {

    private Socket  s ;
    private ServerSocket ss ;
    private InputStreamReader entradaSocket;
    private BufferedReader entrada;
    private DataOutputStream salida ;
    final int puerto = 4314;
    
    public Conector(){
        
        try{
            ss= new ServerSocket(puerto);
            s = ss.accept();
            
            entradaSocket= new InputStreamReader(s.getInputStream());
            entrada = new BufferedReader (entradaSocket); 
            salida= new DataOutputStream(s.getOutputStream());
            
        }catch(Exception e){
            
        }
              
        
    }
    public Conector(String ip){
        try{
            s= new Socket(ip,this.puerto);
            
            
            entradaSocket= new InputStreamReader(s.getInputStream());
            entrada = new BufferedReader (entradaSocket); 
            salida= new DataOutputStream(s.getOutputStream());
            
        }catch(Exception e){
            
        }
    }
    public void enviarMSG(String msg){
        try{
            salida.writeUTF(msg);
        }catch(Exception e){
            
        }
    }
    public String leerMsg(){
        
        try{
            return entrada.readLine();
        }catch(IOException e){};
        return null;
    }
    public void Desconectar(){
        try{
            s.close();
        }catch(Exception e){};
    }
}
