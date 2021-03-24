package chainofresponsibility;

import java.util.HashMap;

/**
 * @Author: chy
 * @Date: 2021/1/21 13:26
 * @Description:
 */
public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        Request request = new Request.RequestBuilder().loggedOn(true).frequentOk(true).build();
        Handler handler = new RequestFrequentHandler(new LoggedOnHandler(null));
        System.out.println(handler.process(request));
    }
}

class Request {
    private boolean loggedOn;
    private boolean frequentOk;
    private boolean isPermits;
    private boolean containsSensitiveWords;
    private String requestBody;

    public Request(boolean loggedOn, boolean frequentOk, boolean isPermits, boolean containsSensitiveWords) {
        this.loggedOn = loggedOn;
        this.frequentOk = frequentOk;
        this.isPermits = isPermits;
        this.containsSensitiveWords = containsSensitiveWords;
    }

    static class RequestBuilder {
        private boolean loggedOn;
        private boolean frequentOk;
        private boolean isPermits;
        private boolean containsSensitiveWords;

        RequestBuilder loggedOn(boolean loggedOn) {
            this.loggedOn = loggedOn;
            return this;
        }
        RequestBuilder frequentOk(boolean frequentOk) {
            this.frequentOk = frequentOk;
            return this;
        }
        RequestBuilder isPermits(boolean isPermits) {
            this.isPermits = isPermits;
            return this;
        }
        RequestBuilder containsSensitiveWords(boolean containsSensitiveWords) {
            this.containsSensitiveWords = containsSensitiveWords;
            return this;
        }
        public Request build() {
            Request request = new Request(this.loggedOn, this.frequentOk, this.isPermits, this.containsSensitiveWords);
            return request;
        }
    }

    public boolean isLoggedOn() {
        return loggedOn;
    }

    public boolean isFrequentOk() {
        return frequentOk;
    }

    public boolean isPermits() {
        return isPermits;
    }
    public boolean isContainsSensitiveWords() {
        return containsSensitiveWords;
    }
}

abstract class Handler {
    private Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    abstract public boolean process(Request request);
}

class LoggedOnHandler extends Handler {

    public LoggedOnHandler(Handler next) {
        super(next);
    }

    @Override
    public boolean process(Request request) {
        System.out.println("登录控制。");
        if (request.isLoggedOn()) {
            Handler handler = getNext();
            if (null==handler) {
                return true;
            }
            if (!handler.process(request)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}

class RequestFrequentHandler extends Handler {

    public RequestFrequentHandler(Handler next) {
        super(next);
    }

    @Override
    public boolean process(Request request) {
        System.out.println("访问频率控制。");
        if (request.isFrequentOk()) {
            Handler handler = getNext();
            if (null==handler) {
                return true;
            }
            if (!handler.process(request)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}

class PermitsHandler extends Handler {

    public PermitsHandler(Handler next) {
        super(next);
    }

    @Override
    public boolean process(Request request) {
        System.out.println("权限控制。");
        if (request.isPermits()) {
            Handler handler = getNext();
            if (null==handler) {
                return true;
            }
            if (!handler.process(request)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}

class ContainsSensitiveHandler extends Handler {

    public ContainsSensitiveHandler(Handler next) {
        super(next);
    }

    @Override
    public boolean process(Request request) {
        System.out.println("敏感词控制。");
        if (request.isContainsSensitiveWords()) {
            Handler handler = getNext();
            if (null==handler) {
                return true;
            }
            if (!handler.process(request)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}