package Neuro.exeption;

/**
 * Created by baylrock on 06.05.2016.
 */
public class MergeException extends Exception {


    private String msg;
    private int CODE;

    public MergeException( String msg, int CODE ) {
        this.msg = msg;
        this.CODE = CODE;
    }


    public int getCODE() {
        return CODE;
    }

    public String getMsg() {
        return msg;
    }


}
