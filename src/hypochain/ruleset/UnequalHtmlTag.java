package hypochain.ruleset;

import hypochain.ruleBase;

public class UnequalHtmlTag extends ruleBase {

    private String html;
    private boolean hypothesis = false;


    public boolean isHypothesis() {
        return hypothesis;
    }
    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }

    public UnequalHtmlTag(String html) {
        super(html);
        this.html = html;
    }

    public void rule(){
        int htmlTagNum=0;
        String[] checkBig = html.split("<");// < �������� ���� �ɰ��� �ܾ�� �迭�����

        for(int i=0; i<checkBig.length;i++){
            String [] checkMid = checkBig[i].split(">");
            for(int j=0; j<checkMid.length; j++){
                String [] checkSmall = checkMid[j].split(" ");
                for(int k=0; k<checkSmall.length; k++){


                    if(checkSmall[k].equals("html")){
                        htmlTagNum++;
                    }

                }

            }

        }

        if((htmlTagNum&2)!=0){
            setHypothesis(true);
        }
    }
}
