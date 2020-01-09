package orion.transfer.core.common;

import org.apache.commons.lang3.StringUtils;
import orion.transfer.core.exception.DownloadLinkException;
import orion.transfer.core.info.FtpLinkInfo;
import orion.transfer.core.info.HttpLinkInfo;

public class DownloadLinkParser {
    private static final String PREFIX_FTP = "ftp";
    private static final String PREFIX_HTTP = "http";
    private static DownloadLinkParser instance;

    private DownloadLinkParser() {
    }

    /**
     * 双重锁的单例
     *
     * @return DownloadLinkParser
     */
    public static DownloadLinkParser getInstance() {
        if (null == instance) {
            synchronized (DownloadLinkParser.class) {
                if (null == instance) {
                    instance = new DownloadLinkParser();
                }
            }
        }
        return instance;
    }

    public Object protocolSeparate(String url) throws DownloadLinkException {
        if (StringUtils.isEmpty(url)) {
            throw new DownloadLinkException("Download url can not be null/empty!");
        }
        String[] split = url.split("://");
        switch (split[0]) {
            case PREFIX_FTP:
                return parseFtp(split[1]); //TODO 这里设计有问题
            case PREFIX_HTTP:
                return parseHttp(split[1]);
        }
        return new Object();
    }


    /**
     * 从ftp开头的url中解析组装成FtpLinkInfo
     *
     * @param arg url
     * @return FtpLinkInfo
     */
    private FtpLinkInfo parseFtp(String arg) {
        FtpLinkInfo info = new FtpLinkInfo();
        String[] split = arg.split("@");
        mkUser(info, split[0].split(":"));
        mkUri(info, split[1].substring(0, split[1].indexOf("/")).split(":"));
        info.setProtocol(PREFIX_FTP);
        return info;
    }

    private void mkUser(FtpLinkInfo ftpLinkInfo, String[] userInfo) {
        ftpLinkInfo.setUsername(userInfo[0]);
        ftpLinkInfo.setPassword(userInfo[1]);
    }

    private void mkUri(FtpLinkInfo ftpLinkInfo, String[] userInfo) {
        ftpLinkInfo.setHost(userInfo[0]);
        ftpLinkInfo.setPort(Integer.parseInt(userInfo[1]));
    }

    //TODO 还没写呢
    private HttpLinkInfo parseHttp(String arg) {
        return new HttpLinkInfo();
    }

}
