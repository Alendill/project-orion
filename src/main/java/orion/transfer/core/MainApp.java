package orion.transfer.core;

import orion.transfer.core.common.DownloadLinkParser;
import orion.transfer.core.exception.DownloadLinkException;
import orion.transfer.core.info.DownloadLinkInfo;
import orion.transfer.core.util.FtpUtil;

public class MainApp {
    public static void main(String[] args) throws DownloadLinkException {
        System.out.println("迅雷就是个鸡掰！");
        String url = "ftp://ygdy8:ygdy8@yg39.dydytt.net:3004/阳光电影www.ygdy8.com.哆啦A梦：大雄的月球探险记.BD.1080p.国粤日三语中字.mkv";
//        FtpUtil.download(url);

        DownloadLinkParser instance = DownloadLinkParser.getInstance();
        DownloadLinkInfo downloadLinkInfo = instance.protocolSeparate(url);
        System.out.println(downloadLinkInfo.toString());
    }
}
