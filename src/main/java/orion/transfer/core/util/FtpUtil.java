package orion.transfer.core.util;

import org.apache.commons.net.ftp.FTPClient;
import orion.transfer.core.info.FtpLinkInfo;

import java.io.IOException;

public class FtpUtil {
    public static void download(FtpLinkInfo info) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(info.getHost(), info.getPort()); //TODO 连不上!!
            ftpClient.login(info.getUsername(), info.getPassword());
            System.out.println(ftpClient.isConnected());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
