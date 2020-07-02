# HypoChain
- 프로젝트 설명
: 사용자 경험을 고려한 지식 기반 악성 URL 탐지 라이브러리 
HypoChain은 악성 URL을 규칙 기반으로 탐지하기 위한 라이브러리이다. 특히, 독자적인 규칙을 기반으로 악성 URL을 탐지하기 위해 Rule-Set을 정의하고, Rule Chain을 생성하여 악성 URL 탐지의 확장성을 제시한다. 다양한 분야에서의 라이브러리 적용이 가능하도록 개발을 진행하였다.


- 버전
: HypoChain1.1.2 


- 라이브러리 개발 환경
: Eclipse IDE, Android Studio


- 동작 원리 
Rule-Set에 포함되어있는 기준 클래스들은 RuleBase클래스를 상속받아 rule()메소드 오버라이딩
Rule()메소드의 조건을 만족시, setHypothsis()함수를 통해 결과값 반환하여 조건 확인 후 계산식을 사용하여 확률 값을 도출함.
url-based rule, html-base rule을 통해 탐지 기준 구축후, rule-chain의 and, or 조건을 사용하여 규칙 연결을 통해 정확도를 제시함.
Rule-set 체계를 통해 구축된 프로젝트를 java 라이브러리화하여 ‘jar’ 형식으로 포맷팅하고,
jsoup라이브러리 이용하여 입력된 url 의 html 데이터를 가져오는 작업을 진행한다.
HypoChain1.12 라이브러리를 사용하기 위해 method 클래스의 정적 함수 checkUrl 메소드 즉, url의 주소 정보와 html의 악성 가능성을 비율 값으로 리턴한다.


- 역할 
rulebase.java
: 악성 url의 판단 기준이 되는 rule의 기본 토대 제공

rule set
: rule 클래스들의 구성

evidenceAc.java
: hypochain의 검증 엔진 역할

Method.java
:method클래스의 checkUrl()함수를 호출하면 최종적인 확률값 반환

JSOUP-1.12.1.jar
:url의 HTML구문을 분석하고, 데이터를 추출하는 기능 제공


- 테스트 프로젝트 설명
: 프로젝트 ‘jar’ 형식 포맷팅 후 Android 환경 적용 테스트 프로젝트 생성
 Jsoup 라이브러리 이용하여 입력된 url의 HTML 데이터 가져옴
 JsoupAnsytTask 클래스 생성 , execute() 메소드 실행 
doInBackground()메소드에서 라이브러리 사용 위해 정적 함수 checkURL 메소드 호출
checkURL 메소드는 url의 주소 정보 및 HTML 악성 가능성 비율 값으로 리턴


- 테스트 기능 
: HypoChain 라이브러리를 사용하는 Appdms 메시지에 대한 접근 권한을 가질 때 이를 활용하여 곧바로 악성 URL 여부를 확인하고 사용자에게 경고 알람을 주는 것이 가능하다.


(English Ver)


- Project title and description
: Rule-based malicious url detection library considering user experience 


- Library for detecting malicious url based on rules. 
In particular, rule-set is defined to detect malicious url based on independent rules, and rule-chain is generated to present the scalability of malicious url detection.
In addition, the development into a library form that can be used in any application was used in various applications.


- Version
: HypoChain1.1.2 


- Library Development Environment
: Eclipse IDE, AndroidStudio


- Operating principle
The reference classes included in the Rule-set inherit the RuleBase class and override the rule()method.
When the conditions of the Rule()method are satisfied, return the missing value through the setHypothsis() function, and use the calculation formula to derive the probability value.
Establish detection criteria through url-based rules, html-base rules, and or conditions in rule-chain to provide accuracy through rule connection.
Projects built through the Rule-set scheme are java libraryized and formatted in 'jar' format.
Use jsoup library to import html data of url entered.
To use the HypoChain1.12 library, return the static function checkUrl method of the method class, i.e. address information of url and the malicious possibility of html to the ratio value.


- Role of Each Class
RuleBase.java
: Provides the basic foundation for rules based on the judgment of malicious url

RuleSet
: the composition of rule classes

EvidenceAc.java
: The role of the verification engine in hyperchain

Method.java
: Recalling the checkUrl() function of the method class returns the final probability value.

JSOUP-1.12.1.jar
: Provides the ability to analyze HTML syntax and extract data from url


- Test Project
Create an Android environment-applied test project after formatting the project 'jar' format
Importing HTML data from url entered using Jsoup library
Create JsoupAnsyTask Class , execute execute() method 
DoInBackground()call static function checkURL method for library use in method
CheckURL method returns address information of url and HTML malicious probability ratio value


- Purpose for Test Project
When you have access to Appdms messages using the HypoChain library, it is possible to immediately check for malicious URLs and alert users.
