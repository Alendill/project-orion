package orion.transfer.core.util;

import org.apache.commons.lang3.StringUtils;
import orion.transfer.core.exception.DownloadLinkException;
import orion.transfer.core.info.DownloadLinkInfo;
import orion.transfer.core.info.FtpLinkInfo;

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

    private DownloadLinkInfo protocolSeparate(String url) throws DownloadLinkException {
        if (StringUtils.isEmpty(url)) {
            throw new DownloadLinkException("Download url can not be null/empty!");
        }
        DownloadLinkInfo downloadLinkInfo = null;
        switch (url.split("://")[0]) {
            case PREFIX_FTP:
                downloadLinkInfo = parseFtp(url);
                break;
            case PREFIX_HTTP:

        }
        return downloadLinkInfo;
    }


    /**
     * 从ftp开头的url中解析组装成FtpLinkInfo
     *
     * @param url url
     * @return FtpLinkInfo
     */
    private FtpLinkInfo parseFtp(String url) {
        if (true) {


        }
        return new FtpLinkInfo();
    }

}
