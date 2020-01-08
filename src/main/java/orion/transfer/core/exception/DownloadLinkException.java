package orion.transfer.core.exception;

public class DownloadLinkException extends Exception {
    public DownloadLinkException() {
        super();
    }

    public DownloadLinkException(String message) {
        super(message);
    }

    public DownloadLinkException(String message, Throwable cause) {
        super(message, cause);
    }

    public DownloadLinkException(Throwable cause) {
        super(cause);
    }

    protected DownloadLinkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
