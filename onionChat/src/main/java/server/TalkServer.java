package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import lombok.extern.log4j.Log4j2;
import server.thread.TalkServerThread;

@Log4j2
@SuppressWarnings( "serial" )
public class TalkServer extends JFrame implements Runnable {
    
    public List<TalkServerThread> userList = null;
    
    ServerSocket serverSocket;
    Socket       socket;
    
    public JTextArea   jta_log = new JTextArea( 10, 30 );
    public JScrollPane jsp_log = new JScrollPane( jta_log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
    
    public void initDisplay() {
        this.add( "Center", jsp_log );
        this.setSize( 500, 400 );
        this.setVisible( true );
    }
    
    @Override
    public void run() {
        int port = 20000;
        
        userList = new Vector<>();
        
        try {
            serverSocket = new ServerSocket( port );
            jta_log.append( "Server Ready.........\n" );
            
            while ( true ) {
                
                log.info( "서버 대기중... {}", serverSocket.getLocalSocketAddress() );
                
                socket = serverSocket.accept();// 클라이언트 시그널 대기
                log.info( "클라이언트 접속... {}", socket.getRemoteSocketAddress() );
                
                // TalkServerThread 클래스로 client 연결정보 넘겨주기
                TalkServerThread tst = new TalkServerThread( socket, this );
                tst.start();
            }
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }
    
    public static void main( String[] args ) {
        TalkServer ts = new TalkServer();
        ts.initDisplay();
        
        Thread thread = new Thread( ts );
        thread.start();
    }
    
}
