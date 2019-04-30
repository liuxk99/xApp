package aosp.app.hello;

class SjLogGen {
    private final String mTag;

    SjLogGen(String tag) {
        mTag = tag;
    }

    SjLog build(String msg) {
        SjLog sjLog = new SjLog(this.mTag);
        sjLog.setMsg(msg);
        return sjLog;
    }
}
