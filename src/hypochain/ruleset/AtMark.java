package hypochain.ruleset;

import hypochain.ruleBase;

public class AtMark extends ruleBase {

    private String url;
    private boolean hypothesis = false;

    public boolean isHypothesis() {
        return hypothesis;
    }

    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }

    public AtMark(String url) {
        super(url);
        this.url = url;
    }

    public void rule(){
        char [] c ;
        c = url.toCharArray();

        for(int i=0; i<c.length; i++){
            if(c[i]=='@'){ // ���縸 �ϸ� �ٷ� �ǽ� ����Ʈ�� ( ���� �� ��ó)
                setHypothesis(true);
            }
        }

    }
}