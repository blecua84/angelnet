package es.uah.cc.ie.harvestedsnsangelguard;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class Main {

    static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier() {
            public boolean verify(String hostname,
                    javax.net.ssl.SSLSession sslSession) {
                if (hostname.equals("localhost")) {
                    return true;
                }
                return false;
            }
        });
    }
    
    public static void main(String[] args) throws MalformedURLException {
        try {
            if ((args.length < 3) || (args.length > 3)) {
                System.out.println("Los par?metros introducidos no son correctos");
            } else {
                String contextApp = args[0];
                String pathSSL = args[1];
                String passSSL = args[2];

                String servletRequest = contextApp + "SNSAngelGuardFB/harvestedSNS";

                InputStream fileCertificadosConfianza = new FileInputStream(new File(pathSSL));
                KeyStore ksCertificadosConfianza = KeyStore.getInstance(KeyStore
                        .getDefaultType());
                ksCertificadosConfianza.load(fileCertificadosConfianza, passSSL.toCharArray());
                fileCertificadosConfianza.close();

                // Ponemos el contenido en nuestro manager de certificados de
                // confianza.
                TrustManagerFactory tmf = TrustManagerFactory
                        .getInstance(TrustManagerFactory.getDefaultAlgorithm());
                tmf.init(ksCertificadosConfianza);

                // Creamos un contexto SSL con nuestro manager de certificados en los
                // que confiamos.
                SSLContext context = SSLContext.getInstance("TLS");
                context.init(null, tmf.getTrustManagers(), null);
                SSLSocketFactory sslSocketFactory = context.getSocketFactory();

                // Ya podemos conectar

                URL servlet = new URL(servletRequest);
                URLConnection servletConn = servlet.openConnection();
                ((HttpsURLConnection) servletConn).setSSLSocketFactory(sslSocketFactory);
                servletConn.setDoInput(true);
                servletConn.setDoOutput(true);
                servletConn.getExpiration();
            }
        } catch (KeyStoreException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CertificateException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
