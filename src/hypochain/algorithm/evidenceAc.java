package hypochain.algorithm;

import hypochain.ruleset.*;

public class evidenceAc {
	
	private ATag aTag;
	private AtMark atMark;
	private BackSlash backSlash; 
	private Bitly bitly;
	private CharCodeAtMethod charCodeAtMethod;
	private ContainDigits containDigits;
	private Dot dot;
	private EqualSign equalSign;
	private EscapeMethod escapeMethod;
	private EvalMethod evalMethod;
	private FromCharCodeMethod fromCharCodeMethod;
	private HiddenTag hiddenTag;
	private Hypen hypen;
	private IframeTag iframeTag;
	private LengthOfDoc lengthOfDoc;
	private LengthOfURL lengthOfURL;
	private NumberOfLines numberOfLines;
	private ParseIntMethod parseIntMethod;
	private SemiColon semiColon;
	private SuspiciousWords suspiciousWords;
	private Tld tld;
	private UnequalHtmlTag unequalHtmlTag;
	private WindowOpenMethod windowOpenMethod;
	
	private int JavaMethodNum=0; // JavaMethod 카운팅 변수
	private int SpecialCharacterNum=0; // URL 주소 안의 특수문자 카운팅 변수 
	
	
	public evidenceAc(String url, String html){
		
		aTag = new ATag(html);
		atMark = new AtMark(url);
		backSlash = new BackSlash(url);
		bitly = new Bitly(url);
		charCodeAtMethod = new CharCodeAtMethod(html);
		containDigits = new ContainDigits(url);
		dot = new Dot(url);
		equalSign = new EqualSign(url);
		escapeMethod = new EscapeMethod(html);
		evalMethod = new EvalMethod(html);
		fromCharCodeMethod = new FromCharCodeMethod(html);
		hiddenTag = new HiddenTag(html);
		hypen = new Hypen(url);
		iframeTag = new IframeTag(html);
		lengthOfDoc = new LengthOfDoc(html);
		lengthOfURL = new LengthOfURL(url);
		numberOfLines = new NumberOfLines(html);
		parseIntMethod = new ParseIntMethod(html);
		semiColon = new SemiColon(url);
		suspiciousWords = new SuspiciousWords(html);
		tld = new Tld(url);
		unequalHtmlTag = new UnequalHtmlTag(html);
		windowOpenMethod = new WindowOpenMethod(html);
		
		aTag.rule();
		atMark.rule();
		backSlash.rule();		
		bitly.rule();
		charCodeAtMethod.rule();
		containDigits.rule();
		dot.rule();
		equalSign.rule();
		escapeMethod.rule();
		evalMethod.rule();
		fromCharCodeMethod.rule();
		hiddenTag.rule();
		hypen.rule();
		iframeTag.rule();
		lengthOfDoc.rule();
		lengthOfURL.rule();
		numberOfLines.rule();
		parseIntMethod.rule();
		semiColon.rule();
		suspiciousWords.rule();
		tld.rule();
		unequalHtmlTag.rule();
		windowOpenMethod.rule();
	}
	
	public boolean upperAuthority(){
        if(backSlash.isHypothesis() && lengthOfURL.isHypothesis()){
            if(dot.isHypothesis()){
                //상위 권한 탈취 가능성
                return true;
            }
        }
        return false;
    }

    public boolean ChinaTld(){
        if(tld.isCn_hypothesis()){
            // 중국에 위치한 TLD
            return true;
        }
        return false;
    }

    public boolean RussiaTld(){
        if(tld.isRu_hypothesis()){
            // 러시아에 위치한 TLD
            return true;
        }
        return false;
    }

    public boolean javaExe(){
    	 //위험한 java script 실행 가능성
        if(evalMethod.isHypothesis()) {
        	JavaMethodNum++;
        }
        if(windowOpenMethod.isHypothesis()) {
        	JavaMethodNum++;
        }
        if(charCodeAtMethod.isHypothesis()) {
        	JavaMethodNum++;
        }
        if(escapeMethod.isHypothesis()) {
        	JavaMethodNum++;
        }
        if(fromCharCodeMethod.isHypothesis()) {
        	JavaMethodNum++;
        }
        if(parseIntMethod.isHypothesis()) {
        	JavaMethodNum++;
        }
       
        if(JavaMethodNum>=1) {
        	return true;
        }
        return false;
    }
    
    
    public boolean fastPage(){
        if((numberOfLines.isHypothesis()||lengthOfDoc.isHypothesis())&&suspiciousWords.isHypothesis()){
            //빠르게 만들어진 피싱 페이지
            return true;
        }
        return false;
    }


    // 룰체인 보민 추가
    public boolean SmishingUrl(){
        if(bitly.isHypothesis()&&suspiciousWords.isHypothesis()){
            // 단축 url + '택배' 단어
            return true;
        }
        return false;
    }

    public boolean IPUrl(){
        if(dot.isHypothesis()&&containDigits.isHypothesis()){
            // IP주소가 URL에 존재하는 경우
            return true;

        }
        return false;
    }

    public boolean linkPossibility(){
        if(aTag.isHypothesis()&&iframeTag.isHypothesis()){
            // iframe안에 a태그를 통한 링크 존재하는 경우
            return  true;
        }
        return false;
    }

    public boolean tagExist(){
        if(iframeTag.isHypothesis()&&hiddenTag.isHypothesis()&&unequalHtmlTag.isHypothesis()){
            // 의심스러운 태그들이 포착된 경우
            return true;
        }
        return false;
    }
    
    // 20.03.04 추가 
    
    public boolean SpecialCharacter() {
    	
    	if(atMark.isHypothesis()) {
    		SpecialCharacterNum++;
    	}
    	if(equalSign.isHypothesis()) {
    		
    		SpecialCharacterNum++;
    }
    	if(hypen.isHypothesis()) {
    		SpecialCharacterNum++;
    	}
    	if(semiColon.isHypothesis()) {
    		SpecialCharacterNum++;
    	}
    	
    	if(SpecialCharacterNum>=1) {
    		
    		return true;
    	}
    	
		return false;
 }

}