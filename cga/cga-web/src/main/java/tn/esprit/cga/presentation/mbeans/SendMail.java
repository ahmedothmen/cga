package tn.esprit.cga.presentation.mbeans;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@ManagedBean
@RequestScoped
public class SendMail {
	
	
	public void send(){
        final String username = "ahmed.ben.othmenne@gmail.com";
		final String password = "123abz123";
                Properties props = new Properties();  
         props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");
         props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
         
         Session session = Session.getInstance(props,
	  new javax.mail.Authenticator() {
                 @Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	  });
         
         Message message = new MimeMessage(session);
         
try {
 message.setFrom(new InternetAddress("ahmed.ben.othmenne@gmail.com"));
 message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse("ahmed.ben.othmenne@gmail.com"));
 
 
 message.setSubject("From SGA");
 
 message.setText("Der sr we found that you without contarct and wi suggest many type of policy " );

		Transport.send(message);

		System.out.println("Done");
 
 
 
} catch (MessagingException ex) {
 Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
}
         
         
         }

public void sendSmS (){
	
    String myURL="https://rest.nexmo.com/sms/json?api_key=5cda4d36&api_secret=975ddd6c0d079a0d&to=216"+
            "50866087"+"&from=BeMyGuest&text=Vous+avez+recu+une+demande+de+reservation+Code+du+message+:+"+1523;
    System.out.println(myURL);
    StringBuilder sb = new StringBuilder();
    URLConnection urlConn = null;
    InputStreamReader in = null;
    try {
        URL url = new URL(myURL);
        urlConn = url.openConnection();
        if (urlConn != null)
            urlConn.setReadTimeout(60 * 1000);
        if (urlConn != null && urlConn.getInputStream() != null) {
            in = new InputStreamReader(urlConn.getInputStream(),
                    Charset.defaultCharset());
            BufferedReader bufferedReader = new BufferedReader(in);
            if (bufferedReader != null) {
                int cp;
                while ((cp = bufferedReader.read()) != -1) {
                    sb.append((char) cp);
                }
                bufferedReader.close();
            }
        }
        in.close();
    } catch (Exception e) {
        throw new RuntimeException("Exception while calling URL:"+ myURL, e);
    }
	
	
}



}
