package orion.transfer.core.common;

import org.apache.commons.lang3.StringUtils;
import orion.transfer.core.exception.DownloadLinkException;
import orion.transfer.core.info.DownloadLinkInfo;
import orion.transfer.core.info.FtpLinkInfo;
import orion.transfer.core.info.HttpLinkInfo;

public class DownloadLinkParser {
    private static final String PREFIX_FTP = "ftp";
    private static final String PREFIX_HTTP = "http";
    private static final String PREFIX_THUNDER = "thunder";
    private static final String PREFIX_TORRENT = "torrent";
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

    /**
     * 获取协议信息
     *
     * @param url 要解析的下载路径
     * @return 下载信息
     * @throws DownloadLinkException 异常
     */
    public DownloadLinkInfo getProtocolInfo(String url) throws DownloadLinkException {
        if (StringUtils.isEmpty(url)) {
            throw new DownloadLinkException("Download url can not be null/empty!");
        }
        String[] split = url.split("://");
        DownloadLinkInfo result = null;
        switch (split[0]) {
            case PREFIX_FTP:
                result = parseFtp(split[1]); //TODO 一个ftp都搞不定，玩毛线？
                break;
            case PREFIX_HTTP:
                result = parseHttp(split[1]);
                break;
            case PREFIX_THUNDER:
                break;
            default:
                result = new DownloadLinkInfo();
                break;
        }
        return result;
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

    //TODO 还没写呢
    private HttpLinkInfo parseHttp(String arg) {
        return new HttpLinkInfo();
    }

    private void mkUser(FtpLinkInfo ftpLinkInfo, String[] userInfo) {
        ftpLinkInfo.setUsername(userInfo[0]);
        ftpLinkInfo.setPassword(userInfo[1]);
    }

    private void mkUri(FtpLinkInfo ftpLinkInfo, String[] userInfo) {
        ftpLinkInfo.setHost(userInfo[0]);
        ftpLinkInfo.setPort(Integer.parseInt(userInfo[1]));
    }
}
