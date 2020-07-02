package hypochain.ruleset;

import hypochain.ruleBase;

public class IframeTag extends ruleBase {

    private String html;
    private boolean hypothesis = false;

    public boolean isHypothesis() {
        return hypothesis;
    }
    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }

    public IframeTag(String html) {
        super(html);
        this.html = html;
    }

    public void rule(){
        String[] checkBig = html.split("<");// < �������� ���� �ɰ��� �ܾ�� �迭�����
        for(int i=0; i<checkBig.length;i++){
            String [] checkMid = checkBig[i].split(">");
            for(int j=0; j<checkMid.length; j++){
                String [] checkSmall = checkMid[j].split(" ");
                for(int k=0; k<checkSmall.length; k++){

                    //Number of iframes
                    if(checkSmall[k].equals("iframe")){
                        setHypothesis(true);
                    }
                }
            }
        }
    }
}
