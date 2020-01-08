package orion.transfer.core;

import orion.transfer.core.util.FtpUtil;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("迅雷就是个鸡掰！");
        String url = "ftp://ygdy8:ygdy8@yg39.dydytt.net:3004/阳光电影www.ygdy8.com.哆啦A梦：大雄的月球探险记.BD.1080p.国粤日三语中字.mkv";
        FtpUtil.download(url);
    }
}
