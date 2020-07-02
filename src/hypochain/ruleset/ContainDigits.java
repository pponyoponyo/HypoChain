package hypochain.ruleset;

import hypochain.ruleBase;

public class ContainDigits extends ruleBase {

    private String url;
    private boolean hypothesis = false;

    public boolean isHypothesis() {
        return hypothesis;
    }
    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }

    public ContainDigits(String url) {
        super(url);
        this.url = url;
    }

    public void rule(){

       char [] d = {'0','1','2','3','4','5','6','7','8','9'}; // digits �迭 ����

        char [] c ;
        c = url.toCharArray(); // url�� char ���ڷ� ��ȯ


        for(int i=0; i<c.length; i++){
            for(int j=0; j<10; j++){
                if(c[i]==(d[j])){
                setHypothesis(true);
                }
            }
        }
    }
}
