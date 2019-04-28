package aosp.app.hello;

class SjLog {
    private String mMsg;
    private static final String PREFIX_IN = "=> ";
    private static final String PREFIX_OUT = "<- ";

    SjLog(String msg) {
        mMsg = msg;
    }

    String in() {
        if (mMsg != null)
            return PREFIX_IN + mMsg;
        return PREFIX_IN;
    }

    String out() {
        if (mMsg != null)
            return PREFIX_OUT + mMsg;
        return PREFIX_OUT;
    }
}
